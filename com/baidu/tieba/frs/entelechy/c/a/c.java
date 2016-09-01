package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.tbadkCore.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bXf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bXf = aVar;
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
        aVar = this.bXf.bXa;
        cy cyVar = (cy) y.c(aVar.adr(), i);
        if (cyVar != null) {
            i2 = this.bXf.bXb;
            if (i2 == cyVar.bTp) {
                cVar.dismiss();
                return;
            }
            ay ayVar = new ay("c11437");
            ayVar.s("obj_locate", cyVar.bTp);
            str = this.bXf.ahj;
            ayVar.ab("fid", str);
            TiebaStatic.log(ayVar);
            this.bXf.bXc = true;
            textView = this.bXf.bWY;
            textView.setText(cyVar.name);
            this.bXf.bXb = cyVar.bTp;
            cVar.dismiss();
            i3 = this.bXf.bXb;
            if (i3 != 7) {
                s.Hf();
                t.bkd();
            } else {
                t.bkc();
            }
            frsActivity = this.bXf.bWX;
            if (frsActivity.aaV() != null) {
                frsActivity2 = this.bXf.bWX;
                if (frsActivity2.abg() != null) {
                    frsActivity3 = this.bXf.bWX;
                    frsActivity3.aaV().hU(cyVar.bTp);
                    frsActivity4 = this.bXf.bWX;
                    frsActivity4.abg().kv();
                    return;
                }
                return;
            }
            return;
        }
        cVar.dismiss();
    }
}
