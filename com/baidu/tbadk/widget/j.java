package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.gif.g {
    final /* synthetic */ i atp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.atp = iVar;
    }

    @Override // com.baidu.tbadk.gif.g
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.atp.ato;
        giftGifView.setIsHide(true);
        linearLayout = this.atp.atn;
        linearLayout.setVisibility(8);
        dialog = this.atp.atm;
        activity = this.atp.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.g
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.atp.mWaitingDialog;
        com.baidu.adp.lib.util.n.a(progressDialog);
        dialog = this.atp.atm;
        activity = this.atp.mActivity;
        com.baidu.adp.lib.g.k.a(dialog, activity);
        giftGifView = this.atp.ato;
        giftGifView.setVisibility(0);
        linearLayout = this.atp.atn;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.g
    public void onFail() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.atp.mWaitingDialog;
        com.baidu.adp.lib.util.n.a(progressDialog);
        dialog = this.atp.atm;
        activity = this.atp.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            activity3 = this.atp.mActivity;
            com.baidu.adp.lib.util.n.showToast(activity3, t.gif_play_failed_tip);
            return;
        }
        activity2 = this.atp.mActivity;
        com.baidu.adp.lib.util.n.showToast(activity2, t.neterror);
    }
}
