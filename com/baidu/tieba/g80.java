package com.baidu.tieba;

import java.util.Map;
/* loaded from: classes4.dex */
public interface g80 {
    String getContentType();

    Map<String, String> getHeaders();

    String getHost();

    String getMethod();

    byte[] getRequestParameter();
}
