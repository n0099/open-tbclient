package com.baidu.tieba.addresslist.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class c implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        com.baidu.tieba.addresslist.im.searchfriend.a.a friendInfo;
        com.baidu.tbadk.core.b.a rI;
        t<String> ck;
        if (customMessage != null && (customMessage instanceof RequestRecommendWriteMessage) && (friendInfo = ((RequestRecommendWriteMessage) customMessage).getFriendInfo()) != null && (rI = com.baidu.tbadk.core.b.a.rI()) != null && (ck = rI.ck("tb.recommend_friend")) != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ck.remove(currentAccount);
            ck.f(currentAccount, friendInfo.Gi().toString());
        }
        return null;
    }
}
