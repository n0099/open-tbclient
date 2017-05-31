package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ bu bCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bu buVar) {
        this.bCs = buVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ci<CardPersonDynamicThreadData> Ud = this.bCs.Ud();
        if (Ud != null) {
            view.setTag("2");
            cardPersonDynamicThreadData = this.bCs.bCh;
            Ud.a(view, cardPersonDynamicThreadData);
        }
    }
}
