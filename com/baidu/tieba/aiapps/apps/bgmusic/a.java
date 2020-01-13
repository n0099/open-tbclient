package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes5.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dZs;

    public static synchronized SwanAppBgMusicPlayerImpl aXt() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dZs == null) {
                dZs = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dZs;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
