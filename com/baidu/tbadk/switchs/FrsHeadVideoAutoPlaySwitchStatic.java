package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class FrsHeadVideoAutoPlaySwitchStatic extends BaseNormalSwitchStatic {
    private static final FrsHeadVideoAutoPlaySwitchStatic aEh;

    static {
        e.dN().n(GraffitiSwitchStatic.class);
        aEh = new FrsHeadVideoAutoPlaySwitchStatic();
    }

    public static boolean GL() {
        return aEh.eX();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "is_auto_play_forumheadvideo";
    }
}
