package com.baidu.tbadk.widget;

import android.content.DialogInterface;
import com.baidu.tbadk.gif.GiftGifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnDismissListener {
    final /* synthetic */ e aCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aCh = eVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        GiftGifView giftGifView;
        giftGifView = this.aCh.aCg;
        giftGifView.stop();
    }
}
