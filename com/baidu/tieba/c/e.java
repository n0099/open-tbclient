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
    private boolean btf;
    private String btg;
    private int btm;
    private int bto;
    private int btp;
    private int btq;
    private View.OnClickListener btt;
    private boolean btu;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c hYa = null;
    private int bth = R.drawable.pic_sign_tip;
    private int bti = 0;
    private boolean hYb = false;
    private int btj = 1;
    private int btk = 1000;
    private int btl = 3000;
    private boolean hYc = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int btr = 48;
    private int bts = 4;
    private boolean mUseDirectOffset = false;
    private int hYd = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean hYe = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private int hYf = 0;
    private boolean hYg = false;
    private Runnable btv = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.hYa == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.btu || e.this.Qi()) {
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
                            textView.setPadding(e.this.btm, e.this.bto, e.this.btp, e.this.btq);
                            textView.setLines(e.this.hYd);
                            if (e.this.hYe) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.hYf != 0) {
                                if (e.this.hYg) {
                                    if (e.this.mTextColorId != 0) {
                                        i = e.this.mTextColorId;
                                    } else {
                                        i = R.color.cp_cont_a;
                                    }
                                    drawable = WebPManager.a(e.this.hYf, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.hYf);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.bth);
                            if (e.this.btt != null) {
                                textView.setOnClickListener(e.this.btt);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.bts;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.btr;
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
                    e.this.hYa = dVar.mi();
                    e.this.hYa.setShouldCheckLocInWindow(false);
                    e.this.hYa.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.hYa.d(e.this.mPageContext.getPageActivity(), e.this.hYc);
                    e.this.btf = true;
                    e.this.Qg();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.btw, e.this.btl);
                }
            }
        }
    };
    private Runnable btw = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.Qh();
        }
    };

    public void setAnchor(int i) {
        this.bts = i;
    }

    public void fg(int i) {
        this.btr = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.btm = 0;
        this.bto = 0;
        this.btp = 0;
        this.btq = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.btm = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bto = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.btp = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.btq = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void ow(boolean z) {
        this.hYc = z;
    }

    public void xa(int i) {
        this.bto = i;
    }

    public void xb(int i) {
        this.btq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qg() {
        if (!this.hYb) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt(this.btg, this.bti + 1);
        }
    }

    public void aL(String str, String str2) {
        y(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.btf || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.btg = str2;
        this.hYb = z2;
        this.bti = com.baidu.tbadk.core.sharedPref.b.bnH().getInt(str2, 0);
        if (this.bti < this.btj || this.hYb) {
            if (z) {
                Qg();
                this.btf = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.btv, this.btk);
            return true;
        }
        return false;
    }

    public boolean y(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void IS(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.btv, this.btk);
        }
    }

    public void Qh() {
        if (this.hYa != null) {
            this.hYa.dismiss();
            this.hYa = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.btv);
            this.mHandler.removeCallbacks(this.btw);
        }
        this.isShowing = false;
    }

    public void fh(int i) {
        if (i > 0) {
            this.bth = i;
        }
    }

    public void xc(int i) {
        if (i > 0) {
            this.btk = i;
        }
    }

    public void fi(int i) {
        if (i > 0) {
            this.btl = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.btj = i;
        }
    }

    public void xd(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void A(int i, int i2, int i3, int i4) {
        this.btm = i;
        this.bto = i2;
        this.btp = i3;
        this.btq = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.btt = onClickListener;
    }

    public void ox(boolean z) {
        this.btu = z;
    }

    public boolean Qi() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void xe(int i) {
        this.hYd = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void oy(boolean z) {
        this.hYe = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void xf(int i) {
        this.hYf = i;
    }

    public void oz(boolean z) {
        this.hYg = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
