package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.SendForeNoticeResponseMessage;
/* loaded from: classes.dex */
class h extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.a.hideProgressBar();
        if (this.a.o != null) {
            this.a.o.d.setEnabled(true);
            this.a.o.c.setEnabled(true);
        }
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 107107) {
            if (!(socketResponsedMessage instanceof SendForeNoticeResponseMessage)) {
                this.a.showToast(com.baidu.tieba.u.neterror);
                return;
            }
            SendForeNoticeResponseMessage sendForeNoticeResponseMessage = (SendForeNoticeResponseMessage) socketResponsedMessage;
            if (sendForeNoticeResponseMessage.hasError()) {
                if (com.baidu.adp.lib.util.g.b(sendForeNoticeResponseMessage.getUserMsg())) {
                    this.a.showToast(com.baidu.tieba.u.neterror);
                } else {
                    this.a.showToast(sendForeNoticeResponseMessage.getUserMsg());
                }
                this.a.n = true;
                return;
            }
            this.a.showToast(sendForeNoticeResponseMessage.getUserMsg());
            this.a.n = false;
            if (this.a.o != null) {
                this.a.o.dismiss();
            }
        }
    }
}
