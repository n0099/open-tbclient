package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tieba.im.chat.receiveChatMsgHandler.b {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.a = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        c.b().a(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        if (z) {
            MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(String str, List<CommonMsgPojo> list) {
        if (list != null && list.size() != 0) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                    com.baidu.tieba.im.chat.receiveChatMsgHandler.a.a(commonMsgPojo.getContent());
                }
            }
        }
    }
}
