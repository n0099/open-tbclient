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
    private Dialog arI;
    private LinearLayout arJ;
    private GiftGifView arK;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public i(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.arI = Dy();
        this.arJ = (LinearLayout) this.arI.findViewById(v.gift_gif_ll);
        this.arK = (GiftGifView) this.arI.findViewById(v.gift_gif_view);
        this.arJ.setOnClickListener(this);
        this.arK.setOnClickListener(this);
        this.arK.setAutoPlay(true);
        this.arK.setPlayCallback(new j(this));
    }

    public void play(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.aks = str;
            aVar.aku = str;
            this.arK.setIsHide(false);
            this.arK.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.n.a(this.mActivity, this.mActivity.getString(y.loading), this);
        }
    }

    private Dialog Dy() {
        Dialog dialog = new Dialog(this.mActivity, z.dialog_full_screen);
        dialog.setContentView(w.gif_play_dialog);
        dialog.setOnDismissListener(new k(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.arK.zw();
        com.baidu.adp.lib.g.k.b(this.arI, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.arK.stop();
        com.baidu.adp.lib.g.k.b(this.arI, this.mActivity);
    }
}
