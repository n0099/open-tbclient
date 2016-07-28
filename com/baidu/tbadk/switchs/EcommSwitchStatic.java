package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class EcommSwitchStatic extends BaseNormalSwitchStatic {
    private static final EcommSwitchStatic aAZ;

    static {
        e.cS().n(EcommSwitchStatic.class);
        aAZ = new EcommSwitchStatic();
    }

    public static boolean Fr() {
        return aAZ.ec();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "is_ecomm_open";
    }
}
