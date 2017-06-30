package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements a.b {
    final /* synthetic */ ImMemoryCacheRegister this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(ImMemoryCacheRegister imMemoryCacheRegister) {
        this.this$0 = imMemoryCacheRegister;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        b.auI().g(imMessageCenterPojo);
        if (z) {
            MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
    }
}
