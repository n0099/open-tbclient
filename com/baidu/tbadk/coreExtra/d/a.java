package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private C0042a ahn;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.ahn == null) {
            this.ahn = new C0042a(this, null);
            this.ahn.setPriority(2);
            this.ahn.aN(z);
            this.ahn.setPortrait(str);
            this.ahn.setToUid(str2);
            this.ahn.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a extends BdAsyncTask<Integer, Integer, String> {
        private w afh;
        private boolean agI;
        private String portrait;
        private String toUid;

        private C0042a() {
            this.afh = null;
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
            this.agI = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.afh = new w();
                    if (this.agI) {
                        this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.afh.o(IntentConfig.PORTRAIT, this.portrait);
                    this.afh.ue().uV().mIsNeedTbs = true;
                    this.afh.tD();
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
            a.this.ahn = null;
            if (this.afh != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.Cj = this.afh.ue().uW().qS();
                aVar.errorString = this.afh.getErrorString();
                aVar.agI = this.agI;
                aVar.toUid = this.toUid;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afh != null) {
                this.afh.gJ();
                this.afh = null;
            }
            a.this.ahn = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.ahn != null) {
            this.ahn.cancel();
        }
    }
}
