package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
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
        c.PN().e(imMessageCenterPojo);
        c.PN().a(-1, imMessageCenterPojo.getPulled_msgId(), String.valueOf(com.baidu.tieba.im.chat.w.aNT));
        if (z) {
            MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void b(String str, List<CommonMsgPojo> list) {
        for (CommonMsgPojo commonMsgPojo : list) {
            if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
            }
        }
    }
}
