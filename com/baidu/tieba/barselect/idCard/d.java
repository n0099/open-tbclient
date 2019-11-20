package com.baidu.tieba.barselect.idCard;

import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.barselect.idCard.ICameraControl;
/* loaded from: classes3.dex */
public interface d {

    /* loaded from: classes3.dex */
    public interface a {
        int f(byte[] bArr, int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void z(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    View aZA();

    Rect aZI();

    void aZJ();

    void aZy();

    @ICameraControl.FlashMode
    int aZz();

    void oB(@ICameraControl.FlashMode int i);

    void pause();

    void resume();

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
