package com.baidu.tieba.game;

import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
class aw implements com.baidu.tieba.game.view.c {
    final /* synthetic */ av aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.aJj = avVar;
    }

    @Override // com.baidu.tieba.game.view.c
    public void onClick(GameInfoData gameInfoData, int i) {
        if (gameInfoData.getGameType() == 2) {
            ab.Hu().n(gameInfoData);
            this.aJj.HC().add(gameInfoData);
            this.aJj.HB().remove(gameInfoData);
            this.aJj.HE();
        }
    }
}
