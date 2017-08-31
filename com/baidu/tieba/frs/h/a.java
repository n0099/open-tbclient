package com.baidu.tieba.frs.h;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private View alz;
    private boolean cFP;
    private PopupWindow cFQ;
    private TbPageContext mF;
    private int cFO = d.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable cFR = new Runnable() { // from class: com.baidu.tieba.frs.h.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mF != null && a.this.alz != null) {
                Activity pageActivity = a.this.mF.getPageActivity();
                int g = k.g(pageActivity, d.f.ds64);
                View f = a.this.f(pageActivity, a.this.cFO);
                int[] iArr = new int[2];
                a.this.alz.getLocationInWindow(iArr);
                int g2 = k.g(pageActivity, d.f.ds32);
                int g3 = k.g(pageActivity, d.f.ds16) + (iArr[1] - g);
                a.this.cFQ = new PopupWindow(f, -2, g);
                a.this.cFQ.showAtLocation(a.this.alz, 53, g2, g3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cFQ != null) {
                            a.this.alt();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mF = tbPageContext;
        this.cFP = z;
    }

    public void ax(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mF != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.alz = view;
            if (this.cFP) {
                this.cFO = d.l.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.cFP = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.cFP = false;
                this.mHandler.postDelayed(this.cFR, 500L);
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
        aj.j(textView, d.g.bg_tip_blue_left);
        aj.i(textView, d.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        alt();
    }

    public void alt() {
        if (this.cFQ != null) {
            this.cFQ.dismiss();
            this.cFQ = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        alt();
    }
}
