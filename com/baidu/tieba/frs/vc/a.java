package com.baidu.tieba.frs.vc;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a implements View.OnClickListener {
    private PopupWindow hDr;
    private boolean iAG;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int iAF = R.string.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable iAH = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int dimens = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds64);
                View g = a.this.g(pageActivity, a.this.iAF);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds32);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds16) + (iArr[1] - dimens);
                a.this.hDr = new PopupWindow(g, -2, dimens);
                a.this.hDr.showAtLocation(a.this.mAnchor, 53, dimens2, dimens3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.hDr != null) {
                            a.this.cwj();
                        }
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.iAG = z;
    }

    public void cv(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.iAG) {
                this.iAF = R.string.attention_post_update_tip;
                String str = currentAccount + SharedPrefConfig.FRS_GOD_NEW_POST_TIP_COUNT;
                int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt(str, 0);
                if (i >= 3) {
                    this.iAG = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt(str, i + 1);
                this.iAG = false;
                this.mHandler.postDelayed(this.iAH, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View g(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int dimens = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.ds20);
        textView.setPadding(dimens, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), dimens, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        ap.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
        ap.setViewTextColor(textView, R.color.cp_cont_a);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cwj();
    }

    public void cwj() {
        if (this.hDr != null) {
            this.hDr.dismiss();
            this.hDr = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        cwj();
    }
}
