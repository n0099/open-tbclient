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
    private View.OnClickListener aYG;
    private boolean bTK;
    private String bTL;
    private int bTP;
    private int bTQ;
    private int bTR;
    private int bTS;
    private View ju;
    private TbPageContext mF;
    private String mMessage;
    private Handler mHandler = null;
    private c bTJ = null;
    private int bTM = d.g.pic_sign_tip;
    private int bTN = 0;
    private int bTO = 1;
    private int bvC = 1000;
    private int bvB = 3000;
    private int alu = 5;
    private int mYOffset = 0;
    private Runnable bTT = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bTJ == null && !StringUtils.isNull(a.this.mMessage)) {
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
                        textView.setPadding(a.this.bTP, a.this.bTQ, a.this.bTR, a.this.bTS);
                        textView.setSingleLine(true);
                        aj.j(textView, a.this.bTM);
                        if (a.this.aYG != null) {
                            textView.setOnClickListener(a.this.aYG);
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
                        return a.this.alu;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.mYOffset;
                    }
                });
                a.this.bTJ = dVar.eZ();
                a.this.bTJ.y(false);
                a.this.bTJ.j(a.this.mF.getPageActivity());
                a.this.bTK = true;
                a.this.ZN();
                a.this.mHandler.postDelayed(a.this.bTU, a.this.bvB);
            }
        }
    };
    private Runnable bTU = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bTJ != null) {
                a.this.bTJ.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.bTP = 0;
        this.bTQ = 0;
        this.bTR = 0;
        this.bTS = 0;
        this.mF = tbPageContext;
        this.ju = view;
        this.bTP = this.mF.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTQ = this.mF.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTR = this.mF.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTS = this.mF.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bTL, this.bTN + 1);
    }

    public void aM(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.bTK && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.bTL = str2;
            this.bTN = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bTN < this.bTO) {
                if (z) {
                    ZN();
                    this.bTK = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bTT, this.bvC);
            }
        }
    }

    public void ZO() {
        if (this.bTJ != null) {
            this.bTJ.dismiss();
            this.bTJ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bTT);
            this.mHandler.removeCallbacks(this.bTU);
        }
    }

    public void hW(int i) {
        if (i > 0) {
            this.bTM = i;
        }
    }

    public void hX(int i) {
        if (i > 0) {
            this.bvB = i;
        }
    }

    public void hY(int i) {
        if (i > 0) {
            this.bTO = i;
        }
    }

    public void hZ(int i) {
        this.alu = i;
    }

    public void ia(int i) {
        this.mYOffset = i;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bTP = i;
        this.bTQ = i2;
        this.bTR = i3;
        this.bTS = i4;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aYG = onClickListener;
    }
}
