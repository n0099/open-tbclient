package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes3.dex */
public interface ai0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ai0 b = new zh0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable bi0 bi0Var);

    void b(String str, String str2, di0 di0Var);

    String[] c();

    boolean d(Context context, String str);
}
