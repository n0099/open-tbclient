package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.tbadkCore.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bWZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bWZ = aVar;
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
        aVar = this.bWZ.bWU;
        cy cyVar = (cy) y.c(aVar.adF(), i);
        if (cyVar != null) {
            i2 = this.bWZ.bWV;
            if (i2 == cyVar.bTi) {
                cVar.dismiss();
                return;
            }
            ax axVar = new ax("c11437");
            axVar.s("obj_locate", cyVar.bTi);
            str = this.bWZ.aPG;
            axVar.ab("fid", str);
            TiebaStatic.log(axVar);
            this.bWZ.bWW = true;
            textView = this.bWZ.bWS;
            textView.setText(cyVar.name);
            this.bWZ.bWV = cyVar.bTi;
            cVar.dismiss();
            i3 = this.bWZ.bWV;
            if (i3 != 7) {
                s.He();
                t.bkP();
            } else {
                t.bkO();
            }
            frsActivity = this.bWZ.bWR;
            if (frsActivity.abi() != null) {
                frsActivity2 = this.bWZ.bWR;
                if (frsActivity2.abs() != null) {
                    frsActivity3 = this.bWZ.bWR;
                    frsActivity3.abi().hY(cyVar.bTi);
                    frsActivity4 = this.bWZ.bWR;
                    frsActivity4.abs().kv();
                    return;
                }
                return;
            }
            return;
        }
        cVar.dismiss();
    }
}
