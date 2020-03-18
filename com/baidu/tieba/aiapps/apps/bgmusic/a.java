package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes7.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl eea;

    public static synchronized SwanAppBgMusicPlayerImpl aZP() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (eea == null) {
                eea = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = eea;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
