package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface aka {
    public static final ServiceReference a = new ServiceReference("yaLog", "yaLogConfig");

    void a(JSONObject jSONObject);

    void b(JSONObject jSONObject, boolean z);
}
