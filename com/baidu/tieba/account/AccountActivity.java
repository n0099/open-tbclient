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
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aHG = null;
    private k aHH = null;
    private ListView mList = null;
    private RelativeLayout aHI = null;
    private TextView aHJ = null;
    private View.OnClickListener aHK = null;
    private d aHL = null;
    private a aHM = null;
    private CustomMessageListener aHN = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.account_activity);
        GG();
        GH();
        registerListener(this.aHN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.aHI);
        this.aHH.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GG() {
        if (TbadkCoreApplication.m411getInst().isAccountsDataFromPass()) {
            this.aHG = com.baidu.tbadk.coreExtra.a.a.wy().wB();
        } else {
            this.aHG = com.baidu.tbadk.core.a.b.rd();
        }
    }

    private void GH() {
        this.aHI = (RelativeLayout) findViewById(n.g.account_container);
        this.aHK = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.aHJ = (TextView) addCustomView.findViewById(n.g.right_textview);
        this.aHJ.setText(getPageContext().getString(n.j.edit));
        as.b(this.aHJ, n.d.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aHH = new k(this, this.aHK);
        this.aHH.setData(this.aHG);
        this.mList = (ListView) findViewById(n.g.list);
        this.mList.setAdapter((ListAdapter) this.aHH);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.aHL == null) {
            gm("account changed");
            showLoadingDialog(getPageContext().getString(n.j.account_logining), new g(this));
            com.baidu.tbadk.core.a.a.qY().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.aHL = new d(accountData);
        this.aHL.setPriority(3);
        if (this.aHL != null) {
            if (GJ()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aHL.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c wy = com.baidu.tbadk.coreExtra.a.a.wy();
                if (wy != null) {
                    wy.f(this.mAccount);
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
    public class c implements a.InterfaceC0041a {
        private AccountData anv;

        public c(AccountData accountData) {
            this.anv = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
        public void ck(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.anv != null) {
                ReloginManager.tE().e(this.anv);
                AccountActivity.this.a(false, this.anv);
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
        this.aHL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aHM == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                gm("account delete");
            }
            showLoadingDialog(getPageContext().getString(n.j.deleting), new h(this, z2));
            this.aHM = new a(z, accountData);
            this.aHM.setPriority(3);
            GI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        if (this.aHM != null) {
            if (GJ()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aHM.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aHS;
        private boolean aHT;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aHT = false;
            this.aHS = accountData;
            this.aHT = z;
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
                if (this.aHS != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aHT) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aHS.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aHS.getID()));
                    l.deleteAccountAllInfo(this.aHS.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.tJ().remove("get_addresslist_switch" + this.aHS.getID());
                    if (this.aHS.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c wy = com.baidu.tbadk.coreExtra.a.a.wy();
                        if (wy != null) {
                            wy.wA();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c wy2 = com.baidu.tbadk.coreExtra.a.a.wy();
                        if (wy2 != null) {
                            wy2.g(this.aHS);
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
            if (this.aHS != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aHS.getID());
                new b(this.aHS.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.h.h.hj().postDelayed(new i(this), 1000L);
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(n.j.success));
                    AccountActivity.this.aHG.remove(this.aHS);
                    this.aHS = null;
                    AccountActivity.this.aHH.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m411getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(AccountActivity.this.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                    break;
            }
            AccountActivity.this.aHM = null;
        }
    }

    private void gm(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ev();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String wA;

        public b(String str) {
            this.wA = null;
            this.wA = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            abVar.uw().vp().adq = false;
            abVar.uw().vp().mIsUseCurrentBDUSS = false;
            abVar.o("BDUSS", this.wA);
            abVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            abVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            abVar.tV();
        }
    }

    private boolean GJ() {
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
