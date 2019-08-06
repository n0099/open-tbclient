package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private int bZl;
    private boolean eLW;
    private String eLX;
    private int eMd;
    private int eMe;
    private int eMf;
    private View.OnClickListener eMi;
    private boolean eMj;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c eLV = null;
    private int eLY = R.drawable.pic_sign_tip;
    private int eLZ = 0;
    private int eMa = 1;
    private int eMb = 1000;
    private int eMc = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int eMg = 48;
    private int eMh = 4;
    private boolean zB = false;
    private Runnable eMk = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eLV == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.eMj || d.this.bbC()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.y(d.this.mTargetView).X(0).U(true).V(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.j(textView, R.color.cp_btn_a);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds76));
                            textView.setPadding(d.this.bZl, d.this.eMd, d.this.eMe, d.this.eMf);
                            textView.setSingleLine(true);
                            am.k(textView, d.this.eLY);
                            if (d.this.eMi != null) {
                                textView.setOnClickListener(d.this.eMi);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hT() {
                            return d.this.eMh;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hU() {
                            return d.this.eMg;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return d.this.mXOffset;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return d.this.mYOffset;
                        }
                    });
                    d.this.eLV = dVar.hV();
                    d.this.eLV.R(false);
                    d.this.eLV.S(d.this.zB);
                    d.this.eLV.q(d.this.mPageContext.getPageActivity());
                    d.this.eLW = true;
                    d.this.bbA();
                    d.this.mHandler.postDelayed(d.this.eMl, d.this.eMc);
                }
            }
        }
    };
    private Runnable eMl = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eLV != null) {
                d.this.eLV.dismiss();
            }
        }
    };

    public void qa(int i) {
        this.eMh = i;
    }

    public void qb(int i) {
        this.eMg = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bZl = 0;
        this.eMd = 0;
        this.eMe = 0;
        this.eMf = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bZl = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eMd = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eMe = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eMf = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbA() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt(this.eLX, this.eLZ + 1);
    }

    public void cI(String str, String str2) {
        u(str, str2, false);
    }

    public void u(String str, String str2, boolean z) {
        if (!this.eLW && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.eLX = str2;
            this.eLZ = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt(str2, 0);
            if (this.eLZ < this.eMa) {
                if (z) {
                    bbA();
                    this.eLW = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.eMk, this.eMb);
            }
        }
    }

    public void vJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.eMk, this.eMb);
        }
    }

    public void bbB() {
        if (this.eLV != null) {
            this.eLV.dismiss();
            this.eLV = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eMk);
            this.mHandler.removeCallbacks(this.eMl);
        }
    }

    public void qc(int i) {
        if (i > 0) {
            this.eLY = i;
        }
    }

    public void qd(int i) {
        if (i > 0) {
            this.eMc = i;
        }
    }

    public void qe(int i) {
        if (i > 0) {
            this.eMa = i;
        }
    }

    public void qf(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void t(int i, int i2, int i3, int i4) {
        this.bZl = i;
        this.eMd = i2;
        this.eMe = i3;
        this.eMf = i4;
    }

    public void q(View.OnClickListener onClickListener) {
        this.eMi = onClickListener;
    }

    public void iR(boolean z) {
        this.eMj = z;
    }

    public boolean bbC() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void S(boolean z) {
        this.zB = z;
    }
}
