package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes7.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl eDR;

    public static synchronized SwanAppBgMusicPlayerImpl bhT() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (eDR == null) {
                eDR = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = eDR;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
