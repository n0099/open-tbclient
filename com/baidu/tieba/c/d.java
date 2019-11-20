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
    private boolean akM;
    private String akN;
    private int akT;
    private int akU;
    private int akV;
    private int akW;
    private View.OnClickListener akZ;
    private boolean ala;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c eVs = null;
    private int akO = R.drawable.pic_sign_tip;
    private int akP = 0;
    private int akQ = 1;
    private int akR = 1000;
    private int akS = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int akX = 48;
    private int akY = 4;
    private boolean mUseDirectOffset = false;
    private Runnable alb = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eVs == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.ala || d.this.uR()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).I(0).B(true).C(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.akT, d.this.akU, d.this.akV, d.this.akW);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.akO);
                            if (d.this.akZ != null) {
                                textView.setOnClickListener(d.this.akZ);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.akY;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.akX;
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
                    d.this.eVs = dVar.fu();
                    d.this.eVs.setShouldCheckLocInWindow(false);
                    d.this.eVs.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.eVs.show(d.this.mPageContext.getPageActivity());
                    d.this.akM = true;
                    d.this.uP();
                    d.this.mHandler.postDelayed(d.this.alc, d.this.akS);
                }
            }
        }
    };
    private Runnable alc = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eVs != null) {
                d.this.eVs.dismiss();
            }
        }
    };

    public void pe(int i) {
        this.akY = i;
    }

    public void bA(int i) {
        this.akX = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.akT = 0;
        this.akU = 0;
        this.akV = 0;
        this.akW = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.akT = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.akU = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.akV = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.akW = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP() {
        com.baidu.tbadk.core.sharedPref.b.alP().putInt(this.akN, this.akP + 1);
    }

    public void R(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.akM && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.akN = str2;
            this.akP = com.baidu.tbadk.core.sharedPref.b.alP().getInt(str2, 0);
            if (this.akP < this.akQ) {
                if (z) {
                    uP();
                    this.akM = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.alb, this.akR);
            }
        }
    }

    public void uK(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.alb, this.akR);
        }
    }

    public void uQ() {
        if (this.eVs != null) {
            this.eVs.dismiss();
            this.eVs = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.alb);
            this.mHandler.removeCallbacks(this.alc);
        }
    }

    public void bB(int i) {
        if (i > 0) {
            this.akO = i;
        }
    }

    public void bC(int i) {
        if (i > 0) {
            this.akS = i;
        }
    }

    public void pf(int i) {
        if (i > 0) {
            this.akQ = i;
        }
    }

    public void pg(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void t(int i, int i2, int i3, int i4) {
        this.akT = i;
        this.akU = i2;
        this.akV = i3;
        this.akW = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.akZ = onClickListener;
    }

    public void iX(boolean z) {
        this.ala = z;
    }

    public boolean uR() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
