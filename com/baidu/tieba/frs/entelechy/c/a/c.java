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
    final /* synthetic */ a bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bVC = aVar;
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
        if (!i.gY()) {
            frsActivity6 = this.bVC.bVu;
            frsActivity6.showToast(w.l.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.bVC.bVx;
        bv bvVar = (bv) x.c(aVar.acQ(), i);
        if (bvVar != null) {
            i2 = this.bVC.bVy;
            if (i2 != bvVar.bSf) {
                this.bVC.bVz = true;
                textView = this.bVC.bVv;
                textView.setText(bvVar.name);
                i3 = this.bVC.bVy;
                if (i3 == 7) {
                    as asVar = new as("c11437");
                    asVar.s("obj_locate", bvVar.bSf);
                    str = this.bVC.bsM;
                    asVar.aa("fid", str);
                    TiebaStatic.log(asVar);
                }
                this.bVC.bVy = bvVar.bSf;
                cVar.dismiss();
                i4 = this.bVC.bVy;
                if (i4 != 7) {
                    r.Ht();
                    s.bkm();
                } else {
                    s.bkl();
                }
                frsActivity = this.bVC.bVu;
                if (frsActivity.ZU() != null) {
                    frsActivity2 = this.bVC.bVu;
                    if (frsActivity2.aab() != null) {
                        frsActivity3 = this.bVC.bVu;
                        frsActivity3.ZU().iw(bvVar.bSf);
                        frsActivity4 = this.bVC.bVu;
                        frsActivity4.aab().startPullRefresh();
                        frsActivity5 = this.bVC.bVu;
                        e.aem().f(frsActivity5.ZU().getForumName(), bvVar.bSf, bvVar.name);
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
