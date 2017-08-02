package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private String AA;
    private SurfaceTexture aTq;
    private Map<String, String> headers;
    private Uri uri;

    public void gZ(String str) {
        this.AA = str;
    }

    public String getHost() {
        return this.AA;
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
        return this.aTq;
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.aTq = surfaceTexture;
    }
}
