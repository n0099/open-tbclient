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
    private View alx;
    private boolean cGH;
    private PopupWindow cGI;
    private TbPageContext mF;
    private int cGG = d.l.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable cGJ = new Runnable() { // from class: com.baidu.tieba.frs.h.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mF != null && a.this.alx != null) {
                Activity pageActivity = a.this.mF.getPageActivity();
                int f = k.f(pageActivity, d.f.ds64);
                View f2 = a.this.f(pageActivity, a.this.cGG);
                int[] iArr = new int[2];
                a.this.alx.getLocationInWindow(iArr);
                int f3 = k.f(pageActivity, d.f.ds32);
                int f4 = k.f(pageActivity, d.f.ds16) + (iArr[1] - f);
                a.this.cGI = new PopupWindow(f2, -2, f);
                a.this.cGI.showAtLocation(a.this.alx, 53, f3, f4);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cGI != null) {
                            a.this.alE();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mF = tbPageContext;
        this.cGH = z;
    }

    public void ax(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mF != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.alx = view;
            if (this.cGH) {
                this.cGG = d.l.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.cGH = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.cGH = false;
                this.mHandler.postDelayed(this.cGJ, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View f(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int f = k.f(activity, d.f.ds20);
        textView.setPadding(f, 0 - activity.getResources().getDimensionPixelSize(d.f.ds12), f, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.f.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, k.f(activity, d.f.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        aj.j(textView, d.g.bg_tip_blue_left);
        aj.i(textView, d.e.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        alE();
    }

    public void alE() {
        if (this.cGI != null) {
            this.cGI.dismiss();
            this.cGI = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        alE();
    }
}
