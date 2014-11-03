package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.gif.g {
    final /* synthetic */ i aaP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aaP = iVar;
    }

    @Override // com.baidu.tbadk.gif.g
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.aaP.aaO;
        giftGifView.setIsHide(true);
        linearLayout = this.aaP.aaN;
        linearLayout.setVisibility(8);
        dialog = this.aaP.aaM;
        activity = this.aaP.mActivity;
        com.baidu.adp.lib.g.j.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.g
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.aaP.mWaitingDialog;
        com.baidu.adp.lib.util.m.a(progressDialog);
        dialog = this.aaP.aaM;
        activity = this.aaP.mActivity;
        com.baidu.adp.lib.g.j.a(dialog, activity);
        giftGifView = this.aaP.aaO;
        giftGifView.setVisibility(0);
        linearLayout = this.aaP.aaN;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.g
    public void onFail() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.aaP.mWaitingDialog;
        com.baidu.adp.lib.util.m.a(progressDialog);
        dialog = this.aaP.aaM;
        activity = this.aaP.mActivity;
        com.baidu.adp.lib.g.j.b(dialog, activity);
        if (com.baidu.adp.lib.util.m.isNetOk()) {
            activity3 = this.aaP.mActivity;
            com.baidu.adp.lib.util.m.showToast(activity3, y.gif_play_failed_tip);
            return;
        }
        activity2 = this.aaP.mActivity;
        com.baidu.adp.lib.util.m.showToast(activity2, y.neterror);
    }
}
