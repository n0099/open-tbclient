package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.NetMessage;
import d.b.i0.g0.b.g;
import d.b.i0.g0.b.h;
/* loaded from: classes3.dex */
public class MvcNetMessage<T extends g, D extends h> extends NetMessage {
    public boolean isNeedCache;
    public T requestData;
    public Class<D> responseDataClass;

    public MvcNetMessage(T t, int i, int i2) {
        super(i, i2);
        this.isNeedCache = false;
        this.requestData = t;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        return this.requestData.e(z);
    }

    public T getRequestData() {
        return this.requestData;
    }

    public Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public void setRequestData(T t) {
        this.requestData = t;
    }

    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }
}
