package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private String Ca;
    private SurfaceTexture aUC;
    private Map<String, String> headers;
    private Uri uri;

    public void he(String str) {
        this.Ca = str;
    }

    public String getHost() {
        return this.Ca;
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
        return this.aUC;
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.aUC = surfaceTexture;
    }
}
