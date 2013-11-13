package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.Message;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1740a;
    private List<Message> b;
    private com.baidu.tieba.im.codec.p c;

    public q(p pVar, List<Message> list, com.baidu.tieba.im.codec.p pVar2) {
        this.f1740a = pVar;
        this.b = list;
        this.c = pVar2;
    }

    public List<Message> a() {
        return this.b;
    }

    public com.baidu.tieba.im.codec.p b() {
        return this.c;
    }
}
