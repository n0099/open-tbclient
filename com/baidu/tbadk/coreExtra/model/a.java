package com.baidu.tbadk.coreExtra.model;

import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a {
    private C0416a dPp;
    private com.baidu.adp.base.d mLoadDataCallBack;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setLoadDataCallBack(com.baidu.adp.base.d dVar) {
        this.mLoadDataCallBack = dVar;
    }

    public void a(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        a(z, str, str2, false, "0", bdUniqueId, null, "0");
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        if (this.dPp == null) {
            this.dPp = new C0416a();
            this.dPp.setPriority(2);
            this.dPp.hk(z);
            this.dPp.setPortrait(str);
            this.dPp.setToUid(str2);
            this.dPp.setIsGod(z2);
            this.dPp.setFrom(str3);
            this.dPp.setPageId(bdUniqueId);
            this.dPp.setForumId(str4);
            this.dPp.setInLive(str5);
            this.dPp.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0416a extends BdAsyncTask<Integer, Integer, String> {
        private String authSid;
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
        private AuthTokenData tokenData;

        private C0416a() {
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

        public void hk(boolean z) {
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
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/c/user/follow");
                        this.mNetwork.gI(true);
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
                    this.mNetwork.aOy().aOZ().mIsNeedTbs = true;
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
            boolean[] g;
            super.onPostExecute((C0416a) str);
            a.this.dPp = null;
            if (this.mNetwork != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.isSucc = this.mNetwork.aOy().aPa().isRequestSuccess();
                aVar.errorString = this.mNetwork.getErrorString();
                aVar.isAttention = this.isAttention;
                aVar.toUid = this.toUid;
                aVar.isGod = this.isGod;
                aVar.parserJson(str, this.showToastAfterAttentionSuc);
                if (this.mNetwork.aOy().aPa().isRequestSuccess()) {
                    aVar.dOo = null;
                }
                if (!AntiHelper.d(a.this.getContext(), this.mNetwork.getServerErrorCode(), aVar.blockUrl)) {
                    UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                    updateAttentionMessage.setOrginalMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, this.pageId));
                    MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                    if (!this.isAttention || (g = a.this.g(a.this.mPageContext)) == null) {
                        return;
                    }
                    if (g[0] || g[1]) {
                        com.baidu.tbadk.coreExtra.c.a.a(a.this.mPageContext, g, a.this.mPageContext == null ? null : a.this.mPageContext.getString(R.string.attention_success), a.this.mPageContext != null ? a.this.mPageContext.getString(R.string.notification_permission_dialog_des_attention) : null);
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
            if (a.this.dPp != null) {
                a.this.dPp.cancel();
                a.this.dPp = null;
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
        if (this.dPp != null) {
            this.dPp.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean[] g(TbPageContext tbPageContext) {
        boolean[] zArr = null;
        String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
        if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("first_call_attention", true)) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("first_call_attention", false);
            zArr = new boolean[2];
            zArr[0] = !NotificationManagerCompat.from(this.mPageContext.getPageActivity()).areNotificationsEnabled();
            zArr[1] = !com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTP();
            if (!zArr[0] && !zArr[1] && tbPageContext != null) {
                tbPageContext.showToast(R.string.attention_success);
            }
        } else if (tbPageContext != null) {
            tbPageContext.showToast(R.string.attention_success);
        }
        return zArr;
    }
}
