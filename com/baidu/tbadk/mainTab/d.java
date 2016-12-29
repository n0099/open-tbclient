package com.baidu.tbadk.mainTab;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class d {
    private static Game azD;

    public static Game getGame() {
        return azD;
    }

    public static void a(Game game) {
        azD = game;
    }
}
