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
            return aHb();
        }
        RequestGroupInfoLocalMessage requestGroupInfoLocalMessage = (RequestGroupInfoLocalMessage) customMessage;
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        String str2 = "group_info" + str + requestGroupInfoLocalMessage.getGroupId();
        com.baidu.adp.lib.cache.l<byte[]> cY = com.baidu.tbadk.core.c.a.ty().cY("tb.im_groupactivity");
        if (cY != null && (bArr = cY.get(str2)) != null) {
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
            try {
                responseGroupInfoLocalMessage.decodeInBackGround(2001102, bArr);
                return responseGroupInfoLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aHb();
    }

    private CustomResponsedMessage<?> aHb() {
        ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
        responseGroupInfoLocalMessage.setError(-18);
        return responseGroupInfoLocalMessage;
    }
}
