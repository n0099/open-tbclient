package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.LinearLayout;
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements GiftGifView.a {
    final /* synthetic */ e aCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aCh = eVar;
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.aCh.aCg;
        giftGifView.setIsHide(true);
        linearLayout = this.aCh.aCf;
        linearLayout.setVisibility(8);
        dialog = this.aCh.aCe;
        activity = this.aCh.mActivity;
        j.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.aCh.mWaitingDialog;
        k.a(progressDialog);
        dialog = this.aCh.aCe;
        activity = this.aCh.mActivity;
        j.a(dialog, activity);
        giftGifView = this.aCh.aCg;
        giftGifView.setVisibility(0);
        linearLayout = this.aCh.aCf;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void Cq() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.aCh.mWaitingDialog;
        k.a(progressDialog);
        dialog = this.aCh.aCe;
        activity = this.aCh.mActivity;
        j.b(dialog, activity);
        if (k.jc()) {
            activity3 = this.aCh.mActivity;
            k.showToast(activity3, i.h.gif_play_failed_tip);
            return;
        }
        activity2 = this.aCh.mActivity;
        k.showToast(activity2, i.h.neterror);
    }
}
