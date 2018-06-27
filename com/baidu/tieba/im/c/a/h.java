package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
/* loaded from: classes3.dex */
public class h implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        byte[] bArr;
        if (customMessage == null || !(customMessage instanceof RequestGroupInfoLocalMessage)) {
            return aMC();
        }
        RequestGroupInfoLocalMessage requestGroupInfoLocalMessage = (RequestGroupInfoLocalMessage) customMessage;
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        String str2 = "group_info" + str + requestGroupInfoLocalMessage.getGroupId();
        com.baidu.adp.lib.cache.l<byte[]> dA = com.baidu.tbadk.core.c.a.xj().dA("tb.im_groupactivity");
        if (dA != null && (bArr = dA.get(str2)) != null) {
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
            try {
                responseGroupInfoLocalMessage.decodeInBackGround(2001102, bArr);
                return responseGroupInfoLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aMC();
    }

    private CustomResponsedMessage<?> aMC() {
        ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
        responseGroupInfoLocalMessage.setError(-18);
        return responseGroupInfoLocalMessage;
    }
}
