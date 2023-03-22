package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface baa {
    public static final ServiceReference a = new ServiceReference("voyager", StatConstants.VALUE_TYPE_UPLOAD);

    void a(String str, String str2, int i, aaa aaaVar);

    void b(List<String> list, String str, long j, JSONObject jSONObject);

    void c(String str, String str2, JSONObject jSONObject);

    boolean d(JSONObject jSONObject);

    void e(String str, String str2, aaa aaaVar);

    void f();

    void g(List<String> list, String str, long j, aaa aaaVar);

    void retry();
}
