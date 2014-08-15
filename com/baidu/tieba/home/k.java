package com.baidu.tieba.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.z;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<z, Integer, String> {
    final /* synthetic */ e a;
    private ae b = null;
    private z c;

    public k(e eVar, z zVar) {
        this.a = eVar;
        this.c = null;
        this.c = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(z... zVarArr) {
        z zVar = this.c;
        if (zVar != null) {
            try {
                if (zVar.a() != null && zVar.b() != null) {
                    this.b = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.b.a("fid", zVar.a());
                    this.b.a("kw", zVar.b());
                    this.b.a().a().a = true;
                    this.b.h();
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        p pVar;
        super.onPostExecute(str);
        this.a.c = null;
        if (this.b != null) {
            if (this.b.a().b().b()) {
                baseFragmentActivity2 = this.a.h;
                baseFragmentActivity2.a(this.a.getString(x.success));
                ai.c().e(true);
                pVar = this.a.b;
                pVar.a();
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.c.a()));
                return;
            }
            baseFragmentActivity = this.a.h;
            baseFragmentActivity.a(this.b.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.f();
            this.b = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
