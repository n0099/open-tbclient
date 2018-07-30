package com.baidu.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private boolean cId;
    private String cIe;
    private int cIk;
    private int cIl;
    private int cIm;
    private int cIn;
    private View.OnClickListener cIq;
    private boolean cIr;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cIc = null;
    private int cIf = d.f.pic_sign_tip;
    private int cIg = 0;
    private int cIh = 1;
    private int cIi = 1000;
    private int cIj = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int cIo = 48;
    private int cIp = 4;
    private boolean yH = false;
    private Runnable cIs = new Runnable() { // from class: com.baidu.tieba.c.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cIc == null && !StringUtils.isNull(d.this.mMessage)) {
                if (!d.this.cIr || d.this.akN()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(d.this.mTargetView).X(0).E(true).F(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.c.d.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(d.this.mPageContext.getPageActivity());
                            textView.setText(d.this.mMessage);
                            textView.setGravity(17);
                            am.h(textView, d.C0140d.cp_cont_i);
                            textView.setTextSize(0, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(d.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(d.this.cIk, d.this.cIl, d.this.cIm, d.this.cIn);
                            textView.setSingleLine(true);
                            am.i(textView, d.this.cIf);
                            if (d.this.cIq != null) {
                                textView.setOnClickListener(d.this.cIq);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hw() {
                            return d.this.cIp;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int hx() {
                            return d.this.cIo;
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
                    d.this.cIc = dVar.hy();
                    d.this.cIc.B(false);
                    d.this.cIc.C(d.this.yH);
                    d.this.cIc.k(d.this.mPageContext.getPageActivity());
                    d.this.cId = true;
                    d.this.akL();
                    d.this.mHandler.postDelayed(d.this.cIt, d.this.cIj);
                }
            }
        }
    };
    private Runnable cIt = new Runnable() { // from class: com.baidu.tieba.c.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.cIc != null) {
                d.this.cIc.dismiss();
            }
        }
    };

    public void jn(int i) {
        this.cIp = i;
    }

    public void jo(int i) {
        this.cIo = i;
    }

    public d(TbPageContext tbPageContext, View view) {
        this.cIk = 0;
        this.cIl = 0;
        this.cIm = 0;
        this.cIn = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.cIk = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cIl = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cIm = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cIn = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cIe, this.cIg + 1);
    }

    public void aO(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cId && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.cIe = str2;
            this.cIg = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cIg < this.cIh) {
                if (z) {
                    akL();
                    this.cId = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cIs, this.cIi);
            }
        }
    }

    public void ll(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cIs, this.cIi);
        }
    }

    public void akM() {
        if (this.cIc != null) {
            this.cIc.dismiss();
            this.cIc = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cIs);
            this.mHandler.removeCallbacks(this.cIt);
        }
    }

    public void jp(int i) {
        if (i > 0) {
            this.cIf = i;
        }
    }

    public void jq(int i) {
        if (i > 0) {
            this.cIj = i;
        }
    }

    public void jr(int i) {
        if (i > 0) {
            this.cIh = i;
        }
    }

    public void js(int i) {
        this.mXOffset = i;
    }

    public void jt(int i) {
        this.mYOffset = i;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cIk = i;
        this.cIl = i2;
        this.cIm = i3;
        this.cIn = i4;
    }

    public void k(View.OnClickListener onClickListener) {
        this.cIq = onClickListener;
    }

    public void eL(boolean z) {
        this.cIr = z;
    }

    public boolean akN() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }

    public void C(boolean z) {
        this.yH = z;
    }
}
