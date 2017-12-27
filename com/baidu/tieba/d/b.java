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
    private int cYA;
    private int cYB;
    private int cYC;
    private View.OnClickListener cYF;
    private boolean cYG;
    private boolean cYs;
    private String cYt;
    private int cYz;
    private String mMessage;
    private TbPageContext mPageContext;
    private View yH;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cYr = null;
    private int cYu = d.f.pic_sign_tip;
    private int cYv = 0;
    private int cYw = 1;
    private int cYx = 1000;
    private int cYy = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int Ie = 5;
    private int mYOffset = 0;
    private int cYD = 48;
    private int cYE = 4;
    private Runnable cYH = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cYr == null && !StringUtils.isNull(b.this.mMessage)) {
                if (!b.this.cYG || b.this.alp()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.aG(b.this.yH).cW(0).ag(true).ah(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(b.this.mPageContext.getPageActivity());
                            textView.setText(b.this.mMessage);
                            textView.setGravity(17);
                            aj.r(textView, d.C0108d.cp_cont_i);
                            textView.setTextSize(0, b.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(b.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(b.this.cYz, b.this.cYA, b.this.cYB, b.this.cYC);
                            textView.setSingleLine(true);
                            aj.s(textView, b.this.cYu);
                            if (b.this.cYF != null) {
                                textView.setOnClickListener(b.this.cYF);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mA() {
                            return b.this.cYE;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mB() {
                            return b.this.cYD;
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
                    b.this.cYr = dVar.mC();
                    b.this.cYr.ae(false);
                    b.this.cYr.j(b.this.mPageContext.getPageActivity());
                    b.this.cYs = true;
                    b.this.aln();
                    b.this.mHandler.postDelayed(b.this.cYI, b.this.cYy);
                }
            }
        }
    };
    private Runnable cYI = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cYr != null) {
                b.this.cYr.dismiss();
            }
        }
    };

    public void lR(int i) {
        this.cYD = i;
    }

    public b(TbPageContext tbPageContext, View view) {
        this.cYz = 0;
        this.cYA = 0;
        this.cYB = 0;
        this.cYC = 0;
        this.mPageContext = tbPageContext;
        this.yH = view;
        this.cYz = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cYA = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cYB = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cYC = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aln() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cYt, this.cYv + 1);
    }

    public void aK(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cYs && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.yH != null && this.yH.getVisibility() == 0) {
            this.mMessage = str;
            this.cYt = str2;
            this.cYv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cYv < this.cYw) {
                if (z) {
                    aln();
                    this.cYs = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cYH, this.cYx);
            }
        }
    }

    public void kj(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cYH, this.cYx);
        }
    }

    public void alo() {
        if (this.cYr != null) {
            this.cYr.dismiss();
            this.cYr = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cYH);
            this.mHandler.removeCallbacks(this.cYI);
        }
    }

    public void lS(int i) {
        if (i > 0) {
            this.cYu = i;
        }
    }

    public void lT(int i) {
        if (i > 0) {
            this.cYy = i;
        }
    }

    public void lU(int i) {
        if (i > 0) {
            this.cYw = i;
        }
    }

    public void lV(int i) {
        this.Ie = i;
    }

    public void lW(int i) {
        this.mYOffset = i;
    }

    public void v(int i, int i2, int i3, int i4) {
        this.cYz = i;
        this.cYA = i2;
        this.cYB = i3;
        this.cYC = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.cYF = onClickListener;
    }

    public void eN(boolean z) {
        this.cYG = z;
    }

    public boolean alp() {
        return this.yH != null && this.yH.getVisibility() == 0 && ((double) this.yH.getAlpha()) >= 0.4d;
    }
}
