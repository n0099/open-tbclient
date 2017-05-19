package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x bTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bTG = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bkVar = this.bTG.ahV;
        if (bkVar != null) {
            bkVar6 = this.bTG.ahV;
            if (bkVar6.getAuthor() != null) {
                bkVar7 = this.bTG.ahV;
                if (bkVar7.getAuthor().getGodInfo() != null) {
                    com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10806").s("obj_locate", 3);
                    bkVar8 = this.bTG.ahV;
                    TiebaStatic.log(s.aa("tid", bkVar8.getId()));
                }
            }
        }
        bkVar2 = this.bTG.ahV;
        if (bkVar2 != null) {
            bkVar4 = this.bTG.ahV;
            if (bkVar4.rg()) {
                com.baidu.tbadk.core.util.as s2 = new com.baidu.tbadk.core.util.as("c11663").s("obj_param1", 1);
                bkVar5 = this.bTG.ahV;
                TiebaStatic.log(s2.aa("post_id", bkVar5.getTid()));
            }
        }
        if (this.bTG.getOnSubCardOnClickListenner() != null) {
            cd<bk> onSubCardOnClickListenner = this.bTG.getOnSubCardOnClickListenner();
            bkVar3 = this.bTG.ahV;
            onSubCardOnClickListenner.a(view, bkVar3);
        }
        this.bTG.Tj();
    }
}
