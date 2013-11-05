package com.baidu.tieba.im.message;

import com.baidu.cyberplayer.sdk.BVideoView;
/* loaded from: classes.dex */
public class RequestMarkReadedMessage extends Message {
    private String groupId;

    public RequestMarkReadedMessage() {
        super.setCmd(BVideoView.MEDIA_ERROR_TIMED_OUT);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
