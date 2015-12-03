package com.baidu.tieba.gift.giftTab;

import android.util.SparseBooleanArray;
import android.view.View;
import com.baidu.tieba.gift.giftTab.ad;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ad bwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ad adVar) {
        this.bwb = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad.f fVar;
        SparseBooleanArray sparseBooleanArray;
        int i;
        ad.f fVar2;
        ArrayList arrayList;
        int i2;
        fVar = this.bwb.bvQ;
        if (fVar != null) {
            sparseBooleanArray = this.bwb.bvT;
            i = this.bwb.bvR;
            sparseBooleanArray.append(i, true);
            fVar2 = this.bwb.bvQ;
            arrayList = this.bwb.bvy;
            i2 = this.bwb.bvR;
            fVar2.hv(((i) arrayList.get(i2)).getCategoryId());
        }
    }
}
