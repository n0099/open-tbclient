package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ bp bwH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bp bpVar) {
        this.bwH = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.bwH.getOnSubCardOnClickListenner() != null) {
            cd<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bwH.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.bwH.bww;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
