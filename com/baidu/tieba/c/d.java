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
    private boolean ddZ;
    private String dea;
    private int deg;
    private int deh;
    private int dei;
    private int dej;
    private View.OnClickListener dem;
    private boolean den;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c ddY = null;
    private int deb = e.f.pic_sign_tip;
    private int dec = 0;
    private int ded = 1;
    private int dee = 1000;
    private int def = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int dek = 48;
    private int del = 4;
    private boolean BO = false;
    private Runnable deo = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ddY == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.den || d.this.arn()) {
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
                            textView.setPadding(d.this.deg, d.this.deh, d.this.dei, d.this.dej);
                            textView.setSingleLine(true);
                            al.i(textView, d.this.deb);
                            if (d.this.dem != null) {
                                textView.setOnClickListener(d.this.dem);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iR() {
                            return d.this.del;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int iS() {
                            return d.this.dek;
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
                    d.this.ddY = dVar.iT();
                    d.this.ddY.Z(false);
                    d.this.ddY.aa(d.this.BO);
                    d.this.ddY.n(d.this.mPageContext.getPageActivity());
                    d.this.ddZ = true;
                    d.this.arl();
                    d.this.mHandler.postDelayed(d.this.dep, d.this.def);
                }
            }
        }
    };
    private Runnable dep = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ddY != null) {
                d.this.ddY.dismiss();
            }
        }
    };

    public void kS(int i) {
        this.del = i;
    }

    public void kT(int i) {
        this.dek = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.deg = 0;
        this.deh = 0;
        this.dei = 0;
        this.dej = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.deg = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.deh = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dei = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.dej = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arl() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dea, this.dec + 1);
    }

    public void bo(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.ddZ && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.dea = str2;
            this.dec = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dec < this.ded) {
                if (z) {
                    arl();
                    this.ddZ = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.deo, this.dee);
            }
        }
    }

    public void mR(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.deo, this.dee);
        }
    }

    public void arm() {
        if (this.ddY != null) {
            this.ddY.dismiss();
            this.ddY = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.deo);
            this.mHandler.removeCallbacks(this.dep);
        }
    }

    public void kU(int i) {
        if (i > 0) {
            this.deb = i;
        }
    }

    public void kV(int i) {
        if (i > 0) {
            this.def = i;
        }
    }

    public void kW(int i) {
        if (i > 0) {
            this.ded = i;
        }
    }

    public void kX(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.deg = i;
        this.deh = i2;
        this.dei = i3;
        this.dej = i4;
    }

    public void n(View.OnClickListener onClickListener) {
        this.dem = onClickListener;
    }

    public void fG(boolean z) {
        this.den = z;
    }

    public boolean arn() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
