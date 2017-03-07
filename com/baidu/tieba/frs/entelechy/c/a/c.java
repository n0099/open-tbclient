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
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.smartsort.e;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bTx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bTx = aVar;
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
        if (!i.gS()) {
            frsActivity6 = this.bTx.bTp;
            frsActivity6.showToast(w.l.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.bTx.bTs;
        bt btVar = (bt) x.c(aVar.abt(), i);
        if (btVar != null) {
            i2 = this.bTx.bTt;
            if (i2 != btVar.bPZ) {
                this.bTx.bTu = true;
                textView = this.bTx.bTq;
                textView.setText(btVar.name);
                i3 = this.bTx.bTt;
                if (i3 == 7) {
                    as asVar = new as("c11437");
                    asVar.s("obj_locate", btVar.bPZ);
                    str = this.bTx.bqC;
                    asVar.Z("fid", str);
                    TiebaStatic.log(asVar);
                }
                this.bTx.bTt = btVar.bPZ;
                cVar.dismiss();
                i4 = this.bTx.bTt;
                if (i4 != 7) {
                    r.GU();
                    s.biA();
                } else {
                    s.biz();
                }
                frsActivity = this.bTx.bTp;
                if (frsActivity.Yx() != null) {
                    frsActivity2 = this.bTx.bTp;
                    if (frsActivity2.YE() != null) {
                        frsActivity3 = this.bTx.bTp;
                        frsActivity3.Yx().ip(btVar.bPZ);
                        frsActivity4 = this.bTx.bTp;
                        frsActivity4.YE().startPullRefresh();
                        frsActivity5 = this.bTx.bTp;
                        e.adr().f(frsActivity5.Yx().getForumName(), btVar.bPZ, btVar.name);
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
