package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes4.dex */
public interface dj5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "GroupChatService");

    void a(@NonNull Context context, long j, int i, String str);

    void b(@NonNull Context context, long j, int i, String str, @Nullable Bundle bundle, boolean z);

    void c(@NonNull Context context, long j);

    void d(@NonNull Context context, long j, String str);
}
