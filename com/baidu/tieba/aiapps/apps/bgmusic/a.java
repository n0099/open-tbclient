package com.baidu.tieba.aiapps.apps.bgmusic;
/* loaded from: classes2.dex */
public class a {
    private static volatile SwanAppBgMusicPlayerImpl dcW;

    public static synchronized SwanAppBgMusicPlayerImpl aFg() {
        SwanAppBgMusicPlayerImpl swanAppBgMusicPlayerImpl;
        synchronized (a.class) {
            if (dcW == null) {
                dcW = new SwanAppBgMusicPlayerImpl();
            }
            swanAppBgMusicPlayerImpl = dcW;
        }
        return swanAppBgMusicPlayerImpl;
    }
}
