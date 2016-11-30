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
    private C0037a amd;
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
        if (this.amd == null) {
            this.amd = new C0037a(this, null);
            this.amd.setPriority(2);
            this.amd.bi(z);
            this.amd.setPortrait(str);
            this.amd.setToUid(str2);
            this.amd.setIsGod(z2);
            this.amd.setFrom(str3);
            this.amd.setPageId(bdUniqueId);
            this.amd.setForumId(str4);
            this.amd.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a extends BdAsyncTask<Integer, Integer, String> {
        private z ajm;
        private boolean alx;
        private BdUniqueId ame;
        private boolean amf;
        private String forumId;
        private String from;
        private boolean isGod;
        private String portrait;
        private String toUid;

        private C0037a() {
            this.ajm = null;
            this.isGod = false;
            this.from = "0";
            this.forumId = null;
            this.amf = false;
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
            this.alx = z;
        }

        public void setIsGod(boolean z) {
            this.isGod = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setPageId(BdUniqueId bdUniqueId) {
            this.ame = bdUniqueId;
        }

        public void setForumId(String str) {
            this.forumId = str;
            if (str != null) {
                this.amf = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.ajm = new z();
                    if (this.alx) {
                        this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.ajm.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.ajm.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.ajm.n("forum_id", this.forumId);
                    }
                    this.ajm.uW().vR().mIsNeedTbs = true;
                    return this.ajm.uy();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ez */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.amd = null;
            if (this.ajm != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.vS = this.ajm.uW().vS().oH();
                aVar.errorString = this.ajm.getErrorString();
                aVar.alx = this.alx;
                aVar.toUid = this.toUid;
                aVar.isGod = this.isGod;
                aVar.n(str, this.amf);
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.ame));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.ajm != null) {
                this.ajm.eg();
                this.ajm = null;
            }
            a.this.amd = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.g(false);
            }
        }
    }

    public void cancel() {
        if (this.amd != null) {
            this.amd.cancel();
        }
    }
}
