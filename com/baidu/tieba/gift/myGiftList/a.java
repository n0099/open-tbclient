package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a implements DialogInterface.OnCancelListener, View.OnClickListener {
    private Dialog bns;
    private LinearLayout bnt;
    private GiftGifView bnu;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public a(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.bns = QM();
        this.bnt = (LinearLayout) this.bns.findViewById(i.f.gift_gif_ll);
        this.bnu = (GiftGifView) this.bns.findViewById(i.f.gift_gif_view);
        this.bnt.setOnClickListener(this);
        this.bnu.setOnClickListener(this);
        this.bnu.setAutoPlay(true);
        this.bnu.setPlayCallback(new b(this));
    }

    public void hq(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.arU = str;
            aVar.arW = str;
            this.bnu.setIsHide(false);
            this.bnu.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.k.a(this.mActivity, this.mActivity.getString(i.h.loading), this);
        }
    }

    private Dialog QM() {
        Dialog dialog = new Dialog(this.mActivity, i.C0057i.dialog_full_screen);
        dialog.setContentView(i.g.gif_play_dialog);
        dialog.setOnDismissListener(new c(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.bnu.BS();
        com.baidu.adp.lib.g.j.b(this.bns, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bnu.stop();
        com.baidu.adp.lib.g.j.b(this.bns, this.mActivity);
    }
}
