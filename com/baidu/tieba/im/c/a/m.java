package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
/* loaded from: classes3.dex */
public class m implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestOfficialBarMenuLocalMessage)) {
            return null;
        }
        byte[] bArr = com.baidu.tbadk.core.c.a.xb().dx("tb.official_bar_menu").get(ResponseOfficialBarMenuMessage.OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuLocalMessage) customMessage).getForum_id());
        ResponseOfficialBarMenuLocalMessage responseOfficialBarMenuLocalMessage = new ResponseOfficialBarMenuLocalMessage();
        try {
            responseOfficialBarMenuLocalMessage.decodeInBackGround(2001177, bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseOfficialBarMenuLocalMessage;
    }
}
