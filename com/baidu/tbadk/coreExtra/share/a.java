package com.baidu.tbadk.coreExtra.share;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0374a dll;

    /* renamed from: com.baidu.tbadk.coreExtra.share.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0374a {
        void d(ShareItem shareItem);
    }

    public void b(final ShareItem shareItem) {
        new BdAsyncTask<ShareItem, Integer, ShareItem>() { // from class: com.baidu.tbadk.coreExtra.share.a.1
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
                x xVar = new x();
                xVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_SHARE_IMAGE);
                if (shareItem2.typeShareToSmallApp == 4) {
                    xVar.addPostData("forum_id", shareItem.fid);
                    xVar.addPostData("type", "2");
                } else {
                    xVar.addPostData("thread_id", str2);
                    xVar.addPostData("type", "3");
                }
                String postNetData = xVar.postNetData();
                if (aq.isEmpty(postNetData)) {
                    return shareItem2;
                }
                try {
                    str = new JSONObject(postNetData).optString(BigdayActivityConfig.IMG_URL);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                if (shareItem2.typeShareToSmallApp != 4) {
                    shareItem2.dlT = str;
                    shareItem2.imageUri = Uri.parse(str);
                }
                return shareItem2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public void onPostExecute(ShareItem shareItem2) {
                super.onPostExecute(shareItem2);
                if (a.this.dll != null) {
                    a.this.dll.d(shareItem2);
                }
            }
        }.execute(shareItem);
    }

    public void a(InterfaceC0374a interfaceC0374a) {
        this.dll = interfaceC0374a;
    }
}
