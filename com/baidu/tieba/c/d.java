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
    private View.OnClickListener cXB;
    private boolean cXC;
    private boolean cXo;
    private String cXp;
    private int cXv;
    private int cXw;
    private int cXx;
    private int cXy;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cXn = null;
    private int cXq = e.f.pic_sign_tip;
    private int cXr = 0;
    private int cXs = 1;
    private int cXt = 1000;
    private int cXu = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cXz = 48;
    private int cXA = 4;
    private boolean BO = false;
    private Runnable cXD = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cXn == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.cXC || d.this.apB()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).aw(0).ac(true).ad(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.h(textView, e.d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds76));
                            textView.setPadding(d.this.cXv, d.this.cXw, d.this.cXx, d.this.cXy);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.cXq);
                            if (d.this.cXB != null) {
                                textView.setOnClickListener(d.this.cXB);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.cXA;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.cXz;
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
                    d.this.cXn = dVar.iT();
                    d.this.cXn.Z(false);
                    d.this.cXn.aa(d.this.BO);
                    d.this.cXn.n(d.this.mPageContext.getPageActivity());
                    d.this.cXo = true;
                    d.this.apz();
                    d.this.mHandler.postDelayed(d.this.cXE, d.this.cXu);
                }
            }
        }
    };
    private Runnable cXE = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cXn != null) {
                d.this.cXn.dismiss();
            }
        }
    };

    public void kC(int i) {
        this.cXA = i;
    }

    public void kD(int i) {
        this.cXz = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cXv = 0;
        this.cXw = 0;
        this.cXx = 0;
        this.cXy = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cXv = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds24);
        this.cXw = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds24);
        this.cXx = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds24);
        this.cXy = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apz() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cXp, this.cXr + 1);
    }

    public void bj(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.cXo && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cXp = str2;
            this.cXr = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cXr < this.cXs) {
                if (z) {
                    apz();
                    this.cXo = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cXD, this.cXt);
            }
        }
    }

    public void ms(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cXD, this.cXt);
        }
    }

    public void apA() {
        if (this.cXn != null) {
            this.cXn.dismiss();
            this.cXn = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cXD);
            this.mHandler.removeCallbacks(this.cXE);
        }
    }

    public void kE(int i) {
        if (i > 0) {
            this.cXq = i;
        }
    }

    public void kF(int i) {
        if (i > 0) {
            this.cXu = i;
        }
    }

    public void kG(int i) {
        if (i > 0) {
            this.cXs = i;
        }
    }

    public void kH(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cXv = i;
        this.cXw = i2;
        this.cXx = i3;
        this.cXy = i4;
    }

    public void n(View.OnClickListener onClickListener) {
        this.cXB = onClickListener;
    }

    public void fF(boolean z) {
        this.cXC = z;
    }

    public boolean apB() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
