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
    private final com.baidu.tieba.frs.g cIy;
    private a daz;

    public c(com.baidu.tieba.frs.g gVar) {
        this.cIy = gVar;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.cIy != null && this.cIy.alF() != null && this.cIy.alF().aRo() != null && !StringUtils.isNull(this.cIy.alF().aRo().getName()) && this.cIy.alF().gzX != null && aqN() && this.daz == null) {
            this.daz = new a();
            this.daz.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqN() {
        PopInfo popInfo = this.cIy.alF().gzX;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.cIy.alF().gzX.if_pop.intValue() == 0) ? false : true;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            l<String> cP = com.baidu.tbadk.core.c.a.td().cP("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.cIy.alF().aRo().getName());
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
            if (bool.booleanValue() && c.this.aqN() && c.this.cIy.isAdded()) {
                final PopInfo popInfo = c.this.cIy.alF().gzX;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.cIy.getActivity());
                aVar.cR(popInfo.title);
                aVar.cS(popInfo.v_title);
                aVar.te();
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
                        av.vI().c(c.this.cIy.getPageContext(), new String[]{popInfo.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.b(c.this.cIy.getPageContext()).th();
            }
        }
    }
}
