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
    private boolean axU;
    private String axV;
    private int ayb;
    private int ayc;
    private int ayd;
    private int aye;
    private View.OnClickListener ayh;
    private boolean ayi;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c fPS = null;
    private int axW = R.drawable.pic_sign_tip;
    private int axX = 0;
    private int axY = 1;
    private int axZ = 1000;
    private int aya = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int ayf = 48;
    private int ayg = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayj = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fPS == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.ayi || d.this.zA()) {
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
                            textView.setPadding(d.this.ayb, d.this.ayc, d.this.ayd, d.this.aye);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.axW);
                            if (d.this.ayh != null) {
                                textView.setOnClickListener(d.this.ayh);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.ayg;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.ayf;
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
                    d.this.fPS = dVar.fI();
                    d.this.fPS.setShouldCheckLocInWindow(false);
                    d.this.fPS.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.fPS.show(d.this.mPageContext.getPageActivity());
                    d.this.axU = true;
                    d.this.zy();
                    d.this.mHandler.postDelayed(d.this.ayk, d.this.aya);
                }
            }
        }
    };
    private Runnable ayk = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fPS != null) {
                d.this.fPS.dismiss();
            }
        }
    };

    public void rx(int i) {
        this.ayg = i;
    }

    public void cj(int i) {
        this.ayf = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.ayb = 0;
        this.ayc = 0;
        this.ayd = 0;
        this.aye = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.ayb = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayc = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ayd = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aye = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy() {
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(this.axV, this.axX + 1);
    }

    public void aj(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.axU && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.axV = str2;
            this.axX = com.baidu.tbadk.core.sharedPref.b.aFD().getInt(str2, 0);
            if (this.axX < this.axY) {
                if (z) {
                    zy();
                    this.axU = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayj, this.axZ);
            }
        }
    }

    public void Ad(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.ayj, this.axZ);
        }
    }

    public void zz() {
        if (this.fPS != null) {
            this.fPS.dismiss();
            this.fPS = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayj);
            this.mHandler.removeCallbacks(this.ayk);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.axW = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.aya = i;
        }
    }

    public void ry(int i) {
        if (i > 0) {
            this.axY = i;
        }
    }

    public void rz(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.ayb = i;
        this.ayc = i2;
        this.ayd = i3;
        this.aye = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayh = onClickListener;
    }

    public void kw(boolean z) {
        this.ayi = z;
    }

    public boolean zA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
