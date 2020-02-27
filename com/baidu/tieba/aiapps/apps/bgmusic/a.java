package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes7.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl edw;

    public static synchronized SwanAppBgMusicPlayerImpl aZI() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (edw == null) {
                edw = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = edw;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
