package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x bZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bZy = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        blVar = this.bZy.ahM;
        if (blVar != null) {
            blVar6 = this.bZy.ahM;
            if (blVar6.getAuthor() != null) {
                blVar7 = this.bZy.ahM;
                if (blVar7.getAuthor().getGodInfo() != null) {
                    com.baidu.tbadk.core.util.as r = new com.baidu.tbadk.core.util.as("c10806").r("obj_locate", 3);
                    blVar8 = this.bZy.ahM;
                    TiebaStatic.log(r.Z("tid", blVar8.getId()));
                }
            }
        }
        blVar2 = this.bZy.ahM;
        if (blVar2 != null) {
            blVar4 = this.bZy.ahM;
            if (blVar4.rc()) {
                com.baidu.tbadk.core.util.as r2 = new com.baidu.tbadk.core.util.as("c11663").r("obj_param1", 1);
                blVar5 = this.bZy.ahM;
                TiebaStatic.log(r2.Z("post_id", blVar5.getTid()));
            }
        }
        if (this.bZy.Ud() != null) {
            ci<bl> Ud = this.bZy.Ud();
            blVar3 = this.bZy.ahM;
            Ud.a(view, blVar3);
        }
        this.bZy.Ur();
    }
}
