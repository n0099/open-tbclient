package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bVP = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        biVar = this.bVP.aiC;
        if (biVar != null) {
            biVar6 = this.bVP.aiC;
            if (biVar6.getAuthor() != null) {
                biVar7 = this.bVP.aiC;
                if (biVar7.getAuthor().getGodInfo() != null) {
                    com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10806").s("obj_locate", 3);
                    biVar8 = this.bVP.aiC;
                    TiebaStatic.log(s.aa("tid", biVar8.getId()));
                }
            }
        }
        biVar2 = this.bVP.aiC;
        if (biVar2 != null) {
            biVar4 = this.bVP.aiC;
            if (biVar4.rW()) {
                com.baidu.tbadk.core.util.as s2 = new com.baidu.tbadk.core.util.as("c11663").s("obj_param1", 1);
                biVar5 = this.bVP.aiC;
                TiebaStatic.log(s2.aa("post_id", biVar5.getTid()));
            }
        }
        if (this.bVP.getOnSubCardOnClickListenner() != null) {
            cf<bi> onSubCardOnClickListenner = this.bVP.getOnSubCardOnClickListenner();
            biVar3 = this.bVP.aiC;
            onSubCardOnClickListenner.a(view, biVar3);
        }
        this.bVP.TR();
    }
}
