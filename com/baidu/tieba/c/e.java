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
    private boolean bra;
    private String brb;
    private int brh;
    private int bri;
    private int brj;
    private int brk;
    private View.OnClickListener brn;
    private boolean bro;
    private boolean isShowing;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c hLD = null;
    private int brc = R.drawable.pic_sign_tip;
    private int brd = 0;
    private boolean hLE = false;
    private int bre = 1;
    private int brf = 1000;
    private int brg = 3000;
    private boolean hLF = true;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int brl = 48;
    private int brm = 4;
    private boolean mUseDirectOffset = false;
    private int hLG = 1;
    private int mHeight = 0;
    private int mWidth = 0;
    private boolean hLH = false;
    private int mTextColorId = 0;
    private int mTextViewGravity = 0;
    private int hLI = 0;
    private boolean hLJ = false;
    private Runnable brp = new Runnable() { // from class: com.baidu.tieba.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.hLD == null && !StringUtils.isNull(e.this.mMessage)) {
                if (!e.this.bro || e.this.Pp()) {
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
                            textView.setPadding(e.this.brh, e.this.bri, e.this.brj, e.this.brk);
                            textView.setLines(e.this.hLG);
                            if (e.this.hLH) {
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (e.this.hLI != 0) {
                                if (e.this.hLJ) {
                                    if (e.this.mTextColorId != 0) {
                                        i = e.this.mTextColorId;
                                    } else {
                                        i = R.color.cp_cont_a;
                                    }
                                    drawable = WebPManager.a(e.this.hLI, ap.getColor(i), WebPManager.ResourceStateType.NORMAL);
                                } else {
                                    drawable = ap.getDrawable(e.this.hLI);
                                }
                                int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                                drawable.setBounds(0, 0, dimens, dimens);
                                textView.setCompoundDrawablePadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                                textView.setCompoundDrawables(drawable, null, null, null);
                            }
                            ap.setBackgroundResource(textView, e.this.brc);
                            if (e.this.brn != null) {
                                textView.setOnClickListener(e.this.brn);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getAnchor() {
                            return e.this.brm;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getFitPosition() {
                            return e.this.brl;
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
                    e.this.hLD = dVar.mi();
                    e.this.hLD.setShouldCheckLocInWindow(false);
                    e.this.hLD.setUseDirectOffset(e.this.mUseDirectOffset);
                    e.this.hLD.d(e.this.mPageContext.getPageActivity(), e.this.hLF);
                    e.this.bra = true;
                    e.this.Pn();
                    e.this.isShowing = true;
                    e.this.mHandler.postDelayed(e.this.brq, e.this.brg);
                }
            }
        }
    };
    private Runnable brq = new Runnable() { // from class: com.baidu.tieba.c.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.Po();
        }
    };

    public void setAnchor(int i) {
        this.brm = i;
    }

    public void fe(int i) {
        this.brl = i;
    }

    public e(TbPageContext tbPageContext, View view) {
        this.brh = 0;
        this.bri = 0;
        this.brj = 0;
        this.brk = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.brh = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.bri = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.brj = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.brk = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public void oe(boolean z) {
        this.hLF = z;
    }

    public void wH(int i) {
        this.bri = i;
    }

    public void wI(int i) {
        this.brk = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pn() {
        if (!this.hLE) {
            com.baidu.tbadk.core.sharedPref.b.blO().putInt(this.brb, this.brd + 1);
        }
    }

    public void aJ(String str, String str2) {
        y(str, str2, false);
    }

    public boolean b(String str, String str2, boolean z, boolean z2) {
        if (this.bra || StringUtils.isNull(str) || StringUtils.isNull(str2) || this.mTargetView == null || this.mTargetView.getVisibility() != 0) {
            return false;
        }
        this.mMessage = str;
        this.brb = str2;
        this.hLE = z2;
        this.brd = com.baidu.tbadk.core.sharedPref.b.blO().getInt(str2, 0);
        if (this.brd < this.bre || this.hLE) {
            if (z) {
                Pn();
                this.bra = true;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.brp, this.brf);
            return true;
        }
        return false;
    }

    public boolean y(String str, String str2, boolean z) {
        return b(str, str2, z, false);
    }

    public void It(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.brp, this.brf);
        }
    }

    public void Po() {
        if (this.hLD != null) {
            this.hLD.dismiss();
            this.hLD = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.brp);
            this.mHandler.removeCallbacks(this.brq);
        }
        this.isShowing = false;
    }

    public void ff(int i) {
        if (i > 0) {
            this.brc = i;
        }
    }

    public void wJ(int i) {
        if (i > 0) {
            this.brf = i;
        }
    }

    public void fg(int i) {
        if (i > 0) {
            this.brg = i;
        }
    }

    public void setMaxShowTime(int i) {
        if (i > 0) {
            this.bre = i;
        }
    }

    public void wK(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void z(int i, int i2, int i3, int i4) {
        this.brh = i;
        this.bri = i2;
        this.brj = i3;
        this.brk = i4;
    }

    public void c(View.OnClickListener onClickListener) {
        this.brn = onClickListener;
    }

    public void of(boolean z) {
        this.bro = z;
    }

    public boolean Pp() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    public void wL(int i) {
        this.hLG = i;
    }

    public void setHeight(@DimenRes int i) {
        this.mHeight = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void setWidth(@DimenRes int i) {
        this.mWidth = this.mPageContext.getResources().getDimensionPixelSize(i);
    }

    public void og(boolean z) {
        this.hLH = z;
    }

    public void setTextColor(@ColorRes int i) {
        this.mTextColorId = i;
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    public void wM(int i) {
        this.hLI = i;
    }

    public void oh(boolean z) {
        this.hLJ = z;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
