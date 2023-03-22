package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes4.dex */
public interface fh5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "GroupChatService");

    void a(@NonNull Context context, long j, int i, String str);

    void b(@NonNull Context context, long j);

    void c(@NonNull Context context, long j, String str);

    void d(@NonNull Context context, long j, int i, String str, String str2, long j2, boolean z);
}
