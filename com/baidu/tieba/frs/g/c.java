package com.baidu.tieba.frs.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aw;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes2.dex */
public class c {
    private final com.baidu.tieba.frs.i dFP;
    private a dVc;

    public c(com.baidu.tieba.frs.i iVar) {
        this.dFP = iVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.dFP != null && this.dFP.avl() != null && this.dFP.avl().bas() != null && !StringUtils.isNull(this.dFP.avl().bas().getName()) && this.dFP.avl().gZc != null && aAe() && this.dVc == null) {
            this.dVc = new a();
            this.dVc.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAe() {
        PopInfo popInfo = this.dFP.avl().gZc;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.dFP.avl().gZc.if_pop.intValue() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            l<String> dh = com.baidu.tbadk.core.c.a.AQ().dh("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.dFP.avl().bas().getName());
            if (dh.get(encode) == null) {
                dh.e(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.aAe() && c.this.dFP.isAdded()) {
                final PopInfo popInfo = c.this.dFP.avl().gZc;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.dFP.getActivity());
                aVar.dj(popInfo.title);
                aVar.dk(popInfo.v_title);
                aVar.AR();
                aVar.b(popInfo.ok_info, new a.b() { // from class: com.baidu.tieba.frs.g.c.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.a(popInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.frs.g.c.a.2
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.i */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aw.Du().c(c.this.dFP.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.dFP.getPageContext()).AU();
            }
        }
    }
}
