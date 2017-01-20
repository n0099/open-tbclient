package com.baidu.tbadk.mainTab;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class d {
    private static Game ayy;

    public static Game getGame() {
        return ayy;
    }

    public static void a(Game game) {
        ayy = game;
    }
}
