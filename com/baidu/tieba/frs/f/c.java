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
    private final com.baidu.tieba.frs.i dCS;
    private a dRQ;

    public c(com.baidu.tieba.frs.i iVar) {
        this.dCS = iVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.dCS != null && this.dCS.auv() != null && this.dCS.auv().aYJ() != null && !StringUtils.isNull(this.dCS.auv().aYJ().getName()) && this.dCS.auv().gWJ != null && azc() && this.dRQ == null) {
            this.dRQ = new a();
            this.dRQ.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azc() {
        PopInfo popInfo = this.dCS.auv().gWJ;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.dCS.auv().gWJ.if_pop.intValue() == 0) ? false : true;
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            l<String> cW = com.baidu.tbadk.core.c.a.Ax().cW("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.dCS.auv().aYJ().getName());
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
            if (bool.booleanValue() && c.this.azc() && c.this.dCS.isAdded()) {
                final PopInfo popInfo = c.this.dCS.auv().gWJ;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.dCS.getActivity());
                aVar.cY(popInfo.title);
                aVar.cZ(popInfo.v_title);
                aVar.Ay();
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
                        av.Da().c(c.this.dCS.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.dCS.getPageContext()).AB();
            }
        }
    }
}
