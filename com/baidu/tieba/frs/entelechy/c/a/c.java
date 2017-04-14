package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.smartsort.e;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bTl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bTl = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        int i2;
        TextView textView;
        int i3;
        int i4;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        String str;
        FrsActivity frsActivity6;
        if (!i.gX()) {
            frsActivity6 = this.bTl.bTd;
            frsActivity6.showToast(w.l.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.bTl.bTg;
        bv bvVar = (bv) x.c(aVar.abP(), i);
        if (bvVar != null) {
            i2 = this.bTl.bTh;
            if (i2 != bvVar.bPO) {
                this.bTl.bTi = true;
                textView = this.bTl.bTe;
                textView.setText(bvVar.name);
                i3 = this.bTl.bTh;
                if (i3 == 7) {
                    as asVar = new as("c11437");
                    asVar.s("obj_locate", bvVar.bPO);
                    str = this.bTl.bqv;
                    asVar.aa("fid", str);
                    TiebaStatic.log(asVar);
                }
                this.bTl.bTh = bvVar.bPO;
                cVar.dismiss();
                i4 = this.bTl.bTh;
                if (i4 != 7) {
                    r.Ht();
                    s.bjl();
                } else {
                    s.bjk();
                }
                frsActivity = this.bTl.bTd;
                if (frsActivity.YT() != null) {
                    frsActivity2 = this.bTl.bTd;
                    if (frsActivity2.Za() != null) {
                        frsActivity3 = this.bTl.bTd;
                        frsActivity3.YT().iq(bvVar.bPO);
                        frsActivity4 = this.bTl.bTd;
                        frsActivity4.Za().startPullRefresh();
                        frsActivity5 = this.bTl.bTd;
                        e.adl().f(frsActivity5.YT().getForumName(), bvVar.bPO, bvVar.name);
                        return;
                    }
                    return;
                }
                return;
            }
            cVar.dismiss();
            return;
        }
        cVar.dismiss();
    }
}
