package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext ajr;
    private boolean bDn;
    private String bDo;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d bDm = null;
    private int bDp = w.g.pic_sign_tip;
    private int bDq = 0;
    private int bDr = 1;
    private int bDs = 1000;
    private int bDt = 3000;
    private int ajy = 5;
    private int mYOffset = 0;
    private Runnable bkg = new b(this);
    private Runnable bDu = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.ajr = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Va() {
        com.baidu.tbadk.core.sharedPref.b.tX().putInt(this.bDo, this.bDq + 1);
    }

    public void aD(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bDn && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bDo = str2;
            this.bDq = com.baidu.tbadk.core.sharedPref.b.tX().getInt(str2, 0);
            if (this.bDq < this.bDr) {
                if (z) {
                    Va();
                    this.bDn = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bkg, this.bDs);
            }
        }
    }

    public void Vb() {
        if (this.bDm != null) {
            this.bDm.dismiss();
            this.bDm = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bkg);
            this.mHandler.removeCallbacks(this.bDu);
        }
    }

    public void ha(int i) {
        if (i > 0) {
            this.bDt = i;
        }
    }

    public void hb(int i) {
        if (i > 0) {
            this.bDr = i;
        }
    }

    public void hc(int i) {
        this.ajy = i;
    }
}
