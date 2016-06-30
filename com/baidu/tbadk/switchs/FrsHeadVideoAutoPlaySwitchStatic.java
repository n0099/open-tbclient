package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class FrsHeadVideoAutoPlaySwitchStatic extends BaseNormalSwitchStatic {
    private static final FrsHeadVideoAutoPlaySwitchStatic aAk;

    static {
        e.cT().n(GraffitiSwitchStatic.class);
        aAk = new FrsHeadVideoAutoPlaySwitchStatic();
    }

    public static boolean Fq() {
        return aAk.ed();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitchStatic, com.baidu.adp.lib.c.a
    protected String getName() {
        return "is_auto_play_forumheadvideo";
    }
}
