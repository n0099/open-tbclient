package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.aa;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener, View.OnClickListener {
    private Dialog aiY;
    private LinearLayout aiZ;
    private GiftGifView aja;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public i(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.aiY = zW();
        this.aiZ = (LinearLayout) this.aiY.findViewById(w.gift_gif_ll);
        this.aja = (GiftGifView) this.aiY.findViewById(w.gift_gif_view);
        this.aiZ.setOnClickListener(this);
        this.aja.setOnClickListener(this);
        this.aja.setAutoPlay(true);
        this.aja.setPlayCallback(new j(this));
    }

    public void play(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.ZM = str;
            aVar.ZO = str;
            this.aja.setIsHide(false);
            this.aja.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.l.a(this.mActivity, this.mActivity.getString(z.loading), this);
        }
    }

    private Dialog zW() {
        Dialog dialog = new Dialog(this.mActivity, aa.dialog_full_screen);
        dialog.setContentView(x.gif_play_dialog);
        dialog.setOnDismissListener(new k(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aja.vQ();
        com.baidu.adp.lib.g.k.b(this.aiY, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aja.stop();
        com.baidu.adp.lib.g.k.b(this.aiY, this.mActivity);
    }
}
