package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
/* loaded from: classes.dex */
public class e implements CustomMessageTask.CustomRunnable<Integer> {
    private ResponseGetGroupActivityLocalMessage a() {
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = new ResponseGetGroupActivityLocalMessage();
        responseGetGroupActivityLocalMessage.setError(-18);
        return responseGetGroupActivityLocalMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestGetGroupActivityLocalMessage)) {
            return a();
        }
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = (RequestGetGroupActivityLocalMessage) customMessage;
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().u().a("group_activity" + str + requestGetGroupActivityLocalMessage.getData());
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = new ResponseGetGroupActivityLocalMessage();
        if (a != null) {
            try {
                responseGetGroupActivityLocalMessage.decodeInBackGround(2001127, a);
                return responseGetGroupActivityLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a();
    }
}
