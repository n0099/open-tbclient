package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext ajU;
    private boolean bDm;
    private String bDn;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d bDl = null;
    private int bDo = w.g.pic_sign_tip;
    private int bDp = 0;
    private int bDq = 1;
    private int bDr = 1000;
    private int bDs = 3000;
    private int akb = 5;
    private int mYOffset = 0;
    private Runnable bjJ = new b(this);
    private Runnable bDt = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.ajU = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VH() {
        com.baidu.tbadk.core.sharedPref.b.uL().putInt(this.bDn, this.bDp + 1);
    }

    public void aD(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bDm && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bDn = str2;
            this.bDp = com.baidu.tbadk.core.sharedPref.b.uL().getInt(str2, 0);
            if (this.bDp < this.bDq) {
                if (z) {
                    VH();
                    this.bDm = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bjJ, this.bDr);
            }
        }
    }

    public void VI() {
        if (this.bDl != null) {
            this.bDl.dismiss();
            this.bDl = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bjJ);
            this.mHandler.removeCallbacks(this.bDt);
        }
    }

    public void he(int i) {
        if (i > 0) {
            this.bDs = i;
        }
    }

    public void hf(int i) {
        if (i > 0) {
            this.bDq = i;
        }
    }
}
