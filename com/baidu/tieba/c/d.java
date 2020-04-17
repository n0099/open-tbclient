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
    private boolean aRN;
    private String aRO;
    private int aRU;
    private int aRV;
    private int aRW;
    private int aRX;
    private View.OnClickListener aSa;
    private boolean aSb;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c gvi = null;
    private int aRP = R.drawable.pic_sign_tip;
    private int aRQ = 0;
    private int aRR = 1;
    private int aRS = 1000;
    private int aRT = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aRY = 48;
    private int aRZ = 4;
    private boolean mUseDirectOffset = false;
    private Runnable aSc = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gvi == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.aSb || d.this.EF()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).Y(0).ae(true).af(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.aRU, d.this.aRV, d.this.aRW, d.this.aRX);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.aRP);
                            if (d.this.aSa != null) {
                                textView.setOnClickListener(d.this.aSa);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.aRZ;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.aRY;
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
                    d.this.gvi = dVar.km();
                    d.this.gvi.setShouldCheckLocInWindow(false);
                    d.this.gvi.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.gvi.show(d.this.mPageContext.getPageActivity());
                    d.this.aRN = true;
                    d.this.ED();
                    d.this.mHandler.postDelayed(d.this.aSd, d.this.aRT);
                }
            }
        }
    };
    private Runnable aSd = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gvi != null) {
                d.this.gvi.dismiss();
            }
        }
    };

    public void rR(int i) {
        this.aRZ = i;
    }

    public void cy(int i) {
        this.aRY = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.aRU = 0;
        this.aRV = 0;
        this.aRW = 0;
        this.aRX = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aRU = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aRV = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aRW = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aRX = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ED() {
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt(this.aRO, this.aRQ + 1);
    }

    public void al(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.aRN && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.aRO = str2;
            this.aRQ = com.baidu.tbadk.core.sharedPref.b.aNV().getInt(str2, 0);
            if (this.aRQ < this.aRR) {
                if (z) {
                    ED();
                    this.aRN = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.aSc, this.aRS);
            }
        }
    }

    public void BL(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.aSc, this.aRS);
        }
    }

    public void EE() {
        if (this.gvi != null) {
            this.gvi.dismiss();
            this.gvi = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aSc);
            this.mHandler.removeCallbacks(this.aSd);
        }
    }

    public void cz(int i) {
        if (i > 0) {
            this.aRP = i;
        }
    }

    public void cA(int i) {
        if (i > 0) {
            this.aRT = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.aRR = i;
        }
    }

    public void rS(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.aRU = i;
        this.aRV = i2;
        this.aRW = i3;
        this.aRX = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.aSa = onClickListener;
    }

    public void lE(boolean z) {
        this.aSb = z;
    }

    public boolean EF() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
