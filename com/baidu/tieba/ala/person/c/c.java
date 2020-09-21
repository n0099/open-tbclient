package com.baidu.tieba.ala.person.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.az;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.data.Config;
/* loaded from: classes4.dex */
public class c {
    private Context context;
    private a gUY;
    private b gUZ;
    private boolean hasMore;
    private TbPageContext mTbPageContext;
    private int pn = 0;
    private int type;
    private String url;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.person.a.c cVar);

        void onFail(String str);
    }

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.context = tbPageContext.getPageActivity();
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void i(int i, String str, String str2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gUY != null) {
                this.gUY.onFail(this.context.getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.type = i;
        if (i == 0) {
            this.url = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        } else {
            this.url = TbConfig.SERVER_ADDRESS + "ala/user/followList";
        }
        this.pn++;
        this.gUZ = new b();
        this.gUZ.execute(str, str2);
    }

    public void cancel() {
        if (this.gUZ != null && !this.gUZ.isCancelled()) {
            this.gUZ.cancel();
        }
        if (this.gUY != null) {
            this.gUY.onFail(null);
        }
    }

    public void a(a aVar) {
        this.gUY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Void, Object> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            com.baidu.tieba.ala.person.a.c cVar;
            NetWork netWork = new NetWork(c.this.url);
            String str = strArr[0];
            String str2 = strArr[1];
            netWork.addPostData("uid", str);
            netWork.addPostData("meta_key", str2);
            if (c.this.type == 0) {
                if (c.this.pn > 0) {
                    netWork.addPostData(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(c.this.pn));
                }
            } else {
                netWork.addPostData(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(c.this.pn));
            }
            if (c.this.type == 0) {
                netWork.addPostData("need_concern", "1");
            }
            netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            String postNetData = netWork.postNetData();
            if (netWork.isRequestSuccess()) {
                String bb = com.baidu.tieba.ala.person.d.a.bb(c.this.type, postNetData);
                if (TextUtils.isEmpty(bb)) {
                    return null;
                }
                com.baidu.tieba.ala.person.a.c cVar2 = new com.baidu.tieba.ala.person.a.c();
                cVar2.parserJson(bb);
                c.this.hasMore = cVar2.has_more == 1;
                if (c.this.type == 1) {
                    c.this.a(str, cVar2);
                }
                cVar = cVar2;
            } else {
                cVar = null;
            }
            return cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (c.this.gUY != null) {
                c.this.gUY.c((com.baidu.tieba.ala.person.a.c) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.baidu.tieba.ala.person.a.c cVar) {
        if (cVar != null && cVar.user_list != null && !cVar.user_list.isEmpty()) {
            for (az azVar : cVar.user_list) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.equals(str)) {
                    azVar.aJZ = 1;
                }
            }
        }
    }
}
