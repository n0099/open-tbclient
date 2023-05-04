package com.baidu.tieba;

import java.util.Map;
/* loaded from: classes3.dex */
public interface a70 {
    String getContentType();

    Map<String, String> getHeaders();

    String getHost();

    String getMethod();

    byte[] getRequestParameter();
}
