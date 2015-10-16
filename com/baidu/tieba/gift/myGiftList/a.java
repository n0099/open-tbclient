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
    private Dialog bmO;
    private LinearLayout bmP;
    private GiftGifView bmQ;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public a(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.bmO = Qu();
        this.bmP = (LinearLayout) this.bmO.findViewById(i.f.gift_gif_ll);
        this.bmQ = (GiftGifView) this.bmO.findViewById(i.f.gift_gif_view);
        this.bmP.setOnClickListener(this);
        this.bmQ.setOnClickListener(this);
        this.bmQ.setAutoPlay(true);
        this.bmQ.setPlayCallback(new b(this));
    }

    public void ho(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.atg = str;
            aVar.ati = str;
            this.bmQ.setIsHide(false);
            this.bmQ.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.k.a(this.mActivity, this.mActivity.getString(i.h.loading), this);
        }
    }

    private Dialog Qu() {
        Dialog dialog = new Dialog(this.mActivity, i.C0057i.dialog_full_screen);
        dialog.setContentView(i.g.gif_play_dialog);
        dialog.setOnDismissListener(new c(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.bmQ.Cc();
        com.baidu.adp.lib.g.j.b(this.bmO, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bmQ.stop();
        com.baidu.adp.lib.g.j.b(this.bmO, this.mActivity);
    }
}
