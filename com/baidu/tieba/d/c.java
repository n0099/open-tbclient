package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class c {
    private boolean cxI;
    private String cxJ;
    private int cxP;
    private int cxQ;
    private int cxR;
    private int cxS;
    private View.OnClickListener cxV;
    private boolean cxW;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cxH = null;
    private int cxK = d.f.pic_sign_tip;
    private int cxL = 0;
    private int cxM = 1;
    private int cxN = 1000;
    private int cxO = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cxT = 48;
    private int cxU = 4;
    private boolean sF = false;
    private Runnable cxX = new Runnable() { // from class: com.baidu.tieba.d.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cxH == null && !StringUtils.isNull(c.this.mMessage)) {
                if (!c.this.cxW || c.this.ahg()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(c.this.mTargetView).W(0).D(true).E(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.c.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(c.this.mPageContext.getPageActivity());
                            textView.setText(c.this.mMessage);
                            textView.setGravity(17);
                            ak.h(textView, d.C0126d.cp_cont_i);
                            textView.setTextSize(0, c.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(c.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(c.this.cxP, c.this.cxQ, c.this.cxR, c.this.cxS);
                            textView.setSingleLine(true);
                            ak.i(textView, c.this.cxK);
                            if (c.this.cxV != null) {
                                textView.setOnClickListener(c.this.cxV);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eF() {
                            return c.this.cxU;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eG() {
                            return c.this.cxT;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return c.this.mXOffset;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return c.this.mYOffset;
                        }
                    });
                    c.this.cxH = dVar.eH();
                    c.this.cxH.A(false);
                    c.this.cxH.B(c.this.sF);
                    c.this.cxH.l(c.this.mPageContext.getPageActivity());
                    c.this.cxI = true;
                    c.this.ahe();
                    c.this.mHandler.postDelayed(c.this.cxY, c.this.cxO);
                }
            }
        }
    };
    private Runnable cxY = new Runnable() { // from class: com.baidu.tieba.d.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cxH != null) {
                c.this.cxH.dismiss();
            }
        }
    };

    public void jb(int i) {
        this.cxU = i;
    }

    public void jc(int i) {
        this.cxT = i;
    }

    public c(TbPageContext tbPageContext, View view2) {
        this.cxP = 0;
        this.cxQ = 0;
        this.cxR = 0;
        this.cxS = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view2;
        this.cxP = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cxQ = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cxR = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cxS = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahe() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cxJ, this.cxL + 1);
    }

    public void aJ(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.cxI && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cxJ = str2;
            this.cxL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cxL < this.cxM) {
                if (z) {
                    ahe();
                    this.cxI = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cxX, this.cxN);
            }
        }
    }

    public void kJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cxX, this.cxN);
        }
    }

    public void ahf() {
        if (this.cxH != null) {
            this.cxH.dismiss();
            this.cxH = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cxX);
            this.mHandler.removeCallbacks(this.cxY);
        }
    }

    public void jd(int i) {
        if (i > 0) {
            this.cxK = i;
        }
    }

    public void je(int i) {
        if (i > 0) {
            this.cxO = i;
        }
    }

    public void jf(int i) {
        if (i > 0) {
            this.cxM = i;
        }
    }

    public void jg(int i) {
        this.mXOffset = i;
    }

    public void jh(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cxP = i;
        this.cxQ = i2;
        this.cxR = i3;
        this.cxS = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.cxV = onClickListener;
    }

    public void eF(boolean z) {
        this.cxW = z;
    }

    public boolean ahg() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void B(boolean z) {
        this.sF = z;
    }
}
