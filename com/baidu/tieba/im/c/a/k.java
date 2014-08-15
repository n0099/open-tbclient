package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestMyLiveListLocalMessage;
import com.baidu.tieba.im.message.ResponseMyLiveListLocalMessage;
/* loaded from: classes.dex */
public class k implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestMyLiveListLocalMessage)) {
            return null;
        }
        String valueOf = String.valueOf(((RequestMyLiveListLocalMessage) customMessage).getType());
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        byte[] a = com.baidu.tbadk.core.a.a.a().a("tb.live_hotlist").a("mylive_" + valueOf + currentAccount);
        ResponseMyLiveListLocalMessage responseMyLiveListLocalMessage = new ResponseMyLiveListLocalMessage();
        try {
            responseMyLiveListLocalMessage.decodeInBackGround(2001165, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMyLiveListLocalMessage;
    }
}
