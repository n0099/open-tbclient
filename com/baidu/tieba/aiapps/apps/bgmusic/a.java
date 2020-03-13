package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes7.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl edK;

    public static synchronized SwanAppBgMusicPlayerImpl aZL() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (edK == null) {
                edK = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = edK;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
