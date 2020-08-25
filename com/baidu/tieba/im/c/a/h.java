package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
/* loaded from: classes17.dex */
public class h implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        byte[] bArr;
        if (customMessage == null || !(customMessage instanceof RequestGroupInfoLocalMessage)) {
            return cIq();
        }
        RequestGroupInfoLocalMessage requestGroupInfoLocalMessage = (RequestGroupInfoLocalMessage) customMessage;
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        String str2 = "group_info" + str + requestGroupInfoLocalMessage.getGroupId();
        com.baidu.adp.lib.cache.l<byte[]> zw = com.baidu.tbadk.core.c.a.bhb().zw("tb.im_groupactivity");
        if (zw != null && (bArr = zw.get(str2)) != null) {
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
            try {
                responseGroupInfoLocalMessage.decodeInBackGround(CmdConfigCustom.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, bArr);
                return responseGroupInfoLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cIq();
    }

    private CustomResponsedMessage<?> cIq() {
        ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
        responseGroupInfoLocalMessage.setError(-18);
        return responseGroupInfoLocalMessage;
    }
}
