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
    private boolean cyR;
    private String cyS;
    private int cyY;
    private int cyZ;
    private int cza;
    private int czb;
    private View.OnClickListener cze;
    private boolean czf;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cyQ = null;
    private int cyT = d.f.pic_sign_tip;
    private int cyU = 0;
    private int cyV = 1;
    private int cyW = 1000;
    private int cyX = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int czc = 48;
    private int czd = 4;
    private boolean sE = false;
    private Runnable czg = new Runnable() { // from class: com.baidu.tieba.d.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cyQ == null && !StringUtils.isNull(c.this.mMessage)) {
                if (!c.this.czf || c.this.ahg()) {
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
                            textView.setPadding(c.this.cyY, c.this.cyZ, c.this.cza, c.this.czb);
                            textView.setSingleLine(true);
                            ak.i(textView, c.this.cyT);
                            if (c.this.cze != null) {
                                textView.setOnClickListener(c.this.cze);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eF() {
                            return c.this.czd;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eG() {
                            return c.this.czc;
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
                    c.this.cyQ = dVar.eH();
                    c.this.cyQ.A(false);
                    c.this.cyQ.B(c.this.sE);
                    c.this.cyQ.l(c.this.mPageContext.getPageActivity());
                    c.this.cyR = true;
                    c.this.ahe();
                    c.this.mHandler.postDelayed(c.this.czh, c.this.cyX);
                }
            }
        }
    };
    private Runnable czh = new Runnable() { // from class: com.baidu.tieba.d.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cyQ != null) {
                c.this.cyQ.dismiss();
            }
        }
    };

    public void ja(int i) {
        this.czd = i;
    }

    public void jb(int i) {
        this.czc = i;
    }

    public c(TbPageContext tbPageContext, View view2) {
        this.cyY = 0;
        this.cyZ = 0;
        this.cza = 0;
        this.czb = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view2;
        this.cyY = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cyZ = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cza = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.czb = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahe() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cyS, this.cyU + 1);
    }

    public void aJ(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.cyR && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cyS = str2;
            this.cyU = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cyU < this.cyV) {
                if (z) {
                    ahe();
                    this.cyR = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.czg, this.cyW);
            }
        }
    }

    public void kM(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.czg, this.cyW);
        }
    }

    public void ahf() {
        if (this.cyQ != null) {
            this.cyQ.dismiss();
            this.cyQ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.czg);
            this.mHandler.removeCallbacks(this.czh);
        }
    }

    public void jc(int i) {
        if (i > 0) {
            this.cyT = i;
        }
    }

    public void jd(int i) {
        if (i > 0) {
            this.cyX = i;
        }
    }

    public void je(int i) {
        if (i > 0) {
            this.cyV = i;
        }
    }

    public void jf(int i) {
        this.mXOffset = i;
    }

    public void jg(int i) {
        this.mYOffset = i;
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cyY = i;
        this.cyZ = i2;
        this.cza = i3;
        this.czb = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.cze = onClickListener;
    }

    public void eG(boolean z) {
        this.czf = z;
    }

    public boolean ahg() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void B(boolean z) {
        this.sE = z;
    }
}
