package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
final class v extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ u b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, LinkedList linkedList) {
        this.b = uVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        return com.baidu.tieba.im.db.m.d().a(this.c);
    }
}
