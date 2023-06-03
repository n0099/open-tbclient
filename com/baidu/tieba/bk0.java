package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes5.dex */
public interface bk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final bk0 b = new ak0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ck0 ck0Var);

    void b(String str, String str2, ek0 ek0Var);

    String[] c();

    boolean d(Context context, String str);
}
