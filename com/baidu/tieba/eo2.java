package com.baidu.tieba;

import android.view.Surface;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface eo2 extends go2 {

    /* loaded from: classes4.dex */
    public interface a {
    }

    void W(long j);

    int getVideoHeight();

    int getVideoWidth();

    void m(String str);

    void o(@NonNull a aVar);

    void onSurfaceChanged(int i, int i2);

    void s(int i, int i2, int i3, int i4);

    void setSurface(Surface surface);

    void z(int i);
}
