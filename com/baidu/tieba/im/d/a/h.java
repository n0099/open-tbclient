package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
/* loaded from: classes.dex */
public class h implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        byte[] bArr;
        if (customMessage == null || !(customMessage instanceof RequestGroupInfoLocalMessage)) {
            return RK();
        }
        RequestGroupInfoLocalMessage requestGroupInfoLocalMessage = (RequestGroupInfoLocalMessage) customMessage;
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        String str2 = "group_info" + str + requestGroupInfoLocalMessage.getGroupId();
        com.baidu.adp.lib.cache.t<byte[]> bc = com.baidu.tbadk.core.a.a.kS().bc("tb.im_groupactivity");
        if (bc != null && (bArr = bc.get(str2)) != null) {
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
            try {
                responseGroupInfoLocalMessage.decodeInBackGround(2001102, bArr);
                return responseGroupInfoLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return RK();
    }

    private CustomResponsedMessage<?> RK() {
        ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
        responseGroupInfoLocalMessage.setError(-18);
        return responseGroupInfoLocalMessage;
    }
}
