package com.baidu.tieba.frs.g;

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
    private final com.baidu.tieba.frs.f cIp;
    private a dal;

    public c(com.baidu.tieba.frs.f fVar) {
        this.cIp = fVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.cIp != null && this.cIp.alv() != null && this.cIp.alv().aRf() != null && !StringUtils.isNull(this.cIp.alv().aRf().getName()) && this.cIp.alv().gxp != null && aqE() && this.dal == null) {
            this.dal = new a();
            this.dal.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqE() {
        PopInfo popInfo = this.cIp.alv().gxp;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.cIp.alv().gxp.if_pop.intValue() == 0) ? false : true;
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
            l<String> cP = com.baidu.tbadk.core.c.a.tg().cP("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.cIp.alv().aRf().getName());
            if (cP.get(encode) == null) {
                cP.e(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.aqE() && c.this.cIp.isAdded()) {
                final PopInfo popInfo = c.this.cIp.alv().gxp;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.cIp.getActivity());
                aVar.cR(popInfo.title);
                aVar.cS(popInfo.v_title);
                aVar.th();
                aVar.b(popInfo.ok_info, new a.b() { // from class: com.baidu.tieba.frs.g.c.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.a(popInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.frs.g.c.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        av.vL().c(c.this.cIp.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.cIp.getPageContext()).tk();
            }
        }
    }
}
