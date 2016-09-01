package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements UserLikeButton.a {
    final /* synthetic */ ah aZK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.aZK = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dm(int i) {
        this.aZK.gc(i);
    }
}
