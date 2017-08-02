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
    private View.OnClickListener aXK;
    private TbPageContext ako;
    private boolean bOf;
    private String bOg;
    private int bOn;
    private int bOo;
    private int bOp;
    private int bOq;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private c bOe = null;
    private int bOh = d.g.pic_sign_tip;
    private int bOi = 0;
    private int bOj = 1;
    private int bsB = 1000;
    private int bsA = 3000;
    private int akG = 5;
    private int akH = 0;
    private Runnable btj = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bOe == null && !StringUtils.isNull(b.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(b.this.jv).ad(0).z(true).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(b.this.ako.getPageActivity());
                        textView.setText(b.this.mMessage);
                        textView.setGravity(17);
                        ai.i(textView, d.e.cp_cont_i);
                        textView.setTextSize(0, b.this.ako.getResources().getDimensionPixelSize(d.f.fontsize28));
                        textView.setHeight(b.this.ako.getResources().getDimensionPixelSize(d.f.ds76));
                        textView.setPadding(b.this.bOn, b.this.bOo, b.this.bOp, b.this.bOq);
                        textView.setSingleLine(true);
                        ai.j(textView, b.this.bOh);
                        if (b.this.aXK != null) {
                            textView.setOnClickListener(b.this.aXK);
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
                        return b.this.akG;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return b.this.akH;
                    }
                });
                b.this.bOe = dVar.eZ();
                b.this.bOe.x(false);
                b.this.bOe.j(b.this.ako.getPageActivity());
                b.this.bOf = true;
                b.this.Yc();
                b.this.mHandler.postDelayed(b.this.bOk, b.this.bsA);
            }
        }
    };
    private Runnable bOk = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bOe != null) {
                b.this.bOe.dismiss();
            }
        }
    };

    public b(TbPageContext tbPageContext, View view) {
        this.bOn = 0;
        this.bOo = 0;
        this.bOp = 0;
        this.bOq = 0;
        this.ako = tbPageContext;
        this.jv = view;
        this.bOn = this.ako.getResources().getDimensionPixelSize(d.f.ds24);
        this.bOo = this.ako.getResources().getDimensionPixelSize(d.f.ds24);
        this.bOp = this.ako.getResources().getDimensionPixelSize(d.f.ds24);
        this.bOq = this.ako.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yc() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bOg, this.bOi + 1);
    }

    public void aH(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bOf && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bOg = str2;
            this.bOi = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bOi < this.bOj) {
                if (z) {
                    Yc();
                    this.bOf = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.btj, this.bsB);
            }
        }
    }

    public void Yd() {
        if (this.bOe != null) {
            this.bOe.dismiss();
            this.bOe = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.btj);
            this.mHandler.removeCallbacks(this.bOk);
        }
    }

    public void hH(int i) {
        if (i > 0) {
            this.bOh = i;
        }
    }

    public void hI(int i) {
        if (i > 0) {
            this.bsA = i;
        }
    }

    public void hK(int i) {
        if (i > 0) {
            this.bOj = i;
        }
    }

    public void hL(int i) {
        this.akG = i;
    }

    public void hM(int i) {
        this.akH = i;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.bOn = i;
        this.bOo = i2;
        this.bOp = i3;
        this.bOq = i4;
    }

    public void m(View.OnClickListener onClickListener) {
        this.aXK = onClickListener;
    }
}
