package com.baidu.tbadk.coreExtra.share;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private a eGh;

    /* loaded from: classes.dex */
    public interface a {
        void e(ShareItem shareItem);
    }

    public void c(final ShareItem shareItem) {
        new BdAsyncTask<ShareItem, Integer, ShareItem>() { // from class: com.baidu.tbadk.coreExtra.share.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: a */
            public ShareItem doInBackground(ShareItem... shareItemArr) {
                ShareItem shareItem2;
                String str = null;
                if (shareItemArr == null || shareItemArr.length < 1 || (shareItem2 = shareItemArr[0]) == null) {
                    return null;
                }
                String str2 = shareItem2.tid;
                aa aaVar = new aa();
                aaVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_SHARE_IMAGE);
                if (shareItem2.typeShareToSmallApp == 4) {
                    aaVar.addPostData("forum_id", shareItem.fid);
                    aaVar.addPostData("type", "2");
                } else {
                    aaVar.addPostData("thread_id", str2);
                    aaVar.addPostData("type", "3");
                }
                String postNetData = aaVar.postNetData();
                if (at.isEmpty(postNetData)) {
                    return shareItem2;
                }
                try {
                    str = new JSONObject(postNetData).optString(BigdayActivityConfig.IMG_URL);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                if (shareItem2.typeShareToSmallApp != 4) {
                    shareItem2.eGR = str;
                    shareItem2.imageUri = Uri.parse(str);
                }
                return shareItem2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public void onPostExecute(ShareItem shareItem2) {
                super.onPostExecute(shareItem2);
                if (b.this.eGh != null) {
                    b.this.eGh.e(shareItem2);
                }
            }
        }.execute(shareItem);
    }

    public void a(a aVar) {
        this.eGh = aVar;
    }
}
