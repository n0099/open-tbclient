package com.baidu.tieba;

import java.util.Map;
/* loaded from: classes5.dex */
public interface d30 {
    String getContentType();

    Map<String, String> getHeaders();

    String getHost();

    String getMethod();

    byte[] getRequestParameter();
}
