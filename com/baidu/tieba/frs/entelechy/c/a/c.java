package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.smartsort.e;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bZm = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        int i2;
        TextView textView;
        int i3;
        r rVar;
        r rVar2;
        int i4;
        int i5;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        String str;
        r rVar9;
        if (!i.gY()) {
            rVar9 = this.bZm.bVm;
            rVar9.showToast(w.l.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.bZm.bZh;
        bp bpVar = (bp) x.c(aVar.acb(), i);
        if (bpVar != null) {
            i2 = this.bZm.bZi;
            if (i2 != bpVar.bWI) {
                this.bZm.bZj = true;
                textView = this.bZm.bZf;
                textView.setText(bpVar.name);
                i3 = this.bZm.bZi;
                if (i3 == 7) {
                    as asVar = new as("c11437");
                    asVar.r("obj_locate", bpVar.bWI);
                    str = this.bZm.bur;
                    asVar.Z("fid", str);
                    TiebaStatic.log(asVar);
                }
                rVar = this.bZm.bVm;
                if (rVar.ZY() != null) {
                    rVar2 = this.bZm.bVm;
                    FrsModelController ZY = rVar2.ZY();
                    i4 = this.bZm.bZi;
                    ZY.iL(i4);
                    this.bZm.bZi = bpVar.bWI;
                    cVar.dismiss();
                    i5 = this.bZm.bZi;
                    if (i5 != 7) {
                        u.Gy();
                        s.bjd();
                    } else {
                        s.bjc();
                    }
                    rVar3 = this.bZm.bVm;
                    if (rVar3.ZY() != null) {
                        rVar4 = this.bZm.bVm;
                        if (rVar4.aad() != null) {
                            rVar5 = this.bZm.bVm;
                            rVar5.ZY().iK(bpVar.bWI);
                            rVar6 = this.bZm.bVm;
                            rVar6.aad().startPullRefresh();
                            rVar7 = this.bZm.bVm;
                            rVar7.ZY().eu(true);
                            rVar8 = this.bZm.bVm;
                            e.ads().f(rVar8.ZY().getForumName(), bpVar.bWI, bpVar.name);
                            return;
                        }
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
