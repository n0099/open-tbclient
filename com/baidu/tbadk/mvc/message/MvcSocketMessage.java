package com.baidu.tbadk.mvc.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import d.b.h0.g0.b.h;
import d.b.h0.g0.b.i;
/* loaded from: classes3.dex */
public class MvcSocketMessage<T extends i, D extends h> extends TbSocketMessage {
    public boolean isNeedCache;
    public T requestData;
    public Class<D> responseDataClass;

    public MvcSocketMessage(T t, int i) {
        super(i);
        this.isNeedCache = false;
        this.requestData = t;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        return this.requestData.e(false);
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
