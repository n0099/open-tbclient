package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private C0042a aig;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.aig == null) {
            this.aig = new C0042a(this, null);
            this.aig.setPriority(2);
            this.aig.aN(z);
            this.aig.setPortrait(str);
            this.aig.setToUid(str2);
            this.aig.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a extends BdAsyncTask<Integer, Integer, String> {
        private v afJ;
        private boolean ahB;
        private String portrait;
        private String toUid;

        private C0042a() {
            this.afJ = null;
        }

        /* synthetic */ C0042a(a aVar, C0042a c0042a) {
            this();
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setToUid(String str) {
            this.toUid = str;
        }

        public void aN(boolean z) {
            this.ahB = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.afJ = new v();
                    if (this.ahB) {
                        this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.afJ.o(IntentConfig.PORTRAIT, this.portrait);
                    this.afJ.ue().uV().mIsNeedTbs = true;
                    this.afJ.tD();
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
        public void onPostExecute(String str) {
            super.onPostExecute((C0042a) str);
            a.this.aig = null;
            if (this.afJ != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.ahA = this.afJ.ue().uW().rb();
                aVar.errorString = this.afJ.getErrorString();
                aVar.ahB = this.ahB;
                aVar.toUid = this.toUid;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afJ != null) {
                this.afJ.gM();
                this.afJ = null;
            }
            a.this.aig = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.aig != null) {
            this.aig.cancel();
        }
    }
}
