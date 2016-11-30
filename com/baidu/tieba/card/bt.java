package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ bl bey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bl blVar) {
        this.bey = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.bey.getOnSubCardOnClickListenner() != null) {
            bz<CardPersonDynamicThreadData> onSubCardOnClickListenner = this.bey.getOnSubCardOnClickListenner();
            cardPersonDynamicThreadData = this.bey.bej;
            onSubCardOnClickListenner.a(view, cardPersonDynamicThreadData);
        }
    }
}
