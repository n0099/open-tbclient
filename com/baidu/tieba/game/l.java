package com.baidu.tieba.game;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class l {
    private static l aGV;
    private Game aGW;
    private boolean aGX;

    private l() {
    }

    public static synchronized l Hi() {
        l lVar;
        synchronized (l.class) {
            if (aGV == null) {
                aGV = new l();
            }
            lVar = aGV;
        }
        return lVar;
    }

    public void a(Game game) {
        this.aGW = game;
    }

    public Game Hj() {
        return this.aGW;
    }

    public void cm(boolean z) {
        this.aGX = z;
    }
}
