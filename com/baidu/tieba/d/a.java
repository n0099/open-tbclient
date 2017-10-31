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
    private View.OnClickListener baM;
    private boolean caN;
    private String caO;
    private int caU;
    private int caV;
    private int caW;
    private int caX;
    private View ju;
    private String mMessage;
    private TbPageContext mPageContext;
    private Handler mHandler = null;
    private c caM = null;
    private int caP = d.f.pic_sign_tip;
    private int caQ = 0;
    private int caR = 1;
    private int caS = 1000;
    private int caT = 3000;
    private int aVD = 5;
    private int mYOffset = 0;
    private Runnable caY = new Runnable() { // from class: com.baidu.tieba.d.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.caM == null && !StringUtils.isNull(a.this.mMessage)) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(a.this.ju).ad(0).A(true).B(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.a.1.1
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView = new TextView(a.this.mPageContext.getPageActivity());
                        textView.setText(a.this.mMessage);
                        textView.setGravity(17);
                        aj.i(textView, d.C0080d.cp_cont_i);
                        textView.setTextSize(0, a.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                        textView.setHeight(a.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                        textView.setPadding(a.this.caU, a.this.caV, a.this.caW, a.this.caX);
                        textView.setSingleLine(true);
                        aj.j(textView, a.this.caP);
                        if (a.this.baM != null) {
                            textView.setOnClickListener(a.this.baM);
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
                        return a.this.aVD;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return a.this.mYOffset;
                    }
                });
                a.this.caM = dVar.eY();
                a.this.caM.y(false);
                a.this.caM.j(a.this.mPageContext.getPageActivity());
                a.this.caN = true;
                a.this.abD();
                a.this.mHandler.postDelayed(a.this.caZ, a.this.caT);
            }
        }
    };
    private Runnable caZ = new Runnable() { // from class: com.baidu.tieba.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.caM != null) {
                a.this.caM.dismiss();
            }
        }
    };

    public a(TbPageContext tbPageContext, View view) {
        this.caU = 0;
        this.caV = 0;
        this.caW = 0;
        this.caX = 0;
        this.mPageContext = tbPageContext;
        this.ju = view;
        this.caU = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.caV = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.caW = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.caX = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.caO, this.caQ + 1);
    }

    public void aH(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.caN && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.ju != null && this.ju.getVisibility() == 0) {
            this.mMessage = str;
            this.caO = str2;
            this.caQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.caQ < this.caR) {
                if (z) {
                    abD();
                    this.caN = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.caY, this.caS);
            }
        }
    }

    public void jW(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.caY, this.caS);
        }
    }

    public void abE() {
        if (this.caM != null) {
            this.caM.dismiss();
            this.caM = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.caY);
            this.mHandler.removeCallbacks(this.caZ);
        }
    }

    public void iw(int i) {
        if (i > 0) {
            this.caP = i;
        }
    }

    public void ix(int i) {
        if (i > 0) {
            this.caT = i;
        }
    }

    public void iy(int i) {
        if (i > 0) {
            this.caR = i;
        }
    }

    public void iz(int i) {
        this.aVD = i;
    }

    public void iA(int i) {
        this.mYOffset = i;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.caU = i;
        this.caV = i2;
        this.caW = i3;
        this.caX = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.baM = onClickListener;
    }
}
