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
/* loaded from: classes2.dex */
public class e {
    private int bkA;
    private int bkB;
    private View.OnClickListener bkE;
    private boolean bkF;
    private boolean bkr;
    private String bks;
    private int bky;
    private int bkz;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c hpA = null;
    private int bkt = R.drawable.pic_sign_tip;
    private int bku = 0;
    private boolean hpB = false;
    private int bkv = 1;
    private int bkw = 1000;
    private int bkx = 3000;
    private boolean hpC = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bkC = 48;
    private int bkD = 4;
    private boolean mUseDirectOffset = false;
    private int hpD = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean hpE = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private int hpF = 0;
    private boolean hpG = false;
    private Runnable bkG = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.hpA == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bkF || e.this.NH()) {
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
                            textView.setPadding(e.this.bky, e.this.bkz, e.this.bkA, e.this.bkB);
                            textView.setLines(e.this.hpD);
                            if (e.this.hpE) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.hpF != 0) {
                                if (e.this.hpG) {
                                    if (e.this.mTextColorId != 0) {
                                        i = e.this.mTextColorId;
                                    } else {
                                        i = R.color.cp_cont_a;
                                    }
                                    drawable = WebPManager.a(e.this.hpF, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.hpF);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bkt);
                            if (e.this.bkE != null) {
                                textView.setOnClickListener(e.this.bkE);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bkD;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bkC;
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
                    e.this.hpA = dVar.md();
                    e.this.hpA.setShouldCheckLocInWindow(false);
                    e.this.hpA.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.hpA.d(e.this.mPageContext.getPageActivity(), e.this.hpC);
                    e.this.bkr = true;
                    e.this.NF();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bkH, e.this.bkx);
                }
            }
        }
    };
    private Runnable bkH = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.NG();
        }
    };

    public void setAnchor(int i) {
        this.bkD = i;
    }

    public void eK(int i) {
        this.bkC = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bky = 0;
        this.bkz = 0;
        this.bkA = 0;
        this.bkB = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bky = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bkz = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bkA = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bkB = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void nr(boolean z) {
        this.hpC = z;
    }

    public void vC(int i) {
        this.bkz = i;
    }

    public void vD(int i) {
        this.bkB = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        if (!this.hpB) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(this.bks, this.bku + 1);
        }
    }

    public void aG(String str, String str2) {
        y(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bkr || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bks = str2;
        this.hpB = z2;
        this.bku = com.baidu.tbadk.core.sharedPref.b.bik().getInt(str2, 0);
        if (this.bku < this.bkv || this.hpB) {
            if (z) {
                NF();
                this.bkr = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bkG, this.bkw);
            return true;
        }
        return false;
    }

    public boolean y(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void Hi(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bkG, this.bkw);
        }
    }

    public void NG() {
        if (this.hpA != null) {
            this.hpA.dismiss();
            this.hpA = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bkG);
            this.mHandler.removeCallbacks(this.bkH);
        }
        this.isShowing = false;
    }

    public void eL(int i) {
        if (i > 0) {
            this.bkt = i;
        }
    }

    public void vE(int i) {
        if (i > 0) {
            this.bkw = i;
        }
    }

    public void eM(int i) {
        if (i > 0) {
            this.bkx = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bkv = i;
        }
    }

    public void vF(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void z(int i, int i2, int i3, int i4) {
        this.bky = i;
        this.bkz = i2;
        this.bkA = i3;
        this.bkB = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.bkE = onClickListener;
    }

    public void ns(boolean z) {
        this.bkF = z;
    }

    public boolean NH() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void vG(int i) {
        this.hpD = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void nt(boolean z) {
        this.hpE = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void vH(int i) {
        this.hpF = i;
    }

    public void nu(boolean z) {
        this.hpG = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
