package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {
    final /* synthetic */ bp bbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bp bpVar) {
        this.bbs = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.bbs.getOnSubCardOnClickListenner() != null) {
            cd<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bbs.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.bbs.bbe;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
