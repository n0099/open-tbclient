package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private int cFD;
    private int cFE;
    private int cFF;
    private int cFG;
    private View.OnClickListener cFJ;
    private boolean cFK;
    private boolean cFw;
    private String cFx;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cFv = null;
    private int cFy = d.f.pic_sign_tip;
    private int cFz = 0;
    private int cFA = 1;
    private int cFB = 1000;
    private int cFC = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cFH = 48;
    private int cFI = 4;
    private boolean yM = false;
    private Runnable cFL = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cFv == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.cFK || d.this.ako()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(d.this.mTargetView).X(0).F(true).G(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.h(textView, d.C0142d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(d.this.cFD, d.this.cFE, d.this.cFF, d.this.cFG);
                            textView.setSingleLine(true);
                            am.i(textView, d.this.cFy);
                            if (d.this.cFJ != null) {
                                textView.setOnClickListener(d.this.cFJ);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hw() {
                            return d.this.cFI;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hx() {
                            return d.this.cFH;
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
                    d.this.cFv = dVar.hy();
                    d.this.cFv.C(false);
                    d.this.cFv.D(d.this.yM);
                    d.this.cFv.k(d.this.mPageContext.getPageActivity());
                    d.this.cFw = true;
                    d.this.akm();
                    d.this.mHandler.postDelayed(d.this.cFM, d.this.cFC);
                }
            }
        }
    };
    private Runnable cFM = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cFv != null) {
                d.this.cFv.dismiss();
            }
        }
    };

    public void jb(int i) {
        this.cFI = i;
    }

    public void jc(int i) {
        this.cFH = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cFD = 0;
        this.cFE = 0;
        this.cFF = 0;
        this.cFG = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cFD = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cFE = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cFF = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cFG = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akm() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cFx, this.cFz + 1);
    }

    public void aQ(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.cFw && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cFx = str2;
            this.cFz = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cFz < this.cFA) {
                if (z) {
                    akm();
                    this.cFw = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cFL, this.cFB);
            }
        }
    }

    public void lm(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cFL, this.cFB);
        }
    }

    public void akn() {
        if (this.cFv != null) {
            this.cFv.dismiss();
            this.cFv = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cFL);
            this.mHandler.removeCallbacks(this.cFM);
        }
    }

    public void jd(int i) {
        if (i > 0) {
            this.cFy = i;
        }
    }

    public void je(int i) {
        if (i > 0) {
            this.cFC = i;
        }
    }

    public void jf(int i) {
        if (i > 0) {
            this.cFA = i;
        }
    }

    public void jg(int i) {
        this.mXOffset = i;
    }

    public void jh(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cFD = i;
        this.cFE = i2;
        this.cFF = i3;
        this.cFG = i4;
    }

    public void k(View.OnClickListener onClickListener) {
        this.cFJ = onClickListener;
    }

    public void eK(boolean z) {
        this.cFK = z;
    }

    public boolean ako() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void D(boolean z) {
        this.yM = z;
    }
}
