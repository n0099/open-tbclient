package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String a;
    private List<String> b;
    private c c;
    private boolean d;

    public static a a() {
        a aVar;
        aVar = d.a;
        return aVar;
    }

    private a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.d = false;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public void a(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.a = str;
            com.baidu.tbadk.core.sharedPref.b.a().b("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> b() {
        if (this.b == null) {
            this.b = b(com.baidu.tbadk.core.sharedPref.b.a().a("KeyOfSharedPrefIpList", (String) null));
        }
        return this.b;
    }

    public void c() {
        this.d = false;
    }

    public boolean d() {
        return this.d;
    }

    public void a(b bVar) {
        if (this.c == null) {
            this.d = true;
            this.c = new c(this, bVar);
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
