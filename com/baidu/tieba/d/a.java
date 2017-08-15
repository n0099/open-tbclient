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
    private View.OnClickListener aYW;
    private boolean bPY;
    private String bPZ;
    private View jv;
    private TbPageContext oV;
    private Handler mHandler = null;
    private c bPX = null;
    private int bQa = d.g.pic_sign_tip;
    private int bQb = 0;
    private int bQc = 1;
    private int bub = 1000;
    private int bua = 3000;
    private int amb = 0;
    private int amc = 0;
    private Runnable bQd = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bPX == null && a.this.oV != null && a.this.oV.getPageActivity() != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.jv).ag(0).z(true).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.oV.getPageActivity());
                        textView.setHeight(k.ah(a.this.oV.getPageActivity()));
                        textView.setWidth(k.ag(a.this.oV.getPageActivity()));
                        ai.j(textView, a.this.bQa);
                        if (a.this.aYW != null) {
                            textView.setOnClickListener(a.this.aYW);
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
                a.this.bPX = dVar.fk();
                a.this.bPX.x(false);
                a.this.bPX.j(a.this.oV.getPageActivity());
                a.this.bPY = true;
                a.this.YC();
                if (a.this.bua > 0) {
                    a.this.mHandler.postDelayed(a.this.bQe, a.this.bua);
                }
            }
        }
    };
    private Runnable bQe = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bPX != null) {
                a.this.bPX.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.oV = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YC() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bPZ, this.bQb + 1);
    }

    public void jq(String str) {
        B(str, false);
    }

    public void B(String str, boolean z) {
        if (!this.bPY && !StringUtils.isNull(str) && this.jv != null && this.jv.getVisibility() == 0) {
            this.bPZ = str;
            this.bQb = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
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
        this.bua = i;
    }

    public void hL(int i) {
        this.bub = i;
    }

    public void hM(int i) {
        if (i > 0) {
            this.bQc = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYW = onClickListener;
    }
}
