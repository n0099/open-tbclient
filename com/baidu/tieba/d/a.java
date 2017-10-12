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
    private int bTA;
    private int bTB;
    private int bTC;
    private int bTD;
    private boolean bTv;
    private String bTw;
    private View.OnClickListener bat;
    private View ju;
    private TbPageContext mG;
    private String mMessage;
    private Handler mHandler = null;
    private c bTu = null;
    private int bTx = d.g.pic_sign_tip;
    private int bTy = 0;
    private int bTz = 1;
    private int bxm = 1000;
    private int bxl = 3000;
    private int aVG = 5;
    private int mYOffset = 0;
    private Runnable bTE = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bTu == null && !StringUtils.isNull(a.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.ju).ad(0).A(true).B(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.mG.getPageActivity());
                        textView.setText(a.this.mMessage);
                        textView.setGravity(17);
                        aj.i(textView, d.e.cp_cont_i);
                        textView.setTextSize(0, a.this.mG.getResources().getDimensionPixelSize(d.f.fontsize28));
                        textView.setHeight(a.this.mG.getResources().getDimensionPixelSize(d.f.ds76));
                        textView.setPadding(a.this.bTA, a.this.bTB, a.this.bTC, a.this.bTD);
                        textView.setSingleLine(true);
                        aj.j(textView, a.this.bTx);
                        if (a.this.bat != null) {
                            textView.setOnClickListener(a.this.bat);
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
                        return a.this.aVG;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.mYOffset;
                    }
                });
                a.this.bTu = dVar.eY();
                a.this.bTu.y(false);
                a.this.bTu.j(a.this.mG.getPageActivity());
                a.this.bTv = true;
                a.this.Zy();
                a.this.mHandler.postDelayed(a.this.bTF, a.this.bxl);
            }
        }
    };
    private Runnable bTF = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bTu != null) {
                a.this.bTu.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.bTA = 0;
        this.bTB = 0;
        this.bTC = 0;
        this.bTD = 0;
        this.mG = tbPageContext;
        this.ju = view;
        this.bTA = this.mG.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTB = this.mG.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTC = this.mG.getResources().getDimensionPixelSize(d.f.ds24);
        this.bTD = this.mG.getResources().getDimensionPixelSize(d.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zy() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bTw, this.bTy + 1);
    }

    public void aM(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.bTv && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.bTw = str2;
            this.bTy = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bTy < this.bTz) {
                if (z) {
                    Zy();
                    this.bTv = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bTE, this.bxm);
            }
        }
    }

    public void jz(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bTE, this.bxm);
        }
    }

    public void Zz() {
        if (this.bTu != null) {
            this.bTu.dismiss();
            this.bTu = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bTE);
            this.mHandler.removeCallbacks(this.bTF);
        }
    }

    public void ie(int i) {
        if (i > 0) {
            this.bTx = i;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m11if(int i) {
        if (i > 0) {
            this.bxl = i;
        }
    }

    public void ig(int i) {
        if (i > 0) {
            this.bTz = i;
        }
    }

    public void ih(int i) {
        this.aVG = i;
    }

    public void ii(int i) {
        this.mYOffset = i;
    }

    public void l(int i, int i2, int i3, int i4) {
        this.bTA = i;
        this.bTB = i2;
        this.bTC = i3;
        this.bTD = i4;
    }

    public void i(View.OnClickListener onClickListener) {
        this.bat = onClickListener;
    }
}
