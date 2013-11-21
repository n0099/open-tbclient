package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.chat.ChatData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1128a;
    private com.baidu.tieba.a.e b = null;

    public ae(ab abVar) {
        this.f1128a = abVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ad adVar;
        ad adVar2;
        super.b();
        adVar = this.f1128a.k;
        if (adVar != null) {
            adVar2 = this.f1128a.k;
            adVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        this.b = new com.baidu.tieba.a.e();
        com.baidu.tieba.a.e eVar = this.b;
        str = this.f1128a.b;
        str2 = this.f1128a.d;
        eVar.a(str, str2);
        if (this.b != null && this.b.b() && this.b.d() == 0) {
            this.f1128a.h();
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f1128a.j = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ad adVar;
        ad adVar2;
        ChatData chatData;
        ad adVar3;
        ChatData chatData2;
        super.a((ae) bool);
        if (bool.booleanValue()) {
            chatData = this.f1128a.h;
            chatData.clearData();
            adVar3 = this.f1128a.k;
            chatData2 = this.f1128a.h;
            adVar3.a(true, null, false, 0, chatData2, false);
        } else if (this.b != null) {
            if (this.b.b()) {
                adVar2 = this.f1128a.k;
                adVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                adVar = this.f1128a.k;
                adVar.a(false, this.b.c(), false, 0, null, false);
            }
        }
        this.f1128a.j = null;
    }
}
