package com.baidu.tieba.aiapps.apps.media.videoplayer;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.play.g;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.baidu.tieba.aiapps.apps.media.videoplayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0298a {
        void a(b bVar);

        void a(b bVar, int i, int i2);

        void a(b bVar, int i, int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(g gVar);

        a aHo();
    }

    void a(InterfaceC0298a interfaceC0298a);

    void b(InterfaceC0298a interfaceC0298a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i);

    void setVideoSampleAspectRatio(int i, int i2);

    void setVideoSize(int i, int i2);
}
