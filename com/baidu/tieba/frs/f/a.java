package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext FY;
    private boolean bUD;
    private boolean bUE;
    private View bUF;
    private PopupWindow bUG;
    private int bUC = r.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable bUH = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.FY = tbPageContext;
        this.bUE = z;
    }

    public void an(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.FY != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.bUF = view;
            if (this.bUD) {
                this.bUC = r.l.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.tQ().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.tQ().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.bUH, 500L);
                    return;
                }
            }
            if (this.bUE) {
                this.bUC = r.l.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.tQ().getInt(str2, 0);
                if (i2 >= 3) {
                    this.bUE = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.tQ().putInt(str2, i2 + 1);
                this.bUE = false;
                this.mHandler.postDelayed(this.bUH, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View e(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int e = com.baidu.adp.lib.util.k.e(activity, r.f.ds20);
        textView.setPadding(e, 0 - activity.getResources().getDimensionPixelSize(r.f.ds12), e, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(r.f.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.k.e(activity, r.f.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        com.baidu.tbadk.core.util.ap.j((View) textView, r.g.bg_tip_blue_left);
        com.baidu.tbadk.core.util.ap.i((View) textView, r.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        acD();
    }

    public void acD() {
        if (this.bUG != null) {
            this.bUG.dismiss();
            this.bUG = null;
        }
    }

    public void ce(boolean z) {
        this.bUD = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        acD();
    }
}
