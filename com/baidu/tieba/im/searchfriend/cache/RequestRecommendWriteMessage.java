package com.baidu.tieba.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class RequestRecommendWriteMessage extends CustomMessage<Object> {
    private com.baidu.tieba.im.searchfriend.a.a friendInfo;

    public RequestRecommendWriteMessage(com.baidu.tieba.im.searchfriend.a.a aVar) {
        super(2001198);
        this.friendInfo = aVar;
    }

    public com.baidu.tieba.im.searchfriend.a.a getFriendInfo() {
        return this.friendInfo;
    }

    public void setFriendInfo(com.baidu.tieba.im.searchfriend.a.a aVar) {
        this.friendInfo = aVar;
    }
}
