package com.baidu.tieba.frs.f;

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
    private View QX;
    private boolean dMD;
    private PopupWindow dME;
    private TbPageContext mPageContext;
    private int dMC = d.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable dMF = new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.QX != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int s = l.s(pageActivity, d.e.ds64);
                View h = a.this.h(pageActivity, a.this.dMC);
                int[] iArr = new int[2];
                a.this.QX.getLocationInWindow(iArr);
                int s2 = l.s(pageActivity, d.e.ds32);
                int s3 = l.s(pageActivity, d.e.ds16) + (iArr[1] - s);
                a.this.dME = new PopupWindow(h, -2, s);
                a.this.dME.showAtLocation(a.this.QX, 53, s2, s3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dME != null) {
                            a.this.axN();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.dMD = z;
    }

    public void bQ(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.QX = view;
            if (this.dMD) {
                this.dMC = d.j.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.dMD = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.dMD = false;
                this.mHandler.postDelayed(this.dMF, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View h(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int s = l.s(activity, d.e.ds20);
        textView.setPadding(s, 0 - activity.getResources().getDimensionPixelSize(d.e.ds12), s, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.s(activity, d.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        aj.s(textView, d.f.bg_tip_blue_left);
        aj.r(textView, d.C0108d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        axN();
    }

    public void axN() {
        if (this.dME != null) {
            this.dME.dismiss();
            this.dME = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        axN();
    }
}
