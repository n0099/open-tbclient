package com.baidu.tieba.QuickPlayer;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private String aoc;
    private SurfaceTexture bPd;
    private Map<String, String> headers;
    private Uri uri;

    public void setHost(String str) {
        this.aoc = str;
    }

    public String getHost() {
        return this.aoc;
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
        return this.bPd;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.bPd = surfaceTexture;
    }
}
