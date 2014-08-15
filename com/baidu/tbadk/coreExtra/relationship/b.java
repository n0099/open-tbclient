package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.t;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class b implements t {
    private boolean a = false;
    private String b;
    private long c;
    private String d;
    private String e;
    private String f;

    public String a() {
        StringBuilder sb = new StringBuilder(64);
        if (this.b != null) {
            sb.append(this.b);
        }
        if (this.e != null) {
            sb.append(this.e);
        }
        return sb.toString();
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void a(long j) {
        this.c = j;
    }

    public long c() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void c(String str) {
        this.e = str;
    }

    public String e() {
        return this.e;
    }

    public void d(String str) {
        this.f = str;
    }

    public String f() {
        return this.f;
    }

    public void a(friendList friendlist) {
        if (friendlist != null) {
            this.b = friendlist.user_name;
            this.c = friendlist.user_id.longValue();
            this.d = friendlist.portrait;
            this.e = friendlist.quanpin;
        }
    }

    @Override // com.baidu.tbadk.core.view.t
    public boolean isChecked() {
        return this.a;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void setChecked(boolean z) {
        this.a = z;
    }
}
