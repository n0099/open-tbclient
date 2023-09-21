package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface gp5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaSquare", "SecondFloorService");

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, boolean z2);

        void b(boolean z);
    }

    void g();

    void h(@Nullable a aVar);

    void hide();

    void i();

    @NonNull
    Fragment j(@NonNull String str);

    void show();
}
