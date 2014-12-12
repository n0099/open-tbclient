package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.mvc.b.g;
import com.baidu.tbadk.mvc.b.j;
/* loaded from: classes.dex */
public class MvcHttpMessage<T extends g, D extends j> extends HttpMessage {
    private boolean isNeedCache;
    private T requestData;
    private Class<D> responseDataClass;

    public MvcHttpMessage(T t, int i) {
        super(i);
        this.isNeedCache = false;
        this.requestData = t;
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
