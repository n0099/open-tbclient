package com.baidu.tieba.ala.person.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tieba.ala.person.a.d;
/* loaded from: classes4.dex */
public class c {
    private Context context;
    private a gEM;
    private b gEN;
    private boolean hasMore;
    private TbPageContext mTbPageContext;
    private int pn = 0;
    private int type;
    private String url;

    /* loaded from: classes4.dex */
    public interface a {
        void c(d dVar);

        void onFail(String str);
    }

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.context = tbPageContext.getPageActivity();
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void h(int i, String str, String str2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gEM != null) {
                this.gEM.onFail(this.context.getResources().getString(a.i.sdk_no_network));
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
        this.gEN = new b();
        this.gEN.execute(str, str2);
    }

    public void cancel() {
        if (this.gEN != null && !this.gEN.isCancelled()) {
            this.gEN.cancel();
        }
        if (this.gEM != null) {
            this.gEM.onFail(null);
        }
    }

    public void a(a aVar) {
        this.gEM = aVar;
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
            d dVar;
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
                String ba = com.baidu.tieba.ala.person.d.a.ba(c.this.type, postNetData);
                if (TextUtils.isEmpty(ba)) {
                    return null;
                }
                d dVar2 = new d();
                dVar2.parserJson(ba);
                c.this.hasMore = dVar2.has_more == 1;
                if (c.this.type == 1) {
                    c.this.a(str, dVar2);
                }
                dVar = dVar2;
            } else {
                dVar = null;
            }
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (c.this.gEM != null) {
                c.this.gEM.c((d) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar) {
        if (dVar != null && dVar.user_list != null && !dVar.user_list.isEmpty()) {
            for (com.baidu.tieba.ala.person.a.b bVar : dVar.user_list) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.equals(str)) {
                    bVar.fVo = 1;
                }
            }
        }
    }
}
