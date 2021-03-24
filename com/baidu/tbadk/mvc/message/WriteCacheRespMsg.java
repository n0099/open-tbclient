package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class WriteCacheRespMsg<T> extends CustomResponsedMessage<T> {
    public boolean isSuccess;

    public WriteCacheRespMsg(int i) {
        super(i);
        this.isSuccess = false;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
