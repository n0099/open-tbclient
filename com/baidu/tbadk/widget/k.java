package com.baidu.tbadk.widget;

import android.content.DialogInterface;
import com.baidu.tbadk.gif.GiftGifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnDismissListener {
    final /* synthetic */ i aaP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.aaP = iVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        GiftGifView giftGifView;
        giftGifView = this.aaP.aaO;
        giftGifView.stop();
    }
}
