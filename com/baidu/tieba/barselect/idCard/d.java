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
        void S(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    void bDZ();

    @ICameraControl.FlashMode
    int bEa();

    View bEb();

    Rect bEj();

    void bEk();

    void pause();

    void rB(@ICameraControl.FlashMode int i);

    void resume();

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
