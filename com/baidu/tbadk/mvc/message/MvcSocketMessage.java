package com.baidu.tbadk.mvc.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.b.k;
/* loaded from: classes.dex */
public class MvcSocketMessage<T extends k, D extends j> extends TbSocketMessage {
    private boolean isNeedCache;
    private T requestData;
    private Class<D> responseDataClass;

    public MvcSocketMessage(T t, int i) {
        super(i);
        this.isNeedCache = false;
        this.requestData = t;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        return this.requestData.cs(false);
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
