package com.baidu.tieba.ala.guardclub.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.RoundImageView;
/* loaded from: classes11.dex */
public class e {
    Dialog bkh;

    public void v(Context context, String str, String str2) {
        if (context != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (Build.VERSION.SDK_INT >= 17) {
                if (activity.isDestroyed() || activity.isFinishing()) {
                    return;
                }
            } else if (activity.isFinishing()) {
                return;
            }
            if (this.bkh == null || !this.bkh.isShowing()) {
                View inflate = LayoutInflater.from(context).inflate(a.g.alal_sdk_dialog_guard, (ViewGroup) null, false);
                this.bkh = new Dialog(context, a.i.FlowerGuideDialogStyle);
                this.bkh.requestWindowFeature(1);
                this.bkh.setCancelable(true);
                this.bkh.setContentView(inflate);
                this.bkh.setCanceledOnTouchOutside(false);
                RoundImageView roundImageView = (RoundImageView) inflate.findViewById(a.f.ala_sdk_guard_top_tv);
                roundImageView.setRadius(context.getResources().getDimension(a.d.sdk_ds36));
                roundImageView.setTop(true);
                TextView textView = (TextView) inflate.findViewById(a.f.ala_sdk_guard_tv_tip);
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(str);
                }
                TextView textView2 = (TextView) inflate.findViewById(a.f.ala_sdk_guard_tv_tip2);
                if (!TextUtils.isEmpty(str2)) {
                    textView2.setText(str2);
                }
                ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.If();
                    }
                });
                this.bkh.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        if (this.bkh != null && this.bkh.isShowing()) {
            Context context = this.bkh.getContext();
            if (context != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                } else if (activity.isFinishing()) {
                    return;
                }
            }
            try {
                this.bkh.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.bkh = null;
    }
}
