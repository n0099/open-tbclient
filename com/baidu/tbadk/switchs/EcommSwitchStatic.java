package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class EcommSwitchStatic extends BaseNormalSwitchStatic {
    private static final EcommSwitchStatic aAj;

    static {
        e.cT().n(EcommSwitchStatic.class);
        aAj = new EcommSwitchStatic();
    }

    public static boolean Fq() {
        return aAj.ed();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "is_ecomm_open";
    }
}
