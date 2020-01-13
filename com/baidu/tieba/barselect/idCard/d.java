package com.baidu.tieba.barselect.idCard;

import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.barselect.idCard.ICameraControl;
/* loaded from: classes6.dex */
public interface d {

    /* loaded from: classes6.dex */
    public interface a {
        int f(byte[] bArr, int i);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void L(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    void bsE();

    @ICameraControl.FlashMode
    int bsF();

    View bsG();

    Rect bsN();

    void bsO();

    void pause();

    void ra(@ICameraControl.FlashMode int i);

    void resume();

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
