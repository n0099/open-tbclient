package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ x bXt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bXt = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        cf<bg> onSubCardOnClickListenner = this.bXt.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            bgVar = this.bXt.adL;
            onSubCardOnClickListenner.a(view, bgVar);
        }
    }
}
