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
    final /* synthetic */ e aAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aAz = eVar;
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.aAz.aAy;
        giftGifView.setIsHide(true);
        linearLayout = this.aAz.aAx;
        linearLayout.setVisibility(8);
        dialog = this.aAz.aAw;
        activity = this.aAz.mActivity;
        j.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.aAz.mWaitingDialog;
        k.a(progressDialog);
        dialog = this.aAz.aAw;
        activity = this.aAz.mActivity;
        j.a(dialog, activity);
        giftGifView = this.aAz.aAy;
        giftGifView.setVisibility(0);
        linearLayout = this.aAz.aAx;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void Cc() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.aAz.mWaitingDialog;
        k.a(progressDialog);
        dialog = this.aAz.aAw;
        activity = this.aAz.mActivity;
        j.b(dialog, activity);
        if (k.jf()) {
            activity3 = this.aAz.mActivity;
            k.showToast(activity3, i.C0057i.gif_play_failed_tip);
            return;
        }
        activity2 = this.aAz.mActivity;
        k.showToast(activity2, i.C0057i.neterror);
    }
}
