package com.baidu.tieba.chat;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ChatListFragment chatListFragment) {
        this.f1196a = chatListFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        if (message != null && message.getCmd() == 103104 && (message instanceof ResponseDismissGroupMessage)) {
            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) message;
            if (responseDismissGroupMessage.getErrNo() > 0) {
                this.f1196a.a(responseDismissGroupMessage.getErrMsg());
            } else if (responseDismissGroupMessage.getErrNo() < 0) {
                this.f1196a.b(R.string.neterror);
            } else {
                this.f1196a.b(responseDismissGroupMessage.getGroupId() + "");
            }
        }
    }
}
