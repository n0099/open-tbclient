package com.baidu.tieba.game.newgame;

import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.a.f;
import com.baidu.tieba.game.ab;
import java.util.List;
/* loaded from: classes.dex */
class b implements f {
    final /* synthetic */ GameNewActivity aKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GameNewActivity gameNewActivity) {
        this.aKg = gameNewActivity;
    }

    @Override // com.baidu.tieba.game.a.f
    public void Il() {
        d dVar;
        dVar = this.aKg.aKe;
        List<GameInfoData> data = dVar.getData();
        if (data != null) {
            for (GameInfoData gameInfoData : data) {
                if (ab.Hu().c(gameInfoData)) {
                    this.aKg.Ii();
                    return;
                }
            }
        }
    }
}
