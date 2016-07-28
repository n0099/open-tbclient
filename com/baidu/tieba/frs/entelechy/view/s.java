package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements UserLikeButton.a {
    final /* synthetic */ r bLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.bLX = rVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void cY(int i) {
        this.bLX.fE(i);
    }
}
