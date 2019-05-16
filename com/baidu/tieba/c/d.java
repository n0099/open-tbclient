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
    private int bYc;
    private boolean eGS;
    private String eGT;
    private int eGZ;
    private int eHa;
    private int eHb;
    private View.OnClickListener eHe;
    private boolean eHf;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c eGR = null;
    private int eGU = R.drawable.pic_sign_tip;
    private int eGV = 0;
    private int eGW = 1;
    private int eGX = 1000;
    private int eGY = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int eHc = 48;
    private int eHd = 4;
    private boolean zw = false;
    private Runnable eHg = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eGR == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.eHf || d.this.aZy()) {
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
                            textView.setPadding(d.this.bYc, d.this.eGZ, d.this.eHa, d.this.eHb);
                            textView.setSingleLine(true);
                            al.k(textView, d.this.eGU);
                            if (d.this.eHe != null) {
                                textView.setOnClickListener(d.this.eHe);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hJ() {
                            return d.this.eHd;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hK() {
                            return d.this.eHc;
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
                    d.this.eGR = dVar.hL();
                    d.this.eGR.R(false);
                    d.this.eGR.S(d.this.zw);
                    d.this.eGR.n(d.this.mPageContext.getPageActivity());
                    d.this.eGS = true;
                    d.this.aZw();
                    d.this.mHandler.postDelayed(d.this.eHh, d.this.eGY);
                }
            }
        }
    };
    private Runnable eHh = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eGR != null) {
                d.this.eGR.dismiss();
            }
        }
    };

    public void pI(int i) {
        this.eHd = i;
    }

    public void pJ(int i) {
        this.eHc = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bYc = 0;
        this.eGZ = 0;
        this.eHa = 0;
        this.eHb = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bYc = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eGZ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eHa = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eHb = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt(this.eGT, this.eGV + 1);
    }

    public void cH(String str, String str2) {
        u(str, str2, false);
    }

    public void u(String str, String str2, boolean z) {
        if (!this.eGS && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.eGT = str2;
            this.eGV = com.baidu.tbadk.core.sharedPref.b.agM().getInt(str2, 0);
            if (this.eGV < this.eGW) {
                if (z) {
                    aZw();
                    this.eGS = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.eHg, this.eGX);
            }
        }
    }

    public void ve(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.eHg, this.eGX);
        }
    }

    public void aZx() {
        if (this.eGR != null) {
            this.eGR.dismiss();
            this.eGR = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eHg);
            this.mHandler.removeCallbacks(this.eHh);
        }
    }

    public void pK(int i) {
        if (i > 0) {
            this.eGU = i;
        }
    }

    public void pL(int i) {
        if (i > 0) {
            this.eGY = i;
        }
    }

    public void pM(int i) {
        if (i > 0) {
            this.eGW = i;
        }
    }

    public void pN(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bYc = i;
        this.eGZ = i2;
        this.eHa = i3;
        this.eHb = i4;
    }

    public void q(View.OnClickListener onClickListener) {
        this.eHe = onClickListener;
    }

    public void iI(boolean z) {
        this.eHf = z;
    }

    public boolean aZy() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void S(boolean z) {
        this.zw = z;
    }
}
