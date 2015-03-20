package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.gif.h {
    final /* synthetic */ i arD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.arD = iVar;
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.arD.arC;
        giftGifView.setIsHide(true);
        linearLayout = this.arD.arB;
        linearLayout.setVisibility(8);
        dialog = this.arD.arA;
        activity = this.arD.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.arD.mWaitingDialog;
        com.baidu.adp.lib.util.n.a(progressDialog);
        dialog = this.arD.arA;
        activity = this.arD.mActivity;
        com.baidu.adp.lib.g.k.a(dialog, activity);
        giftGifView = this.arD.arC;
        giftGifView.setVisibility(0);
        linearLayout = this.arD.arB;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onFail() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.arD.mWaitingDialog;
        com.baidu.adp.lib.util.n.a(progressDialog);
        dialog = this.arD.arA;
        activity = this.arD.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            activity3 = this.arD.mActivity;
            com.baidu.adp.lib.util.n.showToast(activity3, y.gif_play_failed_tip);
            return;
        }
        activity2 = this.arD.mActivity;
        com.baidu.adp.lib.util.n.showToast(activity2, y.neterror);
    }
}
