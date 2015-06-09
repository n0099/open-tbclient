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
public class cm extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ cl aPt;
    private volatile com.baidu.tbadk.core.util.aa aaG;

    private cm(cl clVar) {
        this.aPt = clVar;
        this.aaG = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cm(cl clVar, cm cmVar) {
        this(clVar);
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
    /* renamed from: u */
    public SignData doInBackground(Object... objArr) {
        Object obj;
        Exception e;
        String str;
        String str2;
        String sw;
        JSONObject jSONObject;
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        Object obj2 = null;
        try {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            this.aaG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.aa aaVar = this.aaG;
            str = this.aPt.mForumName;
            aaVar.o("kw", str);
            com.baidu.tbadk.core.util.aa aaVar2 = this.aaG;
            str2 = this.aPt.mForumId;
            aaVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.aaG.sX().tS().mIsNeedTbs = true;
            sw = this.aaG.sw();
        } catch (Exception e2) {
            obj = obj2;
            e = e2;
        }
        if (this.aaG.ta()) {
            obj = this.aaG.sX().tT().qa();
            try {
                if (obj != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(sw);
                    obj = signData;
                } else if (!com.baidu.tbadk.core.util.bb.isEmpty(sw) && (jSONObject = new JSONObject(sw)) != null && "199901".equals(jSONObject.optString("error_code"))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(sw);
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
        if (this.aaG != null) {
            this.aaG.gS();
        }
        this.aPt.aPs = null;
        super.cancel(true);
        iVar = this.aPt.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        com.baidu.adp.base.i iVar;
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        this.aPt.aPs = null;
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        if (signData == null && this.aaG != null) {
            this.aPt.mErrorCode = this.aaG.tb();
            this.aPt.mErrorString = this.aaG.getErrorString();
        }
        iVar = this.aPt.mLoadDataCallBack;
        iVar.c(signData);
    }
}
