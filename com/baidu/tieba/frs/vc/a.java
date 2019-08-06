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
    private PopupWindow eYw;
    private boolean fRw;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int fRv = R.string.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable fRx = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int g = l.g(pageActivity, R.dimen.ds64);
                View g2 = a.this.g(pageActivity, a.this.fRv);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int g3 = l.g(pageActivity, R.dimen.ds32);
                int g4 = l.g(pageActivity, R.dimen.ds16) + (iArr[1] - g);
                a.this.eYw = new PopupWindow(g2, -2, g);
                a.this.eYw.showAtLocation(a.this.mAnchor, 53, g3, g4);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.eYw != null) {
                            a.this.bsr();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.fRw = z;
    }

    public void bY(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.fRw) {
                this.fRv = R.string.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt(str, 0);
                if (i >= 3) {
                    this.fRw = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt(str, i + 1);
                this.fRw = false;
                this.mHandler.postDelayed(this.fRx, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View g(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int g = l.g(activity, R.dimen.ds20);
        textView.setPadding(g, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), g, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.g(activity, R.dimen.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        am.k(textView, R.drawable.bg_tip_blue_left);
        am.j(textView, R.color.cp_btn_a);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bsr();
    }

    public void bsr() {
        if (this.eYw != null) {
            this.eYw.dismiss();
            this.eYw = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        bsr();
    }
}
