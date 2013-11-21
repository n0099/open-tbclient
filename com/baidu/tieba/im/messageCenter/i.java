package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends SingleRunnable<s> {

    /* renamed from: a  reason: collision with root package name */
    private s f1724a;

    public i(s sVar) {
        this.f1724a = null;
        this.f1724a = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public s b() {
        if (this.f1724a != null) {
            this.f1724a.a();
        }
        return this.f1724a;
    }
}
