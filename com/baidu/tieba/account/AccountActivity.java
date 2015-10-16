package com.baidu.tieba.account;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aEp = null;
    private i aEq = null;
    private ListView mList = null;
    private RelativeLayout aEr = null;
    private TextView aEs = null;
    private View.OnClickListener aEt = null;
    private d aEu = null;
    private a aEv = null;
    private Handler mHandler = new com.baidu.tieba.account.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_activity);
        FR();
        FS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aEr);
        this.aEq.notifyDataSetChanged();
    }

    private void FR() {
        if (TbadkCoreApplication.m411getInst().isAccountsDataFromPass()) {
            this.aEp = com.baidu.tbadk.coreExtra.a.a.vX().wa();
        } else {
            this.aEp = com.baidu.tbadk.core.a.b.ri();
        }
    }

    private void FS() {
        this.aEr = (RelativeLayout) findViewById(i.f.account_container);
        this.aEt = new com.baidu.tieba.account.b(this);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.aEs = (TextView) addCustomView.findViewById(i.f.right_textview);
        this.aEs.setText(getPageContext().getString(i.h.edit));
        an.b(this.aEs, i.c.navi_op_text, 1);
        addCustomView.setOnClickListener(new com.baidu.tieba.account.d(this));
        this.aEq = new i(this, this.aEt);
        this.aEq.setData(this.aEp);
        this.mList = (ListView) findViewById(i.f.list);
        this.mList.setAdapter((ListAdapter) this.aEq);
        this.mList.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.aEu == null) {
            fT("account changed");
            showLoadingDialog(getPageContext().getString(i.h.account_logining), new f(this));
            com.baidu.tbadk.core.a.a.rd().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.aEu = new d(accountData);
        this.aEu.setPriority(3);
        if (this.aEu != null) {
            if (FU()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aEu.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Object, Integer, Boolean> {
        private AccountData mAccount;

        public d(AccountData accountData) {
            this.mAccount = null;
            this.mAccount = accountData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c vX = com.baidu.tbadk.coreExtra.a.a.vX();
                if (vX != null) {
                    vX.f(this.mAccount);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            AccountActivity.this.l(this.mAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0040a {
        private AccountData aky;

        public c(AccountData accountData) {
            this.aky = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void cd(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aky != null) {
                ReloginManager.tp().e(this.aky);
                AccountActivity.this.a(false, this.aky);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m411getInst().onUserChanged();
        com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 1, false);
        this.aEu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aEv == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                fT("account delete");
            }
            showLoadingDialog(getPageContext().getString(i.h.deleting), new g(this, z2));
            this.aEv = new a(z, accountData);
            this.aEv.setPriority(3);
            FT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT() {
        if (this.aEv != null) {
            if (FU()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aEv.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aEA;
        private boolean aEB;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aEB = false;
            this.aEA = accountData;
            this.aEB = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.aEA != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aEB) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aEA.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aEA.getID()));
                    j.deleteAccountAllInfo(this.aEA.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.tu().remove("get_addresslist_switch" + this.aEA.getID());
                    if (this.aEA.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c vX = com.baidu.tbadk.coreExtra.a.a.vX();
                        if (vX != null) {
                            vX.vZ();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c vX2 = com.baidu.tbadk.coreExtra.a.a.vX();
                        if (vX2 != null) {
                            vX2.g(this.aEA);
                        }
                        this.mType = 0;
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onPostExecute(AccountData accountData) {
            if (this.aEA != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aEA.getID());
                new b(this.aEA.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(i.h.success));
                    AccountActivity.this.aEp.remove(this.aEA);
                    this.aEA = null;
                    AccountActivity.this.aEq.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m411getInst().onUserChanged();
                    com.baidu.tbadk.core.c.b.b(AccountActivity.this.getPageContext().getPageActivity(), 11, false);
                    break;
            }
            AccountActivity.this.aEv = null;
        }
    }

    private void fT(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ev();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String ws;

        public b(String str) {
            this.ws = null;
            this.ws = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            wVar.uh().uY().abO = false;
            wVar.uh().uY().mIsUseCurrentBDUSS = false;
            wVar.o("BDUSS", this.ws);
            wVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            wVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            wVar.tG();
        }
    }

    private boolean FU() {
        return MessageManager.getInstance().getSocketClient().ey() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
