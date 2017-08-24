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
    private final com.baidu.tieba.frs.f cla;
    private a czN;

    public c(com.baidu.tieba.frs.f fVar) {
        this.cla = fVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.cla != null && this.cla.afH() != null && this.cla.afH().aPJ() != null && !StringUtils.isNull(this.cla.afH().aPJ().getName()) && this.cla.afH().ghV != null && ajS() && this.czN == null) {
            this.czN = new a();
            this.czN.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajS() {
        PopInfo popInfo = this.cla.afH().ghV;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.cla.afH().ghV.if_pop.intValue() == 0) ? false : true;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            l<String> cT = com.baidu.tbadk.core.c.a.to().cT("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.cla.afH().aPJ().getName());
            if (cT.get(encode) == null) {
                cT.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.ajS() && c.this.cla.isAdded()) {
                final PopInfo popInfo = c.this.cla.afH().ghV;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.cla.getActivity());
                aVar.cV(popInfo.title);
                aVar.cW(popInfo.v_title);
                aVar.tp();
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
                        at.wg().c(c.this.cla.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.cla.getPageContext()).ts();
            }
        }
    }
}
