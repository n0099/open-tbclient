package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext ajT;
    private boolean bAV;
    private String bAW;
    private View jv;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d bAU = null;
    private int bAX = w.g.pic_sign_tip;
    private int bAY = 0;
    private int bAZ = 1;
    private int bBa = 1000;
    private int bBb = 3000;
    private int aka = 5;
    private int mYOffset = 0;
    private Runnable bhx = new b(this);
    private Runnable bBc = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.ajT = tbPageContext;
        this.jv = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UG() {
        com.baidu.tbadk.core.sharedPref.b.uL().putInt(this.bAW, this.bAY + 1);
    }

    public void aE(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bAV && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.jv != null && this.jv.getVisibility() == 0) {
            this.mMessage = str;
            this.bAW = str2;
            this.bAY = com.baidu.tbadk.core.sharedPref.b.uL().getInt(str2, 0);
            if (this.bAY < this.bAZ) {
                if (z) {
                    UG();
                    this.bAV = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bhx, this.bBa);
            }
        }
    }

    public void UH() {
        if (this.bAU != null) {
            this.bAU.dismiss();
            this.bAU = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bhx);
            this.mHandler.removeCallbacks(this.bBc);
        }
    }

    public void gY(int i) {
        if (i > 0) {
            this.bBb = i;
        }
    }

    public void gZ(int i) {
        if (i > 0) {
            this.bAZ = i;
        }
    }
}
