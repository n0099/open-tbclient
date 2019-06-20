package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private int bYd;
    private boolean eGT;
    private String eGU;
    private int eHa;
    private int eHb;
    private int eHc;
    private View.OnClickListener eHf;
    private boolean eHg;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c eGS = null;
    private int eGV = R.drawable.pic_sign_tip;
    private int eGW = 0;
    private int eGX = 1;
    private int eGY = 1000;
    private int eGZ = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int eHd = 48;
    private int eHe = 4;
    private boolean zv = false;
    private Runnable eHh = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eGS == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.eHg || d.this.aZB()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).X(0).U(true).V(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.j(textView, R.color.cp_btn_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.bYd, d.this.eHa, d.this.eHb, d.this.eHc);
                            textView.setSingleLine(true);
                            al.k(textView, d.this.eGV);
                            if (d.this.eHf != null) {
                                textView.setOnClickListener(d.this.eHf);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hJ() {
                            return d.this.eHe;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hK() {
                            return d.this.eHd;
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
                    d.this.eGS = dVar.hL();
                    d.this.eGS.R(false);
                    d.this.eGS.S(d.this.zv);
                    d.this.eGS.n(d.this.mPageContext.getPageActivity());
                    d.this.eGT = true;
                    d.this.aZz();
                    d.this.mHandler.postDelayed(d.this.eHi, d.this.eGZ);
                }
            }
        }
    };
    private Runnable eHi = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eGS != null) {
                d.this.eGS.dismiss();
            }
        }
    };

    public void pI(int i) {
        this.eHe = i;
    }

    public void pJ(int i) {
        this.eHd = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bYd = 0;
        this.eHa = 0;
        this.eHb = 0;
        this.eHc = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bYd = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eHa = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eHb = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eHc = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZz() {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt(this.eGU, this.eGW + 1);
    }

    public void cH(String str, String str2) {
        u(str, str2, false);
    }

    public void u(String str, String str2, boolean z) {
        if (!this.eGT && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.eGU = str2;
            this.eGW = com.baidu.tbadk.core.sharedPref.b.agM().getInt(str2, 0);
            if (this.eGW < this.eGX) {
                if (z) {
                    aZz();
                    this.eGT = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.eHh, this.eGY);
            }
        }
    }

    public void vd(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.eHh, this.eGY);
        }
    }

    public void aZA() {
        if (this.eGS != null) {
            this.eGS.dismiss();
            this.eGS = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eHh);
            this.mHandler.removeCallbacks(this.eHi);
        }
    }

    public void pK(int i) {
        if (i > 0) {
            this.eGV = i;
        }
    }

    public void pL(int i) {
        if (i > 0) {
            this.eGZ = i;
        }
    }

    public void pM(int i) {
        if (i > 0) {
            this.eGX = i;
        }
    }

    public void pN(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bYd = i;
        this.eHa = i2;
        this.eHb = i3;
        this.eHc = i4;
    }

    public void q(View.OnClickListener onClickListener) {
        this.eHf = onClickListener;
    }

    public void iI(boolean z) {
        this.eHg = z;
    }

    public boolean aZB() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void S(boolean z) {
        this.zv = z;
    }
}
