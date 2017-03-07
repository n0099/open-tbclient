package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.f;
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
    private C0036a aqj;
    private f mLoadDataCallBack;

    public a(f fVar) {
        this.mLoadDataCallBack = fVar;
    }

    public void a(boolean z, String str, String str2) {
        a(z, str, str2, false, "0", null, null, "0");
    }

    public void a(boolean z, String str, String str2, boolean z2, BdUniqueId bdUniqueId) {
        a(z, str, str2, z2, "0", bdUniqueId, null, "0");
    }

    public void a(boolean z, String str, String str2, BdUniqueId bdUniqueId, String str3) {
        a(z, str, str2, false, "0", bdUniqueId, null, str3);
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.aqj == null) {
            this.aqj = new C0036a(this, null);
            this.aqj.setPriority(2);
            this.aqj.bh(z);
            this.aqj.setPortrait(str);
            this.aqj.setToUid(str2);
            this.aqj.setIsGod(z2);
            this.aqj.setFrom(str3);
            this.aqj.setPageId(bdUniqueId);
            this.aqj.setForumId(str4);
            this.aqj.setInLive(str5);
            this.aqj.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0036a extends BdAsyncTask<Integer, Integer, String> {
        private String forumId;
        private String from;
        private String inLive;
        private boolean isAttention;
        private boolean isGod;
        private z mNetwork;
        private BdUniqueId pageId;
        private String portrait;
        private boolean showToastAfterAttentionSuc;
        private String toUid;

        private C0036a() {
            this.mNetwork = null;
            this.isGod = false;
            this.from = "0";
            this.inLive = "0";
            this.forumId = null;
            this.showToastAfterAttentionSuc = false;
        }

        /* synthetic */ C0036a(a aVar, C0036a c0036a) {
            this();
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setToUid(String str) {
            this.toUid = str;
        }

        public void bh(boolean z) {
            this.isAttention = z;
        }

        public void setIsGod(boolean z) {
            this.isGod = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setPageId(BdUniqueId bdUniqueId) {
            this.pageId = bdUniqueId;
        }

        public void setForumId(String str) {
            this.forumId = str;
            if (str != null) {
                this.showToastAfterAttentionSuc = true;
            }
        }

        public void setInLive(String str) {
            this.inLive = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.mNetwork = new z();
                    if (this.isAttention) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.mNetwork.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.mNetwork.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.mNetwork.n("forum_id", this.forumId);
                    }
                    this.mNetwork.n("in_live", this.inLive);
                    this.mNetwork.uZ().vS().mIsNeedTbs = true;
                    return this.mNetwork.uB();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((C0036a) str);
            a.this.aqj = null;
            if (this.mNetwork != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.CX = this.mNetwork.uZ().vT().isRequestSuccess();
                aVar.errorString = this.mNetwork.getErrorString();
                aVar.isAttention = this.isAttention;
                aVar.toUid = this.toUid;
                aVar.isGod = this.isGod;
                aVar.n(str, this.showToastAfterAttentionSuc);
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.pageId));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fm();
                this.mNetwork = null;
            }
            a.this.aqj = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.g(false);
            }
        }
    }

    public void cancel() {
        if (this.aqj != null) {
            this.aqj.cancel();
        }
    }
}
