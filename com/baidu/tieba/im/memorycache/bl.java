package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements a.b {
    final /* synthetic */ ImMemoryCacheRegister this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(ImMemoryCacheRegister imMemoryCacheRegister) {
        this.this$0 = imMemoryCacheRegister;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        b.asc().g(imMessageCenterPojo);
        if (z) {
            MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
        for (CommonMsgPojo commonMsgPojo : list) {
            if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                com.baidu.tieba.im.data.d a = com.baidu.tieba.im.util.h.a(commonMsgPojo);
                if (a != null) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m9getInst(), "message_receive", "receive", 1, "task_type", a.cSU, InterviewLiveActivityConfig.KEY_TASK_ID, a.taskId);
                }
            }
        }
    }
}
