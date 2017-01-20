package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a {
    private TbPageContext FY;
    private View bK;
    private boolean btT;
    private String btU;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d GD = null;
    private int btV = r.g.pic_sign_tip;
    private int btW = 0;
    private int btX = 1;
    private int btY = 1000;
    private int btZ = 3000;
    private int aew = 5;
    private int aex = 0;
    private Runnable baT = new b(this);
    private Runnable bua = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.FY = tbPageContext;
        this.bK = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        com.baidu.tbadk.core.sharedPref.b.tQ().putInt(this.btU, this.btW + 1);
    }

    public void aC(String str, String str2) {
        e(str, str2, false);
    }

    public void e(String str, String str2, boolean z) {
        if (!this.btT && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.bK != null && this.bK.getVisibility() != 8) {
            this.mMessage = str;
            this.btU = str2;
            this.btW = com.baidu.tbadk.core.sharedPref.b.tQ().getInt(str2, 0);
            if (this.btW < this.btX) {
                if (z) {
                    Tf();
                    this.btT = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.baT, this.btY);
            }
        }
    }

    public void Tg() {
        if (this.GD != null) {
            this.GD.dismiss();
            this.GD = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.baT);
            this.mHandler.removeCallbacks(this.bua);
        }
    }

    public void gY(int i) {
        if (i > 0) {
            this.btZ = i;
        }
    }

    public void gZ(int i) {
        if (i > 0) {
            this.btX = i;
        }
    }

    public void ha(int i) {
        this.aew = i;
    }

    public boolean Th() {
        return this.btT;
    }

    public boolean Ti() {
        return com.baidu.tbadk.core.sharedPref.b.tQ().getInt(this.btU, 0) < this.btX;
    }
}
