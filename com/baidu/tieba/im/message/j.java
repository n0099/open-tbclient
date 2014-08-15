package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class j {
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

    public GroupActivityData a() {
        return this.k;
    }

    public void a(GroupActivityData groupActivityData) {
        this.k = groupActivityData;
    }

    public GroupData b() {
        return this.a;
    }

    public void a(GroupData groupData) {
        this.a = groupData;
    }

    public List<MemberData> c() {
        return this.b;
    }

    public void a(List<MemberData> list) {
        this.b = list;
    }

    public List<PhotoUrlData> d() {
        return this.c;
    }

    public void b(List<PhotoUrlData> list) {
        this.c = list;
    }

    public int e() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int f() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public boolean g() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean h() {
        return this.g;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public boolean i() {
        return this.h;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public boolean j() {
        return this.i;
    }

    public void d(boolean z) {
        this.i = z;
    }

    public boolean k() {
        return this.j;
    }

    public void e(boolean z) {
        this.j = z;
    }
}
