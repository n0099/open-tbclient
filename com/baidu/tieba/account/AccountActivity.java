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
    private List<AccountData> aDj = null;
    private i aDk = null;
    private ListView mList = null;
    private RelativeLayout aDl = null;
    private TextView aDm = null;
    private View.OnClickListener aDn = null;
    private d aDo = null;
    private a aDp = null;
    private Handler mHandler = new com.baidu.tieba.account.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_activity);
        FK();
        FL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aDl);
        this.aDk.notifyDataSetChanged();
    }

    private void FK() {
        if (TbadkCoreApplication.m411getInst().isAccountsDataFromPass()) {
            this.aDj = com.baidu.tbadk.coreExtra.a.a.vY().wb();
        } else {
            this.aDj = com.baidu.tbadk.core.a.b.rg();
        }
    }

    private void FL() {
        this.aDl = (RelativeLayout) findViewById(i.f.account_container);
        this.aDn = new com.baidu.tieba.account.b(this);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.aDm = (TextView) addCustomView.findViewById(i.f.right_textview);
        this.aDm.setText(getPageContext().getString(i.h.edit));
        an.b(this.aDm, i.c.navi_op_text, 1);
        addCustomView.setOnClickListener(new com.baidu.tieba.account.d(this));
        this.aDk = new i(this, this.aDn);
        this.aDk.setData(this.aDj);
        this.mList = (ListView) findViewById(i.f.list);
        this.mList.setAdapter((ListAdapter) this.aDk);
        this.mList.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.aDo == null) {
            fV("account changed");
            showLoadingDialog(getPageContext().getString(i.h.account_logining), new f(this));
            com.baidu.tbadk.core.a.a.rb().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.aDo = new d(accountData);
        this.aDo.setPriority(3);
        if (this.aDo != null) {
            if (FN()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aDo.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c vY = com.baidu.tbadk.coreExtra.a.a.vY();
                if (vY != null) {
                    vY.f(this.mAccount);
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
        private AccountData akD;

        public c(AccountData accountData) {
            this.akD = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void cb(String str) {
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
            if (i == 1 && this.akD != null) {
                ReloginManager.tp().e(this.akD);
                AccountActivity.this.a(false, this.akD);
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
        this.aDo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aDp == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                fV("account delete");
            }
            showLoadingDialog(getPageContext().getString(i.h.deleting), new g(this, z2));
            this.aDp = new a(z, accountData);
            this.aDp.setPriority(3);
            FM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (this.aDp != null) {
            if (FN()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aDp.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aDu;
        private boolean aDv;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aDv = false;
            this.aDu = accountData;
            this.aDv = z;
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
                if (this.aDu != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aDv) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aDu.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aDu.getID()));
                    j.deleteAccountAllInfo(this.aDu.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.tu().remove("get_addresslist_switch" + this.aDu.getID());
                    if (this.aDu.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c vY = com.baidu.tbadk.coreExtra.a.a.vY();
                        if (vY != null) {
                            vY.wa();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c vY2 = com.baidu.tbadk.coreExtra.a.a.vY();
                        if (vY2 != null) {
                            vY2.g(this.aDu);
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
            if (this.aDu != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aDu.getID());
                new b(this.aDu.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(i.h.success));
                    AccountActivity.this.aDj.remove(this.aDu);
                    this.aDu = null;
                    AccountActivity.this.aDk.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m411getInst().onUserChanged();
                    com.baidu.tbadk.core.c.b.b(AccountActivity.this.getPageContext().getPageActivity(), 11, false);
                    break;
            }
            AccountActivity.this.aDp = null;
        }
    }

    private void fV(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ev();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
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
            wVar.uh().uZ().abT = false;
            wVar.uh().uZ().mIsUseCurrentBDUSS = false;
            wVar.o("BDUSS", this.ws);
            wVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            wVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            wVar.tG();
        }
    }

    private boolean FN() {
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
