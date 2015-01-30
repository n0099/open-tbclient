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
        com.baidu.tbadk.core.a.a nV;
        t<String> bT;
        if (customMessage != null && (customMessage instanceof RequestRecommendWriteMessage) && (friendInfo = ((RequestRecommendWriteMessage) customMessage).getFriendInfo()) != null && (nV = com.baidu.tbadk.core.a.a.nV()) != null && (bT = nV.bT("tb.recommend_friend")) != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            bT.remove(currentAccount);
            bT.f(currentAccount, friendInfo.Tk().toString());
        }
        return null;
    }
}
