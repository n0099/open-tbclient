package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.em;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bpB = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a aVar;
        int i2;
        TextView textView;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        aVar = this.bpB.bpw;
        em emVar = (em) y.c(aVar.SK(), i);
        if (emVar != null) {
            i2 = this.bpB.bpx;
            if (i2 == emVar.blZ) {
                cVar.dismiss();
                return;
            }
            aw awVar = new aw("c10990");
            if (emVar.blZ == 2) {
                awVar.s("obj_locate", 1);
            } else if (emVar.blZ == 3) {
                awVar.s("obj_locate", 2);
            } else if (emVar.blZ == 4) {
                awVar.s("obj_locate", 3);
            } else if (emVar.blZ == 5) {
                awVar.s("obj_locate", 4);
            } else if (emVar.blZ == 6) {
                awVar.s("obj_locate", 5);
            }
            TiebaStatic.log(awVar);
            textView = this.bpB.bpu;
            textView.setText(emVar.name);
            this.bpB.bpx = emVar.blZ;
            cVar.dismiss();
            frsActivity = this.bpB.bpt;
            if (frsActivity.Qd() != null) {
                frsActivity2 = this.bpB.bpt;
                if (frsActivity2.Qn() != null) {
                    frsActivity3 = this.bpB.bpt;
                    frsActivity3.Qd().gG(emVar.blZ);
                    frsActivity4 = this.bpB.bpt;
                    frsActivity4.Qn().jy();
                    return;
                }
                return;
            }
            return;
        }
        cVar.dismiss();
    }
}
