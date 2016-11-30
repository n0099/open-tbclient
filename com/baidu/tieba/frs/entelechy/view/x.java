package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w caE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.caE = wVar;
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
        bkVar = this.caE.aeu;
        if (bkVar != null) {
            bkVar6 = this.caE.aeu;
            if (bkVar6.getAuthor() != null) {
                bkVar7 = this.caE.aeu;
                if (bkVar7.getAuthor().getGodInfo() != null) {
                    av s = new av("c10806").s("obj_locate", 3);
                    bkVar8 = this.caE.aeu;
                    TiebaStatic.log(s.ab("tid", bkVar8.getId()));
                }
            }
        }
        bkVar2 = this.caE.aeu;
        if (bkVar2 != null) {
            bkVar4 = this.caE.aeu;
            if (bkVar4.ry()) {
                av s2 = new av("c11663").s("obj_param1", 1);
                bkVar5 = this.caE.aeu;
                TiebaStatic.log(s2.ab("post_id", bkVar5.getTid()));
            }
        }
        if (this.caE.getOnSubCardOnClickListenner() != null) {
            bz<bk> onSubCardOnClickListenner = this.caE.getOnSubCardOnClickListenner();
            bkVar3 = this.caE.aeu;
            onSubCardOnClickListenner.a(view, bkVar3);
        }
        this.caE.Ph();
    }
}
