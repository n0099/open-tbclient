package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class FrsHeadVideoAutoPlaySwitchStatic extends BaseNormalSwitchStatic {
    private static final FrsHeadVideoAutoPlaySwitchStatic aBa;

    static {
        e.cS().n(GraffitiSwitchStatic.class);
        aBa = new FrsHeadVideoAutoPlaySwitchStatic();
    }

    public static boolean Fr() {
        return aBa.ec();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "is_auto_play_forumheadvideo";
    }
}
