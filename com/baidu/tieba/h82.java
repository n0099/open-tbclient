package com.baidu.tieba;

import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
/* loaded from: classes4.dex */
public interface h82 {

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str);

        WebResourceResponse b(String str, Map map, boolean z);

        boolean c();

        String d();

        String getMimeType();

        Map getRequestHeaders();
    }

    WebResourceResponse a(a aVar);
}
