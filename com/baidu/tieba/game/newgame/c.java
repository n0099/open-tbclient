package com.baidu.tieba.game.newgame;

import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.game.view.c {
    final /* synthetic */ GameNewActivity aKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GameNewActivity gameNewActivity) {
        this.aKg = gameNewActivity;
    }

    @Override // com.baidu.tieba.game.view.c
    public void onClick(GameInfoData gameInfoData, int i) {
        com.baidu.tieba.game.a.b bVar;
        bVar = this.aKg.aKf;
        if (bVar.fi(i)) {
            this.aKg.Ii();
        }
    }
}
