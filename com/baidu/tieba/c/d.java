package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private boolean axS;
    private String axT;
    private int axZ;
    private int aya;
    private int ayb;
    private int ayc;
    private View.OnClickListener ayf;
    private boolean ayg;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c fPD = null;
    private int axU = R.drawable.pic_sign_tip;
    private int axV = 0;
    private int axW = 1;
    private int axX = 1000;
    private int axY = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int ayd = 48;
    private int aye = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayh = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fPD == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.ayg || d.this.zy()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).M(0).F(true).G(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.axZ, d.this.aya, d.this.ayb, d.this.ayc);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.axU);
                            if (d.this.ayf != null) {
                                textView.setOnClickListener(d.this.ayf);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.aye;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.ayd;
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
                    d.this.fPD = dVar.fI();
                    d.this.fPD.setShouldCheckLocInWindow(false);
                    d.this.fPD.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.fPD.show(d.this.mPageContext.getPageActivity());
                    d.this.axS = true;
                    d.this.zw();
                    d.this.mHandler.postDelayed(d.this.ayi, d.this.axY);
                }
            }
        }
    };
    private Runnable ayi = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fPD != null) {
                d.this.fPD.dismiss();
            }
        }
    };

    public void rx(int i) {
        this.aye = i;
    }

    public void cj(int i) {
        this.ayd = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.axZ = 0;
        this.aya = 0;
        this.ayb = 0;
        this.ayc = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.axZ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aya = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayb = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayc = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt(this.axT, this.axV + 1);
    }

    public void aj(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.axS && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.axT = str2;
            this.axV = com.baidu.tbadk.core.sharedPref.b.aFB().getInt(str2, 0);
            if (this.axV < this.axW) {
                if (z) {
                    zw();
                    this.axS = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayh, this.axX);
            }
        }
    }

    public void Ac(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.ayh, this.axX);
        }
    }

    public void zx() {
        if (this.fPD != null) {
            this.fPD.dismiss();
            this.fPD = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayh);
            this.mHandler.removeCallbacks(this.ayi);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.axU = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.axY = i;
        }
    }

    public void ry(int i) {
        if (i > 0) {
            this.axW = i;
        }
    }

    public void rz(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.axZ = i;
        this.aya = i2;
        this.ayb = i3;
        this.ayc = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayf = onClickListener;
    }

    public void kw(boolean z) {
        this.ayg = z;
    }

    public boolean zy() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
