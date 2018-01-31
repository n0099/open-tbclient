package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class b {
    private int ddA;
    private int ddB;
    private int ddC;
    private View.OnClickListener ddF;
    private boolean ddG;
    private boolean ddr;
    private String dds;
    private int ddz;
    private String mMessage;
    private TbPageContext mPageContext;
    private View yH;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c ddq = null;
    private int ddt = d.f.pic_sign_tip;
    private int ddv = 0;
    private int ddw = 1;
    private int ddx = 1000;
    private int ddy = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int Ie = 5;
    private int mYOffset = 0;
    private int ddD = 48;
    private int ddE = 4;
    private Runnable ddH = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ddq == null && !StringUtils.isNull(b.this.mMessage)) {
                if (!b.this.ddG || b.this.amx()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.aG(b.this.yH).cW(0).ah(true).ai(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(b.this.mPageContext.getPageActivity());
                            textView.setText(b.this.mMessage);
                            textView.setGravity(17);
                            aj.r(textView, d.C0108d.cp_cont_i);
                            textView.setTextSize(0, b.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(b.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(b.this.ddz, b.this.ddA, b.this.ddB, b.this.ddC);
                            textView.setSingleLine(true);
                            aj.s(textView, b.this.ddt);
                            if (b.this.ddF != null) {
                                textView.setOnClickListener(b.this.ddF);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mB() {
                            return b.this.ddE;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mC() {
                            return b.this.ddD;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return b.this.Ie;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return b.this.mYOffset;
                        }
                    });
                    b.this.ddq = dVar.mD();
                    b.this.ddq.af(false);
                    b.this.ddq.j(b.this.mPageContext.getPageActivity());
                    b.this.ddr = true;
                    b.this.amv();
                    b.this.mHandler.postDelayed(b.this.ddI, b.this.ddy);
                }
            }
        }
    };
    private Runnable ddI = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ddq != null) {
                b.this.ddq.dismiss();
            }
        }
    };

    public void lU(int i) {
        this.ddD = i;
    }

    public b(TbPageContext tbPageContext, View view) {
        this.ddz = 0;
        this.ddA = 0;
        this.ddB = 0;
        this.ddC = 0;
        this.mPageContext = tbPageContext;
        this.yH = view;
        this.ddz = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ddA = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ddB = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ddC = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amv() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dds, this.ddv + 1);
    }

    public void aJ(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.ddr && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.yH != null && this.yH.getVisibility() == 0) {
            this.mMessage = str;
            this.dds = str2;
            this.ddv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.ddv < this.ddw) {
                if (z) {
                    amv();
                    this.ddr = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ddH, this.ddx);
            }
        }
    }

    public void ky(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.ddH, this.ddx);
        }
    }

    public void amw() {
        if (this.ddq != null) {
            this.ddq.dismiss();
            this.ddq = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ddH);
            this.mHandler.removeCallbacks(this.ddI);
        }
    }

    public void lV(int i) {
        if (i > 0) {
            this.ddt = i;
        }
    }

    public void lW(int i) {
        if (i > 0) {
            this.ddy = i;
        }
    }

    public void lX(int i) {
        if (i > 0) {
            this.ddw = i;
        }
    }

    public void lY(int i) {
        this.Ie = i;
    }

    public void lZ(int i) {
        this.mYOffset = i;
    }

    public void v(int i, int i2, int i3, int i4) {
        this.ddz = i;
        this.ddA = i2;
        this.ddB = i3;
        this.ddC = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.ddF = onClickListener;
    }

    public void eT(boolean z) {
        this.ddG = z;
    }

    public boolean amx() {
        return this.yH != null && this.yH.getVisibility() == 0 && ((double) this.yH.getAlpha()) >= 0.4d;
    }
}
