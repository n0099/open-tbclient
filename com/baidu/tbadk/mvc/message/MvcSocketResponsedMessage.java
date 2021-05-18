package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.c.e.p.b;
import d.a.c.e.p.n;
import d.a.j0.g0.b.d;
import d.a.j0.g0.b.h;
import d.a.j0.r.r.a;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes3.dex */
public abstract class MvcSocketResponsedMessage<D extends h, M extends Message> extends TbSocketReponsedMessage {
    public D data;

    public MvcSocketResponsedMessage(int i2) {
        super(i2);
    }

    public Object createData(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (ExceptionInInitializerError e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public D getData() {
        return this.data;
    }

    public abstract Class<M> getProtobufResponseIdlClass();

    public void setData(D d2) {
        this.data = d2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        d dVar;
        l<byte[]> e2;
        super.afterDispatchInBackGround(i2, (int) bArr);
        if (getError() != 0 || bArr == null) {
            return;
        }
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
            String r = dVar.r();
            String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
            if (cacheKey == null || TextUtils.isEmpty(r) || bArr == null || (e2 = a.f().e(r, currentAccount)) == null) {
                return;
            }
            e2.g(cacheKey, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        boolean z;
        List<Field> c2;
        Message parseFrom = new Wire(new Class[0]).parseFrom(bArr, getProtobufResponseIdlClass());
        List<Field> c3 = b.c(parseFrom, Error.class);
        if (c3 == null || c3.size() <= 0) {
            z = false;
        } else {
            z = true;
            Object a2 = n.a(parseFrom, c3.get(0));
            if (a2 instanceof Error) {
                Error error = (Error) a2;
                setError(error.errorno.intValue());
                setErrorString(error.usermsg);
            }
        }
        if (!z && (c2 = b.c(parseFrom, tbclient.Error.class)) != null && c2.size() > 0) {
            Object a3 = n.a(parseFrom, c2.get(0));
            if (a3 instanceof tbclient.Error) {
                tbclient.Error error2 = (tbclient.Error) a3;
                setError(error2.errorno.intValue());
                setErrorString(error2.usermsg);
            }
        }
        if (getError() != 0) {
            return;
        }
        Object obj = null;
        if (getOrginalMessage() instanceof MvcSocketMessage) {
            obj = createData(((MvcSocketMessage) getOrginalMessage()).getResponseDataClass());
        } else if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
            obj = createData(((MvcNetMessage) getOrginalMessage().getExtra()).getResponseDataClass());
        }
        if (obj instanceof h) {
            D d2 = (D) obj;
            this.data = d2;
            d2.initByProtobuf(parseFrom);
        }
    }
}
