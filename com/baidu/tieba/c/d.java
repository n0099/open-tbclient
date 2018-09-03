package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class d {
    private boolean cIa;
    private String cIb;
    private int cIh;
    private int cIi;
    private int cIj;
    private int cIk;
    private View.OnClickListener cIn;
    private boolean cIo;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cHZ = null;
    private int cIc = f.C0146f.pic_sign_tip;
    private int cId = 0;
    private int cIe = 1;
    private int cIf = 1000;
    private int cIg = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cIl = 48;
    private int cIm = 4;
    private boolean yI = false;
    private Runnable cIp = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cHZ == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.cIo || d.this.akP()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(d.this.mTargetView).X(0).E(true).F(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.h(textView, f.d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(f.e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(f.e.ds76));
                            textView.setPadding(d.this.cIh, d.this.cIi, d.this.cIj, d.this.cIk);
                            textView.setSingleLine(true);
                            am.i(textView, d.this.cIc);
                            if (d.this.cIn != null) {
                                textView.setOnClickListener(d.this.cIn);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hw() {
                            return d.this.cIm;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hx() {
                            return d.this.cIl;
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
                    d.this.cHZ = dVar.hy();
                    d.this.cHZ.B(false);
                    d.this.cHZ.C(d.this.yI);
                    d.this.cHZ.j(d.this.mPageContext.getPageActivity());
                    d.this.cIa = true;
                    d.this.akN();
                    d.this.mHandler.postDelayed(d.this.cIq, d.this.cIg);
                }
            }
        }
    };
    private Runnable cIq = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cHZ != null) {
                d.this.cHZ.dismiss();
            }
        }
    };

    public void jm(int i) {
        this.cIm = i;
    }

    public void jn(int i) {
        this.cIl = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cIh = 0;
        this.cIi = 0;
        this.cIj = 0;
        this.cIk = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cIh = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds24);
        this.cIi = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds24);
        this.cIj = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds24);
        this.cIk = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cIb, this.cId + 1);
    }

    public void aO(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cIa && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cIb = str2;
            this.cId = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cId < this.cIe) {
                if (z) {
                    akN();
                    this.cIa = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cIp, this.cIf);
            }
        }
    }

    public void ln(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cIp, this.cIf);
        }
    }

    public void akO() {
        if (this.cHZ != null) {
            this.cHZ.dismiss();
            this.cHZ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cIp);
            this.mHandler.removeCallbacks(this.cIq);
        }
    }

    public void jo(int i) {
        if (i > 0) {
            this.cIc = i;
        }
    }

    public void jp(int i) {
        if (i > 0) {
            this.cIg = i;
        }
    }

    public void jq(int i) {
        if (i > 0) {
            this.cIe = i;
        }
    }

    public void jr(int i) {
        this.mXOffset = i;
    }

    public void js(int i) {
        this.mYOffset = i;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cIh = i;
        this.cIi = i2;
        this.cIj = i3;
        this.cIk = i4;
    }

    public void k(View.OnClickListener onClickListener) {
        this.cIn = onClickListener;
    }

    public void eL(boolean z) {
        this.cIo = z;
    }

    public boolean akP() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void C(boolean z) {
        this.yI = z;
    }
}
