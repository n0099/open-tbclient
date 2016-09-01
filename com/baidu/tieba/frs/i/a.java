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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext GM;
    private boolean ceC;
    private boolean ceD;
    private View ceE;
    private PopupWindow ceF;
    private int ceB = t.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable ceG = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.GM = tbPageContext;
        this.ceD = z;
    }

    public void ai(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.GM != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.ceE = view;
            if (this.ceC) {
                this.ceB = t.j.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.tS().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.tS().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.ceG, 500L);
                    return;
                }
            }
            if (this.ceD) {
                this.ceB = t.j.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.tS().getInt(str2, 0);
                if (i2 >= 3) {
                    this.ceD = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.tS().putInt(str2, i2 + 1);
                this.ceD = false;
                this.mHandler.postDelayed(this.ceG, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View e(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int e = com.baidu.adp.lib.util.k.e(activity, t.e.ds20);
        textView.setPadding(e, 0 - activity.getResources().getDimensionPixelSize(t.e.ds12), e, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(t.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.k.e(activity, t.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        av.k(textView, t.f.bg_tip_blue_left);
        av.j((View) textView, t.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        afd();
    }

    public void afd() {
        if (this.ceF != null) {
            this.ceF.dismiss();
            this.ceF = null;
        }
    }

    public void ef(boolean z) {
        this.ceC = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        afd();
    }
}
