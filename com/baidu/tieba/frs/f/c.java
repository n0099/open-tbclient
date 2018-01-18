package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.av;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes2.dex */
public class c {
    private final com.baidu.tieba.frs.i dCx;
    private a dRv;

    public c(com.baidu.tieba.frs.i iVar) {
        this.dCx = iVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.dCx != null && this.dCx.auq() != null && this.dCx.auq().aYE() != null && !StringUtils.isNull(this.dCx.auq().aYE().getName()) && this.dCx.auq().gWp != null && ayX() && this.dRv == null) {
            this.dRv = new a();
            this.dRv.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayX() {
        PopInfo popInfo = this.dCx.auq().gWp;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.dCx.auq().gWp.if_pop.intValue() == 0) ? false : true;
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            l<String> cW = com.baidu.tbadk.core.c.a.Aw().cW("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.dCx.auq().aYE().getName());
            if (cW.get(encode) == null) {
                cW.e(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.ayX() && c.this.dCx.isAdded()) {
                final PopInfo popInfo = c.this.dCx.auq().gWp;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.dCx.getActivity());
                aVar.cY(popInfo.title);
                aVar.cZ(popInfo.v_title);
                aVar.Ax();
                aVar.b(popInfo.ok_info, new a.b() { // from class: com.baidu.tieba.frs.f.c.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.a(popInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.frs.f.c.a.2
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.i */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        av.CZ().c(c.this.dCx.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.dCx.getPageContext()).AA();
            }
        }
    }
}
