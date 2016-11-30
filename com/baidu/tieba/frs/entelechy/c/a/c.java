package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.g.f;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a caq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.caq = aVar;
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
            frsActivity6 = this.caq.cai;
            frsActivity6.showToast(r.j.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.caq.cal;
        bw bwVar = (bw) x.c(aVar.aeY(), i);
        if (bwVar != null) {
            i2 = this.caq.cam;
            if (i2 != bwVar.bVo) {
                this.caq.can = true;
                textView = this.caq.caj;
                textView.setText(bwVar.name);
                i3 = this.caq.cam;
                if (i3 == 7) {
                    av avVar = new av("c11437");
                    avVar.s("obj_locate", bwVar.bVo);
                    str = this.caq.aRN;
                    avVar.ab("fid", str);
                    TiebaStatic.log(avVar);
                }
                this.caq.cam = bwVar.bVo;
                cVar.dismiss();
                i4 = this.caq.cam;
                if (i4 != 7) {
                    com.baidu.tbadk.util.r.Hh();
                    s.bnf();
                } else {
                    s.bne();
                }
                frsActivity = this.caq.cai;
                if (frsActivity.abS() != null) {
                    frsActivity2 = this.caq.cai;
                    if (frsActivity2.abZ() != null) {
                        frsActivity3 = this.caq.cai;
                        frsActivity3.abS().iw(bwVar.bVo);
                        frsActivity4 = this.caq.cai;
                        frsActivity4.abZ().kv();
                        frsActivity5 = this.caq.cai;
                        f.agR().f(frsActivity5.abS().getForumName(), bwVar.bVo, bwVar.name);
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
