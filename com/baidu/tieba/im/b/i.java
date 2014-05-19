package com.baidu.tieba.im.b;

import com.baidu.tieba.im.db.o;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ LinkedList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LinkedList linkedList) {
        this.b = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        return o.d().a(this.b);
    }
}
