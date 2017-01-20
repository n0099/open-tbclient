package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.e;
/* loaded from: classes.dex */
public class FrsHeadVideoAutoPlaySwitchStatic extends BaseNormalSwitchStatic {
    private static final FrsHeadVideoAutoPlaySwitchStatic aCF;

    static {
        e.dL().n(GraffitiSwitchStatic.class);
        aCF = new FrsHeadVideoAutoPlaySwitchStatic();
    }

    public static boolean Gc() {
        return aCF.eV();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.b.a
    protected String getName() {
        return "is_auto_play_forumheadvideo";
    }
}
