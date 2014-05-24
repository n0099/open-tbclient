package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.data.Hao123Data;
import com.baidu.tieba.model.Hao123Model;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;
    private int c = 0;
    private boolean d;

    public f(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.a = accountActivity;
        this.d = false;
        this.b = accountData;
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.y.deleting), new g(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public AccountData doInBackground(Object... objArr) {
        try {
            Thread.sleep(1000L);
            if (this.d) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2010015, this.b.getID()));
            }
            com.baidu.tieba.util.k.h(this.b.getID());
            if (this.b.getID().equals(TbadkApplication.getCurrentAccount())) {
                this.c = 2;
                a();
                return null;
            }
            this.c = 0;
            return null;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return null;
        }
    }

    private void a() {
        String hao123Cache = Hao123Model.getHao123Cache();
        if (!TextUtils.isEmpty(hao123Cache)) {
            Hao123Data hao123Data = (Hao123Data) new Gson().fromJson(hao123Cache, (Class<Object>) Hao123Data.class);
            hao123Data.login = "no";
            Hao123Model.setHao123Cache(new Gson().toJson(hao123Data));
            return;
        }
        Hao123Data hao123Data2 = new Hao123Data();
        hao123Data2.login = "no";
        Hao123Model.setHao123Cache(new Gson().toJson(hao123Data2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(AccountData accountData) {
        ArrayList arrayList;
        l lVar;
        if (this.b != null) {
            new h(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        if (this.c != 0) {
            TbadkApplication.setCurrentAccount(null, this.a);
        }
        switch (this.c) {
            case 0:
                this.a.showToast(this.a.getString(com.baidu.tieba.y.success));
                arrayList = this.a.a;
                arrayList.remove(this.b);
                this.b = null;
                lVar = this.a.b;
                lVar.notifyDataSetChanged();
                break;
            case 2:
                SapiAccountManager.getInstance().logout();
                TbadkApplication.m252getInst().onUserChanged();
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
                com.baidu.tbadk.core.b.b.a(this.a, 11, false);
                break;
        }
        this.a.i = null;
    }
}
