package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl deQ;

    public static synchronized SwanAppBgMusicPlayerImpl aFM() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (deQ == null) {
                deQ = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = deQ;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
