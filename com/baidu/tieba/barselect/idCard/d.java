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

    Rect bKB();

    void bKC();

    void bKr();

    @ICameraControl.FlashMode
    int bKs();

    View bKt();

    void pause();

    void resume();

    void se(@ICameraControl.FlashMode int i);

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
