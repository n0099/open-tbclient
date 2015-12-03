package com.baidu.tieba.addresslist.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class c implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        com.baidu.tieba.addresslist.im.searchfriend.a.a friendInfo;
        com.baidu.tbadk.core.b.a ts;
        o<String> cz;
        if (customMessage != null && (customMessage instanceof RequestRecommendWriteMessage) && (friendInfo = ((RequestRecommendWriteMessage) customMessage).getFriendInfo()) != null && (ts = com.baidu.tbadk.core.b.a.ts()) != null && (cz = ts.cz("tb.recommend_friend")) != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            cz.remove(currentAccount);
            cz.f(currentAccount, friendInfo.HE().toString());
        }
        return null;
    }
}
