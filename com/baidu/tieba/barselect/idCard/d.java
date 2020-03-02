package com.baidu.tieba.barselect.idCard;

import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.barselect.idCard.ICameraControl;
/* loaded from: classes8.dex */
public interface d {

    /* loaded from: classes8.dex */
    public interface a {
        int h(byte[] bArr, int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void Q(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    void buk();

    @ICameraControl.FlashMode
    int bul();

    View bum();

    Rect but();

    void buu();

    void pause();

    void resume();

    void rh(@ICameraControl.FlashMode int i);

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
