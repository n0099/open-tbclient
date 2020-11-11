package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dNm;
    private final int dNn;
    private final TbPageContext<?> eIc;

    public TbPageContext<?> buC() {
        return this.eIc;
    }

    public int aQS() {
        return this.dNn;
    }

    public int aQR() {
        return this.dNm;
    }

    public boolean isAvailable() {
        return this.eIc != null && this.dNn > 0 && this.dNm > 0;
    }
}
