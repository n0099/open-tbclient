package com.baidu.tieba.frs.vc;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private boolean fRP;
    private PopupWindow fbW;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int fRO = R.string.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable fRQ = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int dimens = l.getDimens(pageActivity, R.dimen.ds64);
                View e = a.this.e(pageActivity, a.this.fRO);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int dimens2 = l.getDimens(pageActivity, R.dimen.ds32);
                int dimens3 = l.getDimens(pageActivity, R.dimen.ds16) + (iArr[1] - dimens);
                a.this.fbW = new PopupWindow(e, -2, dimens);
                a.this.fbW.showAtLocation(a.this.mAnchor, 53, dimens2, dimens3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.fbW != null) {
                            a.this.bqf();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.fRP = z;
    }

    public void bV(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.fRP) {
                this.fRO = R.string.attention_post_update_tip;
                String str = currentAccount + SharedPrefConfig.FRS_GOD_NEW_POST_TIP_COUNT;
                int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt(str, 0);
                if (i >= 3) {
                    this.fRP = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.alP().putInt(str, i + 1);
                this.fRP = false;
                this.mHandler.postDelayed(this.fRQ, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View e(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int dimens = l.getDimens(activity, R.dimen.ds20);
        textView.setPadding(dimens, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), dimens, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.getDimens(activity, R.dimen.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        am.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
        am.setViewTextColor(textView, (int) R.color.cp_cont_a);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bqf();
    }

    public void bqf() {
        if (this.fbW != null) {
            this.fbW.dismiss();
            this.fbW = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        bqf();
    }
}
