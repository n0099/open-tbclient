package com.baidu.tieba.frs.h;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.au;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class c {
    private a cGX;
    private final com.baidu.tieba.frs.f crm;

    public c(com.baidu.tieba.frs.f fVar) {
        this.crm = fVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.crm != null && this.crm.ahq() != null && this.crm.ahq().aPg() != null && !StringUtils.isNull(this.crm.ahq().aPg().getName()) && this.crm.ahq().ghr != null && alL() && this.cGX == null) {
            this.cGX = new a();
            this.cGX.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alL() {
        PopInfo popInfo = this.crm.ahq().ghr;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.crm.ahq().ghr.if_pop.intValue() == 0) ? false : true;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            l<String> cJ = com.baidu.tbadk.core.c.a.tk().cJ("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.crm.ahq().aPg().getName());
            if (cJ.get(encode) == null) {
                cJ.e(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.alL() && c.this.crm.isAdded()) {
                final PopInfo popInfo = c.this.crm.ahq().ghr;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.crm.getActivity());
                aVar.cL(popInfo.title);
                aVar.cM(popInfo.v_title);
                aVar.tl();
                aVar.b(popInfo.ok_info, new a.b() { // from class: com.baidu.tieba.frs.h.c.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.a(popInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.frs.h.c.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        au.wd().c(c.this.crm.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.crm.getPageContext()).to();
            }
        }
    }
}
