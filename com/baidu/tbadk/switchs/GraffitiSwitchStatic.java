package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class GraffitiSwitchStatic extends BaseNormalSwitchStatic {
    private static final GraffitiSwitchStatic aEi;

    static {
        e.dN().n(GraffitiSwitchStatic.class);
        aEi = new GraffitiSwitchStatic();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "graffiti_android";
    }
}
