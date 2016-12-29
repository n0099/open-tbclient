package com.baidu.tieba.frs.h;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes.dex */
public class f {
    private final FrsActivity bFS;
    private a bOH;

    public f(FrsActivity frsActivity) {
        this.bFS = frsActivity;
    }

    public void refresh() {
        if (TbadkCoreApplication.isLogin() && this.bFS != null && this.bFS.WF() != null && this.bFS.WF().aIk() != null && !StringUtils.isNull(this.bFS.WF().aIk().getName()) && this.bFS.WF().feF != null && abG() && this.bOH == null) {
            this.bOH = new a(this, null);
            this.bOH.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abG() {
        PopInfo popInfo = this.bFS.WF().feF;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.bFS.WF().feF.if_pop.intValue() == 0) ? false : true;
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
            com.baidu.adp.lib.cache.o<String> cD = com.baidu.tbadk.core.b.a.sX().cD("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(f.this.bFS.WF().aIk().getName());
            if (cD.get(encode) == null) {
                cD.k(encode, "1");
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && f.this.abG()) {
                PopInfo popInfo = f.this.bFS.WF().feF;
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(f.this.bFS.getActivity());
                aVar.cF(popInfo.title);
                aVar.cG(popInfo.v_title);
                aVar.sY();
                aVar.b(popInfo.ok_info, new g(this));
                aVar.a(popInfo.ahead_info, new h(this, popInfo));
                aVar.b(f.this.bFS.getPageContext()).tb();
            }
        }
    }
}
