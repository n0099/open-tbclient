package com.baidu.tieba.frs.vc;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.FrsFragment;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes4.dex */
public class c {
    private a fSV;
    private final FrsFragment fxh;

    public c(FrsFragment frsFragment) {
        this.fxh = frsFragment;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.fxh != null && this.fxh.bkp() != null && this.fxh.bkp().getForum() != null && !StringUtils.isNull(this.fxh.bkp().getForum().getName()) && this.fxh.bkp().enterFrsDialogInfo != null && bqn() && this.fSV == null) {
            this.fSV = new a();
            this.fSV.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqn() {
        PopInfo popInfo = this.fxh.bkp().enterFrsDialogInfo;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.fxh.bkp().enterFrsDialogInfo.if_pop.intValue() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            l<String> nl = com.baidu.tbadk.core.d.a.akN().nl("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.fxh.bkp().getForum().getName());
            if (nl.get(encode) == null) {
                nl.setForever(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.bqn() && c.this.fxh.isAdded()) {
                final PopInfo popInfo = c.this.fxh.bkp().enterFrsDialogInfo;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.fxh.getActivity());
                aVar.nm(popInfo.title);
                aVar.nn(popInfo.v_title);
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
                        ba.amQ().b(c.this.fxh.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.fxh.getPageContext()).akO();
            }
        }
    }
}
