package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements CommonUserLikeButton.a {
    final /* synthetic */ e bci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bci = eVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
    public void dp(int i) {
        this.bci.gh(i);
    }
}
