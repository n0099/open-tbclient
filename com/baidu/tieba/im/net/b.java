package com.baidu.tieba.im.net;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
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
    public /* synthetic */ b(b bVar) {
        this();
    }

    public int b() {
        return com.baidu.tieba.sharedPref.b.a().a("KeyOfSharedPrefImCount", 0);
    }

    public String c() {
        int b = b();
        if (b >= 10) {
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefImCount", 0);
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefValidIp", "");
            this.a = null;
            return null;
        }
        if (this.a == null) {
            this.a = com.baidu.tieba.sharedPref.b.a().a("KeyOfSharedPrefValidIp", (String) null);
        }
        if (!com.baidu.adp.lib.util.h.b(this.a)) {
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefImCount", b + 1);
        } else {
            this.a = null;
        }
        return this.a;
    }

    public void a(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.a = str;
            com.baidu.tieba.sharedPref.b.a().b("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> d() {
        if (this.b == null) {
            this.b = b(com.baidu.tieba.sharedPref.b.a().a("KeyOfSharedPrefIpList", (String) null));
        }
        return this.b;
    }

    public void e() {
        this.d = false;
    }

    public boolean f() {
        return this.d;
    }

    public void a(c cVar) {
        if (this.c == null) {
            this.d = true;
            this.c = new d(this, cVar);
            this.c.setPriority(3);
            this.c.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> b(String str) {
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
