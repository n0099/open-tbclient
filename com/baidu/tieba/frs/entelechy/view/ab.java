package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bMC = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        bh bhVar6;
        bh bhVar7;
        bh bhVar8;
        bhVar = this.bMC.acX;
        if (bhVar != null) {
            bhVar6 = this.bMC.acX;
            if (bhVar6.getAuthor() != null) {
                bhVar7 = this.bMC.acX;
                if (bhVar7.getAuthor().getGodInfo() != null) {
                    com.baidu.tbadk.core.util.ar s = new com.baidu.tbadk.core.util.ar("c10806").s("obj_locate", 3);
                    bhVar8 = this.bMC.acX;
                    TiebaStatic.log(s.ab("tid", bhVar8.getId()));
                }
            }
        }
        bhVar2 = this.bMC.acX;
        if (bhVar2 != null) {
            bhVar4 = this.bMC.acX;
            if (bhVar4.rf()) {
                com.baidu.tbadk.core.util.ar s2 = new com.baidu.tbadk.core.util.ar("c11663").s("obj_param1", 1);
                bhVar5 = this.bMC.acX;
                TiebaStatic.log(s2.ab("post_id", bhVar5.getTid()));
            }
        }
        if (this.bMC.getOnSubCardOnClickListenner() != null) {
            cf<bh> onSubCardOnClickListenner = this.bMC.getOnSubCardOnClickListenner();
            bhVar3 = this.bMC.acX;
            onSubCardOnClickListenner.a(view, bhVar3);
        }
        this.bMC.Rt();
    }
}
