package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext ajh;
    private boolean cgM;
    private boolean cgN;
    private View cgO;
    private PopupWindow cgP;
    private int cgL = w.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable cgQ = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.ajh = tbPageContext;
        this.cgN = z;
    }

    public void ah(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.ajh != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.cgO = view;
            if (this.cgM) {
                this.cgL = w.l.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.cgQ, 500L);
                    return;
                }
            }
            if (this.cgN) {
                this.cgL = w.l.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
                if (i2 >= 3) {
                    this.cgN = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str2, i2 + 1);
                this.cgN = false;
                this.mHandler.postDelayed(this.cgQ, 500L);
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
        aq.j(textView, w.g.bg_tip_blue_left);
        aq.i(textView, w.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        adF();
    }

    public void adF() {
        if (this.cgP != null) {
            this.cgP.dismiss();
            this.cgP = null;
        }
    }

    public void ce(boolean z) {
        this.cgM = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        adF();
    }
}
