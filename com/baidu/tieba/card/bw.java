package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ br bnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(br brVar) {
        this.bnD = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bnD.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            cardPersonDynamicThreadData = this.bnD.bnq;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
