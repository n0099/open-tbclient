package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.f.f;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bGa = aVar;
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
        if (!i.fZ()) {
            frsActivity6 = this.bGa.bFS;
            frsActivity6.showToast(r.j.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.bGa.bFV;
        bv bvVar = (bv) x.c(aVar.Zt(), i);
        if (bvVar != null) {
            i2 = this.bGa.bFW;
            if (i2 != bvVar.bBw) {
                this.bGa.bFX = true;
                textView = this.bGa.bFT;
                textView.setText(bvVar.name);
                i3 = this.bGa.bFW;
                if (i3 == 7) {
                    at atVar = new at("c11437");
                    atVar.s("obj_locate", bvVar.bBw);
                    str = this.bGa.aRe;
                    atVar.ab("fid", str);
                    TiebaStatic.log(atVar);
                }
                this.bGa.bFW = bvVar.bBw;
                cVar.dismiss();
                i4 = this.bGa.bFW;
                if (i4 != 7) {
                    com.baidu.tbadk.util.r.GD();
                    s.bgZ();
                } else {
                    s.bgY();
                }
                frsActivity = this.bGa.bFS;
                if (frsActivity.Wh() != null) {
                    frsActivity2 = this.bGa.bFS;
                    if (frsActivity2.Wo() != null) {
                        frsActivity3 = this.bGa.bFS;
                        frsActivity3.Wh().hG(bvVar.bBw);
                        frsActivity4 = this.bGa.bFS;
                        frsActivity4.Wo().kv();
                        frsActivity5 = this.bGa.bFS;
                        f.abm().f(frsActivity5.Wh().getForumName(), bvVar.bBw, bvVar.name);
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
