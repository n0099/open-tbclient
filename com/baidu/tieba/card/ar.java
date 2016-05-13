package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.UserLikeButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements UserLikeButton.a {
    final /* synthetic */ aq aQm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.aQm = aqVar;
    }

    @Override // com.baidu.tbadk.core.view.UserLikeButton.a
    public void cW(int i) {
        this.aQm.ft(i);
    }
}
