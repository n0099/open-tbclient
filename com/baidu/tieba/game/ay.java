package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ av aIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(av avVar) {
        this.aIW = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GameCenterActivity gameCenterActivity;
        GameCenterActivity gameCenterActivity2;
        GameCenterActivity gameCenterActivity3;
        gameCenterActivity = this.aIW.aIg;
        if (gameCenterActivity != null) {
            gameCenterActivity3 = this.aIW.aIg;
            gameCenterActivity3.eZ(0);
        }
        gameCenterActivity2 = this.aIW.aIg;
        TiebaStatic.eventStat(gameCenterActivity2, "gcenter_more", "click", 1, new Object[0]);
    }
}
