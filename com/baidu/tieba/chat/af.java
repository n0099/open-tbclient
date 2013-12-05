package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.chat.ChatData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f1175a;
    private com.baidu.tieba.a.e b = null;

    public af(ac acVar) {
        this.f1175a = acVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ae aeVar;
        ae aeVar2;
        super.b();
        aeVar = this.f1175a.k;
        if (aeVar != null) {
            aeVar2 = this.f1175a.k;
            aeVar2.a();
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
        str = this.f1175a.b;
        str2 = this.f1175a.d;
        eVar.a(str, str2);
        if (this.b != null && this.b.b() && this.b.d() == 0) {
            this.f1175a.h();
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
        this.f1175a.j = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ae aeVar;
        ae aeVar2;
        ChatData chatData;
        ae aeVar3;
        ChatData chatData2;
        super.a((af) bool);
        if (bool.booleanValue()) {
            chatData = this.f1175a.h;
            chatData.clearData();
            aeVar3 = this.f1175a.k;
            chatData2 = this.f1175a.h;
            aeVar3.a(true, null, false, 0, chatData2, false);
        } else if (this.b != null) {
            if (this.b.b()) {
                aeVar2 = this.f1175a.k;
                aeVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                aeVar = this.f1175a.k;
                aeVar.a(false, this.b.c(), false, 0, null, false);
            }
        }
        this.f1175a.j = null;
    }
}
