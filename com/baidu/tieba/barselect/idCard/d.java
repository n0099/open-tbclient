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
        void M(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    void aYT();

    @ICameraControl.FlashMode
    int aYU();

    View aYV();

    Rect aZd();

    void aZe();

    void pause();

    void pw(@ICameraControl.FlashMode int i);

    void resume();

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
