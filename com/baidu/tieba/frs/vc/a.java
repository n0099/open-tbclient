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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private PopupWindow cYY;
    private boolean dMZ;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int dMY = e.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable dNa = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int h = l.h(pageActivity, e.C0141e.ds64);
                View f = a.this.f(pageActivity, a.this.dMY);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int h2 = l.h(pageActivity, e.C0141e.ds32);
                int h3 = l.h(pageActivity, e.C0141e.ds16) + (iArr[1] - h);
                a.this.cYY = new PopupWindow(f, -2, h);
                a.this.cYY.showAtLocation(a.this.mAnchor, 53, h2, h3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cYY != null) {
                            a.this.aCt();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.dMZ = z;
    }

    public void aQ(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.dMZ) {
                this.dMY = e.j.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.dMZ = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.dMZ = false;
                this.mHandler.postDelayed(this.dNa, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View f(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int h = l.h(activity, e.C0141e.ds20);
        textView.setPadding(h, 0 - activity.getResources().getDimensionPixelSize(e.C0141e.ds12), h, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(e.C0141e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.h(activity, e.C0141e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        al.i(textView, e.f.bg_tip_blue_left);
        al.h(textView, e.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aCt();
    }

    public void aCt() {
        if (this.cYY != null) {
            this.cYY.dismiss();
            this.cYY = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aCt();
    }
}
