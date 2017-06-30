package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final com.baidu.tieba.frs.r cdv;
    private a cpD;

    public f(com.baidu.tieba.frs.r rVar) {
        this.cdv = rVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.cdv != null && this.cdv.aek() != null && this.cdv.aek().aMt() != null && !StringUtils.isNull(this.cdv.aek().aMt().getName()) && this.cdv.aek().fKw != null && ahH() && this.cpD == null) {
            this.cpD = new a(this, null);
            this.cpD.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahH() {
        PopInfo popInfo = this.cdv.aek().fKw;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.cdv.aek().fKw.if_pop.intValue() == 0) ? false : true;
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
            com.baidu.adp.lib.cache.o<String> cF = com.baidu.tbadk.core.c.a.sW().cF("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(f.this.cdv.aek().aMt().getName());
            if (cF.get(encode) == null) {
                cF.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && f.this.ahH()) {
                PopInfo popInfo = f.this.cdv.aek().fKw;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.cdv.getActivity());
                aVar.cH(popInfo.title);
                aVar.cI(popInfo.v_title);
                aVar.sX();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.cdv.getPageContext()).ta();
            }
        }
    }
}
