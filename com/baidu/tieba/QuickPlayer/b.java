package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private String aoj;
    private SurfaceTexture bNg;
    private Map<String, String> headers;
    private Uri uri;

    public void setHost(String str) {
        this.aoj = str;
    }

    public String getHost() {
        return this.aoj;
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
        return this.bNg;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.bNg = surfaceTexture;
    }
}
