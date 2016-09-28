package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext GM;
    private boolean ceB;
    private boolean ceC;
    private View ceD;
    private PopupWindow ceE;
    private int ceA = r.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable ceF = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.GM = tbPageContext;
        this.ceC = z;
    }

    public void ah(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.GM != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.ceD = view;
            if (this.ceB) {
                this.ceA = r.j.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.uh().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.uh().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.ceF, 500L);
                    return;
                }
            }
            if (this.ceC) {
                this.ceA = r.j.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.uh().getInt(str2, 0);
                if (i2 >= 3) {
                    this.ceC = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.uh().putInt(str2, i2 + 1);
                this.ceC = false;
                this.mHandler.postDelayed(this.ceF, 500L);
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
        av.k(textView, r.f.bg_tip_blue_left);
        av.j((View) textView, r.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        afr();
    }

    public void afr() {
        if (this.ceE != null) {
            this.ceE.dismiss();
            this.ceE = null;
        }
    }

    public void eg(boolean z) {
        this.ceB = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        afr();
    }
}
