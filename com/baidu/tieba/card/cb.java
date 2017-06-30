package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ bu bDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bu buVar) {
        this.bDl = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        if (this.bDl.Vs() != null) {
            ci<CardPersonDynamicThreadData> Vs = this.bDl.Vs();
            cardPersonDynamicThreadData = this.bDl.bDa;
            Vs.a(view, cardPersonDynamicThreadData);
        }
    }
}
