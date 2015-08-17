package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.b;
/* loaded from: classes.dex */
public class ResponseNewFriendDataMessage extends CustomResponsedMessage<b> {
    public ResponseNewFriendDataMessage(b bVar) {
        super(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID, bVar);
    }
}
