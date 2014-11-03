package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ GroupImageActivity baw;
    byte[] dL;
    String mUrl;

    public k(GroupImageActivity groupImageActivity, String str, byte[] bArr) {
        this.baw = groupImageActivity;
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
        switch (com.baidu.tbadk.core.util.s.a(this.mUrl, this.dL, this.baw)) {
            case -2:
                return com.baidu.tbadk.core.util.s.lu();
            case -1:
            default:
                return this.baw.getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.baw.getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((k) str);
        this.baw.showToast(str);
        this.baw.bau = null;
        this.baw.hideProgressBar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.baw.bau = null;
        this.baw.hideProgressBar();
        super.cancel(true);
    }
}
