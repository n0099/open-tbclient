package com.baidu.tieba.frs.g;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private View aYR;
    private boolean dah;
    private PopupWindow dai;
    private TbPageContext mPageContext;
    private int dag = d.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable daj = new Runnable() { // from class: com.baidu.tieba.frs.g.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.aYR != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int f = l.f(pageActivity, d.e.ds64);
                View h = a.this.h(pageActivity, a.this.dag);
                int[] iArr = new int[2];
                a.this.aYR.getLocationInWindow(iArr);
                int f2 = l.f(pageActivity, d.e.ds32);
                int f3 = l.f(pageActivity, d.e.ds16) + (iArr[1] - f);
                a.this.dai = new PopupWindow(h, -2, f);
                a.this.dai.showAtLocation(a.this.aYR, 53, f2, f3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dai != null) {
                            a.this.aqG();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.dah = z;
    }

    public void aE(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.aYR = view;
            if (this.dah) {
                this.dag = d.j.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.dah = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.dah = false;
                this.mHandler.postDelayed(this.daj, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View h(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int f = l.f(activity, d.e.ds20);
        textView.setPadding(f, 0 - activity.getResources().getDimensionPixelSize(d.e.ds12), f, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.f(activity, d.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        aj.j(textView, d.f.bg_tip_blue_left);
        aj.i(textView, d.C0096d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aqG();
    }

    public void aqG() {
        if (this.dai != null) {
            this.dai.dismiss();
            this.dai = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aqG();
    }
}
