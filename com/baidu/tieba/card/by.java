package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ br bwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(br brVar) {
        this.bwI = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.bwI.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bwI.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.bwI.bwv;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
