package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private C0045a alb;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        a(z, str, str2, false);
    }

    public void a(boolean z, String str, String str2, boolean z2) {
        if (this.alb == null) {
            this.alb = new C0045a(this, null);
            this.alb.setPriority(2);
            this.alb.aQ(z);
            this.alb.setPortrait(str);
            this.alb.setToUid(str2);
            this.alb.aR(z2);
            this.alb.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045a extends BdAsyncTask<Integer, Integer, String> {
        private aa aiG;
        private boolean akv;
        private boolean akw;
        private String portrait;
        private String toUid;

        private C0045a() {
            this.aiG = null;
            this.akw = false;
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

        public void aQ(boolean z) {
            this.akv = z;
        }

        public void aR(boolean z) {
            this.akw = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.aiG = new aa();
                    if (this.akv) {
                        this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.aiG.p(IntentConfig.PORTRAIT, this.portrait);
                    this.aiG.vB().wv().mIsNeedTbs = true;
                    this.aiG.uZ();
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
        /* renamed from: ek */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.alb = null;
            if (this.aiG != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.CF = this.aiG.vB().ww().rl();
                aVar.errorString = this.aiG.getErrorString();
                aVar.akv = this.akv;
                aVar.toUid = this.toUid;
                aVar.akw = this.akw;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiG != null) {
                this.aiG.gT();
                this.aiG = null;
            }
            a.this.alb = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.alb != null) {
            this.alb.cancel();
        }
    }
}
