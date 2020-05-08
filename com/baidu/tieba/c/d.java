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
    private boolean aRS;
    private String aRT;
    private int aRZ;
    private int aSa;
    private int aSb;
    private int aSc;
    private View.OnClickListener aSf;
    private boolean aSg;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c gvo = null;
    private int aRU = R.drawable.pic_sign_tip;
    private int aRV = 0;
    private int aRW = 1;
    private int aRX = 1000;
    private int aRY = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aSd = 48;
    private int aSe = 4;
    private boolean mUseDirectOffset = false;
    private Runnable aSh = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gvo == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.aSg || d.this.EE()) {
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
                            textView.setPadding(d.this.aRZ, d.this.aSa, d.this.aSb, d.this.aSc);
                            textView.setSingleLine(true);
                            am.setBackgroundResource(textView, d.this.aRU);
                            if (d.this.aSf != null) {
                                textView.setOnClickListener(d.this.aSf);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return d.this.aSe;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return d.this.aSd;
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
                    d.this.gvo = dVar.km();
                    d.this.gvo.setShouldCheckLocInWindow(false);
                    d.this.gvo.setUseDirectOffset(d.this.mUseDirectOffset);
                    d.this.gvo.show(d.this.mPageContext.getPageActivity());
                    d.this.aRS = true;
                    d.this.EC();
                    d.this.mHandler.postDelayed(d.this.aSi, d.this.aRY);
                }
            }
        }
    };
    private Runnable aSi = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gvo != null) {
                d.this.gvo.dismiss();
            }
        }
    };

    public void rR(int i) {
        this.aSe = i;
    }

    public void cy(int i) {
        this.aSd = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.aRZ = 0;
        this.aSa = 0;
        this.aSb = 0;
        this.aSc = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aRZ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aSa = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aSb = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aSc = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt(this.aRT, this.aRV + 1);
    }

    public void al(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.aRS && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.aRT = str2;
            this.aRV = com.baidu.tbadk.core.sharedPref.b.aNT().getInt(str2, 0);
            if (this.aRV < this.aRW) {
                if (z) {
                    EC();
                    this.aRS = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.aSh, this.aRX);
            }
        }
    }

    public void BO(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.aSh, this.aRX);
        }
    }

    public void ED() {
        if (this.gvo != null) {
            this.gvo.dismiss();
            this.gvo = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aSh);
            this.mHandler.removeCallbacks(this.aSi);
        }
    }

    public void cz(int i) {
        if (i > 0) {
            this.aRU = i;
        }
    }

    public void cA(int i) {
        if (i > 0) {
            this.aRY = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.aRW = i;
        }
    }

    public void rS(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void x(int i, int i2, int i3, int i4) {
        this.aRZ = i;
        this.aSa = i2;
        this.aSb = i3;
        this.aSc = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.aSf = onClickListener;
    }

    public void lE(boolean z) {
        this.aSg = z;
    }

    public boolean EE() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
