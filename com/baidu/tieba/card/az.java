package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements UserLikeButton.a {
    final /* synthetic */ ay aTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.aTS = ayVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void dp(int i) {
        this.aTS.fL(i);
    }
}
