package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bXo = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        if (this.bXo.getOnSubCardOnClickListenner() != null) {
            cf<bg> onSubCardOnClickListenner = this.bXo.getOnSubCardOnClickListenner();
            bgVar = this.bXo.adL;
            onSubCardOnClickListenner.a(view, bgVar);
        }
    }
}
