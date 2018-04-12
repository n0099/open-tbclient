package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private SurfaceTexture aYY;
    private Map<String, String> headers;
    private Uri uri;
    private String yF;

    public void setHost(String str) {
        this.yF = str;
    }

    public String getHost() {
        return this.yF;
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
        return this.aYY;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.aYY = surfaceTexture;
    }
}
