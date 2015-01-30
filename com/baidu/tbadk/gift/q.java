package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.gift.GiftCommonList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ BuyGiftActivity abe;

    private q(BuyGiftActivity buyGiftActivity) {
        this.abe = buyGiftActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(BuyGiftActivity buyGiftActivity, q qVar) {
        this(buyGiftActivity);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        BuyGiftActivity buyGiftActivity = this.abe;
        i2 = this.abe.aaO;
        buyGiftActivity.aaP = i2;
        this.abe.aaQ = i;
        u uVar = (u) adapterView.getAdapter();
        if (uVar != null) {
            GiftCommonList.GiftItem item = uVar.getItem(i);
            if (item != null) {
                this.abe.aaR = item;
            }
            uVar.ds(i);
            uVar.notifyDataSetChanged();
        }
        this.abe.aL(true);
    }
}
