package com.baidu.tieba.im.chat;

import android.widget.FrameLayout;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ AbsMsgImageActivity aWp;
    byte[] mData;
    String mUrl;

    public h(AbsMsgImageActivity absMsgImageActivity, String str, byte[] bArr) {
        this.aWp = absMsgImageActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.o.a(this.mUrl, this.mData, this.aWp.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.o.rI();
            case -1:
            default:
                return this.aWp.getPageContext().getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.aWp.getPageContext().getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        FrameLayout frameLayout;
        super.onPostExecute((h) str);
        this.aWp.aWb = null;
        frameLayout = this.aWp.aWc;
        frameLayout.setClickable(true);
        this.aWp.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        FrameLayout frameLayout;
        this.aWp.aWb = null;
        frameLayout = this.aWp.aWc;
        frameLayout.setClickable(true);
        super.cancel(true);
    }
}
