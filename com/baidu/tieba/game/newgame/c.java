package com.baidu.tieba.game.newgame;

import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.game.view.c {
    final /* synthetic */ GameNewActivity aJT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GameNewActivity gameNewActivity) {
        this.aJT = gameNewActivity;
    }

    @Override // com.baidu.tieba.game.view.c
    public void onClick(GameInfoData gameInfoData, int i) {
        com.baidu.tieba.game.a.b bVar;
        bVar = this.aJT.aJS;
        if (bVar.fi(i)) {
            this.aJT.Ie();
        }
    }
}
