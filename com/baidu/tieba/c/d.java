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
    private int cae;
    private boolean eND;
    private String eNE;
    private int eNK;
    private int eNL;
    private int eNM;
    private View.OnClickListener eNP;
    private boolean eNQ;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c eNC = null;
    private int eNF = R.drawable.pic_sign_tip;
    private int eNG = 0;
    private int eNH = 1;
    private int eNI = 1000;
    private int eNJ = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int eNN = 48;
    private int eNO = 4;
    private boolean zB = false;
    private Runnable eNR = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eNC == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.eNQ || d.this.bcg()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).X(0).U(true).V(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.j(textView, R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.cae, d.this.eNK, d.this.eNL, d.this.eNM);
                            textView.setSingleLine(true);
                            am.k(textView, d.this.eNF);
                            if (d.this.eNP != null) {
                                textView.setOnClickListener(d.this.eNP);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hT() {
                            return d.this.eNO;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hU() {
                            return d.this.eNN;
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
                    d.this.eNC = dVar.hV();
                    d.this.eNC.R(false);
                    d.this.eNC.S(d.this.zB);
                    d.this.eNC.q(d.this.mPageContext.getPageActivity());
                    d.this.eND = true;
                    d.this.bce();
                    d.this.mHandler.postDelayed(d.this.eNS, d.this.eNJ);
                }
            }
        }
    };
    private Runnable eNS = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eNC != null) {
                d.this.eNC.dismiss();
            }
        }
    };

    public void qd(int i) {
        this.eNO = i;
    }

    public void qe(int i) {
        this.eNN = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cae = 0;
        this.eNK = 0;
        this.eNL = 0;
        this.eNM = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cae = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eNK = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eNL = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eNM = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bce() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt(this.eNE, this.eNG + 1);
    }

    public void cJ(String str, String str2) {
        v(str, str2, false);
    }

    public void v(String str, String str2, boolean z) {
        if (!this.eND && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.eNE = str2;
            this.eNG = com.baidu.tbadk.core.sharedPref.b.ahU().getInt(str2, 0);
            if (this.eNG < this.eNH) {
                if (z) {
                    bce();
                    this.eND = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.eNR, this.eNI);
            }
        }
    }

    public void wi(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.eNR, this.eNI);
        }
    }

    public void bcf() {
        if (this.eNC != null) {
            this.eNC.dismiss();
            this.eNC = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eNR);
            this.mHandler.removeCallbacks(this.eNS);
        }
    }

    public void qf(int i) {
        if (i > 0) {
            this.eNF = i;
        }
    }

    public void qg(int i) {
        if (i > 0) {
            this.eNJ = i;
        }
    }

    public void qh(int i) {
        if (i > 0) {
            this.eNH = i;
        }
    }

    public void qi(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void w(int i, int i2, int i3, int i4) {
        this.cae = i;
        this.eNK = i2;
        this.eNL = i3;
        this.eNM = i4;
    }

    public void q(View.OnClickListener onClickListener) {
        this.eNP = onClickListener;
    }

    public void iU(boolean z) {
        this.eNQ = z;
    }

    public boolean bcg() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void S(boolean z) {
        this.zB = z;
    }
}
