package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private View.OnClickListener aYX;
    private boolean bPZ;
    private String bQa;
    private int bQi;
    private int bQj;
    private int bQk;
    private int bQl;
    private View jv;
    private String mMessage;
    private TbPageContext oW;
    private Handler mHandler = null;
    private c bPY = null;
    private int bQb = d.g.pic_sign_tip;
    private int bQc = 0;
    private int bQd = 1;
    private int buc = 1000;
    private int bub = 3000;
    private int amb = 5;
    private int amc = 0;
    private Runnable bQe = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bPY == null && !StringUtils.isNull(b.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(b.this.jv).ag(0).z(true).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(b.this.oW.getPageActivity());
                        textView.setText(b.this.mMessage);
                        textView.setGravity(17);
                        ai.i(textView, d.e.cp_cont_i);
                        textView.setTextSize(0, b.this.oW.getResources().getDimensionPixelSize(d.f.fontsize28));
                        textView.setHeight(b.this.oW.getResources().getDimensionPixelSize(d.f.ds76));
                        textView.setPadding(b.this.bQi, b.this.bQj, b.this.bQk, b.this.bQl);
                        textView.setSingleLine(true);
                        ai.j(textView, b.this.bQb);
                        if (b.this.aYX != null) {
                            textView.setOnClickListener(b.this.aYX);
                        }
                        return textView;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int fi() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int fj() {
                        return 48;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return b.this.amb;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return b.this.amc;
                    }
                });
                b.this.bPY = dVar.fk();
                b.this.bPY.x(false);
                b.this.bPY.j(b.this.oW.getPageActivity());
                b.this.bPZ = true;
                b.this.Yz();
                b.this.mHandler.postDelayed(b.this.bQf, b.this.bub);
            }
        }
    };
    private Runnable bQf = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bPY != null) {
                b.this.bPY.dismiss();
            }
        }
    };

    public b(TbPageContext tbPageContext, View view) {
        this.bQi = 0;
        this.bQj = 0;
        this.bQk = 0;
        this.bQl = 0;
        this.oW = tbPageContext;
        this.jv = view;
        this.bQi = this.oW.getResources().getDimensionPixelSize(d.f.ds24);
        this.bQj = this.oW.getResources().getDimensionPixelSize(d.f.ds24);
        this.bQk = this.oW.getResources().getDimensionPixelSize(d.f.ds24);
        this.bQl = this.oW.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yz() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bQa, this.bQc + 1);
    }

    public void aI(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bPZ && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bQa = str2;
            this.bQc = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bQc < this.bQd) {
                if (z) {
                    Yz();
                    this.bPZ = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bQe, this.buc);
            }
        }
    }

    public void YA() {
        if (this.bPY != null) {
            this.bPY.dismiss();
            this.bPY = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bQe);
            this.mHandler.removeCallbacks(this.bQf);
        }
    }

    public void hJ(int i) {
        if (i > 0) {
            this.bQb = i;
        }
    }

    public void hK(int i) {
        if (i > 0) {
            this.bub = i;
        }
    }

    public void hM(int i) {
        if (i > 0) {
            this.bQd = i;
        }
    }

    public void hN(int i) {
        this.amb = i;
    }

    public void hO(int i) {
        this.amc = i;
    }

    public void l(int i, int i2, int i3, int i4) {
        this.bQi = i;
        this.bQj = i2;
        this.bQk = i3;
        this.bQl = i4;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aYX = onClickListener;
    }
}
