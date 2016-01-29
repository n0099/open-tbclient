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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aII = null;
    private l aIJ = null;
    private ListView mList = null;
    private RelativeLayout aIK = null;
    private TextView aIL = null;
    private View.OnClickListener aIM = null;
    private d aIN = null;
    private a aIO = null;
    private com.baidu.tbadk.coreExtra.view.j axI = null;
    private CustomMessageListener aIP = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_activity);
        Ih();
        Ii();
        registerListener(this.aIP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.aIK);
        this.aIJ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        if (TbadkCoreApplication.m411getInst().isAccountsDataFromPass()) {
            this.aII = com.baidu.tbadk.coreExtra.a.a.xM().xP();
        } else {
            this.aII = com.baidu.tbadk.core.a.b.rA();
        }
    }

    private void Ii() {
        this.aIK = (RelativeLayout) findViewById(t.g.account_container);
        this.aIM = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.aIL = (TextView) addCustomView.findViewById(t.g.right_textview);
        this.aIL.setText(getPageContext().getString(t.j.edit));
        ar.b(this.aIL, t.d.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aIJ = new l(this, this.aIM);
        this.aIJ.setData(this.aII);
        this.mList = (ListView) findViewById(t.g.list);
        this.mList.setAdapter((ListAdapter) this.aIJ);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.axI == null) {
            this.axI = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.axI.a(new g(this));
        }
        this.axI.AT();
        this.axI.h(accountData);
        this.axI.AP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aIN == null) {
            gm("account changed");
            showLoadingDialog(getPageContext().getString(t.j.account_logining), new h(this));
            com.baidu.tbadk.core.a.a.rv().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        this.aIN = new d(accountData);
        this.aIN.setPriority(3);
        if (this.aIN != null) {
            if (Ik()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aIN.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c xM = com.baidu.tbadk.coreExtra.a.a.xM();
                if (xM != null) {
                    xM.f(this.mAccount);
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
        private AccountData aoo;

        public c(AccountData accountData) {
            this.aoo = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
        public void cj(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.l(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aoo != null) {
                ReloginManager.uJ().e(this.aoo);
                AccountActivity.this.a(false, this.aoo);
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
        com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 1, false);
        this.aIN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aIO == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                gm("account delete");
            }
            showLoadingDialog(getPageContext().getString(t.j.deleting), new i(this, z2));
            this.aIO = new a(z, accountData);
            this.aIO.setPriority(3);
            Ij();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ij() {
        if (this.aIO != null) {
            if (Ik()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aIO.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aIU;
        private boolean aIV;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aIV = false;
            this.aIU = accountData;
            this.aIV = z;
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
                if (this.aIU != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aIV) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aIU.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aIU.getID()));
                    m.deleteAccountAllInfo(this.aIU.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.uO().remove("get_addresslist_switch" + this.aIU.getID());
                    if (this.aIU.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c xM = com.baidu.tbadk.coreExtra.a.a.xM();
                        if (xM != null) {
                            xM.xO();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c xM2 = com.baidu.tbadk.coreExtra.a.a.xM();
                        if (xM2 != null) {
                            xM2.g(this.aIU);
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
            if (this.aIU != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aIU.getID());
                new b(this.aIU.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.h.h.hr().postDelayed(new j(this), 1000L);
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(t.j.success));
                    AccountActivity.this.aII.remove(this.aIU);
                    this.aIU = null;
                    AccountActivity.this.aIJ.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m411getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(AccountActivity.this.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                    break;
            }
            AccountActivity.this.aIO = null;
        }
    }

    private void gm(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ez();
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
        private String wJ;

        public b(String str) {
            this.wJ = null;
            this.wJ = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            aaVar.vB().wv().adM = false;
            aaVar.vB().wv().mIsUseCurrentBDUSS = false;
            aaVar.p("BDUSS", this.wJ);
            aaVar.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            aaVar.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            aaVar.uZ();
        }
    }

    private boolean Ik() {
        return MessageManager.getInstance().getSocketClient().eC() > 0;
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
