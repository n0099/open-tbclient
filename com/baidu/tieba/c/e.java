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
    private boolean bHB;
    private String bHC;
    private int bHI;
    private int bHJ;
    private int bHK;
    private int bHL;
    private View.OnClickListener bHO;
    private boolean bHP;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c iCg = null;
    private int bHD = R.drawable.pic_sign_tip;
    private int bHE = 0;
    private boolean iCh = false;
    private int bHF = 1;
    private int bHG = 1000;
    private int bHH = 3000;
    private boolean iCi = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bHM = 48;
    private int bHN = 4;
    private boolean mUseDirectOffset = false;
    private int iCj = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean iCk = false;
    private int dDL = 0;
    private int mTextViewGravity = 0;
    private int iCl = 0;
    private boolean iCm = false;
    private Runnable bHQ = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.iCg == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bHP || e.this.VM()) {
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
                            if (e.this.dDL != 0) {
                                ao.setViewTextColor(textView, e.this.dDL);
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
                            textView.setPadding(e.this.bHI, e.this.bHJ, e.this.bHK, e.this.bHL);
                            textView.setLines(e.this.iCj);
                            if (e.this.iCk) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.iCl != 0) {
                                if (e.this.iCm) {
                                    if (e.this.dDL != 0) {
                                        i = e.this.dDL;
                                    } else {
                                        i = R.color.CAM_X0101;
                                    }
                                    drawable = WebPManager.a(e.this.iCl, ao.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ao.getDrawable(e.this.iCl);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ao.setBackgroundResource(textView, e.this.bHD);
                            if (e.this.bHO != null) {
                                textView.setOnClickListener(e.this.bHO);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bHN;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bHM;
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
                    e.this.iCg = dVar.lG();
                    e.this.iCg.setShouldCheckLocInWindow(false);
                    e.this.iCg.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.iCg.d(e.this.mPageContext.getPageActivity(), e.this.iCi);
                    e.this.bHB = true;
                    e.this.VK();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bHR, e.this.bHH);
                }
            }
        }
    };
    private Runnable bHR = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.VL();
        }
    };

    public void setAnchor(int i) {
        this.bHN = i;
    }

    public void fO(int i) {
        this.bHM = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bHI = 0;
        this.bHJ = 0;
        this.bHK = 0;
        this.bHL = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bHI = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bHJ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bHK = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bHL = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void pC(boolean z) {
        this.iCi = z;
    }

    public void yE(int i) {
        this.bHJ = i;
    }

    public void yF(int i) {
        this.bHL = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VK() {
        if (!this.iCh) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt(this.bHC, this.bHE + 1);
        }
    }

    public void aK(String str, String str2) {
        C(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bHB || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bHC = str2;
        this.iCh = z2;
        this.bHE = com.baidu.tbadk.core.sharedPref.b.bvr().getInt(str2, 0);
        if (this.bHE < this.bHF || this.iCh) {
            if (z) {
                VK();
                this.bHB = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bHQ, this.bHG);
            return true;
        }
        return false;
    }

    public boolean C(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void Jx(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bHQ, this.bHG);
        }
    }

    public void VL() {
        if (this.iCg != null) {
            this.iCg.dismiss();
            this.iCg = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bHQ);
            this.mHandler.removeCallbacks(this.bHR);
        }
        this.isShowing = false;
    }

    public void fP(int i) {
        if (i > 0) {
            this.bHD = i;
        }
    }

    public void yG(int i) {
        if (i > 0) {
            this.bHG = i;
        }
    }

    public void fQ(int i) {
        if (i > 0) {
            this.bHH = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bHF = i;
        }
    }

    public void yH(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void G(int i, int i2, int i3, int i4) {
        this.bHI = i;
        this.bHJ = i2;
        this.bHK = i3;
        this.bHL = i4;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bHO = onClickListener;
    }

    public void pD(boolean z) {
        this.bHP = z;
    }

    public boolean VM() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void setLines(int i) {
        this.iCj = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void pE(boolean z) {
        this.iCk = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.dDL = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void yI(int i) {
        this.iCl = i;
    }

    public void pF(boolean z) {
        this.iCm = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
