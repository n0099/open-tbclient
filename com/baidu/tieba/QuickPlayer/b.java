package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private SurfaceTexture aZa;
    private Map<String, String> headers;
    private Uri uri;
    private String zV;

    public void hk(String str) {
        this.zV = str;
    }

    public String getHost() {
        return this.zV;
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
        return this.aZa;
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.aZa = surfaceTexture;
    }
}
