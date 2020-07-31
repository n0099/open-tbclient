package com.baidu.tbadk.coreExtra.share;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private a etz;

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
                z zVar = new z();
                zVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_SHARE_IMAGE);
                if (shareItem2.typeShareToSmallApp == 4) {
                    zVar.addPostData("forum_id", shareItem.fid);
                    zVar.addPostData("type", "2");
                } else {
                    zVar.addPostData("thread_id", str2);
                    zVar.addPostData("type", "3");
                }
                String postNetData = zVar.postNetData();
                if (as.isEmpty(postNetData)) {
                    return shareItem2;
                }
                try {
                    str = new JSONObject(postNetData).optString(BigdayActivityConfig.IMG_URL);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                if (shareItem2.typeShareToSmallApp != 4) {
                    shareItem2.euh = str;
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
                if (b.this.etz != null) {
                    b.this.etz.e(shareItem2);
                }
            }
        }.execute(shareItem);
    }

    public void a(a aVar) {
        this.etz = aVar;
    }
}
