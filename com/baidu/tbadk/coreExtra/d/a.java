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
    private C0036a ahJ;
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
        if (this.ahJ == null) {
            this.ahJ = new C0036a(this, null);
            this.ahJ.setPriority(2);
            this.ahJ.ba(z);
            this.ahJ.setPortrait(str);
            this.ahJ.setToUid(str2);
            this.ahJ.setIsGod(z2);
            this.ahJ.setFrom(str3);
            this.ahJ.setPageId(bdUniqueId);
            this.ahJ.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0036a extends BdAsyncTask<Integer, Integer, String> {
        private ab afj;
        private BdUniqueId ahK;
        private boolean ahd;
        private boolean ahe;
        private String from;
        private String portrait;
        private String toUid;

        private C0036a() {
            this.afj = null;
            this.ahe = false;
            this.from = "0";
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

        public void ba(boolean z) {
            this.ahd = z;
        }

        public void setIsGod(boolean z) {
            this.ahe = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setPageId(BdUniqueId bdUniqueId) {
            this.ahK = bdUniqueId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.afj = new ab();
                    if (this.ahd) {
                        this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.afj.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.afj.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    this.afj.ty().uu().mIsNeedTbs = true;
                    this.afj.ta();
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
        /* renamed from: es */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.ahJ = null;
            if (this.afj != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.tb = this.afj.ty().uv().nU();
                aVar.errorString = this.afj.getErrorString();
                aVar.ahd = this.ahd;
                aVar.toUid = this.toUid;
                aVar.ahe = this.ahe;
                UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.ahK));
                MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afj != null) {
                this.afj.dm();
                this.afj = null;
            }
            a.this.ahJ = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.ahJ != null) {
            this.ahJ.cancel();
        }
    }
}
