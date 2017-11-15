package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private View.OnClickListener baV;
    private boolean cba;
    private String cbb;
    private int cbh;
    private int cbi;
    private int cbj;
    private int cbk;
    private View ju;
    private String mMessage;
    private TbPageContext mPageContext;
    private Handler mHandler = null;
    private c caZ = null;
    private int cbc = d.f.pic_sign_tip;
    private int cbd = 0;
    private int cbe = 1;
    private int cbf = 1000;
    private int cbg = 3000;
    private int aVL = 5;
    private int mYOffset = 0;
    private Runnable cbl = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.caZ == null && !StringUtils.isNull(a.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.ju).ad(0).A(true).B(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.mPageContext.getPageActivity());
                        textView.setText(a.this.mMessage);
                        textView.setGravity(17);
                        aj.i(textView, d.C0080d.cp_cont_i);
                        textView.setTextSize(0, a.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                        textView.setHeight(a.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                        textView.setPadding(a.this.cbh, a.this.cbi, a.this.cbj, a.this.cbk);
                        textView.setSingleLine(true);
                        aj.j(textView, a.this.cbc);
                        if (a.this.baV != null) {
                            textView.setOnClickListener(a.this.baV);
                        }
                        return textView;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eW() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eX() {
                        return 48;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return a.this.aVL;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.mYOffset;
                    }
                });
                a.this.caZ = dVar.eY();
                a.this.caZ.y(false);
                a.this.caZ.j(a.this.mPageContext.getPageActivity());
                a.this.cba = true;
                a.this.abP();
                a.this.mHandler.postDelayed(a.this.cbm, a.this.cbg);
            }
        }
    };
    private Runnable cbm = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.caZ != null) {
                a.this.caZ.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.cbh = 0;
        this.cbi = 0;
        this.cbj = 0;
        this.cbk = 0;
        this.mPageContext = tbPageContext;
        this.ju = view;
        this.cbh = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cbi = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cbj = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.cbk = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abP() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.cbb, this.cbd + 1);
    }

    public void aI(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.cba && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.cbb = str2;
            this.cbd = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.cbd < this.cbe) {
                if (z) {
                    abP();
                    this.cba = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.cbl, this.cbf);
            }
        }
    }

    public void jX(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.cbl, this.cbf);
        }
    }

    public void abQ() {
        if (this.caZ != null) {
            this.caZ.dismiss();
            this.caZ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cbl);
            this.mHandler.removeCallbacks(this.cbm);
        }
    }

    public void iu(int i) {
        if (i > 0) {
            this.cbc = i;
        }
    }

    public void iv(int i) {
        if (i > 0) {
            this.cbg = i;
        }
    }

    public void iw(int i) {
        if (i > 0) {
            this.cbe = i;
        }
    }

    public void ix(int i) {
        this.aVL = i;
    }

    public void iy(int i) {
        this.mYOffset = i;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cbh = i;
        this.cbi = i2;
        this.cbj = i3;
        this.cbk = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.baV = onClickListener;
    }
}
