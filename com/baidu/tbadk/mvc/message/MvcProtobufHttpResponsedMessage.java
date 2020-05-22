package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.b;
import com.baidu.adp.lib.util.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.c.a;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class MvcProtobufHttpResponsedMessage<D extends j, M extends Message> extends MvcHttpResponsedMessage<D> {
    protected abstract Class<M> getProtobufResponseIdlClass();

    public MvcProtobufHttpResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        List<Field> fieldsByType;
        super.decodeInBackGround(i, bArr);
        Message parseFrom = new Wire(new Class[0]).parseFrom(bArr, getProtobufResponseIdlClass());
        List<Field> fieldsByType2 = b.getFieldsByType(parseFrom, Error.class);
        if (fieldsByType2 == null || fieldsByType2.size() <= 0) {
            z = false;
        } else {
            Object forceGetProperty = p.forceGetProperty(parseFrom, fieldsByType2.get(0));
            if (forceGetProperty instanceof Error) {
                Error error = (Error) forceGetProperty;
                setError(error.errorno.intValue());
                setErrorString(error.usermsg);
            }
            z = true;
        }
        if (!z && (fieldsByType = b.getFieldsByType(parseFrom, tbclient.Error.class)) != null && fieldsByType.size() > 0) {
            Object forceGetProperty2 = p.forceGetProperty(parseFrom, fieldsByType.get(0));
            if (forceGetProperty2 instanceof tbclient.Error) {
                tbclient.Error error2 = (tbclient.Error) forceGetProperty2;
                setError(error2.errorno.intValue());
                setErrorString(error2.usermsg);
            }
        }
        if (getError() == 0) {
            Object obj = null;
            if (getOrginalMessage() instanceof MvcHttpMessage) {
                obj = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
            } else if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                obj = createData(((MvcNetMessage) getOrginalMessage().getExtra()).getResponseDataClass());
            }
            if (obj instanceof j) {
                this.data = (D) obj;
                this.data.initByProtobuf(parseFrom);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        e eVar;
        l<byte[]> cZ;
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
                String beL = eVar.beL();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey != null && !TextUtils.isEmpty(beL) && bArr != null && (cZ = a.aSS().cZ(beL, currentAccount)) != null) {
                    cZ.setForever(cacheKey, bArr);
                }
            }
        }
    }
}
