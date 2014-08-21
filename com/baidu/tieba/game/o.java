package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        GameCenterHomeActivity gameCenterHomeActivity;
        GameCenterHomeActivity gameCenterHomeActivity2;
        int intValue = ((Integer) view.getTag()).intValue();
        list = this.a.m;
        if (intValue < list.size() && intValue >= 0) {
            list2 = this.a.m;
            com.baidu.tbadk.game.b bVar = (com.baidu.tbadk.game.b) list2.get(intValue);
            if (bVar != null) {
                if (bVar.c() == 2) {
                    gameCenterHomeActivity2 = this.a.b;
                    com.baidu.tbadk.game.a.a(gameCenterHomeActivity2, bVar.b(), bVar.h(), bVar.a());
                    ae.a().i(bVar);
                    this.a.d().add(this.a.c().get(intValue));
                    this.a.c().remove(intValue);
                    this.a.e();
                    return;
                }
                switch (ae.a().j(bVar)) {
                    case 1:
                        ae.a().d(bVar);
                        if (com.baidu.adp.lib.network.willdelete.h.a()) {
                            return;
                        }
                        this.a.k();
                        return;
                    case 2:
                        ae.a().c(bVar);
                        return;
                    case 3:
                        ae.a().d(bVar);
                        if (com.baidu.adp.lib.network.willdelete.h.a()) {
                            return;
                        }
                        this.a.k();
                        return;
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
