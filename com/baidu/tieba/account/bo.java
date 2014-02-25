package com.baidu.tieba.account;

import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class bo extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ bn a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar, AccountData accountData) {
        this.a = bnVar;
        this.b = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        DatabaseService.a(this.b);
        DatabaseService.b(this.b);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Void r4) {
        SapiFastRegActivity sapiFastRegActivity;
        String str;
        SapiFastRegActivity sapiFastRegActivity2;
        SapiFastRegActivity sapiFastRegActivity3;
        Intent intent = new Intent();
        sapiFastRegActivity = this.a.a;
        str = sapiFastRegActivity.b;
        intent.putExtra("fast_reg_user_type", str);
        sapiFastRegActivity2 = this.a.a;
        sapiFastRegActivity2.setResult(-1, intent);
        sapiFastRegActivity3 = this.a.a;
        sapiFastRegActivity3.finish();
    }
}
