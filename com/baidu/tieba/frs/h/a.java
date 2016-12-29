package com.baidu.tieba.frs.h;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext GO;
    private boolean bOg;
    private boolean bOh;
    private View bOi;
    private PopupWindow bOj;
    private int bOf = r.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable bOk = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.GO = tbPageContext;
        this.bOh = z;
    }

    public void ai(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.GO != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.bOi = view;
            if (this.bOg) {
                this.bOf = r.j.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.tW().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.tW().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.bOk, 500L);
                    return;
                }
            }
            if (this.bOh) {
                this.bOf = r.j.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.tW().getInt(str2, 0);
                if (i2 >= 3) {
                    this.bOh = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.tW().putInt(str2, i2 + 1);
                this.bOh = false;
                this.mHandler.postDelayed(this.bOk, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View e(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int e = com.baidu.adp.lib.util.k.e(activity, r.e.ds20);
        textView.setPadding(e, 0 - activity.getResources().getDimensionPixelSize(r.e.ds12), e, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(r.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.k.e(activity, r.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        ar.k(textView, r.f.bg_tip_blue_left);
        ar.j((View) textView, r.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        abw();
    }

    public void abw() {
        if (this.bOj != null) {
            this.bOj.dismiss();
            this.bOj = null;
        }
    }

    public void ee(boolean z) {
        this.bOg = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        abw();
    }
}
