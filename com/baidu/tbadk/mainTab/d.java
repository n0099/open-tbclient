package com.baidu.tbadk.mainTab;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class d {
    private static Game azo;

    public static Game getGame() {
        return azo;
    }

    public static void a(Game game) {
        azo = game;
    }
}
