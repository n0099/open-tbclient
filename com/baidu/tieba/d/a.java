package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext ajP;
    private boolean bJV;
    private String bJW;
    private int bKc;
    private int bKd;
    private int bKe;
    private int bKf;
    private View.OnClickListener bKg;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d bJU = null;
    private int bJX = w.g.pic_sign_tip;
    private int bJY = 0;
    private int bJZ = 1;
    private int bKa = 1000;
    private int bKb = 3000;
    private int ajW = 5;
    private int ajX = 0;
    private Runnable bpd = new b(this);
    private Runnable bKh = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.bKc = 0;
        this.bKd = 0;
        this.bKe = 0;
        this.bKf = 0;
        this.ajP = tbPageContext;
        this.jv = view;
        this.bKc = this.ajP.getResources().getDimensionPixelSize(w.f.ds24);
        this.bKd = this.ajP.getResources().getDimensionPixelSize(w.f.ds24);
        this.bKe = this.ajP.getResources().getDimensionPixelSize(w.f.ds24);
        this.bKf = this.ajP.getResources().getDimensionPixelSize(w.f.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xu() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bJW, this.bJY + 1);
    }

    public void aG(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bJV && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bJW = str2;
            this.bJY = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bJY < this.bJZ) {
                if (z) {
                    Xu();
                    this.bJV = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bpd, this.bKa);
            }
        }
    }

    public void Xv() {
        if (this.bJU != null) {
            this.bJU.dismiss();
            this.bJU = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bpd);
            this.mHandler.removeCallbacks(this.bKh);
        }
    }

    public void hB(int i) {
        if (i > 0) {
            this.bJX = i;
        }
    }

    public void hC(int i) {
        if (i > 0) {
            this.bKb = i;
        }
    }

    public void hD(int i) {
        if (i > 0) {
            this.bJZ = i;
        }
    }

    public void hE(int i) {
        this.ajW = i;
    }

    public void hF(int i) {
        this.ajX = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bKc = i;
        this.bKd = i2;
        this.bKe = i3;
        this.bKf = i4;
    }

    public void o(View.OnClickListener onClickListener) {
        this.bKg = onClickListener;
    }
}
