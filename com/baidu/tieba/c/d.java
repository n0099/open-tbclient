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
    private boolean ayi;
    private String ayj;
    private int ayp;
    private int ayq;
    private int ayr;
    private int ays;
    private View.OnClickListener ayv;
    private boolean ayw;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c fQA = null;
    private int ayk = R.drawable.pic_sign_tip;
    private int ayl = 0;
    private int aym = 1;
    private int ayn = 1000;
    private int ayo = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int ayt = 48;
    private int ayu = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayx = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fQA == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.ayw || d.this.zH()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).M(0).F(true).G(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.ayp, d.this.ayq, d.this.ayr, d.this.ays);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.ayk);
                            if (d.this.ayv != null) {
                                textView.setOnClickListener(d.this.ayv);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.ayu;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.ayt;
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
                    d.this.fQA = dVar.fI();
                    d.this.fQA.setShouldCheckLocInWindow(false);
                    d.this.fQA.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.fQA.show(d.this.mPageContext.getPageActivity());
                    d.this.ayi = true;
                    d.this.zF();
                    d.this.mHandler.postDelayed(d.this.ayy, d.this.ayo);
                }
            }
        }
    };
    private Runnable ayy = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fQA != null) {
                d.this.fQA.dismiss();
            }
        }
    };

    public void rz(int i) {
        this.ayu = i;
    }

    public void cj(int i) {
        this.ayt = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.ayp = 0;
        this.ayq = 0;
        this.ayr = 0;
        this.ays = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.ayp = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayq = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayr = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ays = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt(this.ayj, this.ayl + 1);
    }

    public void ai(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.ayi && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.ayj = str2;
            this.ayl = com.baidu.tbadk.core.sharedPref.b.aFH().getInt(str2, 0);
            if (this.ayl < this.aym) {
                if (z) {
                    zF();
                    this.ayi = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayx, this.ayn);
            }
        }
    }

    public void Af(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.ayx, this.ayn);
        }
    }

    public void zG() {
        if (this.fQA != null) {
            this.fQA.dismiss();
            this.fQA = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayx);
            this.mHandler.removeCallbacks(this.ayy);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.ayk = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.ayo = i;
        }
    }

    public void rA(int i) {
        if (i > 0) {
            this.aym = i;
        }
    }

    public void rB(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.ayp = i;
        this.ayq = i2;
        this.ayr = i3;
        this.ays = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayv = onClickListener;
    }

    public void kB(boolean z) {
        this.ayw = z;
    }

    public boolean zH() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
