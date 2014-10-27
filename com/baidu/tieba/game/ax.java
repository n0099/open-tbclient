package com.baidu.tieba.game;

import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
class ax implements com.baidu.tieba.game.view.d {
    final /* synthetic */ av aIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar) {
        this.aIW = avVar;
    }

    @Override // com.baidu.tieba.game.view.d
    public void a(GameInfoData gameInfoData, DownloadData downloadData) {
        ab.Hs().m(gameInfoData);
    }
}
