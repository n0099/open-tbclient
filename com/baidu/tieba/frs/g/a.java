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
    private TbPageContext ajU;
    private boolean ccN;
    private boolean ccO;
    private View ccP;
    private PopupWindow ccQ;
    private int ccM = w.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable ccR = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.ajU = tbPageContext;
        this.ccO = z;
    }

    public void aj(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.ajU != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.ccP = view;
            if (this.ccN) {
                this.ccM = w.l.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.uL().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.uL().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.ccR, 500L);
                    return;
                }
            }
            if (this.ccO) {
                this.ccM = w.l.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.uL().getInt(str2, 0);
                if (i2 >= 3) {
                    this.ccO = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.uL().putInt(str2, i2 + 1);
                this.ccO = false;
                this.mHandler.postDelayed(this.ccR, 500L);
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
        aez();
    }

    public void aez() {
        if (this.ccQ != null) {
            this.ccQ.dismiss();
            this.ccQ = null;
        }
    }

    public void cf(boolean z) {
        this.ccN = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aez();
    }
}
