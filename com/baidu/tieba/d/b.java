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
    private View.OnClickListener aYW;
    private boolean bPY;
    private String bPZ;
    private int bQh;
    private int bQi;
    private int bQj;
    private int bQk;
    private View jv;
    private String mMessage;
    private TbPageContext oV;
    private Handler mHandler = null;
    private c bPX = null;
    private int bQa = d.g.pic_sign_tip;
    private int bQb = 0;
    private int bQc = 1;
    private int bub = 1000;
    private int bua = 3000;
    private int amb = 5;
    private int amc = 0;
    private Runnable bQd = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bPX == null && !StringUtils.isNull(b.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(b.this.jv).ag(0).z(true).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(b.this.oV.getPageActivity());
                        textView.setText(b.this.mMessage);
                        textView.setGravity(17);
                        ai.i(textView, d.e.cp_cont_i);
                        textView.setTextSize(0, b.this.oV.getResources().getDimensionPixelSize(d.f.fontsize28));
                        textView.setHeight(b.this.oV.getResources().getDimensionPixelSize(d.f.ds76));
                        textView.setPadding(b.this.bQh, b.this.bQi, b.this.bQj, b.this.bQk);
                        textView.setSingleLine(true);
                        ai.j(textView, b.this.bQa);
                        if (b.this.aYW != null) {
                            textView.setOnClickListener(b.this.aYW);
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
                b.this.bPX = dVar.fk();
                b.this.bPX.x(false);
                b.this.bPX.j(b.this.oV.getPageActivity());
                b.this.bPY = true;
                b.this.YC();
                b.this.mHandler.postDelayed(b.this.bQe, b.this.bua);
            }
        }
    };
    private Runnable bQe = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bPX != null) {
                b.this.bPX.dismiss();
            }
        }
    };

    public b(TbPageContext tbPageContext, View view) {
        this.bQh = 0;
        this.bQi = 0;
        this.bQj = 0;
        this.bQk = 0;
        this.oV = tbPageContext;
        this.jv = view;
        this.bQh = this.oV.getResources().getDimensionPixelSize(d.f.ds24);
        this.bQi = this.oV.getResources().getDimensionPixelSize(d.f.ds24);
        this.bQj = this.oV.getResources().getDimensionPixelSize(d.f.ds24);
        this.bQk = this.oV.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YC() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bPZ, this.bQb + 1);
    }

    public void aH(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bPY && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bPZ = str2;
            this.bQb = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bQb < this.bQc) {
                if (z) {
                    YC();
                    this.bPY = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bQd, this.bub);
            }
        }
    }

    public void YD() {
        if (this.bPX != null) {
            this.bPX.dismiss();
            this.bPX = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bQd);
            this.mHandler.removeCallbacks(this.bQe);
        }
    }

    public void hJ(int i) {
        if (i > 0) {
            this.bQa = i;
        }
    }

    public void hK(int i) {
        if (i > 0) {
            this.bua = i;
        }
    }

    public void hM(int i) {
        if (i > 0) {
            this.bQc = i;
        }
    }

    public void hN(int i) {
        this.amb = i;
    }

    public void hO(int i) {
        this.amc = i;
    }

    public void l(int i, int i2, int i3, int i4) {
        this.bQh = i;
        this.bQi = i2;
        this.bQj = i3;
        this.bQk = i4;
    }

    public void m(View.OnClickListener onClickListener) {
        this.aYW = onClickListener;
    }
}
