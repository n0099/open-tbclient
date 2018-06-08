package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private boolean cHC;
    private String cHD;
    private int cHJ;
    private int cHK;
    private int cHL;
    private int cHM;
    private View.OnClickListener cHP;
    private boolean cHQ;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cHB = null;
    private int cHE = d.f.pic_sign_tip;
    private int cHF = 0;
    private int cHG = 1;
    private int cHH = 1000;
    private int cHI = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cHN = 48;
    private int cHO = 4;
    private boolean yO = false;
    private Runnable cHR = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cHB == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.cHQ || d.this.akU()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(d.this.mTargetView).X(0).F(true).G(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.h(textView, d.C0141d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(d.this.cHJ, d.this.cHK, d.this.cHL, d.this.cHM);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.cHE);
                            if (d.this.cHP != null) {
                                textView.setOnClickListener(d.this.cHP);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hw() {
                            return d.this.cHO;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hx() {
                            return d.this.cHN;
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
                    d.this.cHB = dVar.hy();
                    d.this.cHB.C(false);
                    d.this.cHB.D(d.this.yO);
                    d.this.cHB.k(d.this.mPageContext.getPageActivity());
                    d.this.cHC = true;
                    d.this.akS();
                    d.this.mHandler.postDelayed(d.this.cHS, d.this.cHI);
                }
            }
        }
    };
    private Runnable cHS = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cHB != null) {
                d.this.cHB.dismiss();
            }
        }
    };

    public void jd(int i) {
        this.cHO = i;
    }

    public void je(int i) {
        this.cHN = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cHJ = 0;
        this.cHK = 0;
        this.cHL = 0;
        this.cHM = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cHJ = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cHK = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cHL = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cHM = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akS() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cHD, this.cHF + 1);
    }

    public void aQ(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.cHC && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cHD = str2;
            this.cHF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cHF < this.cHG) {
                if (z) {
                    akS();
                    this.cHC = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cHR, this.cHH);
            }
        }
    }

    public void lp(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cHR, this.cHH);
        }
    }

    public void akT() {
        if (this.cHB != null) {
            this.cHB.dismiss();
            this.cHB = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cHR);
            this.mHandler.removeCallbacks(this.cHS);
        }
    }

    public void jf(int i) {
        if (i > 0) {
            this.cHE = i;
        }
    }

    public void jg(int i) {
        if (i > 0) {
            this.cHI = i;
        }
    }

    public void jh(int i) {
        if (i > 0) {
            this.cHG = i;
        }
    }

    public void ji(int i) {
        this.mXOffset = i;
    }

    public void jj(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cHJ = i;
        this.cHK = i2;
        this.cHL = i3;
        this.cHM = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.cHP = onClickListener;
    }

    public void eK(boolean z) {
        this.cHQ = z;
    }

    public boolean akU() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void D(boolean z) {
        this.yO = z;
    }
}
