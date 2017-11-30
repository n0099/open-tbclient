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
    private View.OnClickListener bef;
    private int cjE;
    private int cjF;
    private int cjG;
    private int cjH;
    private boolean cjK;
    private boolean cjx;
    private String cjy;
    private View ju;
    private String mMessage;
    private TbPageContext mPageContext;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c cjw = null;
    private int cjz = d.f.pic_sign_tip;
    private int cjA = 0;
    private int cjB = 1;
    private int cjC = 1000;
    private int cjD = 3000;
    private int aYM = 5;
    private int mYOffset = 0;
    private int cjI = 48;
    private int cjJ = 4;
    private Runnable cjL = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cjw == null && !StringUtils.isNull(b.this.mMessage)) {
                if (!b.this.cjK || b.this.adA()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.o(b.this.ju).ad(0).A(true).B(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(b.this.mPageContext.getPageActivity());
                            textView.setText(b.this.mMessage);
                            textView.setGravity(17);
                            aj.i(textView, d.C0082d.cp_cont_i);
                            textView.setTextSize(0, b.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(b.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(b.this.cjE, b.this.cjF, b.this.cjG, b.this.cjH);
                            textView.setSingleLine(true);
                            aj.j(textView, b.this.cjz);
                            if (b.this.bef != null) {
                                textView.setOnClickListener(b.this.bef);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eW() {
                            return b.this.cjJ;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int eX() {
                            return b.this.cjI;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return b.this.aYM;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return b.this.mYOffset;
                        }
                    });
                    b.this.cjw = dVar.eY();
                    b.this.cjw.y(false);
                    b.this.cjw.j(b.this.mPageContext.getPageActivity());
                    b.this.cjx = true;
                    b.this.ady();
                    b.this.mHandler.postDelayed(b.this.cjM, b.this.cjD);
                }
            }
        }
    };
    private Runnable cjM = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cjw != null) {
                b.this.cjw.dismiss();
            }
        }
    };

    public void iR(int i) {
        this.cjI = i;
    }

    public b(TbPageContext tbPageContext, View view) {
        this.cjE = 0;
        this.cjF = 0;
        this.cjG = 0;
        this.cjH = 0;
        this.mPageContext = tbPageContext;
        this.ju = view;
        this.cjE = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjF = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjG = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cjH = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ady() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cjy, this.cjA + 1);
    }

    public void aK(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cjx && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.cjy = str2;
            this.cjA = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cjA < this.cjB) {
                if (z) {
                    ady();
                    this.cjx = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cjL, this.cjC);
            }
        }
    }

    public void kf(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cjL, this.cjC);
        }
    }

    public void adz() {
        if (this.cjw != null) {
            this.cjw.dismiss();
            this.cjw = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cjL);
            this.mHandler.removeCallbacks(this.cjM);
        }
    }

    public void iS(int i) {
        if (i > 0) {
            this.cjz = i;
        }
    }

    public void iT(int i) {
        if (i > 0) {
            this.cjD = i;
        }
    }

    public void iU(int i) {
        if (i > 0) {
            this.cjB = i;
        }
    }

    public void iV(int i) {
        this.aYM = i;
    }

    public void iW(int i) {
        this.mYOffset = i;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cjE = i;
        this.cjF = i2;
        this.cjG = i3;
        this.cjH = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.bef = onClickListener;
    }

    public void ef(boolean z) {
        this.cjK = z;
    }

    public boolean adA() {
        return this.ju != null && this.ju.getVisibility() == 0 && ((double) this.ju.getAlpha()) >= 0.4d;
    }
}
