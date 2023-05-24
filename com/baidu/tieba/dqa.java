package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface dqa {
    public static final ServiceReference a = new ServiceReference("yaLog", "yaLogConfig");

    void a(JSONObject jSONObject);

    void b(JSONObject jSONObject, boolean z);
}
