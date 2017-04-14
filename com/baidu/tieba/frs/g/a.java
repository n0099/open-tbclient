package com.baidu.tieba.frs.g;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext ajT;
    private boolean caw;
    private boolean cax;
    private View cay;
    private PopupWindow caz;
    private int cav = w.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable caA = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.ajT = tbPageContext;
        this.cax = z;
    }

    public void aj(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.ajT != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.cay = view;
            if (this.caw) {
                this.cav = w.l.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.uL().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.uL().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.caA, 500L);
                    return;
                }
            }
            if (this.cax) {
                this.cav = w.l.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.uL().getInt(str2, 0);
                if (i2 >= 3) {
                    this.cax = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.uL().putInt(str2, i2 + 1);
                this.cax = false;
                this.mHandler.postDelayed(this.caA, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View e(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int g = com.baidu.adp.lib.util.k.g(activity, w.f.ds20);
        textView.setPadding(g, 0 - activity.getResources().getDimensionPixelSize(w.f.ds12), g, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(w.f.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.k.g(activity, w.f.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        com.baidu.tbadk.core.util.aq.j(textView, w.g.bg_tip_blue_left);
        com.baidu.tbadk.core.util.aq.i(textView, w.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ady();
    }

    public void ady() {
        if (this.caz != null) {
            this.caz.dismiss();
            this.caz = null;
        }
    }

    public void cf(boolean z) {
        this.caw = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        ady();
    }
}
