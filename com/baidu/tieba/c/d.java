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
    private boolean aZg;
    private String aZh;
    private int aZn;
    private int aZo;
    private int aZp;
    private int aZq;
    private View.OnClickListener aZt;
    private boolean aZu;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c gKk = null;
    private int aZi = R.drawable.pic_sign_tip;
    private int aZj = 0;
    private int aZk = 1;
    private int aZl = 1000;
    private int aZm = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aZr = 48;
    private int aZs = 4;
    private boolean mUseDirectOffset = false;
    private Runnable aZv = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gKk == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.aZu || d.this.Gv()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).Z(0).ae(true).af(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.aZn, d.this.aZo, d.this.aZp, d.this.aZq);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.aZi);
                            if (d.this.aZt != null) {
                                textView.setOnClickListener(d.this.aZt);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.aZs;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.aZr;
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
                    d.this.gKk = dVar.ko();
                    d.this.gKk.setShouldCheckLocInWindow(false);
                    d.this.gKk.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.gKk.show(d.this.mPageContext.getPageActivity());
                    d.this.aZg = true;
                    d.this.Gt();
                    d.this.mHandler.postDelayed(d.this.aZw, d.this.aZm);
                }
            }
        }
    };
    private Runnable aZw = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gKk != null) {
                d.this.gKk.dismiss();
            }
        }
    };

    public void sx(int i) {
        this.aZs = i;
    }

    public void cH(int i) {
        this.aZr = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.aZn = 0;
        this.aZo = 0;
        this.aZp = 0;
        this.aZq = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aZn = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aZo = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aZp = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aZq = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(this.aZh, this.aZj + 1);
    }

    public void aA(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.aZg && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.aZh = str2;
            this.aZj = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(str2, 0);
            if (this.aZj < this.aZk) {
                if (z) {
                    Gt();
                    this.aZg = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.aZv, this.aZl);
            }
        }
    }

    public void Dx(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.aZv, this.aZl);
        }
    }

    public void Gu() {
        if (this.gKk != null) {
            this.gKk.dismiss();
            this.gKk = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aZv);
            this.mHandler.removeCallbacks(this.aZw);
        }
    }

    public void cI(int i) {
        if (i > 0) {
            this.aZi = i;
        }
    }

    public void sy(int i) {
        if (i > 0) {
            this.aZl = i;
        }
    }

    public void cJ(int i) {
        if (i > 0) {
            this.aZm = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.aZk = i;
        }
    }

    public void sz(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void y(int i, int i2, int i3, int i4) {
        this.aZn = i;
        this.aZo = i2;
        this.aZp = i3;
        this.aZq = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.aZt = onClickListener;
    }

    public void ma(boolean z) {
        this.aZu = z;
    }

    public boolean Gv() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
