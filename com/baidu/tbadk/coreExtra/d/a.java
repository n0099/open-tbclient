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
    private C0044a ajf;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.ajf == null) {
            this.ajf = new C0044a(this, null);
            this.ajf.setPriority(2);
            this.ajf.aS(z);
            this.ajf.setPortrait(str);
            this.ajf.setToUid(str2);
            this.ajf.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0044a extends BdAsyncTask<Integer, Integer, String> {
        private ab agS;
        private boolean aiA;
        private String portrait;
        private String toUid;

        private C0044a() {
            this.agS = null;
        }

        /* synthetic */ C0044a(a aVar, C0044a c0044a) {
            this();
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setToUid(String str) {
            this.toUid = str;
        }

        public void aS(boolean z) {
            this.aiA = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.agS = new ab();
                    if (this.aiA) {
                        this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.agS.o(IntentConfig.PORTRAIT, this.portrait);
                    this.agS.uM().vF().mIsNeedTbs = true;
                    this.agS.ul();
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
            super.onPostExecute((C0044a) str);
            a.this.ajf = null;
            if (this.agS != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.Cq = this.agS.uM().vG().rf();
                aVar.errorString = this.agS.getErrorString();
                aVar.aiA = this.aiA;
                aVar.toUid = this.toUid;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.agS != null) {
                this.agS.gL();
                this.agS = null;
            }
            a.this.ajf = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.ajf != null) {
            this.ajf.cancel();
        }
    }
}
