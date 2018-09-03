package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private String EL;
    private SurfaceTexture bjx;
    private Map<String, String> headers;
    private Uri uri;

    public void setHost(String str) {
        this.EL = str;
    }

    public String getHost() {
        return this.EL;
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
        return this.bjx;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.bjx = surfaceTexture;
    }
}
