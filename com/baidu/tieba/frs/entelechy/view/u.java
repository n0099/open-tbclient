package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements UserLikeButton.a {
    final /* synthetic */ t bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bXo = tVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dm(int i) {
        this.bXo.gc(i);
    }
}
