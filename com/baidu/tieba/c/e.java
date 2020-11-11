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
    private int bzA;
    private int bzB;
    private int bzC;
    private View.OnClickListener bzF;
    private boolean bzG;
    private boolean bzs;
    private String bzt;
    private int bzz;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c ieb = null;
    private int bzu = R.drawable.pic_sign_tip;
    private int bzv = 0;
    private boolean iec = false;
    private int bzw = 1;
    private int bzx = 1000;
    private int bzy = 3000;
    private boolean ied = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bzD = 48;
    private int bzE = 4;
    private boolean mUseDirectOffset = false;
    private int iee = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean ief = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private int ieg = 0;
    private boolean ieh = false;
    private Runnable bzH = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.ieb == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bzG || e.this.SS()) {
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
                            textView.setPadding(e.this.bzz, e.this.bzA, e.this.bzB, e.this.bzC);
                            textView.setLines(e.this.iee);
                            if (e.this.ief) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.ieg != 0) {
                                if (e.this.ieh) {
                                    if (e.this.mTextColorId != 0) {
                                        i = e.this.mTextColorId;
                                    } else {
                                        i = R.color.cp_cont_a;
                                    }
                                    drawable = WebPManager.a(e.this.ieg, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.ieg);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bzu);
                            if (e.this.bzF != null) {
                                textView.setOnClickListener(e.this.bzF);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bzE;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.bzD;
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
                    e.this.ieb = dVar.mi();
                    e.this.ieb.setShouldCheckLocInWindow(false);
                    e.this.ieb.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.ieb.d(e.this.mPageContext.getPageActivity(), e.this.ied);
                    e.this.bzs = true;
                    e.this.SQ();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.bzI, e.this.bzy);
                }
            }
        }
    };
    private Runnable bzI = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.SR();
        }
    };

    public void setAnchor(int i) {
        this.bzE = i;
    }

    public void ft(int i) {
        this.bzD = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.bzz = 0;
        this.bzA = 0;
        this.bzB = 0;
        this.bzC = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bzz = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bzA = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bzB = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bzC = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void oF(boolean z) {
        this.ied = z;
    }

    public void xn(int i) {
        this.bzA = i;
    }

    public void xo(int i) {
        this.bzC = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SQ() {
        if (!this.iec) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(this.bzt, this.bzv + 1);
        }
    }

    public void aM(String str, String str2) {
        z(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bzs || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.bzt = str2;
        this.iec = z2;
        this.bzv = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(str2, 0);
        if (this.bzv < this.bzw || this.iec) {
            if (z) {
                SQ();
                this.bzs = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bzH, this.bzx);
            return true;
        }
        return false;
    }

    public boolean z(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void Jj(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bzH, this.bzx);
        }
    }

    public void SR() {
        if (this.ieb != null) {
            this.ieb.dismiss();
            this.ieb = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bzH);
            this.mHandler.removeCallbacks(this.bzI);
        }
        this.isShowing = false;
    }

    public void fu(int i) {
        if (i > 0) {
            this.bzu = i;
        }
    }

    public void xp(int i) {
        if (i > 0) {
            this.bzx = i;
        }
    }

    public void fv(int i) {
        if (i > 0) {
            this.bzy = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bzw = i;
        }
    }

    public void xq(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void A(int i, int i2, int i3, int i4) {
        this.bzz = i;
        this.bzA = i2;
        this.bzB = i3;
        this.bzC = i4;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bzF = onClickListener;
    }

    public void oG(boolean z) {
        this.bzG = z;
    }

    public boolean SS() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void xr(int i) {
        this.iee = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void oH(boolean z) {
        this.ief = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void xs(int i) {
        this.ieg = i;
    }

    public void oI(boolean z) {
        this.ieh = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
