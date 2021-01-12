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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private PopupWindow iEb;
    private boolean jDW;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int jDV = R.string.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable jDX = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int dimens = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds64);
                View h = a.this.h(pageActivity, a.this.jDV);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds32);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds16) + (iArr[1] - dimens);
                a.this.iEb = new PopupWindow(h, -2, dimens);
                a.this.iEb.showAtLocation(a.this.mAnchor, 53, dimens2, dimens3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.iEb != null) {
                            a.this.cJt();
                        }
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.jDW = z;
    }

    public void dd(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.jDW) {
                this.jDV = R.string.attention_post_update_tip;
                String str = currentAccount + SharedPrefConfig.FRS_GOD_NEW_POST_TIP_COUNT;
                int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt(str, 0);
                if (i >= 3) {
                    this.jDW = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.brx().putInt(str, i + 1);
                this.jDW = false;
                this.mHandler.postDelayed(this.jDX, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View h(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int dimens = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.ds20);
        textView.setPadding(dimens, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), dimens, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        ao.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
        ao.setViewTextColor(textView, R.color.CAM_X0101);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cJt();
    }

    public void cJt() {
        if (this.iEb != null) {
            this.iEb.dismiss();
            this.iEb = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        cJt();
    }
}
