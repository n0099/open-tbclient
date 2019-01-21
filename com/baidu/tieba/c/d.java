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
    private boolean dhD;
    private String dhE;
    private int dhK;
    private int dhL;
    private int dhM;
    private int dhN;
    private View.OnClickListener dhQ;
    private boolean dhR;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c dhC = null;
    private int dhF = e.f.pic_sign_tip;
    private int dhG = 0;
    private int dhH = 1;
    private int dhI = 1000;
    private int dhJ = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int dhO = 48;
    private int dhP = 4;
    private boolean BO = false;
    private Runnable dhS = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.dhC == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.dhR || d.this.asA()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).aw(0).ac(true).ad(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.h(textView, e.d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds76));
                            textView.setPadding(d.this.dhK, d.this.dhL, d.this.dhM, d.this.dhN);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.dhF);
                            if (d.this.dhQ != null) {
                                textView.setOnClickListener(d.this.dhQ);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.dhP;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.dhO;
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
                    d.this.dhC = dVar.iT();
                    d.this.dhC.Z(false);
                    d.this.dhC.aa(d.this.BO);
                    d.this.dhC.n(d.this.mPageContext.getPageActivity());
                    d.this.dhD = true;
                    d.this.asy();
                    d.this.mHandler.postDelayed(d.this.dhT, d.this.dhJ);
                }
            }
        }
    };
    private Runnable dhT = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.dhC != null) {
                d.this.dhC.dismiss();
            }
        }
    };

    public void lg(int i) {
        this.dhP = i;
    }

    public void lh(int i) {
        this.dhO = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.dhK = 0;
        this.dhL = 0;
        this.dhM = 0;
        this.dhN = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.dhK = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dhL = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dhM = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dhN = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asy() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dhE, this.dhG + 1);
    }

    public void bp(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.dhD && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.dhE = str2;
            this.dhG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dhG < this.dhH) {
                if (z) {
                    asy();
                    this.dhD = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.dhS, this.dhI);
            }
        }
    }

    public void nk(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.dhS, this.dhI);
        }
    }

    public void asz() {
        if (this.dhC != null) {
            this.dhC.dismiss();
            this.dhC = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dhS);
            this.mHandler.removeCallbacks(this.dhT);
        }
    }

    public void li(int i) {
        if (i > 0) {
            this.dhF = i;
        }
    }

    public void lj(int i) {
        if (i > 0) {
            this.dhJ = i;
        }
    }

    public void lk(int i) {
        if (i > 0) {
            this.dhH = i;
        }
    }

    public void ll(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.dhK = i;
        this.dhL = i2;
        this.dhM = i3;
        this.dhN = i4;
    }

    public void n(View.OnClickListener onClickListener) {
        this.dhQ = onClickListener;
    }

    public void fL(boolean z) {
        this.dhR = z;
    }

    public boolean asA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
