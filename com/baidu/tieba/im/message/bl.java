package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public final class bl {
    private GroupData a;
    private List<MemberData> b;
    private List<PhotoUrlData> c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private GroupActivityData k;

    public final GroupActivityData a() {
        return this.k;
    }

    public final void a(GroupActivityData groupActivityData) {
        this.k = groupActivityData;
    }

    public final GroupData b() {
        return this.a;
    }

    public final void a(GroupData groupData) {
        this.a = groupData;
    }

    public final List<MemberData> c() {
        return this.b;
    }

    public final void a(List<MemberData> list) {
        this.b = list;
    }

    public final List<PhotoUrlData> d() {
        return this.c;
    }

    public final void b(List<PhotoUrlData> list) {
        this.c = list;
    }

    public final int e() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final int f() {
        return this.e;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final boolean g() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final boolean h() {
        return this.g;
    }

    public final void b(boolean z) {
        this.g = z;
    }

    public final boolean i() {
        return this.h;
    }

    public final void c(boolean z) {
        this.h = z;
    }

    public final boolean j() {
        return this.i;
    }

    public final void d(boolean z) {
        this.i = z;
    }

    public final boolean k() {
        return this.j;
    }

    public final void e(boolean z) {
        this.j = z;
    }
}
