package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes3.dex */
public interface di0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final di0 b = new ci0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ei0 ei0Var);

    void b(String str, String str2, gi0 gi0Var);

    String[] c();

    boolean d(Context context, String str);
}
