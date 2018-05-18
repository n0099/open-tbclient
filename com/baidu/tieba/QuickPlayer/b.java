package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private SurfaceTexture aYZ;
    private Map<String, String> headers;
    private Uri uri;
    private String yE;

    public void setHost(String str) {
        this.yE = str;
    }

    public String getHost() {
        return this.yE;
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
        return this.aYZ;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.aYZ = surfaceTexture;
    }
}
