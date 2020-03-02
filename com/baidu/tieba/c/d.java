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
    private boolean axT;
    private String axU;
    private int aya;
    private int ayb;
    private int ayc;
    private int ayd;
    private View.OnClickListener ayg;
    private boolean ayh;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c fPF = null;
    private int axV = R.drawable.pic_sign_tip;
    private int axW = 0;
    private int axX = 1;
    private int axY = 1000;
    private int axZ = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aye = 48;
    private int ayf = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayi = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fPF == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.ayh || d.this.zA()) {
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
                            textView.setPadding(d.this.aya, d.this.ayb, d.this.ayc, d.this.ayd);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.axV);
                            if (d.this.ayg != null) {
                                textView.setOnClickListener(d.this.ayg);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.ayf;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.aye;
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
                    d.this.fPF = dVar.fI();
                    d.this.fPF.setShouldCheckLocInWindow(false);
                    d.this.fPF.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.fPF.show(d.this.mPageContext.getPageActivity());
                    d.this.axT = true;
                    d.this.zy();
                    d.this.mHandler.postDelayed(d.this.ayj, d.this.axZ);
                }
            }
        }
    };
    private Runnable ayj = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fPF != null) {
                d.this.fPF.dismiss();
            }
        }
    };

    public void rx(int i) {
        this.ayf = i;
    }

    public void cj(int i) {
        this.aye = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.aya = 0;
        this.ayb = 0;
        this.ayc = 0;
        this.ayd = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aya = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayb = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayc = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayd = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(this.axU, this.axW + 1);
    }

    public void aj(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.axT && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.axU = str2;
            this.axW = com.baidu.tbadk.core.sharedPref.b.aFD().getInt(str2, 0);
            if (this.axW < this.axX) {
                if (z) {
                    zy();
                    this.axT = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayi, this.axY);
            }
        }
    }

    public void Ac(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.ayi, this.axY);
        }
    }

    public void zz() {
        if (this.fPF != null) {
            this.fPF.dismiss();
            this.fPF = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayi);
            this.mHandler.removeCallbacks(this.ayj);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.axV = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.axZ = i;
        }
    }

    public void ry(int i) {
        if (i > 0) {
            this.axX = i;
        }
    }

    public void rz(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.aya = i;
        this.ayb = i2;
        this.ayc = i3;
        this.ayd = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayg = onClickListener;
    }

    public void kw(boolean z) {
        this.ayh = z;
    }

    public boolean zA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
