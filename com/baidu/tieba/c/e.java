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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private String bGA;
    private int bGG;
    private int bGH;
    private int bGI;
    private int bGJ;
    private View.OnClickListener bGM;
    private boolean bGN;
    private boolean bGz;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c iDx = null;
    private int bGB = R.drawable.pic_sign_tip;
    private int bGC = 0;
    private boolean iDy = false;
    private int bGD = 1;
    private int bGE = 1000;
    private int bGF = 3000;
    private boolean iDz = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bGK = 48;
    private int bGL = 4;
    private boolean mUseDirectOffset = false;
    private int iDA = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean iDB = false;
    private int dBe = 0;
    private int mTextViewGravity = 0;
    private int iDC = 0;
    private boolean iDD = false;
    private Runnable bGO = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.iDx == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bGN || e.this.TA()) {
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
                            if (e.this.dBe != 0) {
                                ap.setViewTextColor(textView, e.this.dBe);
                            } else {
                                ap.setViewTextColor(textView, R.color.CAM_X0101);
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
                            textView.setPadding(e.this.bGG, e.this.bGH, e.this.bGI, e.this.bGJ);
                            textView.setLines(e.this.iDA);
                            if (e.this.iDB) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.iDC != 0) {
                                if (e.this.iDD) {
                                    if (e.this.dBe != 0) {
                                        i = e.this.dBe;
                                    } else {
                                        i = R.color.CAM_X0101;
                                    }
                                    drawable = WebPManager.a(e.this.iDC, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.iDC);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bGB);
                            if (e.this.bGM != null) {
                                textView.setOnClickListener(e.this.bGM);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bGL;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bGK;
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
                    e.this.iDx = dVar.lF();
                    e.this.iDx.setShouldCheckLocInWindow(false);
                    e.this.iDx.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.iDx.d(e.this.mPageContext.getPageActivity(), e.this.iDz);
                    e.this.bGz = true;
                    e.this.Ty();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bGP, e.this.bGF);
                }
            }
        }
    };
    private Runnable bGP = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.Tz();
        }
    };

    public void xh(int i) {
        this.bGL = i;
    }

    public void em(int i) {
        this.bGK = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bGG = 0;
        this.bGH = 0;
        this.bGI = 0;
        this.bGJ = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bGG = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bGH = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bGI = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bGJ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void pI(boolean z) {
        this.iDz = z;
    }

    public void xi(int i) {
        this.bGH = i;
    }

    public void xj(int i) {
        this.bGJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ty() {
        if (!this.iDy) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt(this.bGA, this.bGC + 1);
        }
    }

    public void aJ(String str, String str2) {
        C(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bGz || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bGA = str2;
        this.iDy = z2;
        this.bGC = com.baidu.tbadk.core.sharedPref.b.brQ().getInt(str2, 0);
        if (this.bGC < this.bGD || this.iDy) {
            if (z) {
                Ty();
                this.bGz = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bGO, this.bGE);
            return true;
        }
        return false;
    }

    public boolean C(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void IY(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bGO, this.bGE);
        }
    }

    public void Tz() {
        if (this.iDx != null) {
            this.iDx.dismiss();
            this.iDx = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bGO);
            this.mHandler.removeCallbacks(this.bGP);
        }
        this.isShowing = false;
    }

    public void en(int i) {
        if (i > 0) {
            this.bGB = i;
        }
    }

    public void xk(int i) {
        if (i > 0) {
            this.bGE = i;
        }
    }

    public void eo(int i) {
        if (i > 0) {
            this.bGF = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bGD = i;
        }
    }

    public void xl(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void G(int i, int i2, int i3, int i4) {
        this.bGG = i;
        this.bGH = i2;
        this.bGI = i3;
        this.bGJ = i4;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bGM = onClickListener;
    }

    public void pJ(boolean z) {
        this.bGN = z;
    }

    public boolean TA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void setLines(int i) {
        this.iDA = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void pK(boolean z) {
        this.iDB = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.dBe = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void xm(int i) {
        this.iDC = i;
    }

    public void pL(boolean z) {
        this.iDD = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
