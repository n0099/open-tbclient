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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private PopupWindow cIo;
    private boolean dpG;
    private View mAnchor;
    private TbPageContext mPageContext;
    private int dpF = d.k.attention_post_update_tip;
    private Handler mHandler = new Handler();
    private Runnable dpH = new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mPageContext != null && a.this.mAnchor != null) {
                Activity pageActivity = a.this.mPageContext.getPageActivity();
                int e = l.e(pageActivity, d.e.ds64);
                View f = a.this.f(pageActivity, a.this.dpF);
                int[] iArr = new int[2];
                a.this.mAnchor.getLocationInWindow(iArr);
                int e2 = l.e(pageActivity, d.e.ds32);
                int e3 = l.e(pageActivity, d.e.ds16) + (iArr[1] - e);
                a.this.cIo = new PopupWindow(f, -2, e);
                a.this.cIo.showAtLocation(a.this.mAnchor, 53, e2, e3);
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cIo != null) {
                            a.this.auR();
                        }
                    }
                }, 3000L);
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.dpG = z;
    }

    public void ax(View view2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.mPageContext != null && view2 != null && !StringUtils.isNull(currentAccount)) {
            this.mAnchor = view2;
            if (this.dpG) {
                this.dpF = d.k.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
                if (i >= 3) {
                    this.dpG = false;
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str, i + 1);
                this.dpG = false;
                this.mHandler.postDelayed(this.dpH, 500L);
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
        ak.i(textView, d.f.bg_tip_blue_left);
        ak.h(textView, d.C0126d.cp_cont_i);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        auR();
    }

    public void auR() {
        if (this.cIo != null) {
            this.cIo.dismiss();
            this.cIo = null;
        }
    }

    public void destory() {
        this.mHandler.removeCallbacksAndMessages(null);
        auR();
    }
}
