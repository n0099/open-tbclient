package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private SurfaceTexture aZe;
    private Map<String, String> headers;
    private Uri uri;
    private String zW;

    public void hk(String str) {
        this.zW = str;
    }

    public String getHost() {
        return this.zW;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.aZe;
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.aZe = surfaceTexture;
    }
}
