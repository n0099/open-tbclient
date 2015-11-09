package com.baidu.tieba.gift.myGiftList;

import android.content.DialogInterface;
import com.baidu.tbadk.gif.GiftGifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnDismissListener {
    final /* synthetic */ a bnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bnv = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        GiftGifView giftGifView;
        giftGifView = this.bnv.bnu;
        giftGifView.stop();
    }
}
