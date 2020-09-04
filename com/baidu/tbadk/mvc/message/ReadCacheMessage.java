package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.mvc.b.e;
/* loaded from: classes.dex */
public class ReadCacheMessage<T> extends CustomMessage<T> {
    private boolean isNeedUid;
    private e requestData;

    public ReadCacheMessage(int i) {
        super(i);
        this.isNeedUid = true;
    }

    public e getRequestData() {
        return this.requestData;
    }

    public void setRequestData(e eVar) {
        this.requestData = eVar;
    }

    public boolean isNeedUid() {
        return this.isNeedUid;
    }

    public void setNeedUid(boolean z) {
        this.isNeedUid = z;
    }
}
