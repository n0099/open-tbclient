package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bVJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bVJ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        if (this.bVJ.getOnSubCardOnClickListenner() != null) {
            cf<bi> onSubCardOnClickListenner = this.bVJ.getOnSubCardOnClickListenner();
            biVar = this.bVJ.aiC;
            onSubCardOnClickListenner.a(view, biVar);
        }
    }
}
