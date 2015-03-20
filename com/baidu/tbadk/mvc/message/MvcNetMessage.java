package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
/* loaded from: classes.dex */
public class MvcNetMessage<T extends i, D extends k> extends NetMessage {
    private boolean isNeedCache;
    private T requestData;
    private Class<D> responseDataClass;

    public MvcNetMessage(T t, int i, int i2) {
        super(i, i2);
        this.isNeedCache = false;
        this.requestData = t;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        return this.requestData.V(z);
    }

    public T getRequestData() {
        return this.requestData;
    }

    public void setRequestData(T t) {
        this.requestData = t;
    }

    public Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }

    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }
}
