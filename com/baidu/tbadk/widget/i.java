package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener, View.OnClickListener {
    private Dialog aaM;
    private LinearLayout aaN;
    private GiftGifView aaO;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public i(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.aaM = vx();
        this.aaN = (LinearLayout) this.aaM.findViewById(v.gift_gif_ll);
        this.aaO = (GiftGifView) this.aaM.findViewById(v.gift_gif_view);
        this.aaN.setOnClickListener(this);
        this.aaO.setOnClickListener(this);
        this.aaO.setAutoPlay(true);
        this.aaO.setPlayCallback(new j(this));
    }

    public void dP(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.Tj = str;
            aVar.Tl = str;
            this.aaO.setIsHide(false);
            this.aaO.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.m.a(this.mActivity, this.mActivity.getString(y.loading), this);
        }
    }

    private Dialog vx() {
        Dialog dialog = new Dialog(this.mActivity, z.dialog_full_screen);
        dialog.setContentView(w.gif_play_dialog);
        dialog.setOnDismissListener(new k(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aaO.rZ();
        com.baidu.adp.lib.g.j.b(this.aaM, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aaO.stop();
        com.baidu.adp.lib.g.j.b(this.aaM, this.mActivity);
    }
}
