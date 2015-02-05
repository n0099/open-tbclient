package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        c.QJ().l(imMessageCenterPojo);
        if (z) {
            MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        for (CommonMsgPojo commonMsgPojo : list) {
            if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                com.baidu.tieba.im.data.g a = com.baidu.tieba.im.util.i.a(commonMsgPojo);
                if (a != null) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m255getInst(), "message_receive", "receive", 1, "task_type", a.aXW, "task_id", a.aXX);
                }
            }
        }
    }
}
