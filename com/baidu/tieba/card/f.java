package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements UserLikeButton.a {
    final /* synthetic */ e aYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aYx = eVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dm(int i) {
        this.aYx.gc(i);
    }
}
