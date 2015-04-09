package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.aa ZF;
    final /* synthetic */ cm aNg;

    private cn(cm cmVar) {
        this.aNg = cmVar;
        this.ZF = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cn(cm cmVar, cn cnVar) {
        this(cmVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00d7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x00a6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:? */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.core.data.SignData] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public SignData doInBackground(Object... objArr) {
        Object obj;
        Exception e;
        String str;
        String str2;
        String rO;
        JSONObject jSONObject;
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        Object obj2 = null;
        try {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            this.ZF = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.ZF;
            str = this.aNg.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.ZF;
            str2 = this.aNg.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.ZF.sp().tp().mIsNeedTbs = true;
            rO = this.ZF.rO();
        } catch (Exception e2) {
            obj = obj2;
            e = e2;
        }
        if (this.ZF.ss()) {
            obj = this.ZF.sp().tq().pv();
            try {
                if (obj != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(rO);
                    obj = signData;
                } else if (!com.baidu.tbadk.core.util.bd.isEmpty(rO) && (jSONObject = new JSONObject(rO)) != null && "199901".equals(jSONObject.optString("error_code"))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(rO);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    obj2 = null;
                    signData2.setBonusPoint(0);
                    obj = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return obj;
            }
            return obj;
        }
        obj = 0;
        return obj;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.ZF != null) {
            this.ZF.hh();
        }
        this.aNg.aNf = null;
        super.cancel(true);
        iVar = this.aNg.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        com.baidu.adp.base.i iVar;
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        this.aNg.aNf = null;
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        if (signData == null && this.ZF != null) {
            this.aNg.mErrorCode = this.ZF.st();
            this.aNg.mErrorString = this.ZF.getErrorString();
        }
        iVar = this.aNg.mLoadDataCallBack;
        iVar.c(signData);
    }
}
