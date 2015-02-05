package com.baidu.tbadk.live.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.live.message.RequestMyLiveListLocalMessage;
import com.baidu.tbadk.live.message.ResponseMyLiveListLocalMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestMyLiveListLocalMessage)) {
            return null;
        }
        String valueOf = String.valueOf(((RequestMyLiveListLocalMessage) customMessage).getType());
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        byte[] bArr = com.baidu.tbadk.core.a.a.nO().bP("tb.live_hotlist").get("mylive_" + valueOf + currentAccount);
        ResponseMyLiveListLocalMessage responseMyLiveListLocalMessage = new ResponseMyLiveListLocalMessage();
        try {
            responseMyLiveListLocalMessage.decodeInBackGround(2001165, bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMyLiveListLocalMessage;
    }
}
