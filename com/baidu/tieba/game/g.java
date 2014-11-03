package com.baidu.tieba.game;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ GameCenterActivity aGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GameCenterActivity gameCenterActivity) {
        this.aGY = gameCenterActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aGY.finish();
    }
}
