package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes4.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dZj;

    public static synchronized SwanAppBgMusicPlayerImpl aWZ() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dZj == null) {
                dZj = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dZj;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
