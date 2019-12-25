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
    private boolean asQ;
    private String asR;
    private int asX;
    private int asY;
    private int asZ;
    private int ata;
    private View.OnClickListener atd;
    private boolean ate;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c fJZ = null;
    private int asS = R.drawable.pic_sign_tip;
    private int asT = 0;
    private int asU = 1;
    private int asV = 1000;
    private int asW = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int atb = 48;
    private int atc = 4;
    private boolean mUseDirectOffset = false;
    private Runnable atf = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fJZ == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.ate || d.this.wQ()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).J(0).F(true).G(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.asX, d.this.asY, d.this.asZ, d.this.ata);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.asS);
                            if (d.this.atd != null) {
                                textView.setOnClickListener(d.this.atd);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.atc;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.atb;
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
                    d.this.fJZ = dVar.fI();
                    d.this.fJZ.setShouldCheckLocInWindow(false);
                    d.this.fJZ.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.fJZ.show(d.this.mPageContext.getPageActivity());
                    d.this.asQ = true;
                    d.this.wO();
                    d.this.mHandler.postDelayed(d.this.atg, d.this.asW);
                }
            }
        }
    };
    private Runnable atg = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fJZ != null) {
                d.this.fJZ.dismiss();
            }
        }
    };

    public void rl(int i) {
        this.atc = i;
    }

    public void bS(int i) {
        this.atb = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.asX = 0;
        this.asY = 0;
        this.asZ = 0;
        this.ata = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.asX = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.asY = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.asZ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ata = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wO() {
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt(this.asR, this.asT + 1);
    }

    public void Z(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.asQ && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.asR = str2;
            this.asT = com.baidu.tbadk.core.sharedPref.b.aCY().getInt(str2, 0);
            if (this.asT < this.asU) {
                if (z) {
                    wO();
                    this.asQ = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.atf, this.asV);
            }
        }
    }

    public void zC(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.atf, this.asV);
        }
    }

    public void wP() {
        if (this.fJZ != null) {
            this.fJZ.dismiss();
            this.fJZ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.atf);
            this.mHandler.removeCallbacks(this.atg);
        }
    }

    public void bT(int i) {
        if (i > 0) {
            this.asS = i;
        }
    }

    public void bU(int i) {
        if (i > 0) {
            this.asW = i;
        }
    }

    public void rm(int i) {
        if (i > 0) {
            this.asU = i;
        }
    }

    public void rn(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.asX = i;
        this.asY = i2;
        this.asZ = i3;
        this.ata = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.atd = onClickListener;
    }

    public void kj(boolean z) {
        this.ate = z;
    }

    public boolean wQ() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
