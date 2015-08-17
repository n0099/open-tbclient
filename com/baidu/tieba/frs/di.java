package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class di extends com.baidu.adp.base.e {
    private a aZh;
    private String mForumId;
    private String mForumName;

    public di(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.aZh = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void MF() {
        if (this.aZh != null) {
            this.aZh.cancel();
            this.aZh = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.aZh == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.aZh = new a(this, null);
            this.aZh.setPriority(2);
            this.aZh.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.v afJ;

        private a() {
            this.afJ = null;
        }

        /* synthetic */ a(di diVar, a aVar) {
            this();
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
        /* renamed from: t */
        public SignData doInBackground(Object... objArr) {
            Object obj;
            Exception e;
            String tD;
            JSONObject jSONObject;
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            Object obj2 = null;
            try {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                this.afJ = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.afJ.o("kw", di.this.mForumName);
                this.afJ.o(ImageViewerConfig.FORUM_ID, di.this.mForumId);
                this.afJ.ue().uV().mIsNeedTbs = true;
                tD = this.afJ.tD();
            } catch (Exception e2) {
                obj = obj2;
                e = e2;
            }
            if (this.afJ.uh()) {
                obj = this.afJ.ue().uW().rb();
                try {
                    if (obj != 0) {
                        SignData signData = new SignData();
                        signData.parserJson(tD);
                        obj = signData;
                    } else if (!com.baidu.tbadk.core.util.aq.isEmpty(tD) && (jSONObject = new JSONObject(tD)) != null && "199901".equals(jSONObject.optString(SocialConstants.PARAM_ERROR_CODE))) {
                        SignData signData2 = new SignData();
                        signData2.parserJson(tD);
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
            if (this.afJ != null) {
                this.afJ.gM();
            }
            di.this.aZh = null;
            super.cancel(true);
            di.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            di.this.aZh = null;
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            if (signData == null && this.afJ != null) {
                di.this.mErrorCode = this.afJ.ui();
                di.this.mErrorString = this.afJ.getErrorString();
            }
            di.this.mLoadDataCallBack.d(signData);
        }
    }
}
