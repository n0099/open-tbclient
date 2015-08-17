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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aDr = null;
    private i aDs = null;
    private ListView mList = null;
    private RelativeLayout aDt = null;
    private TextView aDu = null;
    private View.OnClickListener aDv = null;
    private d aDw = null;
    private a aDx = null;
    private Handler mHandler = new com.baidu.tieba.account.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_activity);
        FN();
        FO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aDt);
        this.aDs.notifyDataSetChanged();
    }

    private void FN() {
        if (TbadkCoreApplication.m411getInst().isAccountsDataFromPass()) {
            this.aDr = com.baidu.tbadk.coreExtra.act.a.vZ().wf();
        } else {
            this.aDr = com.baidu.tbadk.core.a.b.ro();
        }
    }

    private void FO() {
        this.aDt = (RelativeLayout) findViewById(i.f.account_container);
        this.aDv = new com.baidu.tieba.account.b(this);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.aDu = (TextView) addCustomView.findViewById(i.f.right_textview);
        this.aDu.setText(getPageContext().getString(i.C0057i.edit));
        al.b(this.aDu, i.c.navi_op_text, 1);
        addCustomView.setOnClickListener(new com.baidu.tieba.account.d(this));
        this.aDs = new i(this, this.aDv);
        this.aDs.setData(this.aDr);
        this.mList = (ListView) findViewById(i.f.list);
        this.mList.setAdapter((ListAdapter) this.aDs);
        this.mList.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        if (this.aDw == null) {
            fH("account changed");
            showLoadingDialog(getPageContext().getString(i.C0057i.account_logining), new f(this));
            com.baidu.tbadk.core.a.a.rj().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        this.aDw = new d(accountData);
        this.aDw.setPriority(3);
        if (this.aDw != null) {
            if (FQ()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aDw.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.act.l vZ = com.baidu.tbadk.coreExtra.act.a.vZ();
                if (vZ != null) {
                    vZ.i(this.mAccount);
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
            AccountActivity.this.o(this.mAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0040a {
        private AccountData alk;

        public c(AccountData accountData) {
            this.alk = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void cb(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.n(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.alk != null) {
                ReloginManager.tn().e(this.alk);
                AccountActivity.this.a(false, this.alk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m411getInst().onUserChanged();
        com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 1, false);
        this.aDw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aDx == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                fH("account delete");
            }
            showLoadingDialog(getPageContext().getString(i.C0057i.deleting), new g(this, z2));
            this.aDx = new a(z, accountData);
            this.aDx.setPriority(3);
            FP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        if (this.aDx != null) {
            if (FQ()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aDx.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aDC;
        private boolean aDD;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aDD = false;
            this.aDC = accountData;
            this.aDD = z;
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
                if (this.aDC != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aDD) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aDC.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aDC.getID()));
                    j.deleteAccountAllInfo(this.aDC.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.ts().remove("get_addresslist_switch" + this.aDC.getID());
                    if (this.aDC.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.act.l vZ = com.baidu.tbadk.coreExtra.act.a.vZ();
                        if (vZ != null) {
                            vZ.we();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.act.l vZ2 = com.baidu.tbadk.coreExtra.act.a.vZ();
                        if (vZ2 != null) {
                            vZ2.j(this.aDC);
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
        /* renamed from: p */
        public void onPostExecute(AccountData accountData) {
            if (this.aDC != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aDC.getID());
                new b(this.aDC.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(i.C0057i.success));
                    AccountActivity.this.aDr.remove(this.aDC);
                    this.aDC = null;
                    AccountActivity.this.aDs.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m411getInst().onUserChanged();
                    com.baidu.tbadk.core.c.b.a(AccountActivity.this.getPageContext().getPageActivity(), 11, false);
                    break;
            }
            AccountActivity.this.aDx = null;
        }
    }

    private void fH(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ew();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String wt;

        public b(String str) {
            this.wt = null;
            this.wt = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            vVar.ue().uV().abE = false;
            vVar.ue().uV().mIsUseCurrentBDUSS = false;
            vVar.o("BDUSS", this.wt);
            vVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            vVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            vVar.tD();
        }
    }

    private boolean FQ() {
        return MessageManager.getInstance().getSocketClient().ez() > 0;
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
