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
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private boolean egc;
    private PopupWindow egd;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int egb = e.j.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable ege = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int h = l.h(pageActivity, e.C0210e.ds64);
                View g = a.this.g(pageActivity, a.this.egb);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int h2 = l.h(pageActivity, e.C0210e.ds32);
                int h3 = l.h(pageActivity, e.C0210e.ds16) + (iArr[1] - h);
                a.this.egd = new PopupWindow(g, -2, h);
                a.this.egd.showAtLocation(a.this.mAnchor, 53, h2, h3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.egd != null) {
                            a.this.aIf();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.egc = z;
    }

    public void aV(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.egc) {
                this.egb = e.j.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.egc = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.egc = false;
                this.mHandler.postDelayed(this.ege, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View g(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int h = l.h(activity, e.C0210e.ds20);
        textView.setPadding(h, 0 - activity.getResources().getDimensionPixelSize(e.C0210e.ds12), h, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(e.C0210e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.h(activity, e.C0210e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        al.i(textView, e.f.bg_tip_blue_left);
        al.h(textView, e.d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aIf();
    }

    public void aIf() {
        if (this.egd != null) {
            this.egd.dismiss();
            this.egd = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aIf();
    }
}
