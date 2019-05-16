package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dbt;

    public static synchronized SwanAppBgMusicPlayerImpl aDN() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dbt == null) {
                dbt = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dbt;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
