package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    final /* synthetic */ bp bwH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bp bpVar) {
        this.bwH = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        cd<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bwH.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            cardPersonDynamicThreadData = this.bwH.bww;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
