package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x chH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.chH = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        bmVar = this.chH.aiu;
        if (bmVar != null) {
            bmVar6 = this.chH.aiu;
            if (bmVar6.getAuthor() != null) {
                bmVar7 = this.chH.aiu;
                if (bmVar7.getAuthor().getGodInfo() != null) {
                    com.baidu.tbadk.core.util.au r = new com.baidu.tbadk.core.util.au("c10806").r("obj_locate", 3);
                    bmVar8 = this.chH.aiu;
                    TiebaStatic.log(r.Z("tid", bmVar8.getId()));
                }
            }
        }
        bmVar2 = this.chH.aiu;
        if (bmVar2 != null) {
            bmVar4 = this.chH.aiu;
            if (bmVar4.qZ()) {
                com.baidu.tbadk.core.util.au r2 = new com.baidu.tbadk.core.util.au("c11663").r("obj_param1", 1);
                bmVar5 = this.chH.aiu;
                TiebaStatic.log(r2.Z("post_id", bmVar5.getTid()));
            }
        }
        if (this.chH.Vs() != null) {
            ci<bm> Vs = this.chH.Vs();
            bmVar3 = this.chH.aiu;
            Vs.a(view, bmVar3);
        }
        this.chH.VI();
    }
}
