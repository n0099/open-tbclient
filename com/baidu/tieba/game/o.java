package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
        list = this.a.l;
        if (intValue < list.size() && intValue >= 0) {
            list2 = this.a.l;
            ab abVar = (ab) list2.get(intValue);
            if (abVar != null) {
                if (abVar.c() == 2) {
                    gameCenterHomeActivity2 = this.a.a;
                    UtilHelper.launchWebGameActivity(gameCenterHomeActivity2, abVar.b(), abVar.h());
                    ac.a().i(abVar);
                    this.a.d().add(this.a.c().get(intValue));
                    this.a.c().remove(intValue);
                    this.a.e();
                    return;
                }
                switch (ac.a().j(abVar)) {
                    case 1:
                        ac.a().d(abVar);
                        if (com.baidu.adp.lib.network.willdelete.h.a()) {
                            return;
                        }
                        this.a.j();
                        return;
                    case 2:
                        ac.a().c(abVar);
                        return;
                    case 3:
                        ac.a().d(abVar);
                        if (com.baidu.adp.lib.network.willdelete.h.a()) {
                            return;
                        }
                        this.a.j();
                        return;
                    case 4:
                        ac.a().f(abVar);
                        return;
                    case 5:
                        ac.a().e(abVar);
                        gameCenterHomeActivity = this.a.a;
                        TiebaStatic.eventStat(gameCenterHomeActivity, "start_game", "click", 1, abVar.a());
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
