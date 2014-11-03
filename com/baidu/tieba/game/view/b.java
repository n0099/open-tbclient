package com.baidu.tieba.game.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.ab;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ GameDownloadView aKx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GameDownloadView gameDownloadView) {
        this.aKx = gameDownloadView;
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
                context2 = this.aKx.mContext;
                com.baidu.tbadk.game.a.a(context2, gameInfoData.getGameName(), gameInfoData.getGameLink(), gameInfoData.getGameId());
                context3 = this.aKx.mContext;
                TiebaStatic.eventStat(context3, "start_game", "click", 1, "dev_id", gameInfoData.getGameId(), "ref_id", gameInfoData.getRefId());
            } else {
                int o = ab.Hu().o(gameInfoData);
                switch (o) {
                    case 1:
                        ab.Hu().g(gameInfoData);
                        this.aKx.Is();
                        com.baidu.tbadk.game.d.rX().q(gameInfoData.getGameId(), 1);
                        i = o;
                        break;
                    case 2:
                    case 3:
                        ab.Hu().f(gameInfoData);
                        this.aKx.t(ab.Hu().d(gameInfoData));
                        i = o;
                        break;
                    case 4:
                        ab.Hu().g(gameInfoData);
                        this.aKx.Is();
                        i = o;
                        break;
                    case 5:
                        ab.Hu().i(gameInfoData);
                        i = o;
                        break;
                    case 6:
                        ab.Hu().h(gameInfoData);
                        context = this.aKx.mContext;
                        TiebaStatic.eventStat(context, "start_game", "click", 1, "dev_id", gameInfoData.getGameId(), "ref_id", gameInfoData.getRefId());
                        i = o;
                        break;
                    case 7:
                        ab.Hu().g(gameInfoData);
                        this.aKx.Is();
                    default:
                        i = o;
                        break;
                }
            }
            cVar = this.aKx.aJd;
            if (cVar != null) {
                cVar2 = this.aKx.aJd;
                cVar2.onClick(gameInfoData, i);
            }
        }
    }
}
