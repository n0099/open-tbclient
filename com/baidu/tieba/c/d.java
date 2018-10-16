package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {
    private boolean cWi;
    private String cWj;
    private int cWp;
    private int cWq;
    private int cWr;
    private int cWs;
    private View.OnClickListener cWv;
    private boolean cWw;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cWh = null;
    private int cWk = e.f.pic_sign_tip;
    private int cWl = 0;
    private int cWm = 1;
    private int cWn = 1000;
    private int cWo = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cWt = 48;
    private int cWu = 4;
    private boolean BL = false;
    private Runnable cWx = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cWh == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.cWw || d.this.apZ()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).af(0).O(true).P(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.h(textView, e.d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds76));
                            textView.setPadding(d.this.cWp, d.this.cWq, d.this.cWr, d.this.cWs);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.cWk);
                            if (d.this.cWv != null) {
                                textView.setOnClickListener(d.this.cWv);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.cWu;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iT() {
                            return d.this.cWt;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return d.this.mXOffset;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return d.this.mYOffset;
                        }
                    });
                    d.this.cWh = dVar.iU();
                    d.this.cWh.L(false);
                    d.this.cWh.M(d.this.BL);
                    d.this.cWh.n(d.this.mPageContext.getPageActivity());
                    d.this.cWi = true;
                    d.this.apX();
                    d.this.mHandler.postDelayed(d.this.cWy, d.this.cWo);
                }
            }
        }
    };
    private Runnable cWy = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cWh != null) {
                d.this.cWh.dismiss();
            }
        }
    };

    public void kj(int i) {
        this.cWu = i;
    }

    public void kk(int i) {
        this.cWt = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cWp = 0;
        this.cWq = 0;
        this.cWr = 0;
        this.cWs = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cWp = this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds24);
        this.cWq = this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds24);
        this.cWr = this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds24);
        this.cWs = this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apX() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cWj, this.cWl + 1);
    }

    public void bj(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.cWi && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cWj = str2;
            this.cWl = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cWl < this.cWm) {
                if (z) {
                    apX();
                    this.cWi = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cWx, this.cWn);
            }
        }
    }

    public void mr(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cWx, this.cWn);
        }
    }

    public void apY() {
        if (this.cWh != null) {
            this.cWh.dismiss();
            this.cWh = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cWx);
            this.mHandler.removeCallbacks(this.cWy);
        }
    }

    public void kl(int i) {
        if (i > 0) {
            this.cWk = i;
        }
    }

    public void km(int i) {
        if (i > 0) {
            this.cWo = i;
        }
    }

    public void kn(int i) {
        if (i > 0) {
            this.cWm = i;
        }
    }

    public void ko(int i) {
        this.mXOffset = i;
    }

    public void kp(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cWp = i;
        this.cWq = i2;
        this.cWr = i3;
        this.cWs = i4;
    }

    public void l(View.OnClickListener onClickListener) {
        this.cWv = onClickListener;
    }

    public void fu(boolean z) {
        this.cWw = z;
    }

    public boolean apZ() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void M(boolean z) {
        this.BL = z;
    }
}
