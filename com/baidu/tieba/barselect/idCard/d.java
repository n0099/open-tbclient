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
        void L(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    void aWV();

    @ICameraControl.FlashMode
    int aWW();

    View aWX();

    Rect aXe();

    void aXf();

    void pause();

    void pe(@ICameraControl.FlashMode int i);

    void resume();

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
