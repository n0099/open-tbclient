package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseUnreadPointNum extends CustomResponsedMessage<Object> {
    private boolean fromNet;
    private int num;

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public boolean isFromNet() {
        return this.fromNet;
    }

    public void setFromNet(boolean z) {
        this.fromNet = z;
    }

    public ResponseUnreadPointNum(int i, boolean z) {
        super(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.num = i;
        this.fromNet = z;
    }
}
