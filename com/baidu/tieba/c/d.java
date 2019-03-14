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
    private int bQl;
    private String erA;
    private int erG;
    private int erH;
    private int erI;
    private View.OnClickListener erL;
    private boolean erM;
    private boolean erz;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c ery = null;
    private int erB = d.f.pic_sign_tip;
    private int erC = 0;
    private int erD = 1;
    private int erE = 1000;
    private int erF = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int erJ = 48;
    private int erK = 4;
    private boolean BO = false;
    private Runnable erN = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ery == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.erM || d.this.aSs()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).af(0).ac(true).ad(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.j(textView, d.C0277d.cp_btn_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(d.this.bQl, d.this.erG, d.this.erH, d.this.erI);
                            textView.setSingleLine(true);
                            al.k(textView, d.this.erB);
                            if (d.this.erL != null) {
                                textView.setOnClickListener(d.this.erL);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.erK;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.erJ;
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
                    d.this.ery = dVar.iT();
                    d.this.ery.Z(false);
                    d.this.ery.aa(d.this.BO);
                    d.this.ery.n(d.this.mPageContext.getPageActivity());
                    d.this.erz = true;
                    d.this.aSq();
                    d.this.mHandler.postDelayed(d.this.erO, d.this.erF);
                }
            }
        }
    };
    private Runnable erO = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ery != null) {
                d.this.ery.dismiss();
            }
        }
    };

    public void oI(int i) {
        this.erK = i;
    }

    public void oJ(int i) {
        this.erJ = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bQl = 0;
        this.erG = 0;
        this.erH = 0;
        this.erI = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bQl = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.erG = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.erH = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.erI = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSq() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.erA, this.erC + 1);
    }

    public void cu(String str, String str2) {
        s(str, str2, false);
    }

    public void s(String str, String str2, boolean z) {
        if (!this.erz && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.erA = str2;
            this.erC = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.erC < this.erD) {
                if (z) {
                    aSq();
                    this.erz = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.erN, this.erE);
            }
        }
    }

    public void aSr() {
        if (this.ery != null) {
            this.ery.dismiss();
            this.ery = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.erN);
            this.mHandler.removeCallbacks(this.erO);
        }
    }

    public void oK(int i) {
        if (i > 0) {
            this.erB = i;
        }
    }

    public void oL(int i) {
        if (i > 0) {
            this.erF = i;
        }
    }

    public void oM(int i) {
        if (i > 0) {
            this.erD = i;
        }
    }

    public void oN(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bQl = i;
        this.erG = i2;
        this.erH = i3;
        this.erI = i4;
    }

    public void o(View.OnClickListener onClickListener) {
        this.erL = onClickListener;
    }

    public void id(boolean z) {
        this.erM = z;
    }

    public boolean aSs() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
