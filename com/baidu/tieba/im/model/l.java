package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.as;
import com.baidu.tieba.im.message.az;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.d {
    private long a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private List<Long> f;
    private boolean g;
    private as h;

    public void a(as asVar) {
        this.h = asVar;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public boolean b() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public List<Long> c() {
        return this.f;
    }

    public void a(List<Long> list) {
        this.f = list;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public int d() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.c += i;
    }

    public int e() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public long f() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.a = intent.getLongExtra("group_id", 0L);
    }

    public void a(Bundle bundle) {
        this.a = bundle.getLong("group_id", 0L);
        this.c = bundle.getInt("start_position", 0);
        this.d = bundle.getInt("len_position", 0);
    }

    private as b(long j, int i, int i2, int i3) {
        as asVar = new as();
        asVar.a(j);
        asVar.a(i);
        asVar.b(i2);
        asVar.c(i3);
        return asVar;
    }

    private az b(long j, String str) {
        az azVar = new az();
        azVar.a(j);
        azVar.a(str);
        return azVar;
    }

    public void a(long j, int i, int i2, int i3) {
        com.baidu.tieba.im.messageCenter.e.a().a(b(j, i, i2, i3));
    }

    public void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(103005, gVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
    }

    public void a(long j, String str) {
        com.baidu.tieba.im.messageCenter.e.a().a(b(j, str));
    }

    public void c(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(103112, gVar);
    }

    public void d(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
    }

    public void b(Bundle bundle) {
        bundle.putLong("group_id", this.a);
        bundle.putInt("start_position", this.c);
        bundle.putInt("len_position", this.d);
    }
}
