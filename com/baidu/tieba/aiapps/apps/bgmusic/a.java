package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl ddd;

    public static synchronized SwanAppBgMusicPlayerImpl aFi() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (ddd == null) {
                ddd = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = ddd;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
