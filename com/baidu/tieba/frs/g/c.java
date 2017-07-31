package com.baidu.tieba.frs.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.at;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class c {
    private final com.baidu.tieba.frs.f ckn;
    private a cxP;

    public c(com.baidu.tieba.frs.f fVar) {
        this.ckn = fVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.ckn != null && this.ckn.afr() != null && this.ckn.afr().aPh() != null && !StringUtils.isNull(this.ckn.afr().aPh().getName()) && this.ckn.afr().ggd != null && ajr() && this.cxP == null) {
            this.cxP = new a();
            this.cxP.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajr() {
        PopInfo popInfo = this.ckn.afr().ggd;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.ckn.afr().ggd.if_pop.intValue() == 0) ? false : true;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            l<String> cQ = com.baidu.tbadk.core.c.a.tn().cQ("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.ckn.afr().aPh().getName());
            if (cQ.get(encode) == null) {
                cQ.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.ajr()) {
                final PopInfo popInfo = c.this.ckn.afr().ggd;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.ckn.getActivity());
                aVar.cS(popInfo.title);
                aVar.cT(popInfo.v_title);
                aVar.to();
                aVar.b(popInfo.ok_info, new a.b() { // from class: com.baidu.tieba.frs.g.c.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.a(popInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.frs.g.c.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        at.wf().c(c.this.ckn.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.ckn.getPageContext()).tr();
            }
        }
    }
}
