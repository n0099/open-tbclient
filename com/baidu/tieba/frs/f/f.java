package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final FrsActivity bTp;
    private a ccw;

    public f(FrsActivity frsActivity) {
        this.bTp = frsActivity;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.bTp != null && this.bTp.YV() != null && this.bTp.YV().aJp() != null && !StringUtils.isNull(this.bTp.YV().aJp().getName()) && this.bTp.YV().fsx != null && adN() && this.ccw == null) {
            this.ccw = new a(this, null);
            this.ccw.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adN() {
        PopInfo popInfo = this.bTp.YV().fsx;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.bTp.YV().fsx.if_pop.intValue() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Void... voidArr) {
            com.baidu.adp.lib.cache.o<String> cu = com.baidu.tbadk.core.c.a.to().cu("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(f.this.bTp.YV().aJp().getName());
            if (cu.get(encode) == null) {
                cu.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && f.this.adN()) {
                PopInfo popInfo = f.this.bTp.YV().fsx;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.bTp.getActivity());
                aVar.cw(popInfo.title);
                aVar.cx(popInfo.v_title);
                aVar.tp();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.bTp.getPageContext()).ts();
            }
        }
    }
}
