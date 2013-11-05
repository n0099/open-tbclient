package com.baidu.tieba.im.messageCenter;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.a<s> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f1648a = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(s sVar) {
        LinkedList linkedList;
        linkedList = this.f1648a.e;
        if (j.c(sVar, linkedList)) {
            this.f1648a.e(sVar);
        }
    }
}
