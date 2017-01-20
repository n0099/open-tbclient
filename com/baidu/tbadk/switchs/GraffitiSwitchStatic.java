package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.e;
/* loaded from: classes.dex */
public class GraffitiSwitchStatic extends BaseNormalSwitchStatic {
    private static final GraffitiSwitchStatic aCG;

    static {
        e.dL().n(GraffitiSwitchStatic.class);
        aCG = new GraffitiSwitchStatic();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.b.a
    protected String getName() {
        return "graffiti_android";
    }
}
