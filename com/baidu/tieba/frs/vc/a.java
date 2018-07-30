package com.baidu.tieba.frs.vc;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private PopupWindow cTk;
    private boolean dFW;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int dFV = d.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable dFX = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int f = l.f(pageActivity, d.e.ds64);
                View f2 = a.this.f(pageActivity, a.this.dFV);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int f3 = l.f(pageActivity, d.e.ds32);
                int f4 = l.f(pageActivity, d.e.ds16) + (iArr[1] - f);
                a.this.cTk = new PopupWindow(f2, -2, f);
                a.this.cTk.showAtLocation(a.this.mAnchor, 53, f3, f4);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cTk != null) {
                            a.this.aAn();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.dFW = z;
    }

    public void aC(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.dFW) {
                this.dFV = d.j.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.dFW = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.dFW = false;
                this.mHandler.postDelayed(this.dFX, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View f(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int f = l.f(activity, d.e.ds20);
        textView.setPadding(f, 0 - activity.getResources().getDimensionPixelSize(d.e.ds12), f, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.f(activity, d.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        am.i(textView, d.f.bg_tip_blue_left);
        am.h(textView, d.C0140d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aAn();
    }

    public void aAn() {
        if (this.cTk != null) {
            this.cTk.dismiss();
            this.cTk = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aAn();
    }
}
