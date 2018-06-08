package com.baidu.tieba.frs.vc;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsFragment;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes2.dex */
public class c {
    private a dAn;
    private final FrsFragment diZ;

    public c(FrsFragment frsFragment) {
        this.diZ = frsFragment;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.diZ != null && this.diZ.atI() != null && this.diZ.atI().bam() != null && !StringUtils.isNull(this.diZ.atI().bam().getName()) && this.diZ.atI().gHc != null && azg() && this.dAn == null) {
            this.dAn = new a();
            this.dAn.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azg() {
        PopInfo popInfo = this.diZ.atI().gHc;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.diZ.atI().gHc.if_pop.intValue() == 0) ? false : true;
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
            l<String> dy = com.baidu.tbadk.core.c.a.wW().dy("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.diZ.atI().bam().getName());
            if (dy.get(encode) == null) {
                dy.e(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.azg() && c.this.diZ.isAdded()) {
                final PopInfo popInfo = c.this.diZ.atI().gHc;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.diZ.getActivity());
                aVar.dA(popInfo.title);
                aVar.dB(popInfo.v_title);
                aVar.wX();
                aVar.b(popInfo.ok_info, new a.b() { // from class: com.baidu.tieba.frs.vc.c.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.a(popInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.frs.vc.c.a.2
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        ay.zG().c(c.this.diZ.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.diZ.getPageContext()).xa();
            }
        }
    }
}
