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
    private List<AccountData> aGg = null;
    private j aGh = null;
    private ListView mList = null;
    private RelativeLayout aGi = null;
    private TextView aGj = null;
    private View.OnClickListener aGk = null;
    private d aGl = null;
    private a aGm = null;
    private Handler mHandler = new com.baidu.tieba.account.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.account_activity);
        GR();
        GS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.aGi);
        this.aGh.notifyDataSetChanged();
    }

    private void GR() {
        if (TbadkCoreApplication.m411getInst().isAccountsDataFromPass()) {
            this.aGg = com.baidu.tbadk.coreExtra.a.a.wP().wS();
        } else {
            this.aGg = com.baidu.tbadk.core.a.b.ru();
        }
    }

    private void GS() {
        this.aGi = (RelativeLayout) findViewById(n.f.account_container);
        this.aGk = new com.baidu.tieba.account.b(this);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.i.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.aGj = (TextView) addCustomView.findViewById(n.f.right_textview);
        this.aGj.setText(getPageContext().getString(n.i.edit));
        as.b(this.aGj, n.c.navi_op_text, 1);
        addCustomView.setOnClickListener(new com.baidu.tieba.account.d(this));
        this.aGh = new j(this, this.aGk);
        this.aGh.setData(this.aGg);
        this.mList = (ListView) findViewById(n.f.list);
        this.mList.setAdapter((ListAdapter) this.aGh);
        this.mList.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.aGl == null) {
            gi("account changed");
            showLoadingDialog(getPageContext().getString(n.i.account_logining), new f(this));
            com.baidu.tbadk.core.a.a.rp().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.aGl = new d(accountData);
        this.aGl.setPriority(3);
        if (this.aGl != null) {
            if (GU()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aGl.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c wP = com.baidu.tbadk.coreExtra.a.a.wP();
                if (wP != null) {
                    wP.f(this.mAccount);
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
        private AccountData amo;

        public c(AccountData accountData) {
            this.amo = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
        public void ci(String str) {
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
            if (i == 1 && this.amo != null) {
                ReloginManager.tU().e(this.amo);
                AccountActivity.this.a(false, this.amo);
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
        this.aGl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aGm == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                gi("account delete");
            }
            showLoadingDialog(getPageContext().getString(n.i.deleting), new g(this, z2));
            this.aGm = new a(z, accountData);
            this.aGm.setPriority(3);
            GT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GT() {
        if (this.aGm != null) {
            if (GU()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aGm.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aGr;
        private boolean aGs;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aGs = false;
            this.aGr = accountData;
            this.aGs = z;
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
                if (this.aGr != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aGs) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aGr.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aGr.getID()));
                    k.deleteAccountAllInfo(this.aGr.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.tZ().remove("get_addresslist_switch" + this.aGr.getID());
                    if (this.aGr.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c wP = com.baidu.tbadk.coreExtra.a.a.wP();
                        if (wP != null) {
                            wP.wR();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c wP2 = com.baidu.tbadk.coreExtra.a.a.wP();
                        if (wP2 != null) {
                            wP2.g(this.aGr);
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
            if (this.aGr != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aGr.getID());
                new b(this.aGr.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.h.h.hj().postDelayed(new h(this), 1000L);
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(n.i.success));
                    AccountActivity.this.aGg.remove(this.aGr);
                    this.aGr = null;
                    AccountActivity.this.aGh.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m411getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(AccountActivity.this.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                    break;
            }
            AccountActivity.this.aGm = null;
        }
    }

    private void gi(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ev();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String wy;

        public b(String str) {
            this.wy = null;
            this.wy = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            abVar.uM().vF().acL = false;
            abVar.uM().vF().mIsUseCurrentBDUSS = false;
            abVar.o("BDUSS", this.wy);
            abVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            abVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            abVar.ul();
        }
    }

    private boolean GU() {
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
