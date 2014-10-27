package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    final /* synthetic */ av aIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(av avVar) {
        this.aIW = avVar;
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
        list = this.aIW.aIB;
        if (list != null && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
            list2 = this.aIW.aIB;
            if (intValue < list2.size()) {
                list3 = this.aIW.aIB;
                GameInfoData gameInfoData = (GameInfoData) list3.get(intValue);
                if (gameInfoData != null) {
                    if (gameInfoData.getGameType() == 2) {
                        gameCenterActivity2 = this.aIW.aIg;
                        com.baidu.tbadk.game.a.a(gameCenterActivity2, gameInfoData.getGameName(), gameInfoData.getGameLink(), gameInfoData.getGameId());
                        gameCenterActivity3 = this.aIW.aIg;
                        TiebaStatic.eventStat(gameCenterActivity3, "start_game", "click", 1, gameInfoData.getGameId());
                        return;
                    }
                    switch (ab.Hs().n(gameInfoData)) {
                        case 5:
                            ab.Hs().h(gameInfoData);
                            return;
                        case 6:
                            ab.Hs().g(gameInfoData);
                            gameCenterActivity = this.aIW.aIg;
                            TiebaStatic.eventStat(gameCenterActivity, "start_game", "click", 1, gameInfoData.getGameId());
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
