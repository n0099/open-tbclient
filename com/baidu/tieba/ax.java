package com.baidu.tieba;

import android.app.Application;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax implements com.baidu.tieba.im.a<Integer> {
    private final /* synthetic */ AccountData a;
    private final /* synthetic */ Application b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(AccountData accountData, Application application) {
        this.a = accountData;
        this.b = application;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Integer num) {
        AccountData accountData = this.a;
        Application application = this.b;
        com.baidu.tieba.im.e.a();
        com.baidu.tieba.im.i.b();
    }
}
