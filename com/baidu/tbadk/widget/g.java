package com.baidu.tbadk.widget;

import android.content.DialogInterface;
import com.baidu.tbadk.gif.GiftGifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnDismissListener {
    final /* synthetic */ e aAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aAz = eVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        GiftGifView giftGifView;
        giftGifView = this.aAz.aAy;
        giftGifView.stop();
    }
}
