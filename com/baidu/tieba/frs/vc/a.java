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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private PopupWindow cSA;
    private boolean dzY;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int dzX = d.k.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable dzZ = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int e = l.e(pageActivity, d.e.ds64);
                View f = a.this.f(pageActivity, a.this.dzX);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int e2 = l.e(pageActivity, d.e.ds32);
                int e3 = l.e(pageActivity, d.e.ds16) + (iArr[1] - e);
                a.this.cSA = new PopupWindow(f, -2, e);
                a.this.cSA.showAtLocation(a.this.mAnchor, 53, e2, e3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cSA != null) {
                            a.this.aza();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.dzY = z;
    }

    public void ax(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view;
            if (this.dzY) {
                this.dzX = d.k.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.dzY = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.dzY = false;
                this.mHandler.postDelayed(this.dzZ, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View f(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int e = l.e(activity, d.e.ds20);
        textView.setPadding(e, 0 - activity.getResources().getDimensionPixelSize(d.e.ds12), e, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(d.e.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, l.e(activity, d.e.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        al.i(textView, d.f.bg_tip_blue_left);
        al.h(textView, d.C0141d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aza();
    }

    public void aza() {
        if (this.cSA != null) {
            this.cSA.dismiss();
            this.cSA = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        aza();
    }
}
