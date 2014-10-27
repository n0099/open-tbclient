package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.j> {
    com.baidu.tieba.square.j ave;
    final /* synthetic */ c avf;
    private com.baidu.tbadk.core.util.ac yV;

    private d(c cVar) {
        this.avf = cVar;
        this.yV = null;
        this.ave = new com.baidu.tieba.square.j();
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
        if (this.ave != null) {
            eVar = this.avf.auY;
            int errorCode = this.ave.getErrorCode();
            com.baidu.tieba.square.q ado = this.ave.ado();
            String errorMsg = this.ave.getErrorMsg();
            z = this.avf.avd;
            eVar.a(true, errorCode, ado, errorMsg, z);
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
            str5 = this.avf.auZ;
            str6 = bd.get(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.ave.parserJson(str6);
            this.avf.avd = true;
            publishProgress(new Integer[0]);
        }
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/seconddir");
            com.baidu.tbadk.core.util.ac acVar = this.yV;
            str = this.avf.auZ;
            acVar.k("menu_name", str);
            com.baidu.tbadk.core.util.ac acVar2 = this.yV;
            str2 = this.avf.ava;
            acVar2.k("menu_type", str2);
            com.baidu.tbadk.core.util.ac acVar3 = this.yV;
            str3 = this.avf.avb;
            acVar3.k("menu_id", str3);
            lA = this.yV.lA();
        } catch (Exception e) {
            this.ave.setErrorMsg(e.getMessage());
            BdLog.detailException(e);
        }
        if (lA == null) {
            return this.ave;
        }
        if (this.yV.mc().nb().jq()) {
            this.ave.parserJson(lA);
            this.avf.avc = true;
            if (bd != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
                str4 = this.avf.auZ;
                bd.a(append2.append(str4).append("_dir").toString(), lA, 86400000L);
            }
        } else {
            this.ave.setErrorMsg(this.yV.getErrorString());
            this.avf.avc = false;
        }
        return this.ave;
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
        z = this.avf.avc;
        if (!z) {
            eVar2 = this.avf.auY;
            String errorMsg = jVar.getErrorMsg();
            z3 = this.avf.avd;
            eVar2.a(false, -1, null, errorMsg, z3);
        } else if (jVar.ado() != null) {
            eVar = this.avf.auY;
            int errorCode = jVar.getErrorCode();
            com.baidu.tieba.square.q ado = jVar.ado();
            String errorMsg2 = jVar.getErrorMsg();
            z2 = this.avf.avd;
            eVar.a(true, errorCode, ado, errorMsg2, z2);
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
