package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ br bnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(br brVar) {
        this.bnD = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.bnD.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bnD.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.bnD.bnq;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
