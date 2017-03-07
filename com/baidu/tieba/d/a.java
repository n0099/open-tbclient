package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext ajF;
    private boolean bBc;
    private String bBd;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d bBb = null;
    private int bBe = w.g.pic_sign_tip;
    private int bBf = 0;
    private int bBg = 1;
    private int bBh = 1000;
    private int bBi = 3000;
    private int ajM = 5;
    private int mYOffset = 0;
    private Runnable bhE = new b(this);
    private Runnable bBj = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.ajF = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui() {
        com.baidu.tbadk.core.sharedPref.b.uo().putInt(this.bBd, this.bBf + 1);
    }

    public void aA(String str, String str2) {
        e(str, str2, false);
    }

    public void e(String str, String str2, boolean z) {
        if (!this.bBc && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bBd = str2;
            this.bBf = com.baidu.tbadk.core.sharedPref.b.uo().getInt(str2, 0);
            if (this.bBf < this.bBg) {
                if (z) {
                    Ui();
                    this.bBc = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bhE, this.bBh);
            }
        }
    }

    public void Uj() {
        if (this.bBb != null) {
            this.bBb.dismiss();
            this.bBb = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bhE);
            this.mHandler.removeCallbacks(this.bBj);
        }
    }

    public void gV(int i) {
        if (i > 0) {
            this.bBi = i;
        }
    }

    public void gW(int i) {
        if (i > 0) {
            this.bBg = i;
        }
    }
}
