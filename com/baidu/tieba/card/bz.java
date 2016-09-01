package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ br bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(br brVar) {
        this.bbb = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.bbb.getOnSubCardOnClickListenner() != null) {
            cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bbb.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.bbb.baN;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
