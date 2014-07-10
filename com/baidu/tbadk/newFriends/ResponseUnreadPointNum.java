package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ResponseUnreadPointNum extends CustomResponsedMessage<Object> {
    private int num;

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public ResponseUnreadPointNum(int i) {
        super(2001180);
        this.num = i;
    }
}
