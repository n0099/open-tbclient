package com.baidu.tbadk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.gif.GiftGifView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e implements DialogInterface.OnCancelListener, View.OnClickListener {
    private Dialog aCe;
    private LinearLayout aCf;
    private GiftGifView aCg;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public e(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.aCe = Fd();
        this.aCf = (LinearLayout) this.aCe.findViewById(i.f.gift_gif_ll);
        this.aCg = (GiftGifView) this.aCe.findViewById(i.f.gift_gif_view);
        this.aCf.setOnClickListener(this);
        this.aCg.setOnClickListener(this);
        this.aCg.setAutoPlay(true);
        this.aCg.setPlayCallback(new f(this));
    }

    public void fK(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.auI = str;
            aVar.auK = str;
            this.aCg.setIsHide(false);
            this.aCg.a(aVar);
            this.mWaitingDialog = k.a(this.mActivity, this.mActivity.getString(i.h.loading), this);
        }
    }

    private Dialog Fd() {
        Dialog dialog = new Dialog(this.mActivity, i.C0057i.dialog_full_screen);
        dialog.setContentView(i.g.gif_play_dialog);
        dialog.setOnDismissListener(new g(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aCg.Cp();
        j.b(this.aCe, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aCg.stop();
        j.b(this.aCe, this.mActivity);
    }
}
