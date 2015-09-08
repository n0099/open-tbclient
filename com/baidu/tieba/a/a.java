package com.baidu.tieba.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        void a(AccountData accountData);

        void fR(String str);
    }

    public static void a(String str, String str2, InterfaceC0055a interfaceC0055a) {
        b bVar = new b(str, str2, interfaceC0055a);
        bVar.setPriority(3);
        bVar.execute(new Object[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Object, Object, AccountData> {
        private final InterfaceC0055a bXi;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, InterfaceC0055a interfaceC0055a) {
            this.mAccount = str;
            this.mPassword = str2;
            this.bXi = interfaceC0055a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public AccountData doInBackground(Object... objArr) {
            return a.aT(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.bXi != null) {
                if (accountData != null) {
                    this.bXi.a(accountData);
                } else {
                    this.bXi.fR(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData aT(String str, String str2) {
        v vVar;
        String tI;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            vVar = new v(sb.toString());
            vVar.o("un", str);
            vVar.o("passwd", str2);
            vVar.o("isphone", "0");
            vVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            vVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            vVar.uj().uZ().vc().acl = true;
            vVar.uj().uZ().mIsNeedAddCommenParam = false;
            vVar.uj().uZ().mIsUseCurrentBDUSS = false;
            tI = vVar.tI();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (vVar.uj().va().qZ() && tI != null) {
            l lVar = new l();
            lVar.parserJson(tI);
            String userId = lVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(lVar.getUser().getUserName());
            if (lVar.getUser().getPassword() != null) {
                accountData.setPassword(lVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(lVar.getUser().getUserId());
            accountData.setBDUSS(lVar.getUser().getBDUSS());
            accountData.setPortrait(lVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (lVar.rK() != null) {
                accountData.setTbs(lVar.rK().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (vVar.um()) {
            switch (vVar.un()) {
                case 1:
                case 2:
                case 5:
                    vVar.gJ();
                    ReloginManager.ts().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
