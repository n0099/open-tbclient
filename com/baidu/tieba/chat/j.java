package com.baidu.tieba.chat;

import com.baidu.tieba.im.message.bv;
import com.baidu.tieba.im.message.s;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        if (sVar != null && sVar.v() == 103104 && (sVar instanceof bv)) {
            bv bvVar = (bv) sVar;
            if (bvVar.m() > 0) {
                this.a.a(bvVar.n());
            } else if (bvVar.m() < 0) {
                this.a.a(R.string.neterror);
            } else {
                new StringBuilder(String.valueOf(bvVar.a())).toString();
                this.a.b();
            }
        }
    }
}
