package com.baidu.tieba.barselect.idCard;

import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.barselect.idCard.ICameraControl;
/* loaded from: classes5.dex */
public interface d {

    /* loaded from: classes5.dex */
    public interface a {
        int f(byte[] bArr, int i);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void M(byte[] bArr);
    }

    void a(b bVar);

    void a(e eVar);

    void brC();

    @ICameraControl.FlashMode
    int brD();

    View brE();

    Rect brL();

    void brM();

    void pause();

    void qV(@ICameraControl.FlashMode int i);

    void resume();

    void setDisplayOrientation(int i);

    void start();

    void stop();
}
