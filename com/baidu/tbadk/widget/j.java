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
    final /* synthetic */ i ajb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.ajb = iVar;
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.ajb.aja;
        giftGifView.setIsHide(true);
        linearLayout = this.ajb.aiZ;
        linearLayout.setVisibility(8);
        dialog = this.ajb.aiY;
        activity = this.ajb.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.ajb.mWaitingDialog;
        com.baidu.adp.lib.util.l.a(progressDialog);
        dialog = this.ajb.aiY;
        activity = this.ajb.mActivity;
        com.baidu.adp.lib.g.k.a(dialog, activity);
        giftGifView = this.ajb.aja;
        giftGifView.setVisibility(0);
        linearLayout = this.ajb.aiZ;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onFail() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.ajb.mWaitingDialog;
        com.baidu.adp.lib.util.l.a(progressDialog);
        dialog = this.ajb.aiY;
        activity = this.ajb.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            activity3 = this.ajb.mActivity;
            com.baidu.adp.lib.util.l.showToast(activity3, z.gif_play_failed_tip);
            return;
        }
        activity2 = this.ajb.mActivity;
        com.baidu.adp.lib.util.l.showToast(activity2, z.neterror);
    }
}
