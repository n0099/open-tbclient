package com.baidu.tieba.aiapps.apps.b;

import com.baidu.b.a.g.c;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements c {
    @Override // com.baidu.b.a.g.c
    public String sf() {
        return String.format("%s/aps?service=package", com.baidu.tieba.aiapps.apps.d.c.getHost());
    }

    @Override // com.baidu.b.a.g.c
    public String sg() {
        return String.format("%s/ma/aps?service=package", com.baidu.tieba.aiapps.apps.d.c.getHost());
    }

    @Override // com.baidu.b.a.g.c
    public String c(String str, Map<String, String> map) {
        return com.baidu.tieba.aiapps.apps.d.c.g(str, map);
    }
}
