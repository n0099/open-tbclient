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
    private C0037a aiy;
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
        if (this.aiy == null) {
            this.aiy = new C0037a(this, null);
            this.aiy.setPriority(2);
            this.aiy.bd(z);
            this.aiy.setPortrait(str);
            this.aiy.setToUid(str2);
            this.aiy.setIsGod(z2);
            this.aiy.setFrom(str3);
            this.aiy.setPageId(bdUniqueId);
            this.aiy.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a extends BdAsyncTask<Integer, Integer, String> {
        private ab afX;
        private boolean ahS;
        private boolean ahT;
        private BdUniqueId aiz;
        private String from;
        private String portrait;
        private String toUid;

        private C0037a() {
            this.afX = null;
            this.ahT = false;
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

        public void bd(boolean z) {
            this.ahS = z;
        }

        public void setIsGod(boolean z) {
            this.ahT = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setPageId(BdUniqueId bdUniqueId) {
            this.aiz = bdUniqueId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.afX = new ab();
                    if (this.ahS) {
                        this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.afX.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.afX.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    this.afX.tx().uu().mIsNeedTbs = true;
                    this.afX.sZ();
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
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.aiy = null;
            if (this.afX != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.tF = this.afX.tx().uv().nJ();
                aVar.errorString = this.afX.getErrorString();
                aVar.ahS = this.ahS;
                aVar.toUid = this.toUid;
                aVar.ahT = this.ahT;
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.aiz));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afX != null) {
                this.afX.dl();
                this.afX = null;
            }
            a.this.aiy = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.g(false);
            }
        }
    }

    public void cancel() {
        if (this.aiy != null) {
            this.aiy.cancel();
        }
    }
}
