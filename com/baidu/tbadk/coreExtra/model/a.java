package com.baidu.tbadk.coreExtra.model;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a {
    private boolean fmi;
    private C0573a frj;
    private com.baidu.adp.base.e mLoadDataCallBack;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setLoadDataCallBack(com.baidu.adp.base.e eVar) {
        this.mLoadDataCallBack = eVar;
    }

    public void a(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        a(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.frj == null) {
            this.frj = new C0573a();
            this.frj.setPriority(2);
            this.frj.kv(z);
            this.frj.setPortrait(str);
            this.frj.setToUid(str2);
            this.frj.setIsGod(z2);
            this.frj.setFrom(str3);
            this.frj.setPageId(bdUniqueId);
            this.frj.setForumId(str4);
            this.frj.setInLive(str5);
            this.frj.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0573a extends BdAsyncTask<Integer, Integer, String> {
        private String authSid;
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
        private AuthTokenData tokenData;

        private C0573a() {
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

        public void kv(boolean z) {
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
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/c/user/follow");
                        this.mNetwork.jI(true);
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/c/user/unfollow");
                    }
                    this.mNetwork.addPostData("portrait", this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.mNetwork.addPostData("from_type", this.from);
                    }
                    if (!StringUtils.isNull(this.forumId)) {
                        this.mNetwork.addPostData("forum_id", this.forumId);
                    }
                    this.mNetwork.addPostData("in_live", this.inLive);
                    this.mNetwork.addPostData("authsid", this.authSid);
                    this.mNetwork.brX().bsG().mIsNeedTbs = true;
                    String postNetData = this.mNetwork.postNetData();
                    this.tokenData = AuthTokenData.parse(postNetData);
                    return postNetData;
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
            boolean[] i;
            super.onPostExecute((C0573a) str);
            a.this.frj = null;
            if (this.mNetwork != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.isSucc = this.mNetwork.brX().bsH().isRequestSuccess();
                aVar.errorString = this.mNetwork.getErrorString();
                aVar.isAttention = this.isAttention;
                aVar.toUid = this.toUid;
                aVar.isGod = this.isGod;
                aVar.fmi = a.this.fmi;
                aVar.parserJson(str, this.showToastAfterAttentionSuc);
                if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                    aVar.fqk = null;
                }
                int serverErrorCode = this.mNetwork.getServerErrorCode();
                if (!AntiHelper.c(a.this.getContext(), serverErrorCode, aVar.blockUrl)) {
                    UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                    updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, this.pageId));
                    MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                    if (this.isAttention && serverErrorCode == 0 && (i = a.this.i(a.this.mPageContext)) != null) {
                        if (i[0] || i[1]) {
                            com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, i, 1);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            if (a.this.frj != null) {
                a.this.frj.cancel();
                a.this.frj = null;
            }
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.callback(false);
            }
        }
    }

    public Context getContext() {
        if (this.mPageContext != null) {
            return this.mPageContext.getPageActivity();
        }
        return null;
    }

    public void cancel() {
        if (this.frj != null) {
            this.frj.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean[] i(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("first_call_attention", true)) {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("first_call_attention", false);
            zArr = new boolean[2];
            zArr[0] = !NotificationManagerCompat.from(this.mPageContext.getPageActivity()).areNotificationsEnabled();
            zArr[1] = !com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxO();
            if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.fmi) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null && !this.fmi) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }

    public void kd(boolean z) {
        this.fmi = z;
    }
}
