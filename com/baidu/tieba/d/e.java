package com.baidu.tieba.d;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private boolean bxH;
    private String bxI;
    private int bxO;
    private int bxP;
    private int bxQ;
    private int bxR;
    private View.OnClickListener bxU;
    private boolean bxV;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c ieQ = null;
    private int bxJ = R.drawable.pic_sign_tip;
    private int bxK = 0;
    private boolean ieR = false;
    private int bxL = 1;
    private int bxM = 1000;
    private int bxN = 3000;
    private boolean ieS = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bxS = 48;
    private int bxT = 4;
    private boolean mUseDirectOffset = false;
    private int ieT = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean ieU = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private int ieV = 0;
    private boolean ieW = false;
    private Runnable bxW = new Runnable() { // from class: com.baidu.tieba.d.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.ieQ == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bxV || e.this.Sj()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(e.this.mTargetView).ak(0).af(true).ag(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.e.1.1
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
                            if (e.this.mTextColorId != 0) {
                                ap.setViewTextColor(textView, e.this.mTextColorId);
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
                            textView.setPadding(e.this.bxO, e.this.bxP, e.this.bxQ, e.this.bxR);
                            textView.setLines(e.this.ieT);
                            if (e.this.ieU) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.ieV != 0) {
                                if (e.this.ieW) {
                                    if (e.this.mTextColorId != 0) {
                                        i = e.this.mTextColorId;
                                    } else {
                                        i = R.color.CAM_X0101;
                                    }
                                    drawable = WebPManager.a(e.this.ieV, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.ieV);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bxJ);
                            if (e.this.bxU != null) {
                                textView.setOnClickListener(e.this.bxU);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bxT;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bxS;
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
                    e.this.ieQ = dVar.mi();
                    e.this.ieQ.setShouldCheckLocInWindow(false);
                    e.this.ieQ.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.ieQ.d(e.this.mPageContext.getPageActivity(), e.this.ieS);
                    e.this.bxH = true;
                    e.this.Sh();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bxX, e.this.bxN);
                }
            }
        }
    };
    private Runnable bxX = new Runnable() { // from class: com.baidu.tieba.d.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.Si();
        }
    };

    public void setAnchor(int i) {
        this.bxT = i;
    }

    public void fp(int i) {
        this.bxS = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bxO = 0;
        this.bxP = 0;
        this.bxQ = 0;
        this.bxR = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bxO = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bxP = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bxQ = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bxR = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void oI(boolean z) {
        this.ieS = z;
    }

    public void xL(int i) {
        this.bxP = i;
    }

    public void xM(int i) {
        this.bxR = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        if (!this.ieR) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt(this.bxI, this.bxK + 1);
        }
    }

    public void aL(String str, String str2) {
        z(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bxH || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bxI = str2;
        this.ieR = z2;
        this.bxK = com.baidu.tbadk.core.sharedPref.b.bpu().getInt(str2, 0);
        if (this.bxK < this.bxL || this.ieR) {
            if (z) {
                Sh();
                this.bxH = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bxW, this.bxM);
            return true;
        }
        return false;
    }

    public boolean z(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void IK(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bxW, this.bxM);
        }
    }

    public void Si() {
        if (this.ieQ != null) {
            this.ieQ.dismiss();
            this.ieQ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bxW);
            this.mHandler.removeCallbacks(this.bxX);
        }
        this.isShowing = false;
    }

    public void fq(int i) {
        if (i > 0) {
            this.bxJ = i;
        }
    }

    public void xN(int i) {
        if (i > 0) {
            this.bxM = i;
        }
    }

    public void fr(int i) {
        if (i > 0) {
            this.bxN = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bxL = i;
        }
    }

    public void xO(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void B(int i, int i2, int i3, int i4) {
        this.bxO = i;
        this.bxP = i2;
        this.bxQ = i3;
        this.bxR = i4;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bxU = onClickListener;
    }

    public void oJ(boolean z) {
        this.bxV = z;
    }

    public boolean Sj() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void xP(int i) {
        this.ieT = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void oK(boolean z) {
        this.ieU = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void xQ(int i) {
        this.ieV = i;
    }

    public void oL(boolean z) {
        this.ieW = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
