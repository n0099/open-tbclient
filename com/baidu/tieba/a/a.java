package com.baidu.tieba.a;

import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.aj;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a extends i {
    private static final String amO = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/feed/forum";
    private int errorCode = 0;
    private String errorMsg;

    public String ez(String str) {
        k("pn", str);
        k("rn", String.valueOf(20));
        this.mNetWork.mc().na().mIsNeedTbs = true;
        setUrl(amO);
        int n = m.n(aj.wm().getApp());
        int o = m.o(aj.wm().getApp());
        float f = n / 320.0f;
        int i = ba.mD().mF() ? 2 : 1;
        this.mNetWork.k("scr_w", String.valueOf(n));
        this.mNetWork.k("scr_h", String.valueOf(o));
        this.mNetWork.k("scr_dip", String.valueOf(f));
        this.mNetWork.k("q_type", String.valueOf(i));
        String lA = this.mNetWork.lA();
        if (this.mNetWork.mc().nb().jq()) {
            this.yH = new NewErrorData();
            this.yH.parserJson(lA);
            return lA;
        } else if (this.mNetWork.mf()) {
            this.errorCode = this.mNetWork.mg();
            this.errorMsg = this.mNetWork.getErrorString();
            return null;
        } else {
            this.errorCode = -1;
            this.errorMsg = aj.wm().getApp().getResources().getString(y.neterror);
            return null;
        }
    }

    @Override // com.baidu.tbadk.core.i
    public int getErrorCode() {
        if (this.yH != null) {
            return this.yH.getErrorNumber();
        }
        if (this.errorCode == 0) {
            return this.errorCode;
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.i
    public String getErrorMsg() {
        if (this.yH != null) {
            return this.yH.getErrorMsg();
        }
        if (this.errorMsg != null) {
            return this.errorMsg;
        }
        return "";
    }
}
