package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl cSZ;

    public static synchronized SwanAppBgMusicPlayerImpl ayJ() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (cSZ == null) {
                cSZ = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = cSZ;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
