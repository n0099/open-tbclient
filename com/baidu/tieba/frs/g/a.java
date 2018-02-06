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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private View QW;
    private boolean dUM;
    private PopupWindow dUN;
    private TbPageContext mPageContext;
    private int dUL = d.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable dUO = new Runnable() { // from class: com.baidu.tieba.frs.g.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.QW != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int t = l.t(pageActivity, d.e.ds64);
                View f = a.this.f(pageActivity, a.this.dUL);
                int[] iArr = new int[2];
                a.this.QW.getLocationInWindow(iArr);
                int t2 = l.t(pageActivity, d.e.ds32);
                int t3 = l.t(pageActivity, d.e.ds16) + (iArr[1] - t);
                a.this.dUN = new PopupWindow(f, -2, t);
                a.this.dUN.showAtLocation(a.this.QW, 53, t2, t3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dUN != null) {
                            a.this.azX();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.dUM = z;
    }

    public void bS(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.QW = view;
            if (this.dUM) {
                this.dUL = d.j.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.dUM = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.dUM = false;
                this.mHandler.postDelayed(this.dUO, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View f(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int t = l.t(activity, d.e.ds20);
        textView.setPadding(t, 0 - activity.getResources().getDimensionPixelSize(d.e.ds12), t, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.t(activity, d.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        aj.s(textView, d.f.bg_tip_blue_left);
        aj.r(textView, d.C0140d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        azX();
    }

    public void azX() {
        if (this.dUN != null) {
            this.dUN.dismiss();
            this.dUN = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        azX();
    }
}
