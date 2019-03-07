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
    private int bQk;
    private boolean erD;
    private String erE;
    private int erK;
    private int erL;
    private int erM;
    private View.OnClickListener erP;
    private boolean erQ;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c erC = null;
    private int erF = d.f.pic_sign_tip;
    private int erG = 0;
    private int erH = 1;
    private int erI = 1000;
    private int erJ = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int erN = 48;
    private int erO = 4;
    private boolean BO = false;
    private Runnable erR = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.erC == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.erQ || d.this.aSs()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).af(0).ac(true).ad(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.j(textView, d.C0236d.cp_btn_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(d.this.bQk, d.this.erK, d.this.erL, d.this.erM);
                            textView.setSingleLine(true);
                            al.k(textView, d.this.erF);
                            if (d.this.erP != null) {
                                textView.setOnClickListener(d.this.erP);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.erO;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.erN;
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
                    d.this.erC = dVar.iT();
                    d.this.erC.Z(false);
                    d.this.erC.aa(d.this.BO);
                    d.this.erC.n(d.this.mPageContext.getPageActivity());
                    d.this.erD = true;
                    d.this.aSq();
                    d.this.mHandler.postDelayed(d.this.erS, d.this.erJ);
                }
            }
        }
    };
    private Runnable erS = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.erC != null) {
                d.this.erC.dismiss();
            }
        }
    };

    public void oI(int i) {
        this.erO = i;
    }

    public void oJ(int i) {
        this.erN = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bQk = 0;
        this.erK = 0;
        this.erL = 0;
        this.erM = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bQk = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.erK = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.erL = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.erM = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSq() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.erE, this.erG + 1);
    }

    public void cu(String str, String str2) {
        s(str, str2, false);
    }

    public void s(String str, String str2, boolean z) {
        if (!this.erD && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.erE = str2;
            this.erG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.erG < this.erH) {
                if (z) {
                    aSq();
                    this.erD = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.erR, this.erI);
            }
        }
    }

    public void aSr() {
        if (this.erC != null) {
            this.erC.dismiss();
            this.erC = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.erR);
            this.mHandler.removeCallbacks(this.erS);
        }
    }

    public void oK(int i) {
        if (i > 0) {
            this.erF = i;
        }
    }

    public void oL(int i) {
        if (i > 0) {
            this.erJ = i;
        }
    }

    public void oM(int i) {
        if (i > 0) {
            this.erH = i;
        }
    }

    public void oN(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bQk = i;
        this.erK = i2;
        this.erL = i3;
        this.erM = i4;
    }

    public void o(View.OnClickListener onClickListener) {
        this.erP = onClickListener;
    }

    public void id(boolean z) {
        this.erQ = z;
    }

    public boolean aSs() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
