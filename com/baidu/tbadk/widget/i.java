package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener, View.OnClickListener {
    private Dialog atm;
    private LinearLayout atn;
    private GiftGifView ato;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public i(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.atm = Ej();
        this.atn = (LinearLayout) this.atm.findViewById(com.baidu.tieba.q.gift_gif_ll);
        this.ato = (GiftGifView) this.atm.findViewById(com.baidu.tieba.q.gift_gif_view);
        this.atn.setOnClickListener(this);
        this.ato.setOnClickListener(this);
        this.ato.setAutoPlay(true);
        this.ato.setPlayCallback(new j(this));
    }

    public void play(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.alt = str;
            aVar.alv = str;
            this.ato.setIsHide(false);
            this.ato.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.n.a(this.mActivity, this.mActivity.getString(t.loading), this);
        }
    }

    private Dialog Ej() {
        Dialog dialog = new Dialog(this.mActivity, u.dialog_full_screen);
        dialog.setContentView(r.gif_play_dialog);
        dialog.setOnDismissListener(new k(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.ato.Ak();
        com.baidu.adp.lib.g.k.b(this.atm, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ato.stop();
        com.baidu.adp.lib.g.k.b(this.atm, this.mActivity);
    }
}
