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
    private C0037a alj;
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

    public void a(boolean z, String str, String str2, boolean z2, BdUniqueId bdUniqueId, String str3) {
        a(z, str, str2, z2, "0", bdUniqueId, str3);
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4) {
        if (this.alj == null) {
            this.alj = new C0037a(this, null);
            this.alj.setPriority(2);
            this.alj.be(z);
            this.alj.setPortrait(str);
            this.alj.setToUid(str2);
            this.alj.setIsGod(z2);
            this.alj.setFrom(str3);
            this.alj.setPageId(bdUniqueId);
            this.alj.setForumId(str4);
            this.alj.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a extends BdAsyncTask<Integer, Integer, String> {
        private ab aiu;
        private boolean akC;
        private boolean akD;
        private BdUniqueId alk;
        private boolean alm;
        private String forumId;
        private String from;
        private String portrait;
        private String toUid;

        private C0037a() {
            this.aiu = null;
            this.akD = false;
            this.from = "0";
            this.forumId = null;
            this.alm = false;
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

        public void be(boolean z) {
            this.akC = z;
        }

        public void setIsGod(boolean z) {
            this.akD = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setPageId(BdUniqueId bdUniqueId) {
            this.alk = bdUniqueId;
        }

        public void setForumId(String str) {
            this.forumId = str;
            if (str != null) {
                this.alm = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.aiu = new ab();
                    if (this.akC) {
                        this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.aiu.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.aiu.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.aiu.n("forum_id", this.forumId);
                    }
                    this.aiu.uS().vN().mIsNeedTbs = true;
                    return this.aiu.uu();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ex */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.alj = null;
            if (this.aiu != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.vS = this.aiu.uS().vO().oF();
                aVar.errorString = this.aiu.getErrorString();
                aVar.akC = this.akC;
                aVar.toUid = this.toUid;
                aVar.akD = this.akD;
                aVar.n(str, this.alm);
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.alk));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiu != null) {
                this.aiu.eg();
                this.aiu = null;
            }
            a.this.alj = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.g(false);
            }
        }
    }

    public void cancel() {
        if (this.alj != null) {
            this.alj.cancel();
        }
    }
}
