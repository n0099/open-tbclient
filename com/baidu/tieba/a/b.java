package com.baidu.tieba.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.h;
/* loaded from: classes.dex */
public class b extends h {
    private static final String amG = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumsquare";

    public String AB() {
        setUrl(amG);
        return jp();
    }

    public long AC() {
        if (this.mNetWork != null) {
            return this.mNetWork.mc().nc().kW.ko;
        }
        return 0L;
    }

    public long AD() {
        if (this.mNetWork != null) {
            return this.mNetWork.mc().nc().kW.km;
        }
        return 0L;
    }
}
