package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class FrsHeadVideoAutoPlaySwitchStatic extends BaseNormalSwitchStatic {
    private static final FrsHeadVideoAutoPlaySwitchStatic aEw;

    static {
        e.dN().n(GraffitiSwitchStatic.class);
        aEw = new FrsHeadVideoAutoPlaySwitchStatic();
    }

    public static boolean GN() {
        return aEw.eX();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "is_auto_play_forumheadvideo";
    }
}
