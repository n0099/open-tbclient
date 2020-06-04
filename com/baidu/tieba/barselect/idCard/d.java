package com.baidu.tieba.barselect.idCard;

import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.barselect.idCard.ICameraControl;
/* loaded from: classes8.dex */
public interface d {

    /* loaded from: classes8.dex */
    public interface a {
        int i(byte[] bArr, int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void Z(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    Rect bKD();

    void bKE();

    void bKt();

    @ICameraControl.FlashMode
    int bKu();

    View bKv();

    void pause();

    void resume();

    void setDisplayOrientation(int i);

    void sg(@ICameraControl.FlashMode int i);

    void start();

    void stop();
}
