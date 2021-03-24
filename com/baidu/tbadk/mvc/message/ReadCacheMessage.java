package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomMessage;
import d.b.h0.g0.b.d;
/* loaded from: classes3.dex */
public class ReadCacheMessage<T> extends CustomMessage<T> {
    public boolean isNeedUid;
    public d requestData;

    public ReadCacheMessage(int i) {
        super(i);
        this.isNeedUid = true;
    }

    public d getRequestData() {
        return this.requestData;
    }

    public boolean isNeedUid() {
        return this.isNeedUid;
    }

    public void setNeedUid(boolean z) {
        this.isNeedUid = z;
    }

    public void setRequestData(d dVar) {
        this.requestData = dVar;
    }
}
