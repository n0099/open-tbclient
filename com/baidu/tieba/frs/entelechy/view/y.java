package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x bXt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bXt = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        bgVar = this.bXt.adL;
        if (bgVar != null) {
            bgVar3 = this.bXt.adL;
            if (bgVar3.getAuthor() != null) {
                bgVar4 = this.bXt.adL;
                if (bgVar4.getAuthor().getGodInfo() != null) {
                    ay s = new ay("c10806").s("obj_locate", 3);
                    bgVar5 = this.bXt.adL;
                    TiebaStatic.log(s.ab("tid", bgVar5.getId()));
                }
            }
        }
        if (this.bXt.getOnSubCardOnClickListenner() != null) {
            cf<bg> onSubCardOnClickListenner = this.bXt.getOnSubCardOnClickListenner();
            bgVar2 = this.bXt.adL;
            onSubCardOnClickListenner.a(view, bgVar2);
        }
        this.bXt.NF();
    }
}
