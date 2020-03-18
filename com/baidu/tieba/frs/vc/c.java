package com.baidu.tieba.frs.vc;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.FrsFragment;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes9.dex */
public class c {
    private a gMZ;
    private final FrsFragment gqW;

    public c(FrsFragment frsFragment) {
        this.gqW = frsFragment;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.gqW != null && this.gqW.bEz() != null && this.gqW.bEz().getForum() != null && !StringUtils.isNull(this.gqW.bEz().getForum().getName()) && this.gqW.bEz().enterFrsDialogInfo != null && bKA() && this.gMZ == null) {
            this.gMZ = new a();
            this.gMZ.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKA() {
        PopInfo popInfo = this.gqW.bEz().enterFrsDialogInfo;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.gqW.bEz().enterFrsDialogInfo.if_pop.intValue() == 0) ? false : true;
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
            com.baidu.adp.lib.cache.l<String> sP = com.baidu.tbadk.core.c.a.aEF().sP("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.gqW.bEz().getForum().getName());
            if (sP.get(encode) == null) {
                sP.setForever(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.bKA() && c.this.gqW.isAdded()) {
                final PopInfo popInfo = c.this.gqW.bEz().enterFrsDialogInfo;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.gqW.getActivity());
                aVar.sQ(popInfo.title);
                aVar.sR(popInfo.v_title);
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
                        ba.aGK().b(c.this.gqW.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.gqW.getPageContext()).aEG();
            }
        }
    }
}
