package com.baidu.tieba.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        com.baidu.tieba.im.searchfriend.a.a friendInfo;
        com.baidu.tbadk.core.a.a kS;
        t<String> bd;
        if (customMessage != null && (customMessage instanceof RequestRecommendWriteMessage) && (friendInfo = ((RequestRecommendWriteMessage) customMessage).getFriendInfo()) != null && (kS = com.baidu.tbadk.core.a.a.kS()) != null && (bd = kS.bd("tb.recommend_friend")) != null) {
            String currentAccount = TbadkApplication.getCurrentAccount();
            bd.remove(currentAccount);
            bd.b(currentAccount, friendInfo.RC().toString());
        }
        return null;
    }
}
