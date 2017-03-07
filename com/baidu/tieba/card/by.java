package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ br buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(br brVar) {
        this.buz = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.buz.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.buz.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.buz.bul;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
