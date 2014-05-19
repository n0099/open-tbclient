package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ EditHeadActivity a;
    private com.baidu.tbadk.core.util.al b;

    private o(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(EditHeadActivity editHeadActivity, o oVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.u.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        Exception e;
        this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
        try {
            str = this.b.b(TbConfig.PERSON_HEAD_FILE);
            try {
                if (this.b.a().b().b()) {
                    return str;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            str = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.closeLoadingDialog();
        this.a.u = null;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        this.a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.a().b().b()) {
                this.a.setResult(-1);
                this.a.finish();
                this.a.showToast(this.a.getString(com.baidu.tieba.u.upload_head_ok));
                return;
            }
            this.a.showToast(this.b.f());
        }
    }
}
