package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    private SurfaceTexture bxs;
    private Map<String, String> headers;
    private String mHost;
    private Uri uri;

    public void setHost(String str) {
        this.mHost = str;
    }

    public String getHost() {
        return this.mHost;
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
        return this.bxs;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.bxs = surfaceTexture;
    }
}
