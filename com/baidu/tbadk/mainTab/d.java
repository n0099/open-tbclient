package com.baidu.tbadk.mainTab;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class d {
    private static Game awE;

    public static Game getGame() {
        return awE;
    }

    public static void a(Game game) {
        awE = game;
    }
}
