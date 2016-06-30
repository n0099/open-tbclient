package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bKk = aVar;
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
        aVar = this.bKk.bKe;
        dc dcVar = (dc) y.c(aVar.Yl(), i);
        if (dcVar != null) {
            i2 = this.bKk.bKf;
            if (i2 == dcVar.bGN) {
                cVar.dismiss();
                return;
            }
            ay ayVar = new ay("c10990");
            if (dcVar.bGN == 2) {
                ayVar.s("obj_locate", 1);
            } else if (dcVar.bGN == 3) {
                ayVar.s("obj_locate", 2);
            } else if (dcVar.bGN == 4) {
                ayVar.s("obj_locate", 3);
            } else if (dcVar.bGN == 5) {
                ayVar.s("obj_locate", 4);
            } else if (dcVar.bGN == 6) {
                ayVar.s("obj_locate", 5);
            }
            TiebaStatic.log(ayVar);
            this.bKk.bKg = true;
            textView = this.bKk.bKc;
            textView.setText(dcVar.name);
            this.bKk.bKf = dcVar.bGN;
            cVar.dismiss();
            frsActivity = this.bKk.bKb;
            if (frsActivity.VG() != null) {
                frsActivity2 = this.bKk.bKb;
                if (frsActivity2.VQ() != null) {
                    frsActivity3 = this.bKk.bKb;
                    frsActivity3.VG().hs(dcVar.bGN);
                    frsActivity4 = this.bKk.bKb;
                    frsActivity4.VQ().jB();
                    return;
                }
                return;
            }
            return;
        }
        cVar.dismiss();
    }
}
