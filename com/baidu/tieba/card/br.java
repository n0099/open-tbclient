package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ bl bey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bl blVar) {
        this.bey = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        bz<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bey.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            cardPersonDynamicThreadData = this.bey.bej;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
