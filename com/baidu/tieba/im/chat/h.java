package com.baidu.tieba.im.chat;

import android.widget.FrameLayout;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ AbsMsgImageActivity aZl;
    byte[] mData;
    String mUrl;

    public h(AbsMsgImageActivity absMsgImageActivity, String str, byte[] bArr) {
        this.aZl = absMsgImageActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.o.a(this.mUrl, this.mData, this.aZl.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.o.sr();
            case -1:
            default:
                return this.aZl.getPageContext().getString(com.baidu.tieba.t.save_error);
            case 0:
                return this.aZl.getPageContext().getString(com.baidu.tieba.t.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        FrameLayout frameLayout;
        super.onPostExecute((h) str);
        this.aZl.aYW = null;
        frameLayout = this.aZl.aYX;
        frameLayout.setClickable(true);
        this.aZl.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        FrameLayout frameLayout;
        this.aZl.aYW = null;
        frameLayout = this.aZl.aYX;
        frameLayout.setClickable(true);
        super.cancel(true);
    }
}
