package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ br buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(br brVar) {
        this.buz = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.buz.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            cardPersonDynamicThreadData = this.buz.bul;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
