package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dbv;

    public static synchronized SwanAppBgMusicPlayerImpl aDQ() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dbv == null) {
                dbv = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dbv;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
