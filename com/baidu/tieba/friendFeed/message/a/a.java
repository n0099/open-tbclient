package com.baidu.tieba.friendFeed.message.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.friendFeed.message.RequestFriendFeedLocalMessage;
import com.baidu.tieba.friendFeed.message.ResponseFriendFeedLocalMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestFriendFeedLocalMessage)) {
            return null;
        }
        String str = "friend_feed_data" + TbadkCoreApplication.getCurrentAccount();
        t<byte[]> bW = com.baidu.tbadk.core.b.a.rc().bW("tb.friend_feed");
        byte[] bArr = bW != null ? bW.get(str) : null;
        ResponseFriendFeedLocalMessage responseFriendFeedLocalMessage = new ResponseFriendFeedLocalMessage();
        try {
            responseFriendFeedLocalMessage.decodeInBackGround(2001172, bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseFriendFeedLocalMessage;
    }
}
