package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private long f1817a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private List<Long> f;
    private boolean g;
    private RequestMembersMessage h;

    public RequestMembersMessage a() {
        return this.h;
    }

    public void a(RequestMembersMessage requestMembersMessage) {
        this.h = requestMembersMessage;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public boolean c() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public List<Long> d() {
        return this.f;
    }

    public void a(List<Long> list) {
        this.f = list;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public int e() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.c += i;
    }

    public int f() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public long g() {
        return this.f1817a;
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
        this.f1817a = intent.getLongExtra("group_id", 0L);
    }

    public void a(Bundle bundle) {
        this.f1817a = bundle.getLong("group_id", 0L);
        this.c = bundle.getInt("start_position", 0);
        this.d = bundle.getInt("len_position", 0);
    }

    private RequestMembersMessage b(long j, int i, int i2, int i3) {
        RequestMembersMessage requestMembersMessage = new RequestMembersMessage();
        requestMembersMessage.setGroupId(j);
        requestMembersMessage.setOffset(i);
        requestMembersMessage.setRn(i2);
        requestMembersMessage.setOrderType(i3);
        return requestMembersMessage;
    }

    private RequestRemoveMembersMessage b(long j, String str) {
        RequestRemoveMembersMessage requestRemoveMembersMessage = new RequestRemoveMembersMessage();
        requestRemoveMembersMessage.setGroupId(j);
        requestRemoveMembersMessage.setUserIds(str);
        return requestRemoveMembersMessage;
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
        bundle.putLong("group_id", this.f1817a);
        bundle.putInt("start_position", this.c);
        bundle.putInt("len_position", this.d);
    }
}
