package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        GameCenterHomeActivity gameCenterHomeActivity;
        GameCenterHomeActivity gameCenterHomeActivity2;
        list = this.a.n;
        if (list != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            list2 = this.a.n;
            com.baidu.tbadk.game.b bVar = (com.baidu.tbadk.game.b) list2.get(intValue);
            if (bVar != null) {
                if (bVar.c() == 2) {
                    gameCenterHomeActivity2 = this.a.b;
                    com.baidu.tbadk.game.a.a(gameCenterHomeActivity2, bVar.b(), bVar.h(), bVar.a());
                    return;
                }
                switch (ae.a().j(bVar)) {
                    case 4:
                        ae.a().f(bVar);
                        return;
                    case 5:
                        ae.a().e(bVar);
                        gameCenterHomeActivity = this.a.b;
                        TiebaStatic.eventStat(gameCenterHomeActivity, "start_game", "click", 1, bVar.a());
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
