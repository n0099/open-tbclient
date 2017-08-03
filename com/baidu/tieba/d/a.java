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
    private View.OnClickListener aXK;
    private TbPageContext ako;
    private boolean bOf;
    private String bOg;
    private View jv;
    private Handler mHandler = null;
    private c bOe = null;
    private int bOh = d.g.pic_sign_tip;
    private int bOi = 0;
    private int bOj = 1;
    private int bsB = 1000;
    private int bsA = 3000;
    private int akG = 0;
    private int akH = 0;
    private Runnable btj = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bOe == null && a.this.ako != null && a.this.ako.getPageActivity() != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.jv).ad(0).z(true).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.ako.getPageActivity());
                        textView.setHeight(k.ag(a.this.ako.getPageActivity()));
                        textView.setWidth(k.af(a.this.ako.getPageActivity()));
                        ai.j(textView, a.this.bOh);
                        if (a.this.aXK != null) {
                            textView.setOnClickListener(a.this.aXK);
                        }
                        return textView;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eX() {
                        return 5;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eY() {
                        return 32;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return a.this.akG;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.akH;
                    }
                });
                a.this.bOe = dVar.eZ();
                a.this.bOe.x(false);
                a.this.bOe.j(a.this.ako.getPageActivity());
                a.this.bOf = true;
                a.this.Yc();
                if (a.this.bsA > 0) {
                    a.this.mHandler.postDelayed(a.this.bOk, a.this.bsA);
                }
            }
        }
    };
    private Runnable bOk = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bOe != null) {
                a.this.bOe.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.ako = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yc() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bOg, this.bOi + 1);
    }

    public void jk(String str) {
        B(str, false);
    }

    public void B(String str, boolean z) {
        if (!this.bOf && !StringUtils.isNull(str) && this.jv != null && this.jv.getVisibility() == 0) {
            this.bOg = str;
            this.bOi = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str, 0);
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
        this.bsA = i;
    }

    public void hJ(int i) {
        this.bsB = i;
    }

    public void hK(int i) {
        if (i > 0) {
            this.bOj = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aXK = onClickListener;
    }
}
