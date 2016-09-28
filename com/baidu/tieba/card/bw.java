package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ bp bbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bp bpVar) {
        this.bbs = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        cd<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bbs.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            cardPersonDynamicThreadData = this.bbs.bbe;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
