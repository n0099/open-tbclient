package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dol;

    public static synchronized SwanAppBgMusicPlayerImpl aFZ() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dol == null) {
                dol = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dol;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
