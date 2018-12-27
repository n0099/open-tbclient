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
    private boolean dgQ;
    private String dgR;
    private int dgX;
    private int dgY;
    private int dgZ;
    private int dha;
    private View.OnClickListener dhd;
    private boolean dhe;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c dgP = null;
    private int dgS = e.f.pic_sign_tip;
    private int dgT = 0;
    private int dgU = 1;
    private int dgV = 1000;
    private int dgW = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int dhb = 48;
    private int dhc = 4;
    private boolean BO = false;
    private Runnable dhf = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.dgP == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.dhe || d.this.asc()) {
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
                            textView.setPadding(d.this.dgX, d.this.dgY, d.this.dgZ, d.this.dha);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.dgS);
                            if (d.this.dhd != null) {
                                textView.setOnClickListener(d.this.dhd);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.dhc;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.dhb;
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
                    d.this.dgP = dVar.iT();
                    d.this.dgP.Z(false);
                    d.this.dgP.aa(d.this.BO);
                    d.this.dgP.n(d.this.mPageContext.getPageActivity());
                    d.this.dgQ = true;
                    d.this.asa();
                    d.this.mHandler.postDelayed(d.this.dhg, d.this.dgW);
                }
            }
        }
    };
    private Runnable dhg = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.dgP != null) {
                d.this.dgP.dismiss();
            }
        }
    };

    public void lf(int i) {
        this.dhc = i;
    }

    public void lg(int i) {
        this.dhb = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.dgX = 0;
        this.dgY = 0;
        this.dgZ = 0;
        this.dha = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.dgX = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dgY = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dgZ = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dha = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asa() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dgR, this.dgT + 1);
    }

    public void bo(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.dgQ && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.dgR = str2;
            this.dgT = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dgT < this.dgU) {
                if (z) {
                    asa();
                    this.dgQ = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.dhf, this.dgV);
            }
        }
    }

    public void mU(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.dhf, this.dgV);
        }
    }

    public void asb() {
        if (this.dgP != null) {
            this.dgP.dismiss();
            this.dgP = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dhf);
            this.mHandler.removeCallbacks(this.dhg);
        }
    }

    public void lh(int i) {
        if (i > 0) {
            this.dgS = i;
        }
    }

    public void li(int i) {
        if (i > 0) {
            this.dgW = i;
        }
    }

    public void lj(int i) {
        if (i > 0) {
            this.dgU = i;
        }
    }

    public void lk(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.dgX = i;
        this.dgY = i2;
        this.dgZ = i3;
        this.dha = i4;
    }

    public void n(View.OnClickListener onClickListener) {
        this.dhd = onClickListener;
    }

    public void fI(boolean z) {
        this.dhe = z;
    }

    public boolean asc() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
