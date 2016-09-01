package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private C0037a alD;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        a(z, str, str2, false, "0", null);
    }

    public void a(boolean z, String str, String str2, boolean z2, BdUniqueId bdUniqueId) {
        a(z, str, str2, z2, "0", bdUniqueId);
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId) {
        if (this.alD == null) {
            this.alD = new C0037a(this, null);
            this.alD.setPriority(2);
            this.alD.bf(z);
            this.alD.setPortrait(str);
            this.alD.setToUid(str2);
            this.alD.setIsGod(z2);
            this.alD.setFrom(str3);
            this.alD.setPageId(bdUniqueId);
            this.alD.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a extends BdAsyncTask<Integer, Integer, String> {
        private ab aiS;
        private boolean akW;
        private boolean akX;
        private BdUniqueId alE;
        private String from;
        private String portrait;
        private String toUid;

        private C0037a() {
            this.aiS = null;
            this.akX = false;
            this.from = "0";
        }

        /* synthetic */ C0037a(a aVar, C0037a c0037a) {
            this();
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setToUid(String str) {
            this.toUid = str;
        }

        public void bf(boolean z) {
            this.akW = z;
        }

        public void setIsGod(boolean z) {
            this.akX = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setPageId(BdUniqueId bdUniqueId) {
            this.alE = bdUniqueId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.aiS = new ab();
                    if (this.akW) {
                        this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.aiS.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.aiS.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    this.aiS.uD().vz().mIsNeedTbs = true;
                    this.aiS.ue();
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
        /* renamed from: eu */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.alD = null;
            if (this.aiS != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.vS = this.aiS.uD().vA().oE();
                aVar.errorString = this.aiS.getErrorString();
                aVar.akW = this.akW;
                aVar.toUid = this.toUid;
                aVar.akX = this.akX;
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.alE));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiS != null) {
                this.aiS.eg();
                this.aiS = null;
            }
            a.this.alD = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.g(false);
            }
        }
    }

    public void cancel() {
        if (this.alD != null) {
            this.alD.cancel();
        }
    }
}
