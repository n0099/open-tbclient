package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private SurfaceTexture ddt;
    private Map<String, String> headers;
    private String sT;
    private Uri uri;

    public void setHost(String str) {
        this.sT = str;
    }

    public String getHost() {
        return this.sT;
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
        return this.ddt;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.ddt = surfaceTexture;
    }
}
