package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.mvc.b.d;
/* loaded from: classes.dex */
public class ReadCacheMessage<T> extends CustomMessage<T> {
    private boolean isNeedUid;
    private d requestData;

    public ReadCacheMessage(int i) {
        super(i);
        this.isNeedUid = true;
    }

    public d getRequestData() {
        return this.requestData;
    }

    public void setRequestData(d dVar) {
        this.requestData = dVar;
    }

    public boolean isNeedUid() {
        return this.isNeedUid;
    }

    public void setNeedUid(boolean z) {
        this.isNeedUid = z;
    }
}
