package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl cSV;

    public static synchronized SwanAppBgMusicPlayerImpl ayI() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (cSV == null) {
                cSV = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = cSV;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
