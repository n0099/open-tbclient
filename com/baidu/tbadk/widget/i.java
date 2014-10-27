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
    private Dialog aaI;
    private LinearLayout aaJ;
    private GiftGifView aaK;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public i(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.aaI = vv();
        this.aaJ = (LinearLayout) this.aaI.findViewById(v.gift_gif_ll);
        this.aaK = (GiftGifView) this.aaI.findViewById(v.gift_gif_view);
        this.aaJ.setOnClickListener(this);
        this.aaK.setOnClickListener(this);
        this.aaK.setAutoPlay(true);
        this.aaK.setPlayCallback(new j(this));
    }

    public void dP(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.Tf = str;
            aVar.Th = str;
            this.aaK.setIsHide(false);
            this.aaK.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.m.a(this.mActivity, this.mActivity.getString(y.loading), this);
        }
    }

    private Dialog vv() {
        Dialog dialog = new Dialog(this.mActivity, z.dialog_full_screen);
        dialog.setContentView(w.gif_play_dialog);
        dialog.setOnDismissListener(new k(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aaK.rX();
        com.baidu.adp.lib.g.j.b(this.aaI, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aaK.stop();
        com.baidu.adp.lib.g.j.b(this.aaI, this.mActivity);
    }
}
