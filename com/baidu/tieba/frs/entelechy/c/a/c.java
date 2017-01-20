package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.smartsort.e;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bMr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bMr = aVar;
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
        if (!i.fX()) {
            frsActivity6 = this.bMr.bMj;
            frsActivity6.showToast(r.l.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.bMr.bMm;
        bt btVar = (bt) w.c(aVar.aaw(), i);
        if (btVar != null) {
            i2 = this.bMr.bMn;
            if (i2 != btVar.bIQ) {
                this.bMr.bMo = true;
                textView = this.bMr.bMk;
                textView.setText(btVar.name);
                i3 = this.bMr.bMn;
                if (i3 == 7) {
                    ar arVar = new ar("c11437");
                    arVar.s("obj_locate", btVar.bIQ);
                    str = this.bMr.bjT;
                    arVar.ab("fid", str);
                    TiebaStatic.log(arVar);
                }
                this.bMr.bMn = btVar.bIQ;
                cVar.dismiss();
                i4 = this.bMr.bMn;
                if (i4 != 7) {
                    com.baidu.tbadk.util.r.Gv();
                    s.biK();
                } else {
                    s.biJ();
                }
                frsActivity = this.bMr.bMj;
                if (frsActivity.Xy() != null) {
                    frsActivity2 = this.bMr.bMj;
                    if (frsActivity2.XF() != null) {
                        frsActivity3 = this.bMr.bMj;
                        frsActivity3.Xy().it(btVar.bIQ);
                        frsActivity4 = this.bMr.bMj;
                        frsActivity4.XF().startPullRefresh();
                        frsActivity5 = this.bMr.bMj;
                        e.act().f(frsActivity5.Xy().getForumName(), btVar.bIQ, btVar.name);
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
