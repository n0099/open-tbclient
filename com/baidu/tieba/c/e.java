package com.baidu.tieba.c;

import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private boolean beG;
    private String beH;
    private int beN;
    private int beO;
    private int beP;
    private int beQ;
    private View.OnClickListener beT;
    private boolean beU;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c hcJ = null;
    private int beI = R.drawable.pic_sign_tip;
    private int beJ = 0;
    private int beK = 1;
    private int beL = 1000;
    private int beM = 3000;
    private boolean hcK = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int beR = 48;
    private int beS = 4;
    private boolean mUseDirectOffset = false;
    private int hcL = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean hcM = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private Runnable beV = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.hcJ == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.beU || e.this.HO()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(e.this.mTargetView).ah(0).af(true).ag(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.e.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(e.this.mPageContext.getPageActivity());
                            textView.setText(e.this.mMessage);
                            if (e.this.mTextViewGravity != 0) {
                                textView.setGravity(e.this.mTextViewGravity);
                            } else {
                                textView.setGravity(17);
                            }
                            if (e.this.mTextColorId != 0) {
                                ao.setViewTextColor(textView, e.this.mTextColorId);
                            } else {
                                ao.setViewTextColor(textView, R.color.cp_cont_a);
                            }
                            textView.setTextSize(0, e.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            if (e.this.mHeight != 0) {
                                textView.setHeight(e.this.mHeight);
                            } else {
                                textView.setHeight(e.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            }
                            if (e.this.mWidth != 0) {
                                textView.setWidth(e.this.mWidth);
                            }
                            textView.setPadding(e.this.beN, e.this.beO, e.this.beP, e.this.beQ);
                            textView.setLines(e.this.hcL);
                            if (e.this.hcM) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            ao.setBackgroundResource(textView, e.this.beI);
                            if (e.this.beT != null) {
                                textView.setOnClickListener(e.this.beT);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.beS;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.beR;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return e.this.mXOffset;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return e.this.mYOffset;
                        }
                    });
                    e.this.hcJ = dVar.kE();
                    e.this.hcJ.setShouldCheckLocInWindow(false);
                    e.this.hcJ.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.hcJ.d(e.this.mPageContext.getPageActivity(), e.this.hcK);
                    e.this.beG = true;
                    e.this.HM();
                    e.this.mHandler.postDelayed(e.this.beW, e.this.beM);
                }
            }
        }
    };
    private Runnable beW = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.HN();
        }
    };

    public void tn(int i) {
        this.beS = i;
    }

    public void cR(int i) {
        this.beR = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.beN = 0;
        this.beO = 0;
        this.beP = 0;
        this.beQ = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.beN = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.beO = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.beP = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.beQ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void mO(boolean z) {
        this.hcK = z;
    }

    public void to(int i) {
        this.beO = i;
    }

    public void tp(int i) {
        this.beQ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(this.beH, this.beJ + 1);
    }

    public void aC(String str, String str2) {
        z(str, str2, false);
    }

    public boolean z(String str, String str2, boolean z) {
        if (this.beG || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.beH = str2;
        this.beJ = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(str2, 0);
        if (this.beJ < this.beK) {
            if (z) {
                HM();
                this.beG = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.beV, this.beL);
            return true;
        }
        return false;
    }

    public void EJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.beV, this.beL);
        }
    }

    public void HN() {
        if (this.hcJ != null) {
            this.hcJ.dismiss();
            this.hcJ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.beV);
            this.mHandler.removeCallbacks(this.beW);
        }
    }

    public void cS(int i) {
        if (i > 0) {
            this.beI = i;
        }
    }

    public void tq(int i) {
        if (i > 0) {
            this.beL = i;
        }
    }

    public void cT(int i) {
        if (i > 0) {
            this.beM = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.beK = i;
        }
    }

    public void tr(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void z(int i, int i2, int i3, int i4) {
        this.beN = i;
        this.beO = i2;
        this.beP = i3;
        this.beQ = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.beT = onClickListener;
    }

    public void mP(boolean z) {
        this.beU = z;
    }

    public boolean HO() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void ts(int i) {
        this.hcL = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void mQ(boolean z) {
        this.hcM = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }
}
