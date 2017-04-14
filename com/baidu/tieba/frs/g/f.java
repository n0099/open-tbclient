package com.baidu.tieba.frs.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final FrsActivity bTd;
    private a caX;

    public f(FrsActivity frsActivity) {
        this.bTd = frsActivity;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.bTd != null && this.bTd.Zr() != null && this.bTd.Zr().aJw() != null && !StringUtils.isNull(this.bTd.Zr().aJw().getName()) && this.bTd.Zr().fuh != null && adI() && this.caX == null) {
            this.caX = new a(this, null);
            this.caX.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adI() {
        PopInfo popInfo = this.bTd.Zr().fuh;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.bTd.Zr().fuh.if_pop.intValue() == 0) ? false : true;
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
            String encode = URLEncoder.encode(f.this.bTd.Zr().aJw().getName());
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
            if (bool.booleanValue() && f.this.adI()) {
                PopInfo popInfo = f.this.bTd.Zr().fuh;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.bTd.getActivity());
                aVar.cD(popInfo.title);
                aVar.cE(popInfo.v_title);
                aVar.tN();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.bTd.getPageContext()).tQ();
            }
        }
    }
}
