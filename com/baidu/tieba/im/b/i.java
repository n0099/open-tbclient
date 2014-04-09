package com.baidu.tieba.im.b;

import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.m;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends m<Void> {
    private final /* synthetic */ LinkedList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LinkedList linkedList) {
        this.b = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        return o.d().a(this.b);
    }
}
