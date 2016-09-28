package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements UserLikeButton.a {
    final /* synthetic */ af bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bab = afVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dm(int i) {
        this.bab.gh(i);
    }
}
