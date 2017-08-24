package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private View.OnClickListener aYX;
    private boolean bPZ;
    private String bQa;
    private View jv;
    private TbPageContext oW;
    private Handler mHandler = null;
    private c bPY = null;
    private int bQb = d.g.pic_sign_tip;
    private int bQc = 0;
    private int bQd = 1;
    private int buc = 1000;
    private int bub = 3000;
    private int amb = 0;
    private int amc = 0;
    private Runnable bQe = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bPY == null && a.this.oW != null && a.this.oW.getPageActivity() != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.jv).ag(0).z(true).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.oW.getPageActivity());
                        textView.setHeight(k.ah(a.this.oW.getPageActivity()));
                        textView.setWidth(k.ag(a.this.oW.getPageActivity()));
                        ai.j(textView, a.this.bQb);
                        if (a.this.aYX != null) {
                            textView.setOnClickListener(a.this.aYX);
                        }
                        return textView;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int fi() {
                        return 5;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int fj() {
                        return 32;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return a.this.amb;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.amc;
                    }
                });
                a.this.bPY = dVar.fk();
                a.this.bPY.x(false);
                a.this.bPY.j(a.this.oW.getPageActivity());
                a.this.bPZ = true;
                a.this.Yz();
                if (a.this.bub > 0) {
                    a.this.mHandler.postDelayed(a.this.bQf, a.this.bub);
                }
            }
        }
    };
    private Runnable bQf = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bPY != null) {
                a.this.bPY.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.oW = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yz() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bQa, this.bQc + 1);
    }

    public void jt(String str) {
        B(str, false);
    }

    public void B(String str, boolean z) {
        if (!this.bPZ && !StringUtils.isNull(str) && this.jv != null && this.jv.getVisibility() == 0) {
            this.bQa = str;
            this.bQc = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
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
        this.bub = i;
    }

    public void hL(int i) {
        this.buc = i;
    }

    public void hM(int i) {
        if (i > 0) {
            this.bQd = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYX = onClickListener;
    }
}
