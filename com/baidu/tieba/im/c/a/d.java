package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
/* loaded from: classes5.dex */
public class d implements CustomMessageTask.CustomRunnable<Integer> {
    private ResponseGetGroupActivityLocalMessage bwi() {
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = new ResponseGetGroupActivityLocalMessage();
        responseGetGroupActivityLocalMessage.setError(-18);
        return responseGetGroupActivityLocalMessage;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestGetGroupActivityLocalMessage)) {
            return bwi();
        }
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = (RequestGetGroupActivityLocalMessage) customMessage;
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] bArr = com.baidu.tbadk.core.c.a.aaW().lu("tb.im_groupactivity").get("group_activity" + str + requestGetGroupActivityLocalMessage.getData());
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = new ResponseGetGroupActivityLocalMessage();
        if (bArr != null) {
            try {
                responseGetGroupActivityLocalMessage.decodeInBackGround(2001123, bArr);
                return responseGetGroupActivityLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bwi();
    }
}
