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
    private a cGf;
    private final com.baidu.tieba.frs.f cqt;

    public c(com.baidu.tieba.frs.f fVar) {
        this.cqt = fVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.cqt != null && this.cqt.ahf() != null && this.cqt.ahf().aOV() != null && !StringUtils.isNull(this.cqt.ahf().aOV().getName()) && this.cqt.ahf().ggx != null && alA() && this.cGf == null) {
            this.cGf = new a();
            this.cGf.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alA() {
        PopInfo popInfo = this.cqt.ahf().ggx;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.cqt.ahf().ggx.if_pop.intValue() == 0) ? false : true;
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
            String encode = URLEncoder.encode(c.this.cqt.ahf().aOV().getName());
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
            if (bool.booleanValue() && c.this.alA() && c.this.cqt.isAdded()) {
                final PopInfo popInfo = c.this.cqt.ahf().ggx;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.cqt.getActivity());
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
                        au.wd().c(c.this.cqt.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.cqt.getPageContext()).to();
            }
        }
    }
}
