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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private boolean fTn;
    private PopupWindow fac;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int fTm = R.string.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable fTo = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int g = l.g(pageActivity, R.dimen.ds64);
                View h = a.this.h(pageActivity, a.this.fTm);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int g2 = l.g(pageActivity, R.dimen.ds32);
                int g3 = l.g(pageActivity, R.dimen.ds16) + (iArr[1] - g);
                a.this.fac = new PopupWindow(h, -2, g);
                a.this.fac.showAtLocation(a.this.mAnchor, 53, g2, g3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.fac != null) {
                            a.this.bte();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.fTn = z;
    }

    public void bY(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.fTn) {
                this.fTm = R.string.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt(str, 0);
                if (i >= 3) {
                    this.fTn = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt(str, i + 1);
                this.fTn = false;
                this.mHandler.postDelayed(this.fTo, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View h(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int g = l.g(activity, R.dimen.ds20);
        textView.setPadding(g, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), g, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.g(activity, R.dimen.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        am.k(textView, R.drawable.bg_tip_blue_left);
        am.j(textView, R.color.cp_cont_a);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bte();
    }

    public void bte() {
        if (this.fac != null) {
            this.fac.dismiss();
            this.fac = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        bte();
    }
}
