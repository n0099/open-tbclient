package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private SurfaceTexture aVS;
    private Map<String, String> headers;
    private Uri uri;
    private String zX;

    public void hb(String str) {
        this.zX = str;
    }

    public String getHost() {
        return this.zX;
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
        return this.aVS;
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.aVS = surfaceTexture;
    }
}
