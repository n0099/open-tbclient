package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ br buq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(br brVar) {
        this.buq = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.buq.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.buq.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.buq.bud;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
