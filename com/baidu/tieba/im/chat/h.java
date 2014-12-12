package com.baidu.tieba.im.chat;

import android.widget.FrameLayout;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ AbsMsgImageActivity aQe;
    byte[] mData;
    String mUrl;

    public h(AbsMsgImageActivity absMsgImageActivity, String str, byte[] bArr) {
        this.aQe = absMsgImageActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.s.a(this.mUrl, this.mData, this.aQe.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.s.op();
            case -1:
            default:
                return this.aQe.getPageContext().getString(com.baidu.tieba.z.save_error);
            case 0:
                return this.aQe.getPageContext().getString(com.baidu.tieba.z.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        FrameLayout frameLayout;
        super.onPostExecute((h) str);
        this.aQe.aPR = null;
        frameLayout = this.aQe.aPS;
        frameLayout.setClickable(true);
        this.aQe.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        FrameLayout frameLayout;
        this.aQe.aPR = null;
        frameLayout = this.aQe.aPS;
        frameLayout.setClickable(true);
        super.cancel(true);
    }
}
