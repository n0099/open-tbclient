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
    private boolean bTj;
    private String bTk;
    private int bTo;
    private int bTp;
    private int bTq;
    private int bTr;
    private View.OnClickListener baf;
    private View ju;
    private TbPageContext mH;
    private String mMessage;
    private Handler mHandler = null;
    private c bTi = null;
    private int bTl = d.g.pic_sign_tip;
    private int bTm = 0;
    private int bTn = 1;
    private int bxa = 1000;
    private int bwZ = 3000;
    private int aVt = 5;
    private int mYOffset = 0;
    private Runnable bTs = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bTi == null && !StringUtils.isNull(a.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.ju).ad(0).A(true).B(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.mH.getPageActivity());
                        textView.setText(a.this.mMessage);
                        textView.setGravity(17);
                        aj.i(textView, d.e.cp_cont_i);
                        textView.setTextSize(0, a.this.mH.getResources().getDimensionPixelSize(d.f.fontsize28));
                        textView.setHeight(a.this.mH.getResources().getDimensionPixelSize(d.f.ds76));
                        textView.setPadding(a.this.bTo, a.this.bTp, a.this.bTq, a.this.bTr);
                        textView.setSingleLine(true);
                        aj.j(textView, a.this.bTl);
                        if (a.this.baf != null) {
                            textView.setOnClickListener(a.this.baf);
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
                        return a.this.aVt;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.mYOffset;
                    }
                });
                a.this.bTi = dVar.eY();
                a.this.bTi.y(false);
                a.this.bTi.j(a.this.mH.getPageActivity());
                a.this.bTj = true;
                a.this.Zu();
                a.this.mHandler.postDelayed(a.this.bTt, a.this.bwZ);
            }
        }
    };
    private Runnable bTt = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bTi != null) {
                a.this.bTi.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.bTo = 0;
        this.bTp = 0;
        this.bTq = 0;
        this.bTr = 0;
        this.mH = tbPageContext;
        this.ju = view;
        this.bTo = this.mH.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTp = this.mH.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTq = this.mH.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTr = this.mH.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zu() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bTk, this.bTm + 1);
    }

    public void aL(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.bTj && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.bTk = str2;
            this.bTm = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bTm < this.bTn) {
                if (z) {
                    Zu();
                    this.bTj = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bTs, this.bxa);
            }
        }
    }

    public void jy(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bTs, this.bxa);
        }
    }

    public void Zv() {
        if (this.bTi != null) {
            this.bTi.dismiss();
            this.bTi = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bTs);
            this.mHandler.removeCallbacks(this.bTt);
        }
    }

    public void id(int i) {
        if (i > 0) {
            this.bTl = i;
        }
    }

    public void ie(int i) {
        if (i > 0) {
            this.bwZ = i;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m11if(int i) {
        if (i > 0) {
            this.bTn = i;
        }
    }

    public void ig(int i) {
        this.aVt = i;
    }

    public void ih(int i) {
        this.mYOffset = i;
    }

    public void l(int i, int i2, int i3, int i4) {
        this.bTo = i;
        this.bTp = i2;
        this.bTq = i3;
        this.bTr = i4;
    }

    public void i(View.OnClickListener onClickListener) {
        this.baf = onClickListener;
    }
}
