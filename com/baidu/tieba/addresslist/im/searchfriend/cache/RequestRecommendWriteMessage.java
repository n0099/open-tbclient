package com.baidu.tieba.addresslist.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestRecommendWriteMessage extends CustomMessage<Object> {
    private com.baidu.tieba.addresslist.im.searchfriend.a.a friendInfo;

    public RequestRecommendWriteMessage(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        super(CmdConfigCustom.CMD_REQUEST_RECOMMEND_WRITE_CACHE);
        this.friendInfo = aVar;
    }

    public com.baidu.tieba.addresslist.im.searchfriend.a.a getFriendInfo() {
        return this.friendInfo;
    }

    public void setFriendInfo(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        this.friendInfo = aVar;
    }
}
