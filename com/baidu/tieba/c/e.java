package com.baidu.tieba.c;

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
    private int bkB;
    private int bkC;
    private int bkD;
    private int bkE;
    private View.OnClickListener bkH;
    private boolean bkI;
    private boolean bku;
    private String bkv;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c hpE = null;
    private int bkw = R.drawable.pic_sign_tip;
    private int bkx = 0;
    private boolean hpF = false;
    private int bky = 1;
    private int bkz = 1000;
    private int bkA = 3000;
    private boolean hpG = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bkF = 48;
    private int bkG = 4;
    private boolean mUseDirectOffset = false;
    private int hpH = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean hpI = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private int hpJ = 0;
    private boolean hpK = false;
    private Runnable bkJ = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.hpE == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bkI || e.this.NH()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(e.this.mTargetView).aj(0).ag(true).ah(true);
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
                            if (e.this.mTextColorId != 0) {
                                ap.setViewTextColor(textView, e.this.mTextColorId);
                            } else {
                                ap.setViewTextColor(textView, R.color.cp_cont_a);
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
                            textView.setPadding(e.this.bkB, e.this.bkC, e.this.bkD, e.this.bkE);
                            textView.setLines(e.this.hpH);
                            if (e.this.hpI) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.hpJ != 0) {
                                if (e.this.hpK) {
                                    if (e.this.mTextColorId != 0) {
                                        i = e.this.mTextColorId;
                                    } else {
                                        i = R.color.cp_cont_a;
                                    }
                                    drawable = WebPManager.a(e.this.hpJ, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.hpJ);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bkw);
                            if (e.this.bkH != null) {
                                textView.setOnClickListener(e.this.bkH);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bkG;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bkF;
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
                    e.this.hpE = dVar.md();
                    e.this.hpE.setShouldCheckLocInWindow(false);
                    e.this.hpE.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.hpE.d(e.this.mPageContext.getPageActivity(), e.this.hpG);
                    e.this.bku = true;
                    e.this.NF();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bkK, e.this.bkA);
                }
            }
        }
    };
    private Runnable bkK = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.NG();
        }
    };

    public void setAnchor(int i) {
        this.bkG = i;
    }

    public void eK(int i) {
        this.bkF = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bkB = 0;
        this.bkC = 0;
        this.bkD = 0;
        this.bkE = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bkB = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bkC = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bkD = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bkE = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void nt(boolean z) {
        this.hpG = z;
    }

    public void vC(int i) {
        this.bkC = i;
    }

    public void vD(int i) {
        this.bkE = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        if (!this.hpF) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(this.bkv, this.bkx + 1);
        }
    }

    public void aG(String str, String str2) {
        y(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bku || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bkv = str2;
        this.hpF = z2;
        this.bkx = com.baidu.tbadk.core.sharedPref.b.bik().getInt(str2, 0);
        if (this.bkx < this.bky || this.hpF) {
            if (z) {
                NF();
                this.bku = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bkJ, this.bkz);
            return true;
        }
        return false;
    }

    public boolean y(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void Hj(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bkJ, this.bkz);
        }
    }

    public void NG() {
        if (this.hpE != null) {
            this.hpE.dismiss();
            this.hpE = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bkJ);
            this.mHandler.removeCallbacks(this.bkK);
        }
        this.isShowing = false;
    }

    public void eL(int i) {
        if (i > 0) {
            this.bkw = i;
        }
    }

    public void vE(int i) {
        if (i > 0) {
            this.bkz = i;
        }
    }

    public void eM(int i) {
        if (i > 0) {
            this.bkA = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bky = i;
        }
    }

    public void vF(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void z(int i, int i2, int i3, int i4) {
        this.bkB = i;
        this.bkC = i2;
        this.bkD = i3;
        this.bkE = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.bkH = onClickListener;
    }

    public void nu(boolean z) {
        this.bkI = z;
    }

    public boolean NH() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void vG(int i) {
        this.hpH = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void nv(boolean z) {
        this.hpI = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void vH(int i) {
        this.hpJ = i;
    }

    public void nw(boolean z) {
        this.hpK = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
