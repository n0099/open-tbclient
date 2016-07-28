package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.tbadkCore.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bLP = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        int i2;
        String str;
        TextView textView;
        int i3;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        aVar = this.bLP.bLK;
        dc dcVar = (dc) y.c(aVar.YF(), i);
        if (dcVar != null) {
            i2 = this.bLP.bLL;
            if (i2 == dcVar.bIj) {
                cVar.dismiss();
                return;
            }
            ay ayVar = new ay("c11437");
            ayVar.s("obj_type", dcVar.bIj);
            str = this.bLP.aeq;
            ayVar.ab("fid", str);
            TiebaStatic.log(ayVar);
            this.bLP.bLM = true;
            textView = this.bLP.bLI;
            textView.setText(dcVar.name);
            this.bLP.bLL = dcVar.bIj;
            cVar.dismiss();
            i3 = this.bLP.bLL;
            if (i3 != 7) {
                s.FL();
                t.bgC();
            } else {
                t.bgB();
            }
            frsActivity = this.bLP.bLH;
            if (frsActivity.VY() != null) {
                frsActivity2 = this.bLP.bLH;
                if (frsActivity2.Wj() != null) {
                    frsActivity3 = this.bLP.bLH;
                    frsActivity3.VY().hr(dcVar.bIj);
                    frsActivity4 = this.bLP.bLH;
                    frsActivity4.Wj().jA();
                    return;
                }
                return;
            }
            return;
        }
        cVar.dismiss();
    }
}
