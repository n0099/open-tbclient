package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
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
    private C0036a ahf;
    private g mLoadDataCallBack;

    public a(g gVar) {
        this.mLoadDataCallBack = gVar;
    }

    public void a(boolean z, String str, String str2) {
        a(z, str, str2, false, "0");
    }

    public void a(boolean z, String str, String str2, boolean z2, String str3) {
        if (this.ahf == null) {
            this.ahf = new C0036a(this, null);
            this.ahf.setPriority(2);
            this.ahf.bc(z);
            this.ahf.setPortrait(str);
            this.ahf.setToUid(str2);
            this.ahf.bd(z2);
            this.ahf.setFrom(str3);
            this.ahf.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0036a extends BdAsyncTask<Integer, Integer, String> {
        private ab aeI;
        private boolean agA;
        private boolean agz;
        private String from;
        private String portrait;
        private String toUid;

        private C0036a() {
            this.aeI = null;
            this.agA = false;
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

        public void bc(boolean z) {
            this.agz = z;
        }

        public void bd(boolean z) {
            this.agA = z;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            try {
                if (this.portrait != null) {
                    this.aeI = new ab();
                    if (this.agz) {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                    } else {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                    }
                    this.aeI.n(IntentConfig.PORTRAIT, this.portrait);
                    if (!StringUtils.isNull(this.from)) {
                        this.aeI.n(ForumDetailActivityConfig.FROM_TYPE, this.from);
                    }
                    this.aeI.tA().uu().mIsNeedTbs = true;
                    this.aeI.tc();
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
        /* renamed from: eo */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.ahf = null;
            if (this.aeI != null) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.sZ = this.aeI.tA().uv().nZ();
                aVar.errorString = this.aeI.getErrorString();
                aVar.agz = this.agz;
                aVar.toUid = this.toUid;
                aVar.agA = this.agA;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aeI != null) {
                this.aeI.dl();
                this.aeI = null;
            }
            a.this.ahf = null;
            if (a.this.mLoadDataCallBack != null) {
                a.this.mLoadDataCallBack.d(false);
            }
        }
    }

    public void cancel() {
        if (this.ahf != null) {
            this.ahf.cancel();
        }
    }
}
