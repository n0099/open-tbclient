package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.b;
import com.baidu.adp.lib.util.q;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.b.i;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class MvcSocketResponsedMessage<D extends i, M extends Message> extends TbSocketReponsedMessage {
    private D data;

    protected abstract Class<M> getProtobufResponseIdlClass();

    public MvcSocketResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        Message parseFrom = new Wire(new Class[0]).parseFrom(bArr, getProtobufResponseIdlClass());
        List<Field> a = b.a(parseFrom, Error.class);
        if (a != null && a.size() > 0) {
            Object a2 = q.a(parseFrom, a.get(0));
            if (a2 instanceof Error) {
                Error error = (Error) a2;
                setError(error.errorno.intValue());
                setErrorString(error.usermsg);
            }
        }
        if (getError() == 0) {
            Object obj = null;
            if (getOrginalMessage() instanceof MvcSocketMessage) {
                obj = createData(((MvcSocketMessage) getOrginalMessage()).getResponseDataClass());
            } else if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                obj = createData(((MvcNetMessage) getOrginalMessage().getExtra()).getResponseDataClass());
            }
            if (obj instanceof i) {
                this.data = (D) obj;
                this.data.a(parseFrom);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        d dVar;
        t<byte[]> bc;
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && bArr != null) {
            if (getOrginalMessage() instanceof MvcSocketMessage) {
                MvcSocketMessage mvcSocketMessage = (MvcSocketMessage) getOrginalMessage();
                if (mvcSocketMessage.isNeedCache() && (mvcSocketMessage.getData() instanceof d)) {
                    dVar = (d) mvcSocketMessage.getData();
                }
                dVar = null;
            } else {
                if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                    MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
                    if (mvcNetMessage.isNeedCache() && (mvcNetMessage.getRequestData() instanceof d)) {
                        dVar = (d) mvcNetMessage.getRequestData();
                    }
                }
                dVar = null;
            }
            if (dVar != null) {
                String cacheKey = dVar.getCacheKey();
                String sW = dVar.sW();
                if (cacheKey != null && !TextUtils.isEmpty(sW) && bArr != null && (bc = a.kS().bc(sW)) != null) {
                    bc.b(cacheKey, bArr);
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
