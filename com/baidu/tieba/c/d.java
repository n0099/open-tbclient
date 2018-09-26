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
    private boolean cNR;
    private String cNS;
    private int cNY;
    private int cNZ;
    private int cOa;
    private int cOb;
    private View.OnClickListener cOe;
    private boolean cOf;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cNQ = null;
    private int cNT = e.f.pic_sign_tip;
    private int cNU = 0;
    private int cNV = 1;
    private int cNW = 1000;
    private int cNX = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cOc = 48;
    private int cOd = 4;
    private boolean Bd = false;
    private Runnable cOg = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cNQ == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.cOf || d.this.amA()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).af(0).O(true).P(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            al.h(textView, e.d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds76));
                            textView.setPadding(d.this.cNY, d.this.cNZ, d.this.cOa, d.this.cOb);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.cNT);
                            if (d.this.cOe != null) {
                                textView.setOnClickListener(d.this.cOe);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iC() {
                            return d.this.cOd;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iD() {
                            return d.this.cOc;
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
                    d.this.cNQ = dVar.iE();
                    d.this.cNQ.L(false);
                    d.this.cNQ.M(d.this.Bd);
                    d.this.cNQ.n(d.this.mPageContext.getPageActivity());
                    d.this.cNR = true;
                    d.this.amy();
                    d.this.mHandler.postDelayed(d.this.cOh, d.this.cNX);
                }
            }
        }
    };
    private Runnable cOh = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cNQ != null) {
                d.this.cNQ.dismiss();
            }
        }
    };

    public void jL(int i) {
        this.cOd = i;
    }

    public void jM(int i) {
        this.cOc = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cNY = 0;
        this.cNZ = 0;
        this.cOa = 0;
        this.cOb = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cNY = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds24);
        this.cNZ = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds24);
        this.cOa = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds24);
        this.cOb = this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amy() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cNS, this.cNU + 1);
    }

    public void aW(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cNR && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cNS = str2;
            this.cNU = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cNU < this.cNV) {
                if (z) {
                    amy();
                    this.cNR = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cOg, this.cNW);
            }
        }
    }

    public void lP(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cOg, this.cNW);
        }
    }

    public void amz() {
        if (this.cNQ != null) {
            this.cNQ.dismiss();
            this.cNQ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cOg);
            this.mHandler.removeCallbacks(this.cOh);
        }
    }

    public void jN(int i) {
        if (i > 0) {
            this.cNT = i;
        }
    }

    public void jO(int i) {
        if (i > 0) {
            this.cNX = i;
        }
    }

    public void jP(int i) {
        if (i > 0) {
            this.cNV = i;
        }
    }

    public void jQ(int i) {
        this.mXOffset = i;
    }

    public void jR(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cNY = i;
        this.cNZ = i2;
        this.cOa = i3;
        this.cOb = i4;
    }

    public void k(View.OnClickListener onClickListener) {
        this.cOe = onClickListener;
    }

    public void fc(boolean z) {
        this.cOf = z;
    }

    public boolean amA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void M(boolean z) {
        this.Bd = z;
    }
}
