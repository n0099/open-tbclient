package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.gift.GiftCommonList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ BuyGiftActivity abb;

    private q(BuyGiftActivity buyGiftActivity) {
        this.abb = buyGiftActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(BuyGiftActivity buyGiftActivity, q qVar) {
        this(buyGiftActivity);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        BuyGiftActivity buyGiftActivity = this.abb;
        i2 = this.abb.aaL;
        buyGiftActivity.aaM = i2;
        this.abb.aaN = i;
        u uVar = (u) adapterView.getAdapter();
        if (uVar != null) {
            GiftCommonList.GiftItem item = uVar.getItem(i);
            if (item != null) {
                this.abb.aaO = item;
            }
            uVar.ds(i);
            uVar.notifyDataSetChanged();
        }
        this.abb.aL(true);
    }
}
