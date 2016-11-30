package com.baidu.tieba.frs.j;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext GO;
    private boolean cja;
    private boolean cjb;
    private View cjc;
    private PopupWindow cjd;
    private int ciZ = r.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable cje = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.GO = tbPageContext;
        this.cjb = z;
    }

    public void ai(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.GO != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.cjc = view;
            if (this.cja) {
                this.ciZ = r.j.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.um().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.um().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.cje, 500L);
                    return;
                }
            }
            if (this.cjb) {
                this.ciZ = r.j.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.um().getInt(str2, 0);
                if (i2 >= 3) {
                    this.cjb = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.um().putInt(str2, i2 + 1);
                this.cjb = false;
                this.mHandler.postDelayed(this.cje, 500L);
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
        at.k(textView, r.f.bg_tip_blue_left);
        at.j((View) textView, r.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ahb();
    }

    public void ahb() {
        if (this.cjd != null) {
            this.cjd.dismiss();
            this.cjd = null;
        }
    }

    public void eu(boolean z) {
        this.cja = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        ahb();
    }
}
