package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.adp.framework.c.g;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(103011);
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        int i;
        String str;
        String str2;
        e eVar4;
        e eVar5;
        e unused;
        e unused2;
        int unused3;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2.e() != 0) {
            eVar4 = this.a.h;
            if (eVar4 != null) {
                unused = this.a.h;
                if (socketResponsedMessage2.e() <= 0 || TextUtils.isEmpty(socketResponsedMessage2.f())) {
                    return;
                }
                eVar5 = this.a.h;
                eVar5.b(socketResponsedMessage2.f());
            }
        } else if (socketResponsedMessage2 instanceof ResponseQueryGroupCountMessage) {
            ResponseQueryGroupCountMessage responseQueryGroupCountMessage = (ResponseQueryGroupCountMessage) socketResponsedMessage2;
            this.a.d = responseQueryGroupCountMessage.j();
            this.a.e = responseQueryGroupCountMessage.k();
            this.a.f = responseQueryGroupCountMessage.i();
            this.a.g = responseQueryGroupCountMessage.d();
            a.a = false;
            eVar = this.a.h;
            if (eVar != null) {
                unused2 = this.a.h;
            }
            eVar2 = this.a.h;
            if (eVar2 != null) {
                eVar3 = this.a.h;
                unused3 = this.a.d;
                i = this.a.e;
                str = this.a.g;
                str2 = this.a.f;
                eVar3.a(i, str, str2);
            }
        }
    }
}
