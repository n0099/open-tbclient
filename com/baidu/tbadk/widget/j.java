package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.gif.h {
    final /* synthetic */ i aje;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aje = iVar;
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.aje.ajd;
        giftGifView.setIsHide(true);
        linearLayout = this.aje.ajc;
        linearLayout.setVisibility(8);
        dialog = this.aje.ajb;
        activity = this.aje.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.aje.mWaitingDialog;
        com.baidu.adp.lib.util.l.a(progressDialog);
        dialog = this.aje.ajb;
        activity = this.aje.mActivity;
        com.baidu.adp.lib.g.k.a(dialog, activity);
        giftGifView = this.aje.ajd;
        giftGifView.setVisibility(0);
        linearLayout = this.aje.ajc;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onFail() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.aje.mWaitingDialog;
        com.baidu.adp.lib.util.l.a(progressDialog);
        dialog = this.aje.ajb;
        activity = this.aje.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            activity3 = this.aje.mActivity;
            com.baidu.adp.lib.util.l.showToast(activity3, z.gif_play_failed_tip);
            return;
        }
        activity2 = this.aje.mActivity;
        com.baidu.adp.lib.util.l.showToast(activity2, z.neterror);
    }
}
