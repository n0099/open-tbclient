package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bXo = xVar;
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
        biVar = this.bXo.adW;
        if (biVar != null) {
            biVar6 = this.bXo.adW;
            if (biVar6.getAuthor() != null) {
                biVar7 = this.bXo.adW;
                if (biVar7.getAuthor().getGodInfo() != null) {
                    ax s = new ax("c10806").s("obj_locate", 3);
                    biVar8 = this.bXo.adW;
                    TiebaStatic.log(s.ab("tid", biVar8.getId()));
                }
            }
        }
        biVar2 = this.bXo.adW;
        if (biVar2 != null) {
            biVar4 = this.bXo.adW;
            if (biVar4.rw()) {
                ax s2 = new ax("c11663").s("obj_param1", 1);
                biVar5 = this.bXo.adW;
                TiebaStatic.log(s2.ab("post_id", biVar5.getTid()));
            }
        }
        if (this.bXo.getOnSubCardOnClickListenner() != null) {
            cd<bi> onSubCardOnClickListenner = this.bXo.getOnSubCardOnClickListenner();
            biVar3 = this.bXo.adW;
            onSubCardOnClickListenner.a(view, biVar3);
        }
        this.bXo.Of();
    }
}
