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
    final /* synthetic */ a bmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bmR = aVar;
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStop() {
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        Dialog dialog;
        Activity activity;
        giftGifView = this.bmR.bmQ;
        giftGifView.setIsHide(true);
        linearLayout = this.bmR.bmP;
        linearLayout.setVisibility(8);
        dialog = this.bmR.bmO;
        activity = this.bmR.mActivity;
        com.baidu.adp.lib.g.j.b(dialog, activity);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void onStart() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        GiftGifView giftGifView;
        LinearLayout linearLayout;
        progressDialog = this.bmR.mWaitingDialog;
        com.baidu.adp.lib.util.k.a(progressDialog);
        dialog = this.bmR.bmO;
        activity = this.bmR.mActivity;
        com.baidu.adp.lib.g.j.a(dialog, activity);
        giftGifView = this.bmR.bmQ;
        giftGifView.setVisibility(0);
        linearLayout = this.bmR.bmP;
        linearLayout.setVisibility(0);
    }

    @Override // com.baidu.tbadk.gif.GiftGifView.a
    public void Ca() {
        ProgressDialog progressDialog;
        Dialog dialog;
        Activity activity;
        Activity activity2;
        Activity activity3;
        progressDialog = this.bmR.mWaitingDialog;
        com.baidu.adp.lib.util.k.a(progressDialog);
        dialog = this.bmR.bmO;
        activity = this.bmR.mActivity;
        com.baidu.adp.lib.g.j.b(dialog, activity);
        if (com.baidu.adp.lib.util.k.jd()) {
            activity3 = this.bmR.mActivity;
            com.baidu.adp.lib.util.k.showToast(activity3, i.h.gif_play_failed_tip);
            return;
        }
        activity2 = this.bmR.mActivity;
        com.baidu.adp.lib.util.k.showToast(activity2, i.h.neterror);
    }
}
