package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final com.baidu.tieba.frs.r bVm;
    private a chm;

    public f(com.baidu.tieba.frs.r rVar) {
        this.bVm = rVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.bVm != null && this.bVm.aau() != null && this.bVm.aau().aIz() != null && !StringUtils.isNull(this.bVm.aau().aIz().getName()) && this.bVm.aau().fAs != null && adO() && this.chm == null) {
            this.chm = new a(this, null);
            this.chm.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adO() {
        PopInfo popInfo = this.bVm.aau().fAs;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.bVm.aau().fAs.if_pop.intValue() == 0) ? false : true;
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
        public Boolean doInBackground(Void... voidArr) {
            com.baidu.adp.lib.cache.o<String> cy = com.baidu.tbadk.core.c.a.sY().cy("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(f.this.bVm.aau().aIz().getName());
            if (cy.get(encode) == null) {
                cy.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && f.this.adO()) {
                PopInfo popInfo = f.this.bVm.aau().fAs;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.bVm.getActivity());
                aVar.cA(popInfo.title);
                aVar.cB(popInfo.v_title);
                aVar.sZ();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.bVm.getPageContext()).tc();
            }
        }
    }
}
