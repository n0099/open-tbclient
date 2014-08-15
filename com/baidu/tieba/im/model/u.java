package com.baidu.tieba.im.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import java.util.List;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e {
    private long a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private List<Long> f;
    private boolean g;
    private RequestMembersMessage h;

    public u(Context context) {
        super(context);
    }

    public void a(RequestMembersMessage requestMembersMessage) {
        this.h = requestMembersMessage;
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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.a = intent.getLongExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0L);
    }

    public void a(Bundle bundle) {
        this.a = bundle.getLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0L);
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
        super.sendMessage(b(j, i, i2, i3));
    }

    public void a(long j, String str) {
        super.sendMessage(b(j, str));
    }

    public void b(Bundle bundle) {
        bundle.putLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, this.a);
        bundle.putInt("start_position", this.c);
        bundle.putInt("len_position", this.d);
    }
}
