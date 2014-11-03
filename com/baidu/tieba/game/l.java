package com.baidu.tieba.game;

import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class l {
    private static l aHf;
    private Game aHg;
    private boolean aHh;

    private l() {
    }

    public static synchronized l Hk() {
        l lVar;
        synchronized (l.class) {
            if (aHf == null) {
                aHf = new l();
            }
            lVar = aHf;
        }
        return lVar;
    }

    public void a(Game game) {
        this.aHg = game;
    }

    public Game Hl() {
        return this.aHg;
    }

    public void cm(boolean z) {
        this.aHh = z;
    }
}
