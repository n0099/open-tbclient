package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<String, Integer, String> {
    private com.baidu.tbadk.core.util.ad CX;
    final /* synthetic */ EditHeadActivity this$0;

    private o(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
        this.CX = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(EditHeadActivity editHeadActivity, o oVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(com.baidu.tieba.z.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        Exception e;
        this.CX = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
        try {
            str = this.CX.cx(TbConfig.PERSON_HEAD_FILE);
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            if (this.CX.oZ().qh().ma()) {
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
        this.this$0.Py = null;
        if (this.CX != null) {
            this.CX.dJ();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        this.this$0.closeLoadingDialog();
        if (this.CX != null) {
            if (this.CX.oZ().qh().ma()) {
                this.this$0.setResult(-1);
                this.this$0.finish();
                this.this$0.showToast(this.this$0.getPageContext().getString(com.baidu.tieba.z.upload_head_ok));
                return;
            }
            this.this$0.showToast(this.CX.getErrorString());
        }
    }
}
