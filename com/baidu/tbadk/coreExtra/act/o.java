package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ EditHeadActivity this$0;
    private com.baidu.tbadk.core.util.ac yV;

    private o(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
        this.yV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(EditHeadActivity editHeadActivity, o oVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.this$0.showLoadingDialog(this.this$0.getString(com.baidu.tieba.y.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        String str;
        Exception e;
        this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
        try {
            str = this.yV.bG(TbConfig.PERSON_HEAD_FILE);
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            if (this.yV.mc().nb().jq()) {
                return str;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.this$0.closeLoadingDialog();
        this.this$0.JM = null;
        if (this.yV != null) {
            this.yV.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        this.this$0.closeLoadingDialog();
        if (this.yV != null) {
            if (this.yV.mc().nb().jq()) {
                this.this$0.setResult(-1);
                this.this$0.finish();
                this.this$0.showToast(this.this$0.getString(com.baidu.tieba.y.upload_head_ok));
                return;
            }
            this.this$0.showToast(this.yV.getErrorString());
        }
    }
}
