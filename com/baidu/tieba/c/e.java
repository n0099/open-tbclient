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
    private boolean bHZ;
    private String bIa;
    private int bIg;
    private int bIh;
    private int bIi;
    private int bIj;
    private View.OnClickListener bIm;
    private boolean bIn;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c iFg = null;
    private int bIb = R.drawable.pic_sign_tip;
    private int bIc = 0;
    private boolean iFh = false;
    private int bId = 1;
    private int bIe = 1000;
    private int bIf = 3000;
    private boolean iFi = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bIk = 48;
    private int bIl = 4;
    private boolean mUseDirectOffset = false;
    private int iFj = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean iFk = false;
    private int dCF = 0;
    private int mTextViewGravity = 0;
    private int iFl = 0;
    private boolean iFm = false;
    private Runnable bIo = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.iFg == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bIn || e.this.TD()) {
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
                            if (e.this.dCF != 0) {
                                ap.setViewTextColor(textView, e.this.dCF);
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
                            textView.setPadding(e.this.bIg, e.this.bIh, e.this.bIi, e.this.bIj);
                            textView.setLines(e.this.iFj);
                            if (e.this.iFk) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.iFl != 0) {
                                if (e.this.iFm) {
                                    if (e.this.dCF != 0) {
                                        i = e.this.dCF;
                                    } else {
                                        i = R.color.CAM_X0101;
                                    }
                                    drawable = WebPManager.a(e.this.iFl, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.iFl);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bIb);
                            if (e.this.bIm != null) {
                                textView.setOnClickListener(e.this.bIm);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bIl;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bIk;
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
                    e.this.iFg = dVar.lF();
                    e.this.iFg.setShouldCheckLocInWindow(false);
                    e.this.iFg.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.iFg.d(e.this.mPageContext.getPageActivity(), e.this.iFi);
                    e.this.bHZ = true;
                    e.this.TB();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bIp, e.this.bIf);
                }
            }
        }
    };
    private Runnable bIp = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.TC();
        }
    };

    public void xi(int i) {
        this.bIl = i;
    }

    public void en(int i) {
        this.bIk = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bIg = 0;
        this.bIh = 0;
        this.bIi = 0;
        this.bIj = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bIg = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bIh = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bIi = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bIj = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void pI(boolean z) {
        this.iFi = z;
    }

    public void xj(int i) {
        this.bIh = i;
    }

    public void xk(int i) {
        this.bIj = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TB() {
        if (!this.iFh) {
            com.baidu.tbadk.core.sharedPref.b.brR().putInt(this.bIa, this.bIc + 1);
        }
    }

    public void aJ(String str, String str2) {
        C(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bHZ || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bIa = str2;
        this.iFh = z2;
        this.bIc = com.baidu.tbadk.core.sharedPref.b.brR().getInt(str2, 0);
        if (this.bIc < this.bId || this.iFh) {
            if (z) {
                TB();
                this.bHZ = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bIo, this.bIe);
            return true;
        }
        return false;
    }

    public boolean C(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void Jh(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bIo, this.bIe);
        }
    }

    public void TC() {
        if (this.iFg != null) {
            this.iFg.dismiss();
            this.iFg = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bIo);
            this.mHandler.removeCallbacks(this.bIp);
        }
        this.isShowing = false;
    }

    public void eo(int i) {
        if (i > 0) {
            this.bIb = i;
        }
    }

    public void xl(int i) {
        if (i > 0) {
            this.bIe = i;
        }
    }

    public void ep(int i) {
        if (i > 0) {
            this.bIf = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bId = i;
        }
    }

    public void xm(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void G(int i, int i2, int i3, int i4) {
        this.bIg = i;
        this.bIh = i2;
        this.bIi = i3;
        this.bIj = i4;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bIm = onClickListener;
    }

    public void pJ(boolean z) {
        this.bIn = z;
    }

    public boolean TD() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void setLines(int i) {
        this.iFj = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void pK(boolean z) {
        this.iFk = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.dCF = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void xn(int i) {
        this.iFl = i;
    }

    public void pL(boolean z) {
        this.iFm = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
