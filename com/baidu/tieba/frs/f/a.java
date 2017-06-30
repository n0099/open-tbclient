package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext ajP;
    private boolean cpc;
    private boolean cpd;
    private View cpe;
    private PopupWindow cpf;
    private int cpb = w.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable cpg = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.ajP = tbPageContext;
        this.cpd = z;
    }

    public void aj(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.ajP != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.cpe = view;
            if (this.cpc) {
                this.cpb = w.l.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.cpg, 500L);
                    return;
                }
            }
            if (this.cpd) {
                this.cpb = w.l.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
                if (i2 >= 3) {
                    this.cpd = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str2, i2 + 1);
                this.cpd = false;
                this.mHandler.postDelayed(this.cpg, 500L);
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
        as.j(textView, w.g.bg_tip_blue_left);
        as.i(textView, w.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ahy();
    }

    public void ahy() {
        if (this.cpf != null) {
            this.cpf.dismiss();
            this.cpf = null;
        }
    }

    public void cg(boolean z) {
        this.cpc = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        ahy();
    }
}
