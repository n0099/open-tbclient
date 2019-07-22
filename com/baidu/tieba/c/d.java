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
    private int bZf;
    private boolean eLP;
    private String eLQ;
    private int eLW;
    private int eLX;
    private int eLY;
    private View.OnClickListener eMb;
    private boolean eMc;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c eLO = null;
    private int eLR = R.drawable.pic_sign_tip;
    private int eLS = 0;
    private int eLT = 1;
    private int eLU = 1000;
    private int eLV = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int eLZ = 48;
    private int eMa = 4;
    private boolean zB = false;
    private Runnable eMd = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eLO == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.eMc || d.this.bbA()) {
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
                            textView.setPadding(d.this.bZf, d.this.eLW, d.this.eLX, d.this.eLY);
                            textView.setSingleLine(true);
                            am.k(textView, d.this.eLR);
                            if (d.this.eMb != null) {
                                textView.setOnClickListener(d.this.eMb);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hT() {
                            return d.this.eMa;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hU() {
                            return d.this.eLZ;
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
                    d.this.eLO = dVar.hV();
                    d.this.eLO.R(false);
                    d.this.eLO.S(d.this.zB);
                    d.this.eLO.q(d.this.mPageContext.getPageActivity());
                    d.this.eLP = true;
                    d.this.bby();
                    d.this.mHandler.postDelayed(d.this.eMe, d.this.eLV);
                }
            }
        }
    };
    private Runnable eMe = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eLO != null) {
                d.this.eLO.dismiss();
            }
        }
    };

    public void pZ(int i) {
        this.eMa = i;
    }

    public void qa(int i) {
        this.eLZ = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.bZf = 0;
        this.eLW = 0;
        this.eLX = 0;
        this.eLY = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bZf = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eLW = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eLX = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.eLY = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bby() {
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt(this.eLQ, this.eLS + 1);
    }

    public void cI(String str, String str2) {
        u(str, str2, false);
    }

    public void u(String str, String str2, boolean z) {
        if (!this.eLP && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.eLQ = str2;
            this.eLS = com.baidu.tbadk.core.sharedPref.b.ahO().getInt(str2, 0);
            if (this.eLS < this.eLT) {
                if (z) {
                    bby();
                    this.eLP = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.eMd, this.eLU);
            }
        }
    }

    public void vI(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.eMd, this.eLU);
        }
    }

    public void bbz() {
        if (this.eLO != null) {
            this.eLO.dismiss();
            this.eLO = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eMd);
            this.mHandler.removeCallbacks(this.eMe);
        }
    }

    public void qb(int i) {
        if (i > 0) {
            this.eLR = i;
        }
    }

    public void qc(int i) {
        if (i > 0) {
            this.eLV = i;
        }
    }

    public void qd(int i) {
        if (i > 0) {
            this.eLT = i;
        }
    }

    public void qe(int i) {
        this.mXOffset = i;
    }

    public void setYOffset(int i) {
        this.mYOffset = i;
    }

    public void t(int i, int i2, int i3, int i4) {
        this.bZf = i;
        this.eLW = i2;
        this.eLX = i3;
        this.eLY = i4;
    }

    public void q(View.OnClickListener onClickListener) {
        this.eMb = onClickListener;
    }

    public void iR(boolean z) {
        this.eMc = z;
    }

    public boolean bbA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void S(boolean z) {
        this.zB = z;
    }
}
