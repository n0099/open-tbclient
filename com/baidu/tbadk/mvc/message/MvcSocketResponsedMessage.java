package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.b;
import com.baidu.adp.lib.util.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class MvcSocketResponsedMessage<D extends j, M extends Message> extends TbSocketReponsedMessage {
    private D data;

    protected abstract Class<M> getProtobufResponseIdlClass();

    public MvcSocketResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        List<Field> a;
        Message parseFrom = new Wire(new Class[0]).parseFrom(bArr, getProtobufResponseIdlClass());
        List<Field> a2 = b.a(parseFrom, Error.class);
        if (a2 == null || a2.size() <= 0) {
            z = false;
        } else {
            Object a3 = q.a(parseFrom, a2.get(0));
            if (a3 instanceof Error) {
                Error error = (Error) a3;
                setError(error.errorno.intValue());
                setErrorString(error.usermsg);
            }
            z = true;
        }
        if (!z && (a = b.a(parseFrom, tbclient.Error.class)) != null && a.size() > 0) {
            Object a4 = q.a(parseFrom, a.get(0));
            if (a4 instanceof tbclient.Error) {
                tbclient.Error error2 = (tbclient.Error) a4;
                setError(error2.errorno.intValue());
                setErrorString(error2.usermsg);
            }
        }
        if (getError() == 0) {
            Object obj = null;
            if (getOrginalMessage() instanceof MvcSocketMessage) {
                obj = createData(((MvcSocketMessage) getOrginalMessage()).getResponseDataClass());
            } else if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                obj = createData(((MvcNetMessage) getOrginalMessage().getExtra()).getResponseDataClass());
            }
            if (obj instanceof j) {
                this.data = (D) obj;
                this.data.a(parseFrom);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        e eVar;
        o<byte[]> M;
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && bArr != null) {
            if (getOrginalMessage() instanceof MvcSocketMessage) {
                MvcSocketMessage mvcSocketMessage = (MvcSocketMessage) getOrginalMessage();
                if (mvcSocketMessage.isNeedCache() && (mvcSocketMessage.getData() instanceof e)) {
                    eVar = (e) mvcSocketMessage.getData();
                }
                eVar = null;
            } else {
                if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                    MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
                    if (mvcNetMessage.isNeedCache() && (mvcNetMessage.getRequestData() instanceof e)) {
                        eVar = (e) mvcNetMessage.getRequestData();
                    }
                }
                eVar = null;
            }
            if (eVar != null) {
                String cacheKey = eVar.getCacheKey();
                String EN = eVar.EN();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey != null && !TextUtils.isEmpty(EN) && bArr != null && (M = a.tm().M(EN, currentAccount)) != null) {
                    M.k(cacheKey, bArr);
                }
            }
        }
    }

    public void setData(D d) {
        this.data = d;
    }

    public D getData() {
        return this.data;
    }

    protected Object createData(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
