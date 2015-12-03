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
public class fb extends com.baidu.adp.base.e {
    private a bfQ;
    private String mForumId;
    private String mForumName;

    public fb(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.bfQ = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void Op() {
        if (this.bfQ != null) {
            this.bfQ.cancel();
            this.bfQ = null;
        }
    }

    public void aw(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bfQ == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bfQ = new a(this, null);
            this.bfQ.setPriority(2);
            this.bfQ.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.ab agS;

        private a() {
            this.agS = null;
        }

        /* synthetic */ a(fb fbVar, a aVar) {
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
        /* renamed from: s */
        public SignData doInBackground(Object... objArr) {
            Object obj;
            Exception e;
            String ul;
            JSONObject jSONObject;
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            Object obj2 = null;
            try {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                this.agS = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.agS.o("kw", fb.this.mForumName);
                this.agS.o(ImageViewerConfig.FORUM_ID, fb.this.mForumId);
                this.agS.uM().vF().mIsNeedTbs = true;
                ul = this.agS.ul();
            } catch (Exception e2) {
                obj = obj2;
                e = e2;
            }
            if (this.agS.uP()) {
                obj = this.agS.uM().vG().rf();
                try {
                    if (obj != 0) {
                        SignData signData = new SignData();
                        signData.parserJson(ul);
                        obj = signData;
                    } else if (!com.baidu.tbadk.core.util.ax.isEmpty(ul) && (jSONObject = new JSONObject(ul)) != null && "199901".equals(jSONObject.optString(SocialConstants.PARAM_ERROR_CODE))) {
                        SignData signData2 = new SignData();
                        signData2.parserJson(ul);
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
            if (this.agS != null) {
                this.agS.gL();
            }
            fb.this.bfQ = null;
            super.cancel(true);
            fb.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            fb.this.bfQ = null;
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            if (signData == null && this.agS != null) {
                fb.this.mErrorCode = this.agS.uQ();
                fb.this.mErrorString = this.agS.getErrorString();
            }
            fb.this.mLoadDataCallBack.d(signData);
        }
    }
}
