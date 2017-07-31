package com.baidu.tieba.frs.g;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext alI;
    private View ame;
    private boolean cxp;
    private boolean cxq;
    private PopupWindow cxr;
    private int cxo = d.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable cxs = new Runnable() { // from class: com.baidu.tieba.frs.g.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.alI != null && a.this.ame != null) {
                Activity pageActivity = a.this.alI.getPageActivity();
                int g = k.g(pageActivity, d.f.ds64);
                View f = a.this.f(pageActivity, a.this.cxo);
                int[] iArr = new int[2];
                a.this.ame.getLocationInWindow(iArr);
                int g2 = k.g(pageActivity, d.f.ds32);
                int g3 = k.g(pageActivity, d.f.ds16) + (iArr[1] - g);
                a.this.cxr = new PopupWindow(f, -2, g);
                a.this.cxr.showAtLocation(a.this.ame, 53, g2, g3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cxr != null) {
                            a.this.aji();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.alI = tbPageContext;
        this.cxq = z;
    }

    public void ao(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.alI != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.ame = view;
            if (this.cxp) {
                this.cxo = d.l.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.cxs, 500L);
                    return;
                }
            }
            if (this.cxq) {
                this.cxo = d.l.attention_post_update_tip;
                String str2 = currentAccount + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
                if (i2 >= 3) {
                    this.cxq = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str2, i2 + 1);
                this.cxq = false;
                this.mHandler.postDelayed(this.cxs, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View f(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int g = k.g(activity, d.f.ds20);
        textView.setPadding(g, 0 - activity.getResources().getDimensionPixelSize(d.f.ds12), g, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.f.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, k.g(activity, d.f.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        ai.j(textView, d.g.bg_tip_blue_left);
        ai.i(textView, d.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aji();
    }

    public void aji() {
        if (this.cxr != null) {
            this.cxr.dismiss();
            this.cxr = null;
        }
    }

    public void cj(boolean z) {
        this.cxp = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aji();
    }
}
