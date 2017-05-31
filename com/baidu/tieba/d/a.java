package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext ajh;
    private boolean bJd;
    private String bJe;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d bJc = null;
    private int bJf = w.g.pic_sign_tip;
    private int bJg = 0;
    private int bJh = 1;
    private int bJi = 1000;
    private int bJj = 3000;
    private int ajo = 5;
    private int mYOffset = 0;
    private Runnable bln = new b(this);
    private Runnable bJk = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.ajh = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wd() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.bJe, this.bJg + 1);
    }

    public void aB(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bJd && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bJe = str2;
            this.bJg = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.bJg < this.bJh) {
                if (z) {
                    Wd();
                    this.bJd = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bln, this.bJi);
            }
        }
    }

    public void We() {
        if (this.bJc != null) {
            this.bJc.dismiss();
            this.bJc = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bln);
            this.mHandler.removeCallbacks(this.bJk);
        }
    }

    public void hy(int i) {
        if (i > 0) {
            this.bJj = i;
        }
    }

    public void hz(int i) {
        if (i > 0) {
            this.bJh = i;
        }
    }

    public void hA(int i) {
        this.ajo = i;
    }
}
