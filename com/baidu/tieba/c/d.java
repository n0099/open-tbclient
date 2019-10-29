package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private boolean ale;
    private String alf;
    private int alm;
    private int aln;
    private int alo;
    private int alp;
    private View.OnClickListener als;
    private boolean alt;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c eWj = null;
    private int alg = R.drawable.pic_sign_tip;
    private int alh = 0;
    private int ali = 1;
    private int alj = 1000;
    private int alk = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int alq = 48;
    private int alr = 4;
    private boolean mUseDirectOffset = false;
    private Runnable alu = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eWj == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.alt || d.this.uQ()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).I(0).B(true).C(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.alm, d.this.aln, d.this.alo, d.this.alp);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.alg);
                            if (d.this.als != null) {
                                textView.setOnClickListener(d.this.als);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.alr;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.alq;
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
                    d.this.eWj = dVar.fu();
                    d.this.eWj.setShouldCheckLocInWindow(false);
                    d.this.eWj.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.eWj.show(d.this.mPageContext.getPageActivity());
                    d.this.ale = true;
                    d.this.uO();
                    d.this.mHandler.postDelayed(d.this.alv, d.this.alk);
                }
            }
        }
    };
    private Runnable alv = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eWj != null) {
                d.this.eWj.dismiss();
            }
        }
    };

    public void pf(int i) {
        this.alr = i;
    }

    public void bA(int i) {
        this.alq = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.alm = 0;
        this.aln = 0;
        this.alo = 0;
        this.alp = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.alm = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aln = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.alo = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.alp = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO() {
        com.baidu.tbadk.core.sharedPref.b.alR().putInt(this.alf, this.alh + 1);
    }

    public void R(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.ale && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.alf = str2;
            this.alh = com.baidu.tbadk.core.sharedPref.b.alR().getInt(str2, 0);
            if (this.alh < this.ali) {
                if (z) {
                    uO();
                    this.ale = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.alu, this.alj);
            }
        }
    }

    public void uK(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.alu, this.alj);
        }
    }

    public void uP() {
        if (this.eWj != null) {
            this.eWj.dismiss();
            this.eWj = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.alu);
            this.mHandler.removeCallbacks(this.alv);
        }
    }

    public void bB(int i) {
        if (i > 0) {
            this.alg = i;
        }
    }

    public void bC(int i) {
        if (i > 0) {
            this.alk = i;
        }
    }

    public void pg(int i) {
        if (i > 0) {
            this.ali = i;
        }
    }

    public void ph(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void t(int i, int i2, int i3, int i4) {
        this.alm = i;
        this.aln = i2;
        this.alo = i3;
        this.alp = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.als = onClickListener;
    }

    public void iX(boolean z) {
        this.alt = z;
    }

    public boolean uQ() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
