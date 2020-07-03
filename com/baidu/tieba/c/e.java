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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private View.OnClickListener beA;
    private boolean beB;
    private boolean bem;
    private String ben;
    private int beu;
    private int bev;
    private int bew;
    private int bex;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c gXe = null;
    private int beo = R.drawable.pic_sign_tip;
    private int bep = 0;
    private int beq = 1;
    private int ber = 1000;
    private int bes = 3000;
    private boolean gXf = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bey = 48;
    private int bez = 4;
    private boolean mUseDirectOffset = false;
    private int gXg = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean gXh = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private Runnable beC = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.gXe == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.beB || e.this.HI()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(e.this.mTargetView).af(0).af(true).ag(true);
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
                                an.setViewTextColor(textView, e.this.mTextColorId);
                            } else {
                                an.setViewTextColor(textView, (int) R.color.cp_cont_a);
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
                            textView.setPadding(e.this.beu, e.this.bev, e.this.bew, e.this.bex);
                            textView.setLines(e.this.gXg);
                            if (e.this.gXh) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            an.setBackgroundResource(textView, e.this.beo);
                            if (e.this.beA != null) {
                                textView.setOnClickListener(e.this.beA);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bez;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bey;
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
                    e.this.gXe = dVar.kE();
                    e.this.gXe.setShouldCheckLocInWindow(false);
                    e.this.gXe.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.gXe.d(e.this.mPageContext.getPageActivity(), e.this.gXf);
                    e.this.bem = true;
                    e.this.HG();
                    e.this.mHandler.postDelayed(e.this.beD, e.this.bes);
                }
            }
        }
    };
    private Runnable beD = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.HH();
        }
    };

    public void sV(int i) {
        this.bez = i;
    }

    public void cR(int i) {
        this.bey = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.beu = 0;
        this.bev = 0;
        this.bew = 0;
        this.bex = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.beu = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bev = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bew = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bex = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void mj(boolean z) {
        this.gXf = z;
    }

    public void sW(int i) {
        this.bev = i;
    }

    public void sX(int i) {
        this.bex = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(this.ben, this.bep + 1);
    }

    public void aC(String str, String str2) {
        z(str, str2, false);
    }

    public boolean z(String str, String str2, boolean z) {
        if (this.bem || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.ben = str2;
        this.bep = com.baidu.tbadk.core.sharedPref.b.aVP().getInt(str2, 0);
        if (this.bep < this.beq) {
            if (z) {
                HG();
                this.bem = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.beC, this.ber);
            return true;
        }
        return false;
    }

    public void DY(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.beC, this.ber);
        }
    }

    public void HH() {
        if (this.gXe != null) {
            this.gXe.dismiss();
            this.gXe = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.beC);
            this.mHandler.removeCallbacks(this.beD);
        }
    }

    public void cS(int i) {
        if (i > 0) {
            this.beo = i;
        }
    }

    public void sY(int i) {
        if (i > 0) {
            this.ber = i;
        }
    }

    public void cT(int i) {
        if (i > 0) {
            this.bes = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.beq = i;
        }
    }

    public void sZ(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void y(int i, int i2, int i3, int i4) {
        this.beu = i;
        this.bev = i2;
        this.bew = i3;
        this.bex = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.beA = onClickListener;
    }

    public void mk(boolean z) {
        this.beB = z;
    }

    public boolean HI() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void ta(int i) {
        this.gXg = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void ml(boolean z) {
        this.gXh = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }
}
