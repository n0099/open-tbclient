package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ResponseUnreadPointNum extends CustomResponsedMessage<Object> {
    public boolean fromNet;
    public int num;

    public ResponseUnreadPointNum(int i2, boolean z) {
        super(2001176);
        this.num = i2;
        this.fromNet = z;
    }

    public int getNum() {
        return this.num;
    }

    public boolean isFromNet() {
        return this.fromNet;
    }

    public void setFromNet(boolean z) {
        this.fromNet = z;
    }

    public void setNum(int i2) {
        this.num = i2;
    }
}
