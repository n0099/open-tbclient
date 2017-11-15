package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private C0050a asw;
    private com.baidu.adp.base.d mLoadDataCallBack;

    public a(com.baidu.adp.base.d dVar) {
        this.mLoadDataCallBack = dVar;
    }

    public void b(boolean z, String str, String str2) {
        a(z, str, str2, false, "0", null, null, "0");
    }

    public void a(boolean z, String str, String str2, boolean z2, BdUniqueId bdUniqueId) {
        a(z, str, str2, z2, "0", bdUniqueId, null, "0");
    }

    public void a(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        a(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.asw == null) {
            this.asw = new C0050a();
            this.asw.setPriority(2);
            this.asw.bg(z);
            this.asw.setPortrait(str);
            this.asw.setToUid(str2);
            this.asw.setIsGod(z2);
            this.asw.setFrom(str3);
            this.asw.setPageId(bdUniqueId);
            this.asw.setForumId(str4);
            this.asw.setInLive(str5);
            this.asw.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0050a extends BdAsyncTask<Integer, Integer, String> {
        private String forumId;
        private String from;
        private String inLive;
        private boolean isAttention;
        private boolean isGod;
        private x mNetwork;
        private BdUniqueId pageId;
        private String portrait;
        private boolean showToastAfterAttentionSuc;
        private String toUid;

        private C0050a() {
            this.mNetwork = null;
            this.isGod = false;
            this.from = "0";
            this.inLive = "0";
            this.forumId = null;
            this.showToastAfterAttentionSuc = false;
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setToUid(String str) {
            this.toUid = str;
        }

        public void bg(boolean z) {
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
                    this.mNetwork = new x();
                    if (this.isAttention) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.mNetwork.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.mNetwork.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.mNetwork.n("forum_id", this.forumId);
                    }
                    this.mNetwork.n("in_live", this.inLive);
                    this.mNetwork.uN().vK().mIsNeedTbs = true;
                    return this.mNetwork.up();
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
            super.onPostExecute((C0050a) str);
            a.this.asw = null;
            if (this.mNetwork != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.BJ = this.mNetwork.uN().vL().isRequestSuccess();
                aVar.errorString = this.mNetwork.getErrorString();
                aVar.isAttention = this.isAttention;
                aVar.toUid = this.toUid;
                aVar.isGod = this.isGod;
                aVar.k(str, this.showToastAfterAttentionSuc);
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.pageId));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fo();
                this.mNetwork = null;
            }
            if (a.this.asw != null) {
                a.this.asw.cancel();
                a.this.asw = null;
            }
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.f(false);
            }
        }
    }

    public void cancel() {
        if (this.asw != null) {
            this.asw.cancel();
        }
    }
}
