package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements UserLikeButton.a {
    final /* synthetic */ s bpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bpI = sVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void cX(int i) {
        this.bpI.fu(i);
    }
}
