package com.baidu.tieba.frs.vc;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.FrsFragment;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes9.dex */
public class c {
    private final FrsFragment hBW;
    private a hZl;

    public c(FrsFragment frsFragment) {
        this.hBW = frsFragment;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.hBW != null && this.hBW.bYC() != null && this.hBW.bYC().getForum() != null && !StringUtils.isNull(this.hBW.bYC().getForum().getName()) && this.hBW.bYC().enterFrsDialogInfo != null && ceU() && this.hZl == null) {
            this.hZl = new a();
            this.hZl.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceU() {
        PopInfo popInfo = this.hBW.bYC().enterFrsDialogInfo;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.hBW.bYC().enterFrsDialogInfo.if_pop.intValue() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            com.baidu.adp.lib.cache.l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.hBW.bYC().getForum().getName());
            if (wc.get(encode) == null) {
                wc.setForever(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.ceU() && c.this.hBW.isAdded()) {
                final PopInfo popInfo = c.this.hBW.bYC().enterFrsDialogInfo;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.hBW.getActivity());
                aVar.wd(popInfo.title);
                aVar.we(popInfo.v_title);
                aVar.isShowTitleAndMessage();
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
                        bc.aWU().b(c.this.hBW.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.hBW.getPageContext()).aUN();
            }
        }
    }
}
