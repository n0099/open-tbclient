package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.b.c.e.d.l;
import d.b.c.e.p.b;
import d.b.c.e.p.n;
import d.b.h0.g0.b.d;
import d.b.h0.g0.b.h;
import d.b.h0.r.r.a;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes3.dex */
public abstract class MvcProtobufHttpResponsedMessage<D extends h, M extends Message> extends MvcHttpResponsedMessage<D> {
    public MvcProtobufHttpResponsedMessage(int i) {
        super(i);
    }

    public abstract Class<M> getProtobufResponseIdlClass();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        d dVar;
        l<byte[]> e2;
        super.afterDispatchInBackGround(i, (int) bArr);
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
            String q = dVar.q();
            String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
            if (cacheKey == null || TextUtils.isEmpty(q) || bArr == null || (e2 = a.f().e(q, currentAccount)) == null) {
                return;
            }
            e2.g(cacheKey, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        List<Field> c2;
        super.decodeInBackGround(i, bArr);
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
        if (getOrginalMessage() instanceof MvcHttpMessage) {
            obj = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
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
