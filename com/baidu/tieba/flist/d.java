package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.j> {
    com.baidu.tieba.square.j avn;
    final /* synthetic */ c avo;
    private com.baidu.tbadk.core.util.ac yV;

    private d(c cVar) {
        this.avo = cVar;
        this.yV = null;
        this.avn = new com.baidu.tieba.square.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(c cVar, d dVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onProgressUpdate(Integer... numArr) {
        e eVar;
        boolean z;
        super.onProgressUpdate(numArr);
        if (this.avn != null) {
            eVar = this.avo.avh;
            int errorCode = this.avn.getErrorCode();
            com.baidu.tieba.square.q adr = this.avn.adr();
            String errorMsg = this.avn.getErrorMsg();
            z = this.avo.avm;
            eVar.a(true, errorCode, adr, errorMsg, z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public com.baidu.tieba.square.j doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String lA;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_posts");
        if (bd != null) {
            StringBuilder append = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
            str5 = this.avo.avi;
            str6 = bd.get(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.avn.parserJson(str6);
            this.avo.avm = true;
            publishProgress(new Integer[0]);
        }
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/seconddir");
            com.baidu.tbadk.core.util.ac acVar = this.yV;
            str = this.avo.avi;
            acVar.k("menu_name", str);
            com.baidu.tbadk.core.util.ac acVar2 = this.yV;
            str2 = this.avo.avj;
            acVar2.k("menu_type", str2);
            com.baidu.tbadk.core.util.ac acVar3 = this.yV;
            str3 = this.avo.avk;
            acVar3.k("menu_id", str3);
            lA = this.yV.lA();
        } catch (Exception e) {
            this.avn.setErrorMsg(e.getMessage());
            BdLog.detailException(e);
        }
        if (lA == null) {
            return this.avn;
        }
        if (this.yV.mc().nb().jq()) {
            this.avn.parserJson(lA);
            this.avo.avl = true;
            if (bd != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
                str4 = this.avo.avi;
                bd.a(append2.append(str4).append("_dir").toString(), lA, 86400000L);
            }
        } else {
            this.avn.setErrorMsg(this.yV.getErrorString());
            this.avo.avl = false;
        }
        return this.avn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.square.j jVar) {
        boolean z;
        e eVar;
        boolean z2;
        e eVar2;
        boolean z3;
        z = this.avo.avl;
        if (!z) {
            eVar2 = this.avo.avh;
            String errorMsg = jVar.getErrorMsg();
            z3 = this.avo.avm;
            eVar2.a(false, -1, null, errorMsg, z3);
        } else if (jVar.adr() != null) {
            eVar = this.avo.avh;
            int errorCode = jVar.getErrorCode();
            com.baidu.tieba.square.q adr = jVar.adr();
            String errorMsg2 = jVar.getErrorMsg();
            z2 = this.avo.avm;
            eVar.a(true, errorCode, adr, errorMsg2, z2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
    }
}
