package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends com.baidu.adp.framework.c.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(2001114);
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        e eVar;
        e eVar2;
        int i;
        String str;
        String str2;
        e eVar3;
        e eVar4;
        e unused;
        int unused2;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2.e() != 0) {
            eVar3 = this.a.h;
            if (eVar3 != null) {
                unused = this.a.h;
                if (customResponsedMessage2.e() <= 0 || TextUtils.isEmpty(customResponsedMessage2.f())) {
                    return;
                }
                eVar4 = this.a.h;
                eVar4.a(customResponsedMessage2.f());
            }
        } else if (customResponsedMessage2 instanceof ResponseQueryGroupCountLocalMessage) {
            ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = (ResponseQueryGroupCountLocalMessage) customResponsedMessage2;
            this.a.d = responseQueryGroupCountLocalMessage.d();
            this.a.e = responseQueryGroupCountLocalMessage.i();
            this.a.f = responseQueryGroupCountLocalMessage.c();
            this.a.g = responseQueryGroupCountLocalMessage.b();
            this.a.a();
            eVar = this.a.h;
            if (eVar != null) {
                eVar2 = this.a.h;
                unused2 = this.a.d;
                i = this.a.e;
                str = this.a.g;
                str2 = this.a.f;
                eVar2.a(i, str, str2);
            }
        }
    }
}
