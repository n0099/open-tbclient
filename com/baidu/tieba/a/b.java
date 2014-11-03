package com.baidu.tieba.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.i;
/* loaded from: classes.dex */
public class b extends i {
    private static final String amP = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumsquare";

    public String AD() {
        setUrl(amP);
        return jp();
    }

    public long AE() {
        if (this.mNetWork != null) {
            return this.mNetWork.mc().nc().kW.ko;
        }
        return 0L;
    }

    public long AF() {
        if (this.mNetWork != null) {
            return this.mNetWork.mc().nc().kW.km;
        }
        return 0L;
    }
}
