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
    private boolean cxL;
    private String cxM;
    private int cxS;
    private int cxT;
    private int cxU;
    private int cxV;
    private View.OnClickListener cxY;
    private boolean cxZ;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cxK = null;
    private int cxN = d.f.pic_sign_tip;
    private int cxO = 0;
    private int cxP = 1;
    private int cxQ = 1000;
    private int cxR = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cxW = 48;
    private int cxX = 4;
    private boolean sF = false;
    private Runnable cya = new Runnable() { // from class: com.baidu.tieba.d.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cxK == null && !StringUtils.isNull(c.this.mMessage)) {
                if (!c.this.cxZ || c.this.ahg()) {
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
                            textView.setPadding(c.this.cxS, c.this.cxT, c.this.cxU, c.this.cxV);
                            textView.setSingleLine(true);
                            ak.i(textView, c.this.cxN);
                            if (c.this.cxY != null) {
                                textView.setOnClickListener(c.this.cxY);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eF() {
                            return c.this.cxX;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eG() {
                            return c.this.cxW;
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
                    c.this.cxK = dVar.eH();
                    c.this.cxK.A(false);
                    c.this.cxK.B(c.this.sF);
                    c.this.cxK.l(c.this.mPageContext.getPageActivity());
                    c.this.cxL = true;
                    c.this.ahe();
                    c.this.mHandler.postDelayed(c.this.cyb, c.this.cxR);
                }
            }
        }
    };
    private Runnable cyb = new Runnable() { // from class: com.baidu.tieba.d.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cxK != null) {
                c.this.cxK.dismiss();
            }
        }
    };

    public void jb(int i) {
        this.cxX = i;
    }

    public void jc(int i) {
        this.cxW = i;
    }

    public c(TbPageContext tbPageContext, View view2) {
        this.cxS = 0;
        this.cxT = 0;
        this.cxU = 0;
        this.cxV = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view2;
        this.cxS = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cxT = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cxU = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cxV = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahe() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cxM, this.cxO + 1);
    }

    public void aJ(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.cxL && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cxM = str2;
            this.cxO = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cxO < this.cxP) {
                if (z) {
                    ahe();
                    this.cxL = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cya, this.cxQ);
            }
        }
    }

    public void kJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cya, this.cxQ);
        }
    }

    public void ahf() {
        if (this.cxK != null) {
            this.cxK.dismiss();
            this.cxK = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cya);
            this.mHandler.removeCallbacks(this.cyb);
        }
    }

    public void jd(int i) {
        if (i > 0) {
            this.cxN = i;
        }
    }

    public void je(int i) {
        if (i > 0) {
            this.cxR = i;
        }
    }

    public void jf(int i) {
        if (i > 0) {
            this.cxP = i;
        }
    }

    public void jg(int i) {
        this.mXOffset = i;
    }

    public void jh(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cxS = i;
        this.cxT = i2;
        this.cxU = i3;
        this.cxV = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.cxY = onClickListener;
    }

    public void eF(boolean z) {
        this.cxZ = z;
    }

    public boolean ahg() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void B(boolean z) {
        this.sF = z;
    }
}
