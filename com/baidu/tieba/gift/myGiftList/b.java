package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements GiftGifView.a {
    final /* synthetic */ a bnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bnv = aVar;
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.bnv.bnu;
        giftGifView.setIsHide(true);
        linearLayout = this.bnv.bnt;
        linearLayout.setVisibility(8);
        dialog = this.bnv.bns;
        activity = this.bnv.mActivity;
        com.baidu.adp.lib.g.j.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.bnv.mWaitingDialog;
        com.baidu.adp.lib.util.k.a(progressDialog);
        dialog = this.bnv.bns;
        activity = this.bnv.mActivity;
        com.baidu.adp.lib.g.j.a(dialog, activity);
        giftGifView = this.bnv.bnu;
        giftGifView.setVisibility(0);
        linearLayout = this.bnv.bnt;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void BT() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.bnv.mWaitingDialog;
        com.baidu.adp.lib.util.k.a(progressDialog);
        dialog = this.bnv.bns;
        activity = this.bnv.mActivity;
        com.baidu.adp.lib.g.j.b(dialog, activity);
        if (com.baidu.adp.lib.util.k.je()) {
            activity3 = this.bnv.mActivity;
            com.baidu.adp.lib.util.k.showToast(activity3, i.h.gif_play_failed_tip);
            return;
        }
        activity2 = this.bnv.mActivity;
        com.baidu.adp.lib.util.k.showToast(activity2, i.h.neterror);
    }
}
