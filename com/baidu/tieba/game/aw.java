package com.baidu.tieba.game;

import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
class aw implements com.baidu.tieba.game.view.c {
    final /* synthetic */ av aIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.aIW = avVar;
    }

    @Override // com.baidu.tieba.game.view.c
    public void onClick(GameInfoData gameInfoData, int i) {
        if (gameInfoData.getGameType() == 2) {
            ab.Hs().m(gameInfoData);
            this.aIW.Hz().add(gameInfoData);
            this.aIW.Hy().remove(gameInfoData);
            this.aIW.HB();
        }
    }
}
