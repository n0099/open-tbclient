package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ bn bdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bn bnVar) {
        this.bdP = bnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        cb<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bdP.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            cardPersonDynamicThreadData = this.bdP.bdB;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
