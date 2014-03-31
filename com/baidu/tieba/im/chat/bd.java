package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryPrizeMessage;
/* loaded from: classes.dex */
final class bd extends com.baidu.adp.framework.c.g {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(GroupChatActivity groupChatActivity, int i) {
        super(103013);
        this.a = groupChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 instanceof ResponseQueryPrizeMessage) {
            ResponseQueryPrizeMessage responseQueryPrizeMessage = (ResponseQueryPrizeMessage) socketResponsedMessage2;
            if (responseQueryPrizeMessage.e() == 0) {
                if (responseQueryPrizeMessage.d() == 0) {
                    this.a.showToast(responseQueryPrizeMessage.i());
                } else {
                    com.baidu.tieba.im.widget.a.a(this.a, responseQueryPrizeMessage.j());
                }
            } else if (responseQueryPrizeMessage.e() <= 0 || TextUtils.isEmpty(responseQueryPrizeMessage.f())) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
            } else {
                this.a.showToast(responseQueryPrizeMessage.f());
            }
        }
    }
}
