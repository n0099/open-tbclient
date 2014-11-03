package com.baidu.tbadk.gift;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.gift.GiftCommonList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ BuyGiftActivity Uy;

    private q(BuyGiftActivity buyGiftActivity) {
        this.Uy = buyGiftActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(BuyGiftActivity buyGiftActivity, q qVar) {
        this(buyGiftActivity);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        BuyGiftActivity buyGiftActivity = this.Uy;
        i2 = this.Uy.Ui;
        buyGiftActivity.Uj = i2;
        this.Uy.Uk = i;
        u uVar = (u) adapterView.getAdapter();
        if (uVar != null) {
            GiftCommonList.GiftItem item = uVar.getItem(i);
            if (item != null) {
                this.Uy.Ul = item;
            }
            uVar.cM(i);
            uVar.notifyDataSetChanged();
        }
        this.Uy.av(true);
    }
}
