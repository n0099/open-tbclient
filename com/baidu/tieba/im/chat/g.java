package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ AbsMsgImageActivity aNO;
    byte[] dL;
    String mUrl;

    public g(AbsMsgImageActivity absMsgImageActivity, String str, byte[] bArr) {
        this.aNO = absMsgImageActivity;
        this.mUrl = null;
        this.dL = null;
        this.mUrl = str;
        this.dL = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.s.a(this.mUrl, this.dL, this.aNO)) {
            case -2:
                return com.baidu.tbadk.core.util.s.lu();
            case -1:
            default:
                return this.aNO.getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.aNO.getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((g) str);
        this.aNO.aND = null;
        this.aNO.hideProgressBar();
        this.aNO.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.aNO.aND = null;
        this.aNO.hideProgressBar();
        super.cancel(true);
    }
}
