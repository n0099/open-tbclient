package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ GroupImageActivity bah;
    byte[] dL;
    String mUrl;

    public j(GroupImageActivity groupImageActivity, String str, byte[] bArr) {
        this.bah = groupImageActivity;
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
        switch (com.baidu.tbadk.core.util.s.a(this.mUrl, this.dL, this.bah)) {
            case -2:
                return com.baidu.tbadk.core.util.s.lu();
            case -1:
            default:
                return this.bah.getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.bah.getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((j) str);
        this.bah.showToast(str);
        this.bah.bag = null;
        this.bah.hideProgressBar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bah.bag = null;
        this.bah.hideProgressBar();
        super.cancel(true);
    }
}
