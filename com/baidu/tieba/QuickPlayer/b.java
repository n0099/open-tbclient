package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private SurfaceTexture aVF;
    private Map<String, String> headers;
    private Uri uri;
    private String zY;

    public void ha(String str) {
        this.zY = str;
    }

    public String getHost() {
        return this.zY;
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
        return this.aVF;
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.aVF = surfaceTexture;
    }
}
