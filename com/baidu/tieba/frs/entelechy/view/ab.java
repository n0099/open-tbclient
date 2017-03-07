package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa bTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bTK = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        bj bjVar7;
        bj bjVar8;
        bjVar = this.bTK.ain;
        if (bjVar != null) {
            bjVar6 = this.bTK.ain;
            if (bjVar6.getAuthor() != null) {
                bjVar7 = this.bTK.ain;
                if (bjVar7.getAuthor().getGodInfo() != null) {
                    com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10806").s("obj_locate", 3);
                    bjVar8 = this.bTK.ain;
                    TiebaStatic.log(s.Z("tid", bjVar8.getId()));
                }
            }
        }
        bjVar2 = this.bTK.ain;
        if (bjVar2 != null) {
            bjVar4 = this.bTK.ain;
            if (bjVar4.ry()) {
                com.baidu.tbadk.core.util.as s2 = new com.baidu.tbadk.core.util.as("c11663").s("obj_param1", 1);
                bjVar5 = this.bTK.ain;
                TiebaStatic.log(s2.Z("post_id", bjVar5.getTid()));
            }
        }
        if (this.bTK.getOnSubCardOnClickListenner() != null) {
            cf<bj> onSubCardOnClickListenner = this.bTK.getOnSubCardOnClickListenner();
            bjVar3 = this.bTK.ain;
            onSubCardOnClickListenner.a(view, bjVar3);
        }
        this.bTK.Sr();
    }
}
