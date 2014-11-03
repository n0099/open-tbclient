package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    final /* synthetic */ av aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(av avVar) {
        this.aJj = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        int intValue;
        List list2;
        List list3;
        GameCenterActivity gameCenterActivity;
        GameCenterActivity gameCenterActivity2;
        GameCenterActivity gameCenterActivity3;
        list = this.aJj.aIO;
        if (list != null && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
            list2 = this.aJj.aIO;
            if (intValue < list2.size()) {
                list3 = this.aJj.aIO;
                GameInfoData gameInfoData = (GameInfoData) list3.get(intValue);
                if (gameInfoData != null) {
                    if (gameInfoData.getGameType() == 2) {
                        gameCenterActivity2 = this.aJj.aIs;
                        com.baidu.tbadk.game.a.a(gameCenterActivity2, gameInfoData.getGameName(), gameInfoData.getGameLink(), gameInfoData.getGameId());
                        gameCenterActivity3 = this.aJj.aIs;
                        TiebaStatic.eventStat(gameCenterActivity3, "start_game", "click", 1, "dev_id", gameInfoData.getGameId(), "ref_id", "3000201");
                        return;
                    }
                    switch (ab.Hu().o(gameInfoData)) {
                        case 5:
                            ab.Hu().i(gameInfoData);
                            return;
                        case 6:
                            ab.Hu().h(gameInfoData);
                            gameCenterActivity = this.aJj.aIs;
                            TiebaStatic.eventStat(gameCenterActivity, "start_game", "click", 1, "dev_id", gameInfoData.getGameId(), "ref_id", "3000201");
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
