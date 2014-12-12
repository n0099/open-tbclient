package com.baidu.tieba.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class c implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        com.baidu.tieba.im.searchfriend.a.a friendInfo;
        com.baidu.tbadk.core.a.a nS;
        t<String> bV;
        if (customMessage != null && (customMessage instanceof RequestRecommendWriteMessage) && (friendInfo = ((RequestRecommendWriteMessage) customMessage).getFriendInfo()) != null && (nS = com.baidu.tbadk.core.a.a.nS()) != null && (bV = nS.bV("tb.recommend_friend")) != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            bV.remove(currentAccount);
            bV.f(currentAccount, friendInfo.SO().toString());
        }
        return null;
    }
}
