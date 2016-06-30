package com.baidu.tbadk.mainTab;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class d {
    private static Game avP;

    public static Game getGame() {
        return avP;
    }

    public static void a(Game game) {
        avP = game;
    }
}
