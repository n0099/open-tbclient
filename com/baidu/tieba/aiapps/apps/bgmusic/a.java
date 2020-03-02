package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes7.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl edx;

    public static synchronized SwanAppBgMusicPlayerImpl aZK() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (edx == null) {
                edx = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = edx;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
