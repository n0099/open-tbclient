package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
/* loaded from: classes.dex */
public abstract class c extends com.baidu.tieba.im.b<da> {
    private s a = null;

    public abstract da a(s sVar);

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ da a() {
        da a = a(this.a);
        if (a != null) {
            a.a(this.a);
        }
        return a;
    }

    public final void b(s sVar) {
        this.a = sVar;
    }
}
