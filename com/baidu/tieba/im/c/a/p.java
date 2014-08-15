package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
/* loaded from: classes.dex */
public class p implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestOfficialBarMenuLocalMessage)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.a.a.a().a("tb.official_bar_menu").a(ResponseOfficialBarMenuMessage.OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuLocalMessage) customMessage).getForum_id());
        ResponseOfficialBarMenuLocalMessage responseOfficialBarMenuLocalMessage = new ResponseOfficialBarMenuLocalMessage();
        try {
            responseOfficialBarMenuLocalMessage.decodeInBackGround(2001181, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseOfficialBarMenuLocalMessage;
    }
}
