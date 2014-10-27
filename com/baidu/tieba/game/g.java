package com.baidu.tieba.game;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ GameCenterActivity aGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GameCenterActivity gameCenterActivity) {
        this.aGO = gameCenterActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aGO.finish();
    }
}
