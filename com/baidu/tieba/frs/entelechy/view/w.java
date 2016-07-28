package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v bMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.bMb = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        be beVar5;
        beVar = this.bMb.abb;
        if (beVar != null) {
            beVar3 = this.bMb.abb;
            if (beVar3.getAuthor() != null) {
                beVar4 = this.bMb.abb;
                if (beVar4.getAuthor().getGodInfo() != null) {
                    ay s = new ay("c10806").s("obj_locate", 3);
                    beVar5 = this.bMb.abb;
                    TiebaStatic.log(s.ab("tid", beVar5.getId()));
                }
            }
        }
        if (this.bMb.KN() != null) {
            bx<be> KN = this.bMb.KN();
            beVar2 = this.bMb.abb;
            KN.a(view, beVar2);
        }
        this.bMb.Lc();
    }
}
