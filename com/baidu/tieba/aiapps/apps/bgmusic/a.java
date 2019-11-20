package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dnt;

    public static synchronized SwanAppBgMusicPlayerImpl aFX() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dnt == null) {
                dnt = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dnt;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
