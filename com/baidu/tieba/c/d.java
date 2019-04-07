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
    private int bQn;
    private boolean erk;
    private String erl;
    private int ers;
    private int ert;
    private int eru;
    private View.OnClickListener erx;
    private boolean ery;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c erj = null;
    private int erm = d.f.pic_sign_tip;
    private int ern = 0;
    private int ero = 1;
    private int erp = 1000;
    private int erq = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int erv = 48;
    private int erw = 4;
    private boolean BN = false;
    private Runnable erz = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.erj == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.ery || d.this.aSq()) {
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
                            textView.setPadding(d.this.bQn, d.this.ers, d.this.ert, d.this.eru);
                            textView.setSingleLine(true);
                            al.k(textView, d.this.erm);
                            if (d.this.erx != null) {
                                textView.setOnClickListener(d.this.erx);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.erw;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.erv;
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
                    d.this.erj = dVar.iT();
                    d.this.erj.Z(false);
                    d.this.erj.aa(d.this.BN);
                    d.this.erj.n(d.this.mPageContext.getPageActivity());
                    d.this.erk = true;
                    d.this.aSo();
                    d.this.mHandler.postDelayed(d.this.erA, d.this.erq);
                }
            }
        }
    };
    private Runnable erA = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.erj != null) {
                d.this.erj.dismiss();
            }
        }
    };

    public void oE(int i) {
        this.erw = i;
    }

    public void oF(int i) {
        this.erv = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bQn = 0;
        this.ers = 0;
        this.ert = 0;
        this.eru = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bQn = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ers = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ert = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.eru = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSo() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.erl, this.ern + 1);
    }

    public void cv(String str, String str2) {
        s(str, str2, false);
    }

    public void s(String str, String str2, boolean z) {
        if (!this.erk && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.erl = str2;
            this.ern = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.ern < this.ero) {
                if (z) {
                    aSo();
                    this.erk = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.erz, this.erp);
            }
        }
    }

    public void aSp() {
        if (this.erj != null) {
            this.erj.dismiss();
            this.erj = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.erz);
            this.mHandler.removeCallbacks(this.erA);
        }
    }

    public void oG(int i) {
        if (i > 0) {
            this.erm = i;
        }
    }

    public void oH(int i) {
        if (i > 0) {
            this.erq = i;
        }
    }

    public void oI(int i) {
        if (i > 0) {
            this.ero = i;
        }
    }

    public void oJ(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bQn = i;
        this.ers = i2;
        this.ert = i3;
        this.eru = i4;
    }

    public void o(View.OnClickListener onClickListener) {
        this.erx = onClickListener;
    }

    public void id(boolean z) {
        this.ery = z;
    }

    public boolean aSq() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BN = z;
    }
}
