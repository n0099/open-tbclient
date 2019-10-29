package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseNewFriendDataMessage extends CustomResponsedMessage<com.baidu.tieba.im.data.a> {
    public ResponseNewFriendDataMessage(com.baidu.tieba.im.data.a aVar) {
        super(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID, aVar);
    }
}
