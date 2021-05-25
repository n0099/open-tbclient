package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.HttpMessage;
import d.a.m0.g0.b.f;
import d.a.m0.g0.b.h;
/* loaded from: classes3.dex */
public class MvcHttpMessage<T extends f, D extends h> extends HttpMessage {
    public boolean isNeedCache;
    public T requestData;
    public Class<D> responseDataClass;

    public MvcHttpMessage(T t, int i2) {
        super(i2);
        this.isNeedCache = false;
        this.requestData = t;
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
