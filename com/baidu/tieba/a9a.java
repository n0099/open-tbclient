package com.baidu.tieba;

import android.hardware.Camera;
import com.faceunity.encoder.TextureMovieEncoder;
/* loaded from: classes4.dex */
public interface a9a {

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, String str);
    }

    void a(Camera camera);

    void b(Camera camera);

    void c(a aVar);

    void d(Camera camera);

    void e(Camera camera);

    void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener);

    void setPreviewSize(int i, int i2);
}
