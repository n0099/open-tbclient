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
    private Dialog arA;
    private LinearLayout arB;
    private GiftGifView arC;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public i(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.arA = Ds();
        this.arB = (LinearLayout) this.arA.findViewById(v.gift_gif_ll);
        this.arC = (GiftGifView) this.arA.findViewById(v.gift_gif_view);
        this.arB.setOnClickListener(this);
        this.arC.setOnClickListener(this);
        this.arC.setAutoPlay(true);
        this.arC.setPlayCallback(new j(this));
    }

    public void play(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.akk = str;
            aVar.akm = str;
            this.arC.setIsHide(false);
            this.arC.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.n.a(this.mActivity, this.mActivity.getString(y.loading), this);
        }
    }

    private Dialog Ds() {
        Dialog dialog = new Dialog(this.mActivity, z.dialog_full_screen);
        dialog.setContentView(w.gif_play_dialog);
        dialog.setOnDismissListener(new k(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.arC.zq();
        com.baidu.adp.lib.g.k.b(this.arA, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.arC.stop();
        com.baidu.adp.lib.g.k.b(this.arA, this.mActivity);
    }
}
