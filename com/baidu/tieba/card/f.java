package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements UserLikeButton.a {
    final /* synthetic */ e aYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aYZ = eVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dm(int i) {
        this.aYZ.gh(i);
    }
}
