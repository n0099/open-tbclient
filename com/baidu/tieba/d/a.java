package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.adp.lib.guide.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private View.OnClickListener aYV;
    private TbPageContext alI;
    private boolean bPp;
    private String bPq;
    private int bPu;
    private int bPv;
    private int bPw;
    private int bPx;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private c bPo = null;
    private int bPr = d.g.pic_sign_tip;
    private int bPs = 0;
    private int bPt = 1;
    private int btM = 1000;
    private int btL = 3000;
    private int ama = 5;
    private int amb = 0;
    private Runnable buu = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bPo == null && !StringUtils.isNull(a.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.jv).ag(0).z(true).A(true);
                dVar.a(new b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.alI.getPageActivity());
                        textView.setText(a.this.mMessage);
                        textView.setGravity(17);
                        ai.i(textView, d.e.cp_cont_i);
                        textView.setTextSize(0, a.this.alI.getResources().getDimensionPixelSize(d.f.fontsize28));
                        textView.setHeight(a.this.alI.getResources().getDimensionPixelSize(d.f.ds76));
                        textView.setPadding(a.this.bPu, a.this.bPv, a.this.bPw, a.this.bPx);
                        textView.setSingleLine(true);
                        ai.j(textView, a.this.bPr);
                        if (a.this.aYV != null) {
                            textView.setOnClickListener(a.this.aYV);
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
                        return a.this.ama;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.amb;
                    }
                });
                a.this.bPo = dVar.fk();
                a.this.bPo.x(false);
                a.this.bPo.j(a.this.alI.getPageActivity());
                a.this.bPp = true;
                a.this.Yh();
                a.this.mHandler.postDelayed(a.this.bPy, a.this.btL);
            }
        }
    };
    private Runnable bPy = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bPo != null) {
                a.this.bPo.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.bPu = 0;
        this.bPv = 0;
        this.bPw = 0;
        this.bPx = 0;
        this.alI = tbPageContext;
        this.jv = view;
        this.bPu = this.alI.getResources().getDimensionPixelSize(d.f.ds24);
        this.bPv = this.alI.getResources().getDimensionPixelSize(d.f.ds24);
        this.bPw = this.alI.getResources().getDimensionPixelSize(d.f.ds24);
        this.bPx = this.alI.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bPq, this.bPs + 1);
    }

    public void aH(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bPp && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bPq = str2;
            this.bPs = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bPs < this.bPt) {
                if (z) {
                    Yh();
                    this.bPp = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.buu, this.btM);
            }
        }
    }

    public void Yi() {
        if (this.bPo != null) {
            this.bPo.dismiss();
            this.bPo = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.buu);
            this.mHandler.removeCallbacks(this.bPy);
        }
    }

    public void hI(int i) {
        if (i > 0) {
            this.bPr = i;
        }
    }

    public void hJ(int i) {
        if (i > 0) {
            this.btL = i;
        }
    }

    public void hK(int i) {
        if (i > 0) {
            this.bPt = i;
        }
    }

    public void hL(int i) {
        this.ama = i;
    }

    public void hM(int i) {
        this.amb = i;
    }

    public void l(int i, int i2, int i3, int i4) {
        this.bPu = i;
        this.bPv = i2;
        this.bPw = i3;
        this.bPx = i4;
    }

    public void m(View.OnClickListener onClickListener) {
        this.aYV = onClickListener;
    }
}
