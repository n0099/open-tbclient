package com.baidu.tieba.c;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private boolean bCP;
    private String bCQ;
    private int bCW;
    private int bCX;
    private int bCY;
    private int bCZ;
    private View.OnClickListener bDc;
    private boolean bDd;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c ixz = null;
    private int bCR = R.drawable.pic_sign_tip;
    private int bCS = 0;
    private boolean ixA = false;
    private int bCT = 1;
    private int bCU = 1000;
    private int bCV = 3000;
    private boolean ixB = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bDa = 48;
    private int bDb = 4;
    private boolean mUseDirectOffset = false;
    private int ixC = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean ixD = false;
    private int dyZ = 0;
    private int mTextViewGravity = 0;
    private int ixE = 0;
    private boolean ixF = false;
    private Runnable bDe = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.ixz == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bDd || e.this.RT()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(e.this.mTargetView).an(0).ac(true).ad(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.e.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            Drawable drawable;
                            int i;
                            TextView textView = new TextView(e.this.mPageContext.getPageActivity());
                            textView.setText(e.this.mMessage);
                            if (e.this.mTextViewGravity != 0) {
                                textView.setGravity(e.this.mTextViewGravity);
                            } else {
                                textView.setGravity(17);
                            }
                            if (e.this.dyZ != 0) {
                                ao.setViewTextColor(textView, e.this.dyZ);
                            } else {
                                ao.setViewTextColor(textView, R.color.CAM_X0101);
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
                            textView.setPadding(e.this.bCW, e.this.bCX, e.this.bCY, e.this.bCZ);
                            textView.setLines(e.this.ixC);
                            if (e.this.ixD) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.ixE != 0) {
                                if (e.this.ixF) {
                                    if (e.this.dyZ != 0) {
                                        i = e.this.dyZ;
                                    } else {
                                        i = R.color.CAM_X0101;
                                    }
                                    drawable = WebPManager.a(e.this.ixE, ao.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ao.getDrawable(e.this.ixE);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ao.setBackgroundResource(textView, e.this.bCR);
                            if (e.this.bDc != null) {
                                textView.setOnClickListener(e.this.bDc);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bDb;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bDa;
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
                    e.this.ixz = dVar.lG();
                    e.this.ixz.setShouldCheckLocInWindow(false);
                    e.this.ixz.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.ixz.d(e.this.mPageContext.getPageActivity(), e.this.ixB);
                    e.this.bCP = true;
                    e.this.RR();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bDf, e.this.bCV);
                }
            }
        }
    };
    private Runnable bDf = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.RS();
        }
    };

    public void wX(int i) {
        this.bDb = i;
    }

    public void ei(int i) {
        this.bDa = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bCW = 0;
        this.bCX = 0;
        this.bCY = 0;
        this.bCZ = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bCW = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bCX = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bCY = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bCZ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void py(boolean z) {
        this.ixB = z;
    }

    public void wY(int i) {
        this.bCX = i;
    }

    public void wZ(int i) {
        this.bCZ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RR() {
        if (!this.ixA) {
            com.baidu.tbadk.core.sharedPref.b.brx().putInt(this.bCQ, this.bCS + 1);
        }
    }

    public void aJ(String str, String str2) {
        C(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bCP || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bCQ = str2;
        this.ixA = z2;
        this.bCS = com.baidu.tbadk.core.sharedPref.b.brx().getInt(str2, 0);
        if (this.bCS < this.bCT || this.ixA) {
            if (z) {
                RR();
                this.bCP = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bDe, this.bCU);
            return true;
        }
        return false;
    }

    public boolean C(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void Im(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bDe, this.bCU);
        }
    }

    public void RS() {
        if (this.ixz != null) {
            this.ixz.dismiss();
            this.ixz = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bDe);
            this.mHandler.removeCallbacks(this.bDf);
        }
        this.isShowing = false;
    }

    public void ej(int i) {
        if (i > 0) {
            this.bCR = i;
        }
    }

    public void xa(int i) {
        if (i > 0) {
            this.bCU = i;
        }
    }

    public void ek(int i) {
        if (i > 0) {
            this.bCV = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bCT = i;
        }
    }

    public void xb(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void G(int i, int i2, int i3, int i4) {
        this.bCW = i;
        this.bCX = i2;
        this.bCY = i3;
        this.bCZ = i4;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bDc = onClickListener;
    }

    public void pz(boolean z) {
        this.bDd = z;
    }

    public boolean RT() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void setLines(int i) {
        this.ixC = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void pA(boolean z) {
        this.ixD = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.dyZ = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void xc(int i) {
        this.ixE = i;
    }

    public void pB(boolean z) {
        this.ixF = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
