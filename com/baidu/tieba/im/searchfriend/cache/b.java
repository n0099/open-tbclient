package com.baidu.tieba.im.searchfriend.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        com.baidu.tieba.im.searchfriend.a.a friendInfo;
        com.baidu.tbadk.core.a.a a;
        t<String> b;
        if (customMessage != null && (customMessage instanceof RequestRecommendWriteMessage) && (friendInfo = ((RequestRecommendWriteMessage) customMessage).getFriendInfo()) != null && (a = com.baidu.tbadk.core.a.a.a()) != null && (b = a.b("tb.recommend_friend")) != null) {
            String currentAccount = TbadkApplication.getCurrentAccount();
            b.c(currentAccount);
            BdLog.e("WriteCache:" + friendInfo.c().toString());
            b.a(currentAccount, friendInfo.c().toString());
        }
        return null;
    }
}
