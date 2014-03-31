package com.baidu.tieba.im.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class k extends com.baidu.adp.a.e {
    private String a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private GroupPermData i;
    private final Map<String, Boolean> j = new HashMap();
    private com.baidu.tbadk.core.e k;

    public k(com.baidu.tbadk.core.e eVar) {
        this.k = eVar;
    }

    public final void a(String str) {
        this.j.put(str, true);
    }

    public final boolean b(String str) {
        Boolean bool = this.j.get(str);
        return bool != null && bool.booleanValue();
    }

    public final boolean a() {
        return this.b;
    }

    public final int b() {
        return this.g;
    }

    public final int c() {
        return this.h;
    }

    public final GroupPermData d() {
        return this.i;
    }

    public final void a(GroupPermData groupPermData) {
        this.i = groupPermData;
    }

    public final boolean e() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void f() {
        this.i = null;
    }

    public final void a(Activity activity) {
        this.g = com.baidu.adp.lib.util.i.a((Context) activity, 70.0f);
        this.h = com.baidu.adp.lib.util.i.a((Context) activity, 70.0f);
    }

    public final int g() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final boolean h() {
        return this.e == 50;
    }

    public final int i() {
        return this.c;
    }

    public final int j() {
        return this.d;
    }

    public final void b(int i) {
        this.d = 0;
    }

    public final void c(int i) {
        this.d += i;
    }

    public final int k() {
        return this.e;
    }

    public final void d(int i) {
        this.e = i;
    }

    public final String l() {
        return this.a;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(Intent intent) {
        this.a = intent.getStringExtra("forum_id");
        this.b = intent.getBooleanExtra("show_recommend", true);
        this.c = this.b ? 1 : 2;
    }

    public final void a(Bundle bundle) {
        this.a = bundle.getString("forum_id");
        this.b = bundle.getBoolean("show_recommend");
        this.c = bundle.getInt("card_type");
        this.d = bundle.getInt("start_position");
        this.e = bundle.getInt("end_position");
        this.i = (GroupPermData) bundle.getSerializable("group_perm");
    }

    public final void a(String str, int i, int i2, int i3, int i4, int i5) {
        com.baidu.tieba.im.message.ag agVar = new com.baidu.tieba.im.message.ag();
        agVar.a(str);
        agVar.b(String.valueOf(i));
        agVar.c(String.valueOf(i2));
        agVar.d(String.valueOf(i3));
        agVar.d(i4);
        agVar.e(i5);
        this.k.a(agVar);
    }

    @Override // com.baidu.adp.a.e
    public final void registerListener(com.baidu.adp.framework.c.c<?> cVar) {
        this.k.a(cVar);
    }

    public final void b(String str, int i, int i2, int i3, int i4, int i5) {
        com.baidu.tieba.im.message.af afVar = new com.baidu.tieba.im.message.af();
        afVar.a(str);
        afVar.b(String.valueOf(i));
        afVar.c(String.valueOf(i2));
        afVar.d(String.valueOf(i3));
        afVar.c(i4);
        afVar.d(i5);
        this.k.a(afVar);
    }

    private static com.baidu.tieba.im.message.bk d(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.im.message.bk bkVar = new com.baidu.tieba.im.message.bk();
        bkVar.b(j);
        return bkVar;
    }

    public final void c(String str) {
        this.k.a(d(str));
    }

    public final void a(com.baidu.adp.framework.c.c<?> cVar) {
        this.k.a(cVar);
    }

    public final void b(Bundle bundle) {
        bundle.putString("forum_id", this.a);
        bundle.putBoolean("show_recommend", this.b);
        bundle.putInt("card_type", this.c);
        bundle.putInt("start_position", this.d);
        bundle.putInt("end_position", this.e);
        bundle.putSerializable("group_perm", this.i);
    }
}
