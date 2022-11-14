package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface ab5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaSquare", "SecondFloorService");

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, boolean z2);

        void b(boolean z);
    }

    void a();

    void b(@Nullable a aVar);

    void c();

    @NonNull
    Fragment d(@NonNull String str);

    void hide();

    void show();
}
