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
    private C0042a aht;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.aht == null) {
            this.aht = new C0042a(this, null);
            this.aht.setPriority(2);
            this.aht.aN(z);
            this.aht.setPortrait(str);
            this.aht.setToUid(str2);
            this.aht.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a extends BdAsyncTask<Integer, Integer, String> {
        private w afm;
        private boolean agO;
        private String portrait;
        private String toUid;

        private C0042a() {
            this.afm = null;
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
            this.agO = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.afm = new w();
                    if (this.agO) {
                        this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.afm.o(IntentConfig.PORTRAIT, this.portrait);
                    this.afm.uh().uZ().mIsNeedTbs = true;
                    this.afm.tG();
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
            a.this.aht = null;
            if (this.afm != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.Cj = this.afm.uh().va().qT();
                aVar.errorString = this.afm.getErrorString();
                aVar.agO = this.agO;
                aVar.toUid = this.toUid;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afm != null) {
                this.afm.gJ();
                this.afm = null;
            }
            a.this.aht = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.aht != null) {
            this.aht.cancel();
        }
    }
}
