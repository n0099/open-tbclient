package com.baidu.tieba.account;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aRz = null;
    private l aRA = null;
    private ListView mList = null;
    private RelativeLayout aRB = null;
    private TextView aRC = null;
    private View.OnClickListener aRD = null;
    private d aRE = null;
    private a aRF = null;
    private com.baidu.tbadk.coreExtra.view.j azc = null;
    private BdAsyncTask<?, ?, ?> aRG = null;
    private CustomMessageListener aRH = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_activity);
        Lw();
        Lx();
        registerListener(this.aRH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.aRB);
        this.aRA.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw() {
        if (TbadkCoreApplication.m9getInst().isAccountsDataFromPass()) {
            this.aRz = com.baidu.tbadk.coreExtra.a.a.xo().xr();
        } else {
            this.aRz = com.baidu.tbadk.core.a.b.oT();
        }
    }

    private void Lx() {
        this.aRB = (RelativeLayout) findViewById(t.g.account_container);
        this.aRD = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.aRC = (TextView) addCustomView.findViewById(t.g.right_textview);
        this.aRC.setText(getPageContext().getString(t.j.edit));
        av.c(this.aRC, t.d.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aRA = new l(this, this.aRD);
        this.aRA.setData(this.aRz);
        this.mList = (ListView) findViewById(t.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.aRA);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.azc == null) {
            this.azc = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.azc.a(new g(this));
        }
        this.azc.AL();
        this.azc.i(accountData);
        this.azc.AH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.aRE == null) {
            hj("account changed");
            showLoadingDialog(getPageContext().getString(t.j.account_logining), new h(this));
            if (this.aRG != null) {
                this.aRG.cancel();
            }
            this.aRG = com.baidu.tbadk.core.a.a.oO().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        this.aRE = new d(accountData);
        this.aRE.setPriority(3);
        if (this.aRE != null) {
            if (Lz()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aRE.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c xo = com.baidu.tbadk.coreExtra.a.a.xo();
                if (xo != null) {
                    xo.g(this.mAccount);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            AccountActivity.this.n(this.mAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0033a {
        private AccountData aoV;

        public c(AccountData accountData) {
            this.aoV = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
        public void cf(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.m(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aoV != null) {
                ReloginManager.tN().f(this.aoV);
                AccountActivity.this.a(false, this.aoV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m9getInst().onUserChanged();
        com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), 1, false);
        this.aRE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aRF == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                hj("account delete");
            }
            showLoadingDialog(getPageContext().getString(t.j.deleting), new i(this, z2));
            this.aRF = new a(z, accountData);
            this.aRF.setPriority(3);
            Ly();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ly() {
        if (this.aRF != null) {
            if (Lz()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aRF.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aRL;
        private boolean aRM;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aRM = false;
            this.aRL = accountData;
            this.aRM = z;
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
                if (this.aRL != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aRM) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aRL.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aRL.getID()));
                    m.deleteAccountAllInfo(this.aRL.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.tS().remove("get_addresslist_switch" + this.aRL.getID());
                    if (this.aRL.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c xo = com.baidu.tbadk.coreExtra.a.a.xo();
                        if (xo != null) {
                            xo.xq();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c xo2 = com.baidu.tbadk.coreExtra.a.a.xo();
                        if (xo2 != null) {
                            xo2.h(this.aRL);
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
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            if (this.aRL != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aRL.getID());
                new b(this.aRL.getBDUSS(), com.baidu.tbadk.core.a.h.d(this.aRL)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.h.h.eG().postDelayed(new j(this), 1000L);
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(t.j.success));
                    AccountActivity.this.aRz.remove(this.aRL);
                    this.aRL = null;
                    AccountActivity.this.aRA.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m9getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(AccountActivity.this.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                    break;
            }
            AccountActivity.this.aRF = null;
        }
    }

    private void hj(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().bJ();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String mStoken;
        private String pX;

        public b(String str, String str2) {
            this.pX = null;
            this.mStoken = null;
            this.pX = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            abVar.uD().vz().acp = false;
            abVar.uD().vz().mIsUseCurrentBDUSS = false;
            abVar.n("BDUSS", this.pX);
            abVar.n("stoken", this.mStoken);
            abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            abVar.ue();
        }
    }

    private boolean Lz() {
        return MessageManager.getInstance().getSocketClient().bM() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aRG != null) {
            this.aRG.cancel();
        }
    }
}
