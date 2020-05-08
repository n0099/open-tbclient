package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes7.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl eDW;

    public static synchronized SwanAppBgMusicPlayerImpl bhR() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (eDW == null) {
                eDW = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = eDW;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
