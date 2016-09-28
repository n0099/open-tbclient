package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements UserLikeButton.a {
    final /* synthetic */ aj bad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.bad = ajVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dm(int i) {
        this.bad.gh(i);
    }
}
