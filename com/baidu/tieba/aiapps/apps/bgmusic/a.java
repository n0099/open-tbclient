package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dbu;

    public static synchronized SwanAppBgMusicPlayerImpl aDQ() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dbu == null) {
                dbu = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dbu;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
