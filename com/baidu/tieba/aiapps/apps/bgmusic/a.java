package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl cSX;

    public static synchronized SwanAppBgMusicPlayerImpl ayF() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (cSX == null) {
                cSX = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = cSX;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
