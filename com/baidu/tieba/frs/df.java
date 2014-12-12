package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.Hao123UpdateSignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df extends BdAsyncTask<Object, Integer, SignData> {
    private volatile com.baidu.tbadk.core.util.ad CV;
    final /* synthetic */ de aGy;

    private df(de deVar) {
        this.aGy = deVar;
        this.CV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ df(de deVar, df dfVar) {
        this(deVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0100 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x00cf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x009d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00cf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0020 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.core.data.SignData] */
    /* JADX WARN: Type inference failed for: r1v15 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public SignData doInBackground(Object... objArr) {
        com.baidu.tbadk.core.message.b bVar;
        Exception e;
        String str;
        String str2;
        String ov;
        JSONObject jSONObject;
        String str3;
        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        com.baidu.tbadk.core.message.b bVar2 = null;
        bVar2 = null;
        try {
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            this.CV = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
            com.baidu.tbadk.core.util.ad adVar = this.CV;
            str = this.aGy.mForumName;
            adVar.o("kw", str);
            com.baidu.tbadk.core.util.ad adVar2 = this.CV;
            str2 = this.aGy.mForumId;
            adVar2.o(ImageViewerConfig.FORUM_ID, str2);
            this.CV.oW().pV().mIsNeedTbs = true;
            ov = this.CV.ov();
        } catch (Exception e2) {
            bVar = bVar2;
            e = e2;
        }
        if (this.CV.oZ()) {
            bVar = this.CV.oW().pW().ma();
            try {
                if (bVar != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(ov);
                    int signed = signData.getSigned();
                    bVar = signData;
                    bVar2 = signed;
                    if (signed == 1) {
                        com.baidu.tbadk.core.message.b bVar3 = new com.baidu.tbadk.core.message.b();
                        str3 = this.aGy.mForumId;
                        bVar3.Gb = str3;
                        bVar3.Gc = true;
                        bVar3.Gd = signData.getCountSignNum();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new Hao123UpdateSignMessage(bVar3));
                        bVar = signData;
                        bVar2 = bVar3;
                    }
                } else if (!com.baidu.tbadk.core.util.ba.isEmpty(ov) && (jSONObject = new JSONObject(ov)) != null && "199901".equals(jSONObject.optString("error_code"))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(ov);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    bVar2 = null;
                    signData2.setBonusPoint(0);
                    bVar = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return bVar;
            }
            return bVar;
        }
        bVar = 0;
        return bVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        if (this.CV != null) {
            this.CV.dL();
        }
        this.aGy.aGx = null;
        super.cancel(true);
        iVar = this.aGy.mLoadDataCallBack;
        iVar.c(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        com.baidu.adp.base.i iVar;
        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        this.aGy.aGx = null;
        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        if (signData == null && this.CV != null) {
            this.aGy.mErrorCode = this.CV.pa();
            this.aGy.mErrorString = this.CV.getErrorString();
        }
        iVar = this.aGy.mLoadDataCallBack;
        iVar.c(signData);
    }
}
