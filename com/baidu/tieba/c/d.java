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
    private int bQo;
    private boolean erl;
    private String erm;
    private int ert;
    private int eru;
    private int erv;
    private View.OnClickListener ery;
    private boolean erz;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c erk = null;
    private int ern = d.f.pic_sign_tip;
    private int ero = 0;
    private int erp = 1;
    private int erq = 1000;
    private int ers = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int erw = 48;
    private int erx = 4;
    private boolean BN = false;
    private Runnable erA = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.erk == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.erz || d.this.aSq()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).ae(0).ac(true).ad(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.j(textView, d.C0277d.cp_btn_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(d.this.bQo, d.this.ert, d.this.eru, d.this.erv);
                            textView.setSingleLine(true);
                            al.k(textView, d.this.ern);
                            if (d.this.ery != null) {
                                textView.setOnClickListener(d.this.ery);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.erx;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.erw;
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
                    d.this.erk = dVar.iT();
                    d.this.erk.Z(false);
                    d.this.erk.aa(d.this.BN);
                    d.this.erk.n(d.this.mPageContext.getPageActivity());
                    d.this.erl = true;
                    d.this.aSo();
                    d.this.mHandler.postDelayed(d.this.erB, d.this.ers);
                }
            }
        }
    };
    private Runnable erB = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.erk != null) {
                d.this.erk.dismiss();
            }
        }
    };

    public void oE(int i) {
        this.erx = i;
    }

    public void oF(int i) {
        this.erw = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bQo = 0;
        this.ert = 0;
        this.eru = 0;
        this.erv = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bQo = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ert = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.eru = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.erv = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSo() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.erm, this.ero + 1);
    }

    public void cv(String str, String str2) {
        s(str, str2, false);
    }

    public void s(String str, String str2, boolean z) {
        if (!this.erl && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.erm = str2;
            this.ero = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.ero < this.erp) {
                if (z) {
                    aSo();
                    this.erl = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.erA, this.erq);
            }
        }
    }

    public void aSp() {
        if (this.erk != null) {
            this.erk.dismiss();
            this.erk = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.erA);
            this.mHandler.removeCallbacks(this.erB);
        }
    }

    public void oG(int i) {
        if (i > 0) {
            this.ern = i;
        }
    }

    public void oH(int i) {
        if (i > 0) {
            this.ers = i;
        }
    }

    public void oI(int i) {
        if (i > 0) {
            this.erp = i;
        }
    }

    public void oJ(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bQo = i;
        this.ert = i2;
        this.eru = i3;
        this.erv = i4;
    }

    public void o(View.OnClickListener onClickListener) {
        this.ery = onClickListener;
    }

    public void id(boolean z) {
        this.erz = z;
    }

    public boolean aSq() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BN = z;
    }
}
