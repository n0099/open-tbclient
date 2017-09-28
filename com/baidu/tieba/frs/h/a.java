package com.baidu.tieba.frs.h;

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
    private View aVJ;
    private boolean cHA;
    private PopupWindow cHB;
    private TbPageContext mG;
    private int cHz = d.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable cHC = new Runnable() { // from class: com.baidu.tieba.frs.h.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mG != null && a.this.aVJ != null) {
                Activity pageActivity = a.this.mG.getPageActivity();
                int f = l.f(pageActivity, d.f.ds64);
                View f2 = a.this.f(pageActivity, a.this.cHz);
                int[] iArr = new int[2];
                a.this.aVJ.getLocationInWindow(iArr);
                int f3 = l.f(pageActivity, d.f.ds32);
                int f4 = l.f(pageActivity, d.f.ds16) + (iArr[1] - f);
                a.this.cHB = new PopupWindow(f2, -2, f);
                a.this.cHB.showAtLocation(a.this.aVJ, 53, f3, f4);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cHB != null) {
                            a.this.alI();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mG = tbPageContext;
        this.cHA = z;
    }

    public void aw(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mG != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.aVJ = view;
            if (this.cHA) {
                this.cHz = d.l.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.cHA = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.cHA = false;
                this.mHandler.postDelayed(this.cHC, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View f(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int f = l.f(activity, d.f.ds20);
        textView.setPadding(f, 0 - activity.getResources().getDimensionPixelSize(d.f.ds12), f, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.f.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.f(activity, d.f.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        aj.j(textView, d.g.bg_tip_blue_left);
        aj.i(textView, d.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        alI();
    }

    public void alI() {
        if (this.cHB != null) {
            this.cHB.dismiss();
            this.cHB = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        alI();
    }
}
