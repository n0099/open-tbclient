package com.baidu.tieba.chat;

import com.baidu.tieba.im.message.bb;
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
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar != null && nVar.t() == 103104 && (nVar instanceof bb)) {
            bb bbVar = (bb) nVar;
            if (bbVar.j() > 0) {
                this.a.a(bbVar.k());
            } else if (bbVar.j() < 0) {
                this.a.b(R.string.neterror);
            } else {
                this.a.b(bbVar.a() + "");
            }
        }
    }
}
