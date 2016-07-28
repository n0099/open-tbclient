package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements UserLikeButton.a {
    final /* synthetic */ al aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.aUz = alVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void cY(int i) {
        this.aUz.fE(i);
    }
}
