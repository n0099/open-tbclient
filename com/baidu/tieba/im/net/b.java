package com.baidu.tieba.im.net;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    private String a;
    private List<String> b;
    private d c;
    private boolean d;

    public static b a() {
        b bVar;
        bVar = e.a;
        return bVar;
    }

    private b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.d = false;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(byte b) {
        this();
    }

    public final String b() {
        int a = com.baidu.tieba.sharedPref.b.a().a("KeyOfSharedPrefImCount", 0);
        if (a >= 10) {
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefImCount", 0);
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefValidIp", "");
            this.a = null;
            return null;
        }
        if (this.a == null) {
            this.a = com.baidu.tieba.sharedPref.b.a().a("KeyOfSharedPrefValidIp", (String) null);
        }
        if (!com.baidu.adp.lib.util.g.b(this.a)) {
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefImCount", a + 1);
        } else {
            this.a = null;
        }
        return this.a;
    }

    public final void a(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.a = str;
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefValidIp", str);
        }
    }

    public final List<String> c() {
        if (this.b == null) {
            this.b = b(com.baidu.tieba.sharedPref.b.a().a("KeyOfSharedPrefIpList", (String) null));
        }
        return this.b;
    }

    public final void d() {
        this.d = false;
    }

    public final boolean e() {
        return this.d;
    }

    public final void a(c cVar) {
        if (this.c == null) {
            this.d = true;
            this.c = new d(this, cVar);
            this.c.setPriority(3);
            this.c.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> b(String str) {
        String[] split;
        ArrayList arrayList = null;
        if (str != null && str.length() > 0 && (split = str.split(",")) != null && split.length > 0) {
            arrayList = new ArrayList(3);
            for (String str2 : split) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }
}
