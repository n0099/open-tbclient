package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ bu bDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bu buVar) {
        this.bDl = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ci<CardPersonDynamicThreadData> Vs = this.bDl.Vs();
        if (Vs != null) {
            view.setTag("1");
            cardPersonDynamicThreadData = this.bDl.bDa;
            Vs.a(view, cardPersonDynamicThreadData);
        }
    }
}
