package com.baidu.tieba.aiapps.apps.media.videoplayer;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.View;
import com.baidu.tieba.play.g;
/* loaded from: classes9.dex */
public interface a {

    /* renamed from: com.baidu.tieba.aiapps.apps.media.videoplayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0404a {
        void a(b bVar);

        void a(b bVar, int i, int i2);

        void a(b bVar, int i, int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(g gVar);

        a aXJ();

        SurfaceTexture aXK();
    }

    void a(InterfaceC0404a interfaceC0404a);

    void b(InterfaceC0404a interfaceC0404a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i);

    void setVideoSampleAspectRatio(int i, int i2);

    void setVideoSize(int i, int i2);
}
