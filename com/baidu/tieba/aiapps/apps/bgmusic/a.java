package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl cSY;

    public static synchronized SwanAppBgMusicPlayerImpl ayF() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (cSY == null) {
                cSY = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = cSY;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
