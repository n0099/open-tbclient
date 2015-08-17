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
    private Dialog aAw;
    private LinearLayout aAx;
    private GiftGifView aAy;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public e(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.aAw = ET();
        this.aAx = (LinearLayout) this.aAw.findViewById(i.f.gift_gif_ll);
        this.aAy = (GiftGifView) this.aAw.findViewById(i.f.gift_gif_view);
        this.aAx.setOnClickListener(this);
        this.aAy.setOnClickListener(this);
        this.aAy.setAutoPlay(true);
        this.aAy.setPlayCallback(new f(this));
    }

    public void fC(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.asY = str;
            aVar.ata = str;
            this.aAy.setIsHide(false);
            this.aAy.a(aVar);
            this.mWaitingDialog = k.a(this.mActivity, this.mActivity.getString(i.C0057i.loading), this);
        }
    }

    private Dialog ET() {
        Dialog dialog = new Dialog(this.mActivity, i.j.dialog_full_screen);
        dialog.setContentView(i.g.gif_play_dialog);
        dialog.setOnDismissListener(new g(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aAy.Cb();
        j.b(this.aAw, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aAy.stop();
        j.b(this.aAw, this.mActivity);
    }
}
