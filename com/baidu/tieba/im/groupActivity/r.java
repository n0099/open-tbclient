package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestDelGroupActivityMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.RequestGetGroupActivityMessage;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.d {
    private int a;
    private long b;
    private int c;
    private RequestGetGroupActivityMessage d;
    private RequestGetGroupActivityLocalMessage e;
    private RequestDelGroupActivityMessage f;
    private BaseActivity g;
    private GroupActivityData h;

    public r(BaseActivity baseActivity) {
        this.g = baseActivity;
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int b() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public long c() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    private RequestGetGroupActivityMessage e(int i) {
        RequestGetGroupActivityMessage requestGetGroupActivityMessage = new RequestGetGroupActivityMessage();
        requestGetGroupActivityMessage.setActivityId(i);
        requestGetGroupActivityMessage.setFrom(this.c);
        return requestGetGroupActivityMessage;
    }

    private RequestGetGroupActivityLocalMessage f(int i) {
        RequestGetGroupActivityLocalMessage requestGetGroupActivityLocalMessage = new RequestGetGroupActivityLocalMessage();
        requestGetGroupActivityLocalMessage.setActivityId(i);
        requestGetGroupActivityLocalMessage.setFrom(this.c);
        return requestGetGroupActivityLocalMessage;
    }

    public void c(int i) {
        this.d = e(i);
        this.g.sendMessage(this.d);
    }

    @Override // com.baidu.adp.base.d
    public void cancelMessage() {
    }

    public void d(int i) {
        this.e = f(i);
        this.g.sendMessage(this.e);
    }

    public Message<?> d() {
        return this.e;
    }

    public Message<?> e() {
        return this.d;
    }

    public Message<?> f() {
        return this.f;
    }

    public void a(long j, int i) {
        this.f = new RequestDelGroupActivityMessage();
        this.f.setActivityId(i);
        this.f.setGroupId((int) j);
        this.g.sendMessage(this.f);
    }

    public GroupActivityData g() {
        return this.h;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.h = groupActivityData;
        }
    }
}
