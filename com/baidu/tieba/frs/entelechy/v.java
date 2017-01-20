package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u bKK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bKK = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.t tVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.t tVar2;
        com.baidu.tbadk.core.data.t tVar3;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        tVar = this.bKK.bKF;
        if (tVar != null) {
            ba vt = ba.vt();
            tbPageContext = this.bKK.Fp;
            tVar2 = this.bKK.bKF;
            boolean c = vt.c(tbPageContext, new String[]{tVar2.pM()});
            String str = "c11675";
            tVar3 = this.bKK.bKF;
            if (!tVar3.pG()) {
                str = "c11676";
            }
            frsActivity = this.bKK.bHh;
            if (frsActivity != null && c) {
                ar arVar = new ar(str);
                frsActivity2 = this.bKK.bHh;
                TiebaStatic.log(arVar.ab("fid", frsActivity2.getForumId()));
            }
        }
    }
}
