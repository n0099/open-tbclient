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
    private View.OnClickListener beg;
    private boolean cjL;
    private String cjM;
    private int cjS;
    private int cjT;
    private int cjU;
    private int cjV;
    private boolean cjY;
    private View ju;
    private String mMessage;
    private TbPageContext mPageContext;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cjK = null;
    private int cjN = d.f.pic_sign_tip;
    private int cjO = 0;
    private int cjP = 1;
    private int cjQ = 1000;
    private int cjR = 3000;
    private int aYO = 5;
    private int mYOffset = 0;
    private int cjW = 48;
    private int cjX = 4;
    private Runnable cjZ = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cjK == null && !StringUtils.isNull(b.this.mMessage)) {
                if (!b.this.cjY || b.this.adK()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(b.this.ju).ac(0).A(true).B(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(b.this.mPageContext.getPageActivity());
                            textView.setText(b.this.mMessage);
                            textView.setGravity(17);
                            aj.i(textView, d.C0096d.cp_cont_i);
                            textView.setTextSize(0, b.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(b.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(b.this.cjS, b.this.cjT, b.this.cjU, b.this.cjV);
                            textView.setSingleLine(true);
                            aj.j(textView, b.this.cjN);
                            if (b.this.beg != null) {
                                textView.setOnClickListener(b.this.beg);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eW() {
                            return b.this.cjX;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eX() {
                            return b.this.cjW;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return b.this.aYO;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return b.this.mYOffset;
                        }
                    });
                    b.this.cjK = dVar.eY();
                    b.this.cjK.y(false);
                    b.this.cjK.j(b.this.mPageContext.getPageActivity());
                    b.this.cjL = true;
                    b.this.adI();
                    b.this.mHandler.postDelayed(b.this.cka, b.this.cjR);
                }
            }
        }
    };
    private Runnable cka = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cjK != null) {
                b.this.cjK.dismiss();
            }
        }
    };

    public void iT(int i) {
        this.cjW = i;
    }

    public b(TbPageContext tbPageContext, View view) {
        this.cjS = 0;
        this.cjT = 0;
        this.cjU = 0;
        this.cjV = 0;
        this.mPageContext = tbPageContext;
        this.ju = view;
        this.cjS = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjT = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjU = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjV = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adI() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cjM, this.cjO + 1);
    }

    public void aL(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cjL && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.cjM = str2;
            this.cjO = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cjO < this.cjP) {
                if (z) {
                    adI();
                    this.cjL = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cjZ, this.cjQ);
            }
        }
    }

    public void kd(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cjZ, this.cjQ);
        }
    }

    public void adJ() {
        if (this.cjK != null) {
            this.cjK.dismiss();
            this.cjK = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cjZ);
            this.mHandler.removeCallbacks(this.cka);
        }
    }

    public void iU(int i) {
        if (i > 0) {
            this.cjN = i;
        }
    }

    public void iV(int i) {
        if (i > 0) {
            this.cjR = i;
        }
    }

    public void iW(int i) {
        if (i > 0) {
            this.cjP = i;
        }
    }

    public void iX(int i) {
        this.aYO = i;
    }

    public void iY(int i) {
        this.mYOffset = i;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cjS = i;
        this.cjT = i2;
        this.cjU = i3;
        this.cjV = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.beg = onClickListener;
    }

    public void eg(boolean z) {
        this.cjY = z;
    }

    public boolean adK() {
        return this.ju != null && this.ju.getVisibility() == 0 && ((double) this.ju.getAlpha()) >= 0.4d;
    }
}
