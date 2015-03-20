package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
/* loaded from: classes.dex */
class ah implements CustomMessageTask.CustomRunnable<Long> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.im.data.b> run(CustomMessage<Long> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new ResponseNewFriendDataMessage(ba.EX().K(customMessage.getData().longValue()));
    }
}
