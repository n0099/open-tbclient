package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final FrsActivity bMj;
    private a bVe;

    public f(FrsActivity frsActivity) {
        this.bMj = frsActivity;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.bMj != null && this.bMj.XW() != null && this.bMj.XW().aJY() != null && !StringUtils.isNull(this.bMj.XW().aJY().getName()) && this.bMj.XW().fnZ != null && acN() && this.bVe == null) {
            this.bVe = new a(this, null);
            this.bVe.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acN() {
        PopInfo popInfo = this.bMj.XW().fnZ;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.bMj.XW().fnZ.if_pop.intValue() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Void... voidArr) {
            com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.c.a.sR().cB("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(f.this.bMj.XW().aJY().getName());
            if (cB.get(encode) == null) {
                cB.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && f.this.acN()) {
                PopInfo popInfo = f.this.bMj.XW().fnZ;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.bMj.getActivity());
                aVar.cD(popInfo.title);
                aVar.cE(popInfo.v_title);
                aVar.sS();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.bMj.getPageContext()).sV();
            }
        }
    }
}
