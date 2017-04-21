package com.baidu.tieba.frs.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final FrsActivity bVu;
    private a cdo;

    public f(FrsActivity frsActivity) {
        this.bVu = frsActivity;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.bVu != null && this.bVu.aas() != null && this.bVu.aas().aKx() != null && !StringUtils.isNull(this.bVu.aas().aKx().getName()) && this.bVu.aas().fwx != null && aeJ() && this.cdo == null) {
            this.cdo = new a(this, null);
            this.cdo.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aeJ() {
        PopInfo popInfo = this.bVu.aas().fwx;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.bVu.aas().fwx.if_pop.intValue() == 0) ? false : true;
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
            com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.c.a.tM().cB("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(f.this.bVu.aas().aKx().getName());
            if (cB.get(encode) == null) {
                cB.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && f.this.aeJ()) {
                PopInfo popInfo = f.this.bVu.aas().fwx;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.bVu.getActivity());
                aVar.cD(popInfo.title);
                aVar.cE(popInfo.v_title);
                aVar.tN();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.bVu.getPageContext()).tQ();
            }
        }
    }
}
