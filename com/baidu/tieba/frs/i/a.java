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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private TbPageContext Ea;
    private boolean bRv;
    private View bRw;
    private PopupWindow bRx;
    private Handler mHandler = new Handler();
    private Runnable bRy = new b(this);

    public a(TbPageContext tbPageContext, boolean z) {
        this.Ea = tbPageContext;
        this.bRv = z;
    }

    public void ak(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.Ea != null && view != null && this.bRv && !StringUtils.isNull(currentAccount)) {
            String str = String.valueOf(currentAccount) + "frs_god_new_post_tip_count";
            int i = com.baidu.tbadk.core.sharedPref.b.sO().getInt(str, 0);
            if (i >= 3) {
                this.bRv = false;
                return;
            }
            this.bRw = view;
            com.baidu.tbadk.core.sharedPref.b.sO().putInt(str, i + 1);
            this.mHandler.postDelayed(this.bRy, 500L);
            this.bRv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View d(Activity activity, int i) {
        TextView textView = new TextView(activity);
        textView.setPadding(i, 0, i, 0);
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.k.c(activity, u.e.fontsize28));
        textView.setText(u.j.attention_post_update_tip);
        textView.setOnClickListener(this);
        av.k(textView, u.f.bg_tip_blue);
        av.j((View) textView, u.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ZQ();
    }

    public void ZQ() {
        if (this.bRx != null) {
            this.bRx.dismiss();
            this.bRx = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        ZQ();
    }
}
