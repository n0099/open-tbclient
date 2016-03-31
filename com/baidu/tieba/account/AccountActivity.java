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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aLE = null;
    private k aLF = null;
    private ListView mList = null;
    private RelativeLayout aLG = null;
    private TextView aLH = null;
    private View.OnClickListener aLI = null;
    private d aLJ = null;
    private a aLK = null;
    private com.baidu.tbadk.coreExtra.view.j ayp = null;
    private BdAsyncTask<?, ?, ?> aLL = null;
    private CustomMessageListener aLM = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_activity);
        JD();
        JE();
        registerListener(this.aLM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.aLG);
        this.aLF.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        if (TbadkCoreApplication.m411getInst().isAccountsDataFromPass()) {
            this.aLE = com.baidu.tbadk.coreExtra.a.a.yn().yq();
        } else {
            this.aLE = com.baidu.tbadk.core.a.b.qR();
        }
    }

    private void JE() {
        this.aLG = (RelativeLayout) findViewById(t.g.account_container);
        this.aLI = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.aLH = (TextView) addCustomView.findViewById(t.g.right_textview);
        this.aLH.setText(getPageContext().getString(t.j.edit));
        at.b(this.aLH, t.d.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aLF = new k(this, this.aLI);
        this.aLF.setData(this.aLE);
        this.mList = (ListView) findViewById(t.g.list);
        this.mList.setAdapter((ListAdapter) this.aLF);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.ayp == null) {
            this.ayp = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.ayp.a(new g(this));
        }
        this.ayp.Bw();
        this.ayp.h(accountData);
        this.ayp.Bs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aLJ == null) {
            gy("account changed");
            showLoadingDialog(getPageContext().getString(t.j.account_logining), new h(this));
            if (this.aLL != null) {
                this.aLL.cancel();
            }
            this.aLL = com.baidu.tbadk.core.a.a.qM().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        this.aLJ = new d(accountData);
        this.aLJ.setPriority(3);
        if (this.aLJ != null) {
            if (JG()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aLJ.execute(new Object[0]);
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
        /* renamed from: f */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c yn = com.baidu.tbadk.coreExtra.a.a.yn();
                if (yn != null) {
                    yn.f(this.mAccount);
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
            AccountActivity.this.m(this.mAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0042a {
        private AccountData aoF;

        public c(AccountData accountData) {
            this.aoF = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
        public void cg(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.l(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aoF != null) {
                ReloginManager.vf().e(this.aoF);
                AccountActivity.this.a(false, this.aoF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m411getInst().onUserChanged();
        com.baidu.tbadk.core.d.b.b(getPageContext().getPageActivity(), 1, false);
        this.aLJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aLK == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                gy("account delete");
            }
            showLoadingDialog(getPageContext().getString(t.j.deleting), new i(this, z2));
            this.aLK = new a(z, accountData);
            this.aLK.setPriority(3);
            JF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JF() {
        if (this.aLK != null) {
            if (JG()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aLK.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aLR;
        private boolean aLS;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aLS = false;
            this.aLR = accountData;
            this.aLS = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.aLR != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aLS) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aLR.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aLR.getID()));
                    l.deleteAccountAllInfo(this.aLR.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.vk().remove("get_addresslist_switch" + this.aLR.getID());
                    if (this.aLR.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c yn = com.baidu.tbadk.coreExtra.a.a.yn();
                        if (yn != null) {
                            yn.yp();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c yn2 = com.baidu.tbadk.coreExtra.a.a.yn();
                        if (yn2 != null) {
                            yn2.g(this.aLR);
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
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            if (this.aLR != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aLR.getID());
                new b(this.aLR.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(t.j.success));
                    AccountActivity.this.aLE.remove(this.aLR);
                    this.aLR = null;
                    AccountActivity.this.aLF.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
                    TbadkCoreApplication.m411getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(AccountActivity.this.getPageContext().getPageActivity()).createRefreshCfg(2, false)));
                    break;
            }
            AccountActivity.this.aLK = null;
        }
    }

    private void gy(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ez();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String xa;

        public b(String str) {
            this.xa = null;
            this.xa = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            abVar.vU().wO().adb = false;
            abVar.vU().wO().mIsUseCurrentBDUSS = false;
            abVar.p("BDUSS", this.xa);
            abVar.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            abVar.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            abVar.vw();
        }
    }

    private boolean JG() {
        return MessageManager.getInstance().getSocketClient().eC() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aLL != null) {
            this.aLL.cancel();
        }
    }
}
