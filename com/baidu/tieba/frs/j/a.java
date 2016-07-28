package com.baidu.tieba.frs.j;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext EA;
    private boolean bTu;
    private boolean bTv;
    private View bTw;
    private PopupWindow bTx;
    private int bTt = u.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable bTy = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.EA = tbPageContext;
        this.bTv = z;
    }

    public void ai(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.EA != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.bTw = view;
            if (this.bTu) {
                this.bTt = u.j.smart_frs_tip;
                String str = "smart_frs_smart_sort_tip_show_counts_" + currentAccount;
                int i = com.baidu.tbadk.core.sharedPref.b.sN().getInt(str, 0);
                if (i < 1) {
                    com.baidu.tbadk.core.sharedPref.b.sN().putInt(str, i + 1);
                    this.mHandler.postDelayed(this.bTy, 500L);
                    return;
                }
            }
            if (this.bTv) {
                this.bTt = u.j.attention_post_update_tip;
                String str2 = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
                int i2 = com.baidu.tbadk.core.sharedPref.b.sN().getInt(str2, 0);
                if (i2 >= 3) {
                    this.bTv = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.sN().putInt(str2, i2 + 1);
                this.bTv = false;
                this.mHandler.postDelayed(this.bTy, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View d(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int c = com.baidu.adp.lib.util.k.c(activity, u.e.ds20);
        textView.setPadding(c, 0 - activity.getResources().getDimensionPixelSize(u.e.ds12), c, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(u.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.k.c(activity, u.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        av.k(textView, u.f.bg_tip_blue_left);
        av.j((View) textView, u.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aas();
    }

    public void aas() {
        if (this.bTx != null) {
            this.bTx.dismiss();
            this.bTx = null;
        }
    }

    public void dJ(boolean z) {
        this.bTu = z;
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aas();
    }
}
