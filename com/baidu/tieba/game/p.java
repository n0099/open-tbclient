package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
        list = this.a.m;
        if (list != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            list2 = this.a.m;
            ab abVar = (ab) list2.get(intValue);
            if (abVar != null) {
                if (abVar.c() == 2) {
                    gameCenterHomeActivity2 = this.a.a;
                    UtilHelper.launchWebGameActivity(gameCenterHomeActivity2, abVar.b(), abVar.h());
                    return;
                }
                switch (ac.a().j(abVar)) {
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
