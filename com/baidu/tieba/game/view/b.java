package com.baidu.tieba.game.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.ab;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ GameDownloadView aKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GameDownloadView gameDownloadView) {
        this.aKj = gameDownloadView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        c cVar;
        c cVar2;
        Context context2;
        Context context3;
        int i = 1;
        if (view.getTag() != null && (view.getTag() instanceof GameInfoData)) {
            GameInfoData gameInfoData = (GameInfoData) view.getTag();
            if (gameInfoData.getGameType() == 2) {
                context2 = this.aKj.mContext;
                com.baidu.tbadk.game.a.a(context2, gameInfoData.getGameName(), gameInfoData.getGameLink(), gameInfoData.getGameId());
                context3 = this.aKj.mContext;
                TiebaStatic.eventStat(context3, "start_game", "click", 1, gameInfoData.getGameId());
            } else {
                int n = ab.Hs().n(gameInfoData);
                switch (n) {
                    case 1:
                        ab.Hs().f(gameInfoData);
                        this.aKj.Io();
                        com.baidu.tbadk.game.d.rV().q(gameInfoData.getGameId(), 1);
                        i = n;
                        break;
                    case 2:
                    case 3:
                        ab.Hs().e(gameInfoData);
                        this.aKj.t(ab.Hs().c(gameInfoData));
                        i = n;
                        break;
                    case 4:
                        ab.Hs().f(gameInfoData);
                        this.aKj.Io();
                        i = n;
                        break;
                    case 5:
                        ab.Hs().h(gameInfoData);
                        i = n;
                        break;
                    case 6:
                        ab.Hs().g(gameInfoData);
                        context = this.aKj.mContext;
                        TiebaStatic.eventStat(context, "start_game", "click", 1, gameInfoData.getGameId());
                        i = n;
                        break;
                    case 7:
                        ab.Hs().f(gameInfoData);
                        this.aKj.Io();
                    default:
                        i = n;
                        break;
                }
            }
            cVar = this.aKj.aIQ;
            if (cVar != null) {
                cVar2 = this.aKj.aIQ;
                cVar2.onClick(gameInfoData, i);
            }
        }
    }
}
