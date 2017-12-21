package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private View.OnClickListener bek;
    private boolean cjP;
    private String cjQ;
    private int cjW;
    private int cjX;
    private int cjY;
    private int cjZ;
    private boolean ckc;
    private View ju;
    private String mMessage;
    private TbPageContext mPageContext;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cjO = null;
    private int cjR = d.f.pic_sign_tip;
    private int cjS = 0;
    private int cjT = 1;
    private int cjU = 1000;
    private int cjV = 3000;
    private int aYS = 5;
    private int mYOffset = 0;
    private int cka = 48;
    private int ckb = 4;
    private Runnable ckd = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cjO == null && !StringUtils.isNull(b.this.mMessage)) {
                if (!b.this.ckc || b.this.adJ()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(b.this.ju).ac(0).A(true).B(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(b.this.mPageContext.getPageActivity());
                            textView.setText(b.this.mMessage);
                            textView.setGravity(17);
                            aj.i(textView, d.C0095d.cp_cont_i);
                            textView.setTextSize(0, b.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(b.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(b.this.cjW, b.this.cjX, b.this.cjY, b.this.cjZ);
                            textView.setSingleLine(true);
                            aj.j(textView, b.this.cjR);
                            if (b.this.bek != null) {
                                textView.setOnClickListener(b.this.bek);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eW() {
                            return b.this.ckb;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eX() {
                            return b.this.cka;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return b.this.aYS;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return b.this.mYOffset;
                        }
                    });
                    b.this.cjO = dVar.eY();
                    b.this.cjO.y(false);
                    b.this.cjO.j(b.this.mPageContext.getPageActivity());
                    b.this.cjP = true;
                    b.this.adH();
                    b.this.mHandler.postDelayed(b.this.cke, b.this.cjV);
                }
            }
        }
    };
    private Runnable cke = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cjO != null) {
                b.this.cjO.dismiss();
            }
        }
    };

    public void iT(int i) {
        this.cka = i;
    }

    public b(TbPageContext tbPageContext, View view) {
        this.cjW = 0;
        this.cjX = 0;
        this.cjY = 0;
        this.cjZ = 0;
        this.mPageContext = tbPageContext;
        this.ju = view;
        this.cjW = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjX = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjY = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjZ = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adH() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cjQ, this.cjS + 1);
    }

    public void aL(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cjP && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.cjQ = str2;
            this.cjS = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cjS < this.cjT) {
                if (z) {
                    adH();
                    this.cjP = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ckd, this.cjU);
            }
        }
    }

    public void kd(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.ckd, this.cjU);
        }
    }

    public void adI() {
        if (this.cjO != null) {
            this.cjO.dismiss();
            this.cjO = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ckd);
            this.mHandler.removeCallbacks(this.cke);
        }
    }

    public void iU(int i) {
        if (i > 0) {
            this.cjR = i;
        }
    }

    public void iV(int i) {
        if (i > 0) {
            this.cjV = i;
        }
    }

    public void iW(int i) {
        if (i > 0) {
            this.cjT = i;
        }
    }

    public void iX(int i) {
        this.aYS = i;
    }

    public void iY(int i) {
        this.mYOffset = i;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cjW = i;
        this.cjX = i2;
        this.cjY = i3;
        this.cjZ = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.bek = onClickListener;
    }

    public void eg(boolean z) {
        this.ckc = z;
    }

    public boolean adJ() {
        return this.ju != null && this.ju.getVisibility() == 0 && ((double) this.ju.getAlpha()) >= 0.4d;
    }
}
