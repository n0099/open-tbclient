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
    private View.OnClickListener bnA;
    private boolean bnB;
    private boolean bnn;
    private String bno;
    private int bnu;
    private int bnv;
    private int bnw;
    private int bnx;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c hwI = null;
    private int bnp = R.drawable.pic_sign_tip;
    private int bnq = 0;
    private boolean hwJ = false;
    private int bnr = 1;
    private int bns = 1000;
    private int bnt = 3000;
    private boolean hwK = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bny = 48;
    private int bnz = 4;
    private boolean mUseDirectOffset = false;
    private int hwL = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean hwM = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private int hwN = 0;
    private boolean hwO = false;
    private Runnable bnC = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.hwI == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bnB || e.this.Ok()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(e.this.mTargetView).ak(0).af(true).ag(true);
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
                            textView.setPadding(e.this.bnu, e.this.bnv, e.this.bnw, e.this.bnx);
                            textView.setLines(e.this.hwL);
                            if (e.this.hwM) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.hwN != 0) {
                                if (e.this.hwO) {
                                    if (e.this.mTextColorId != 0) {
                                        i = e.this.mTextColorId;
                                    } else {
                                        i = R.color.cp_cont_a;
                                    }
                                    drawable = WebPManager.a(e.this.hwN, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.hwN);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bnp);
                            if (e.this.bnA != null) {
                                textView.setOnClickListener(e.this.bnA);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bnz;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bny;
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
                    e.this.hwI = dVar.mh();
                    e.this.hwI.setShouldCheckLocInWindow(false);
                    e.this.hwI.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.hwI.d(e.this.mPageContext.getPageActivity(), e.this.hwK);
                    e.this.bnn = true;
                    e.this.Oi();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bnD, e.this.bnt);
                }
            }
        }
    };
    private Runnable bnD = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.Oj();
        }
    };

    public void setAnchor(int i) {
        this.bnz = i;
    }

    public void eV(int i) {
        this.bny = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bnu = 0;
        this.bnv = 0;
        this.bnw = 0;
        this.bnx = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bnu = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bnv = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bnw = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bnx = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void nz(boolean z) {
        this.hwK = z;
    }

    public void wb(int i) {
        this.bnv = i;
    }

    public void wc(int i) {
        this.bnx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oi() {
        if (!this.hwJ) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt(this.bno, this.bnq + 1);
        }
    }

    public void aG(String str, String str2) {
        y(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bnn || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bno = str2;
        this.hwJ = z2;
        this.bnq = com.baidu.tbadk.core.sharedPref.b.bjf().getInt(str2, 0);
        if (this.bnq < this.bnr || this.hwJ) {
            if (z) {
                Oi();
                this.bnn = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bnC, this.bns);
            return true;
        }
        return false;
    }

    public boolean y(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void HG(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bnC, this.bns);
        }
    }

    public void Oj() {
        if (this.hwI != null) {
            this.hwI.dismiss();
            this.hwI = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bnC);
            this.mHandler.removeCallbacks(this.bnD);
        }
        this.isShowing = false;
    }

    public void eW(int i) {
        if (i > 0) {
            this.bnp = i;
        }
    }

    public void wd(int i) {
        if (i > 0) {
            this.bns = i;
        }
    }

    public void eX(int i) {
        if (i > 0) {
            this.bnt = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bnr = i;
        }
    }

    public void we(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void z(int i, int i2, int i3, int i4) {
        this.bnu = i;
        this.bnv = i2;
        this.bnw = i3;
        this.bnx = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.bnA = onClickListener;
    }

    public void nA(boolean z) {
        this.bnB = z;
    }

    public boolean Ok() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void wf(int i) {
        this.hwL = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void nB(boolean z) {
        this.hwM = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void wg(int i) {
        this.hwN = i;
    }

    public void nC(boolean z) {
        this.hwO = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
