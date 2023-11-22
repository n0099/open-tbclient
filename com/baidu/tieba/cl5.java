package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface cl5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaSquare", "FrsLiveTabService");

    @NonNull
    Fragment a(@Nullable String str, @Nullable String str2);
}
