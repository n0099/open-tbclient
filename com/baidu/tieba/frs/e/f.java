package com.baidu.tieba.frs.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final com.baidu.tieba.frs.r bPw;
    private a cbb;

    public f(com.baidu.tieba.frs.r rVar) {
        this.bPw = rVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.bPw != null && this.bPw.Zq() != null && this.bPw.Zq().aHE() != null && !StringUtils.isNull(this.bPw.Zq().aHE().getName()) && this.bPw.Zq().fsD != null && acL() && this.cbb == null) {
            this.cbb = new a(this, null);
            this.cbb.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acL() {
        PopInfo popInfo = this.bPw.Zq().fsD;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.bPw.Zq().fsD.if_pop.intValue() == 0) ? false : true;
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
            com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.c.a.sZ().cz("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(f.this.bPw.Zq().aHE().getName());
            if (cz.get(encode) == null) {
                cz.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && f.this.acL()) {
                PopInfo popInfo = f.this.bPw.Zq().fsD;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.bPw.getActivity());
                aVar.cB(popInfo.title);
                aVar.cC(popInfo.v_title);
                aVar.ta();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.bPw.getPageContext()).td();
            }
        }
    }
}
