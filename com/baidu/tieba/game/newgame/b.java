package com.baidu.tieba.game.newgame;

import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.a.f;
import com.baidu.tieba.game.ab;
import java.util.List;
/* loaded from: classes.dex */
class b implements f {
    final /* synthetic */ GameNewActivity aJT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GameNewActivity gameNewActivity) {
        this.aJT = gameNewActivity;
    }

    @Override // com.baidu.tieba.game.a.f
    public void Ih() {
        d dVar;
        dVar = this.aJT.aJR;
        List<GameInfoData> data = dVar.getData();
        if (data != null) {
            for (GameInfoData gameInfoData : data) {
                if (ab.Hs().b(gameInfoData)) {
                    this.aJT.Ie();
                    return;
                }
            }
        }
    }
}
