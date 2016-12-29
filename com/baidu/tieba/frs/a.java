package com.baidu.tieba.frs;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a {
    private TbPageContext GO;
    private View bL;
    private boolean bxJ;
    private String mMessage;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.d Ht = null;
    int bxK = 0;
    private Runnable bxL = new b(this);
    private Runnable bxM = new d(this);

    public a(TbPageContext tbPageContext, View view) {
        this.GO = tbPageContext;
        this.bL = view;
    }

    public void VX() {
        com.baidu.tbadk.core.sharedPref.b.tW().putInt("frs_show_bottle_guide_tips", this.bxK + 1);
    }

    public void iz(String str) {
        if (!this.bxJ && !StringUtils.isNull(str) && this.bL != null && this.bL.getVisibility() != 8) {
            this.mMessage = str;
            this.bxK = com.baidu.tbadk.core.sharedPref.b.tW().getInt("frs_show_bottle_guide_tips", 0);
            if (this.bxK < 1) {
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bxL, 1000L);
            }
        }
    }

    public void VY() {
        if (this.Ht != null) {
            this.Ht.dismiss();
            this.Ht = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bxL);
            this.mHandler.removeCallbacks(this.bxM);
        }
    }
}
