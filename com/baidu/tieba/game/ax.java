package com.baidu.tieba.game;

import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
class ax implements com.baidu.tieba.game.view.d {
    final /* synthetic */ av aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar) {
        this.aJj = avVar;
    }

    @Override // com.baidu.tieba.game.view.d
    public void a(GameInfoData gameInfoData, DownloadData downloadData) {
        ab.Hu().n(gameInfoData);
    }
}
