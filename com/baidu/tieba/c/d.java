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
    private boolean atC;
    private String atD;
    private int atJ;
    private int atK;
    private int atL;
    private int atM;
    private View.OnClickListener atP;
    private boolean atQ;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c fNi = null;
    private int atE = R.drawable.pic_sign_tip;
    private int atF = 0;
    private int atG = 1;
    private int atH = 1000;
    private int atI = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int atN = 48;
    private int atO = 4;
    private boolean mUseDirectOffset = false;
    private Runnable atR = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fNi == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.atQ || d.this.xh()) {
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
                            textView.setPadding(d.this.atJ, d.this.atK, d.this.atL, d.this.atM);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.atE);
                            if (d.this.atP != null) {
                                textView.setOnClickListener(d.this.atP);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.atO;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.atN;
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
                    d.this.fNi = dVar.fI();
                    d.this.fNi.setShouldCheckLocInWindow(false);
                    d.this.fNi.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.fNi.show(d.this.mPageContext.getPageActivity());
                    d.this.atC = true;
                    d.this.xf();
                    d.this.mHandler.postDelayed(d.this.atS, d.this.atI);
                }
            }
        }
    };
    private Runnable atS = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fNi != null) {
                d.this.fNi.dismiss();
            }
        }
    };

    public void rq(int i) {
        this.atO = i;
    }

    public void bT(int i) {
        this.atN = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.atJ = 0;
        this.atK = 0;
        this.atL = 0;
        this.atM = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.atJ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.atK = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.atL = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.atM = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xf() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(this.atD, this.atF + 1);
    }

    public void Y(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.atC && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.atD = str2;
            this.atF = com.baidu.tbadk.core.sharedPref.b.aDr().getInt(str2, 0);
            if (this.atF < this.atG) {
                if (z) {
                    xf();
                    this.atC = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.atR, this.atH);
            }
        }
    }

    public void zM(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.atR, this.atH);
        }
    }

    public void xg() {
        if (this.fNi != null) {
            this.fNi.dismiss();
            this.fNi = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.atR);
            this.mHandler.removeCallbacks(this.atS);
        }
    }

    public void bU(int i) {
        if (i > 0) {
            this.atE = i;
        }
    }

    public void bV(int i) {
        if (i > 0) {
            this.atI = i;
        }
    }

    public void rr(int i) {
        if (i > 0) {
            this.atG = i;
        }
    }

    public void rs(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.atJ = i;
        this.atK = i2;
        this.atL = i3;
        this.atM = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.atP = onClickListener;
    }

    public void ku(boolean z) {
        this.atQ = z;
    }

    public boolean xh() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
