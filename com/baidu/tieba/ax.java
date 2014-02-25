package com.baidu.tieba;

import android.app.Application;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tieba.im.a<Integer> {
    private final /* synthetic */ AccountData a;
    private final /* synthetic */ Application b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(AccountData accountData, Application application) {
        this.a = accountData;
        this.b = application;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Integer num) {
        com.baidu.tieba.im.f.a(this.a, this.b);
        com.baidu.tieba.im.j.b();
    }
}
