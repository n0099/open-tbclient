package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class EcommSwitchStatic extends BaseNormalSwitchStatic {
    private static final EcommSwitchStatic aEg;

    static {
        e.dN().n(EcommSwitchStatic.class);
        aEg = new EcommSwitchStatic();
    }

    public static boolean GL() {
        return aEg.eX();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "is_ecomm_open";
    }
}
