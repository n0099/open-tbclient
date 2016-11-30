package com.baidu.tbadk.mainTab;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class d {
    private static Game aAg;

    public static Game getGame() {
        return aAg;
    }

    public static void a(Game game) {
        aAg = game;
    }
}
