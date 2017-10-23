package com.baidu.tieba.frs.h;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.av;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class c {
    private a cHE;
    private final com.baidu.tieba.frs.f crw;

    public c(com.baidu.tieba.frs.f fVar) {
        this.crw = fVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.crw != null && this.crw.ahf() != null && this.crw.ahf().aMU() != null && !StringUtils.isNull(this.crw.ahf().aMU().getName()) && this.crw.ahf().geI != null && alK() && this.cHE == null) {
            this.cHE = new a();
            this.cHE.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alK() {
        PopInfo popInfo = this.crw.ahf().geI;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.crw.ahf().geI.if_pop.intValue() == 0) ? false : true;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Void... voidArr) {
            l<String> cI = com.baidu.tbadk.core.c.a.sX().cI("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.crw.ahf().aMU().getName());
            if (cI.get(encode) == null) {
                cI.e(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.alK() && c.this.crw.isAdded()) {
                final PopInfo popInfo = c.this.crw.ahf().geI;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.crw.getActivity());
                aVar.cK(popInfo.title);
                aVar.cL(popInfo.v_title);
                aVar.sY();
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
                        av.vA().c(c.this.crw.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.crw.getPageContext()).tb();
            }
        }
    }
}
