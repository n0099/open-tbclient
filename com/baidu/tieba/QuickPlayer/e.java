package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private SurfaceTexture aLo;
    private Map<String, String> headers;
    private Uri uri;

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
        return this.aLo;
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.aLo = surfaceTexture;
    }
}
