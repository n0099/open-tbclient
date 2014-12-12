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
    private GiftGifView aiA;
    private Dialog aiy;
    private LinearLayout aiz;
    private Activity mActivity;
    private ProgressDialog mWaitingDialog;

    public i(Activity activity) {
        this.mActivity = activity;
        init();
    }

    private void init() {
        this.aiy = zI();
        this.aiz = (LinearLayout) this.aiy.findViewById(w.gift_gif_ll);
        this.aiA = (GiftGifView) this.aiy.findViewById(w.gift_gif_view);
        this.aiz.setOnClickListener(this);
        this.aiA.setOnClickListener(this);
        this.aiA.setAutoPlay(true);
        this.aiA.setPlayCallback(new j(this));
    }

    public void play(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.Zo = str;
            aVar.Zq = str;
            this.aiA.setIsHide(false);
            this.aiA.a(aVar);
            this.mWaitingDialog = com.baidu.adp.lib.util.l.a(this.mActivity, this.mActivity.getString(z.loading), this);
        }
    }

    private Dialog zI() {
        Dialog dialog = new Dialog(this.mActivity, aa.dialog_full_screen);
        dialog.setContentView(x.gif_play_dialog);
        dialog.setOnDismissListener(new k(this));
        return dialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aiA.vE();
        com.baidu.adp.lib.g.k.b(this.aiy, this.mActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aiA.stop();
        com.baidu.adp.lib.g.k.b(this.aiy, this.mActivity);
    }
}
