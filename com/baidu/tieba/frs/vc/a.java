package com.baidu.tieba.frs.vc;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private PopupWindow gQX;
    private boolean hLK;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int hLJ = R.string.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable hLL = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int dimens = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds64);
                View h = a.this.h(pageActivity, a.this.hLJ);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds32);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds16) + (iArr[1] - dimens);
                a.this.gQX = new PopupWindow(h, -2, dimens);
                a.this.gQX.showAtLocation(a.this.mAnchor, 53, dimens2, dimens3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.gQX != null) {
                            a.this.cbv();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.hLK = z;
    }

    public void cd(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.hLK) {
                this.hLJ = R.string.attention_post_update_tip;
                String str = currentAccount + SharedPrefConfig.FRS_GOD_NEW_POST_TIP_COUNT;
                int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(str, 0);
                if (i >= 3) {
                    this.hLK = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt(str, i + 1);
                this.hLK = false;
                this.mHandler.postDelayed(this.hLL, 500L);
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
        am.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
        am.setViewTextColor(textView, (int) R.color.cp_cont_a);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cbv();
    }

    public void cbv() {
        if (this.gQX != null) {
            this.gQX.dismiss();
            this.gQX = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        cbv();
    }
}
