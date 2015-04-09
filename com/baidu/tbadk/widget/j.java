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
    final /* synthetic */ i arL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.arL = iVar;
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.arL.arK;
        giftGifView.setIsHide(true);
        linearLayout = this.arL.arJ;
        linearLayout.setVisibility(8);
        dialog = this.arL.arI;
        activity = this.arL.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.arL.mWaitingDialog;
        com.baidu.adp.lib.util.n.a(progressDialog);
        dialog = this.arL.arI;
        activity = this.arL.mActivity;
        com.baidu.adp.lib.g.k.a(dialog, activity);
        giftGifView = this.arL.arK;
        giftGifView.setVisibility(0);
        linearLayout = this.arL.arJ;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.h
    public void onFail() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.arL.mWaitingDialog;
        com.baidu.adp.lib.util.n.a(progressDialog);
        dialog = this.arL.arI;
        activity = this.arL.mActivity;
        com.baidu.adp.lib.g.k.b(dialog, activity);
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            activity3 = this.arL.mActivity;
            com.baidu.adp.lib.util.n.showToast(activity3, y.gif_play_failed_tip);
            return;
        }
        activity2 = this.arL.mActivity;
        com.baidu.adp.lib.util.n.showToast(activity2, y.neterror);
    }
}
