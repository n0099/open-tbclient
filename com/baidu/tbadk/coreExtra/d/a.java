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
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private C0037a alF;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        a(z, str, str2, false, "0", null, null);
    }

    public void a(boolean z, String str, String str2, boolean z2, BdUniqueId bdUniqueId) {
        a(z, str, str2, z2, "0", bdUniqueId, null);
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4) {
        if (this.alF == null) {
            this.alF = new C0037a(this, null);
            this.alF.setPriority(2);
            this.alF.bi(z);
            this.alF.setPortrait(str);
            this.alF.setToUid(str2);
            this.alF.setIsGod(z2);
            this.alF.setFrom(str3);
            this.alF.setPageId(bdUniqueId);
            this.alF.setForumId(str4);
            this.alF.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a extends BdAsyncTask<Integer, Integer, String> {
        private z aiN;
        private boolean akY;
        private BdUniqueId alG;
        private boolean alH;
        private String forumId;
        private String from;
        private boolean isGod;
        private String portrait;
        private String toUid;

        private C0037a() {
            this.aiN = null;
            this.isGod = false;
            this.from = "0";
            this.forumId = null;
            this.alH = false;
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

        public void bi(boolean z) {
            this.akY = z;
        }

        public void setIsGod(boolean z) {
            this.isGod = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setPageId(BdUniqueId bdUniqueId) {
            this.alG = bdUniqueId;
        }

        public void setForumId(String str) {
            this.forumId = str;
            if (str != null) {
                this.alH = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.aiN = new z();
                    if (this.akY) {
                        this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.aiN.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.aiN.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.aiN.n("forum_id", this.forumId);
                    }
                    this.aiN.uI().vB().mIsNeedTbs = true;
                    return this.aiN.uk();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ew */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.alF = null;
            if (this.aiN != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.vS = this.aiN.uI().vC().oH();
                aVar.errorString = this.aiN.getErrorString();
                aVar.akY = this.akY;
                aVar.toUid = this.toUid;
                aVar.isGod = this.isGod;
                aVar.n(str, this.alH);
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.alG));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiN != null) {
                this.aiN.eg();
                this.aiN = null;
            }
            a.this.alF = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.g(false);
            }
        }
    }

    public void cancel() {
        if (this.alF != null) {
            this.alF.cancel();
        }
    }
}
