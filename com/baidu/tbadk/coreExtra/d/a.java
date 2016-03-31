package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private C0045a als;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        a(z, str, str2, false);
    }

    public void a(boolean z, String str, String str2, boolean z2) {
        if (this.als == null) {
            this.als = new C0045a(this, null);
            this.als.setPriority(2);
            this.als.aW(z);
            this.als.setPortrait(str);
            this.als.setToUid(str2);
            this.als.aX(z2);
            this.als.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045a extends BdAsyncTask<Integer, Integer, String> {
        private ab aiW;
        private boolean akM;
        private boolean akN;
        private String portrait;
        private String toUid;

        private C0045a() {
            this.aiW = null;
            this.akN = false;
        }

        /* synthetic */ C0045a(a aVar, C0045a c0045a) {
            this();
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setToUid(String str) {
            this.toUid = str;
        }

        public void aW(boolean z) {
            this.akM = z;
        }

        public void aX(boolean z) {
            this.akN = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.aiW = new ab();
                    if (this.akM) {
                        this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.aiW.p(IntentConfig.PORTRAIT, this.portrait);
                    this.aiW.vU().wO().mIsNeedTbs = true;
                    this.aiW.vw();
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.als = null;
            if (this.aiW != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.CK = this.aiW.vU().wP().qC();
                aVar.errorString = this.aiW.getErrorString();
                aVar.akM = this.akM;
                aVar.toUid = this.toUid;
                aVar.akN = this.akN;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiW != null) {
                this.aiW.gX();
                this.aiW = null;
            }
            a.this.als = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.als != null) {
            this.als.cancel();
        }
    }
}
