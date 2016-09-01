package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements UserLikeButton.a {
    final /* synthetic */ p bXn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bXn = pVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dm(int i) {
        this.bXn.gc(i);
    }
}
