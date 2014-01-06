package com.baidu.tieba.chat;

import com.baidu.tieba.im.message.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null && oVar.u() == 103104 && (oVar instanceof be)) {
            be beVar = (be) oVar;
            if (beVar.j() > 0) {
                this.a.a(beVar.k());
            } else if (beVar.j() < 0) {
                this.a.b(R.string.neterror);
            } else {
                this.a.b(beVar.a() + "");
            }
        }
    }
}
