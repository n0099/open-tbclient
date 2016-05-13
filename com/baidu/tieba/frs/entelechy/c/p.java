package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements UserLikeButton.a {
    final /* synthetic */ o bpH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bpH = oVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void cW(int i) {
        this.bpH.ft(i);
    }
}
