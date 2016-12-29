package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa bGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bGn = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        bg bgVar6;
        bg bgVar7;
        bg bgVar8;
        bgVar = this.bGn.adN;
        if (bgVar != null) {
            bgVar6 = this.bGn.adN;
            if (bgVar6.getAuthor() != null) {
                bgVar7 = this.bGn.adN;
                if (bgVar7.getAuthor().getGodInfo() != null) {
                    com.baidu.tbadk.core.util.at s = new com.baidu.tbadk.core.util.at("c10806").s("obj_locate", 3);
                    bgVar8 = this.bGn.adN;
                    TiebaStatic.log(s.ab("tid", bgVar8.getId()));
                }
            }
        }
        bgVar2 = this.bGn.adN;
        if (bgVar2 != null) {
            bgVar4 = this.bGn.adN;
            if (bgVar4.rn()) {
                com.baidu.tbadk.core.util.at s2 = new com.baidu.tbadk.core.util.at("c11663").s("obj_param1", 1);
                bgVar5 = this.bGn.adN;
                TiebaStatic.log(s2.ab("post_id", bgVar5.getTid()));
            }
        }
        if (this.bGn.getOnSubCardOnClickListenner() != null) {
            cb<bg> onSubCardOnClickListenner = this.bGn.getOnSubCardOnClickListenner();
            bgVar3 = this.bGn.adN;
            onSubCardOnClickListenner.a(view, bgVar3);
        }
        this.bGn.OD();
    }
}
