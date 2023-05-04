package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes3.dex */
public interface ci0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ci0 b = new bi0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable di0 di0Var);

    void b(String str, String str2, fi0 fi0Var);

    String[] c();

    boolean d(Context context, String str);
}
