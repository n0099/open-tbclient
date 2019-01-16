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
    private boolean dhC;
    private String dhD;
    private int dhJ;
    private int dhK;
    private int dhL;
    private int dhM;
    private View.OnClickListener dhP;
    private boolean dhQ;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c dhB = null;
    private int dhE = e.f.pic_sign_tip;
    private int dhF = 0;
    private int dhG = 1;
    private int dhH = 1000;
    private int dhI = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int dhN = 48;
    private int dhO = 4;
    private boolean BO = false;
    private Runnable dhR = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.dhB == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.dhQ || d.this.asA()) {
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
                            textView.setPadding(d.this.dhJ, d.this.dhK, d.this.dhL, d.this.dhM);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.dhE);
                            if (d.this.dhP != null) {
                                textView.setOnClickListener(d.this.dhP);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.dhO;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.dhN;
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
                    d.this.dhB = dVar.iT();
                    d.this.dhB.Z(false);
                    d.this.dhB.aa(d.this.BO);
                    d.this.dhB.n(d.this.mPageContext.getPageActivity());
                    d.this.dhC = true;
                    d.this.asy();
                    d.this.mHandler.postDelayed(d.this.dhS, d.this.dhI);
                }
            }
        }
    };
    private Runnable dhS = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.dhB != null) {
                d.this.dhB.dismiss();
            }
        }
    };

    public void lg(int i) {
        this.dhO = i;
    }

    public void lh(int i) {
        this.dhN = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.dhJ = 0;
        this.dhK = 0;
        this.dhL = 0;
        this.dhM = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.dhJ = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dhK = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dhL = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dhM = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asy() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dhD, this.dhF + 1);
    }

    public void bp(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.dhC && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.dhD = str2;
            this.dhF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dhF < this.dhG) {
                if (z) {
                    asy();
                    this.dhC = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.dhR, this.dhH);
            }
        }
    }

    public void nk(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.dhR, this.dhH);
        }
    }

    public void asz() {
        if (this.dhB != null) {
            this.dhB.dismiss();
            this.dhB = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dhR);
            this.mHandler.removeCallbacks(this.dhS);
        }
    }

    public void li(int i) {
        if (i > 0) {
            this.dhE = i;
        }
    }

    public void lj(int i) {
        if (i > 0) {
            this.dhI = i;
        }
    }

    public void lk(int i) {
        if (i > 0) {
            this.dhG = i;
        }
    }

    public void ll(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.dhJ = i;
        this.dhK = i2;
        this.dhL = i3;
        this.dhM = i4;
    }

    public void n(View.OnClickListener onClickListener) {
        this.dhP = onClickListener;
    }

    public void fL(boolean z) {
        this.dhQ = z;
    }

    public boolean asA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
