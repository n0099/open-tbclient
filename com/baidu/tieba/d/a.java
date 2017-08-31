package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.adp.lib.guide.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private View.OnClickListener aYJ;
    private boolean bSS;
    private String bST;
    private int bSX;
    private int bSY;
    private int bSZ;
    private int bTa;
    private View ju;
    private TbPageContext mF;
    private String mMessage;
    private Handler mHandler = null;
    private c bSR = null;
    private int bSU = d.g.pic_sign_tip;
    private int bSV = 0;
    private int bSW = 1;
    private int buO = 1000;
    private int buN = 3000;
    private int alv = 5;
    private int alw = 0;
    private Runnable bTb = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bSR == null && !StringUtils.isNull(a.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.ju).ad(0).A(true).B(true);
                dVar.a(new b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.mF.getPageActivity());
                        textView.setText(a.this.mMessage);
                        textView.setGravity(17);
                        aj.i(textView, d.e.cp_cont_i);
                        textView.setTextSize(0, a.this.mF.getResources().getDimensionPixelSize(d.f.fontsize28));
                        textView.setHeight(a.this.mF.getResources().getDimensionPixelSize(d.f.ds76));
                        textView.setPadding(a.this.bSX, a.this.bSY, a.this.bSZ, a.this.bTa);
                        textView.setSingleLine(true);
                        aj.j(textView, a.this.bSU);
                        if (a.this.aYJ != null) {
                            textView.setOnClickListener(a.this.aYJ);
                        }
                        return textView;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eX() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eY() {
                        return 48;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return a.this.alv;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.alw;
                    }
                });
                a.this.bSR = dVar.eZ();
                a.this.bSR.y(false);
                a.this.bSR.j(a.this.mF.getPageActivity());
                a.this.bSS = true;
                a.this.ZC();
                a.this.mHandler.postDelayed(a.this.bTc, a.this.buN);
            }
        }
    };
    private Runnable bTc = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bSR != null) {
                a.this.bSR.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.bSX = 0;
        this.bSY = 0;
        this.bSZ = 0;
        this.bTa = 0;
        this.mF = tbPageContext;
        this.ju = view;
        this.bSX = this.mF.getResources().getDimensionPixelSize(d.f.ds24);
        this.bSY = this.mF.getResources().getDimensionPixelSize(d.f.ds24);
        this.bSZ = this.mF.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTa = this.mF.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZC() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bST, this.bSV + 1);
    }

    public void aM(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.bSS && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.bST = str2;
            this.bSV = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bSV < this.bSW) {
                if (z) {
                    ZC();
                    this.bSS = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bTb, this.buO);
            }
        }
    }

    public void ZD() {
        if (this.bSR != null) {
            this.bSR.dismiss();
            this.bSR = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bTb);
            this.mHandler.removeCallbacks(this.bTc);
        }
    }

    public void hU(int i) {
        if (i > 0) {
            this.bSU = i;
        }
    }

    public void hV(int i) {
        if (i > 0) {
            this.buN = i;
        }
    }

    public void hW(int i) {
        if (i > 0) {
            this.bSW = i;
        }
    }

    public void hX(int i) {
        this.alv = i;
    }

    public void hY(int i) {
        this.alw = i;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bSX = i;
        this.bSY = i2;
        this.bSZ = i3;
        this.bTa = i4;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aYJ = onClickListener;
    }
}
