package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class GraffitiSwitchStatic extends BaseNormalSwitchStatic {
    private static final GraffitiSwitchStatic azt;

    static {
        e.cS().f(GraffitiSwitchStatic.class);
        azt = new GraffitiSwitchStatic();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "graffiti_android";
    }
}
