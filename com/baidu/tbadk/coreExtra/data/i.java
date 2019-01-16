package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int aOn;
    private final int aOo;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> GQ() {
        return this.mContext;
    }

    public int GR() {
        return this.aOn;
    }

    public int GS() {
        return this.aOo;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aOn > 0 && this.aOo > 0;
    }
}
