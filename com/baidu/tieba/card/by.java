package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ br bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(br brVar) {
        this.bbb = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        cf<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bbb.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            cardPersonDynamicThreadData = this.bbb.baN;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
