package com.baidu.tieba.chat;

import com.baidu.tieba.im.message.bn;
import com.baidu.tieba.im.message.q;
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
    public void a(q qVar) {
        if (qVar != null && qVar.w() == 103104 && (qVar instanceof bn)) {
            bn bnVar = (bn) qVar;
            if (bnVar.l() > 0) {
                this.a.a(bnVar.m());
            } else if (bnVar.l() < 0) {
                this.a.c(R.string.neterror);
            } else {
                this.a.b(bnVar.a() + "");
            }
        }
    }
}
