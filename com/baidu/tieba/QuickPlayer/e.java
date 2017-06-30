package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private String AA;
    private SurfaceTexture aSh;
    private Map<String, String> headers;
    private Uri uri;

    public void gT(String str) {
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
        return this.aSh;
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.aSh = surfaceTexture;
    }
}
