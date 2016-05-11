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
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aHP = null;
    private k aHQ = null;
    private ListView mList = null;
    private RelativeLayout aHR = null;
    private TextView aHS = null;
    private View.OnClickListener aHT = null;
    private d aHU = null;
    private a aHV = null;
    private com.baidu.tbadk.coreExtra.view.j auq = null;
    private BdAsyncTask<?, ?, ?> aHW = null;
    private CustomMessageListener aHX = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_activity);
        HU();
        HV();
        registerListener(this.aHX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.aHR);
        this.aHQ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU() {
        if (TbadkCoreApplication.m11getInst().isAccountsDataFromPass()) {
            this.aHP = com.baidu.tbadk.coreExtra.a.a.wg().wj();
        } else {
            this.aHP = com.baidu.tbadk.core.a.b.oo();
        }
    }

    private void HV() {
        this.aHR = (RelativeLayout) findViewById(t.g.account_container);
        this.aHT = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.aHS = (TextView) addCustomView.findViewById(t.g.right_textview);
        this.aHS.setText(getPageContext().getString(t.j.edit));
        at.c(this.aHS, t.d.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aHQ = new k(this, this.aHT);
        this.aHQ.setData(this.aHP);
        this.mList = (ListView) findViewById(t.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.aHQ);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.auq == null) {
            this.auq = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.auq.a(new g(this));
        }
        this.auq.zq();
        this.auq.h(accountData);
        this.auq.zm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aHU == null) {
            gz("account changed");
            showLoadingDialog(getPageContext().getString(t.j.account_logining), new h(this));
            if (this.aHW != null) {
                this.aHW.cancel();
            }
            this.aHW = com.baidu.tbadk.core.a.a.oj().a(accountData.getAccount(), accountData.getBDUSS(), "", new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        this.aHU = new d(accountData);
        this.aHU.setPriority(3);
        if (this.aHU != null) {
            if (HX()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aHU.execute(new Object[0]);
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
        /* renamed from: g */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c wg = com.baidu.tbadk.coreExtra.a.a.wg();
                if (wg != null) {
                    wg.f(this.mAccount);
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
    public class c implements a.InterfaceC0033a {
        private AccountData akt;

        public c(AccountData accountData) {
            this.akt = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
        public void ce(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.l(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.akt != null) {
                ReloginManager.sL().e(this.akt);
                AccountActivity.this.a(false, this.akt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m11getInst().onUserChanged();
        com.baidu.tbadk.core.e.b.b(getPageContext().getPageActivity(), 1, false);
        this.aHU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aHV == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                gz("account delete");
            }
            showLoadingDialog(getPageContext().getString(t.j.deleting), new i(this, z2));
            this.aHV = new a(z, accountData);
            this.aHV.setPriority(3);
            HW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HW() {
        if (this.aHV != null) {
            if (HX()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aHV.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aIb;
        private boolean aIc;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aIc = false;
            this.aIb = accountData;
            this.aIc = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.aIb != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aIc) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aIb.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aIb.getID()));
                    l.deleteAccountAllInfo(this.aIb.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.sQ().remove("get_addresslist_switch" + this.aIb.getID());
                    if (this.aIb.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c wg = com.baidu.tbadk.coreExtra.a.a.wg();
                        if (wg != null) {
                            wg.wi();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c wg2 = com.baidu.tbadk.coreExtra.a.a.wg();
                        if (wg2 != null) {
                            wg2.g(this.aIb);
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
            if (this.aIb != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aIb.getID());
                new b(this.aIb.getBDUSS()).start();
            }
            AccountActivity.this.closeLoadingDialog();
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(t.j.success));
                    AccountActivity.this.aHP.remove(this.aIb);
                    this.aIb = null;
                    AccountActivity.this.aHQ.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
                    TbadkCoreApplication.m11getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(AccountActivity.this.getPageContext().getPageActivity()).createRefreshCfg(2, false)));
                    break;
            }
            AccountActivity.this.aHV = null;
        }
    }

    private void gz(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().aP();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gA(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String mZ;

        public b(String str) {
            this.mZ = null;
            this.mZ = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            abVar.tA().uu().YA = false;
            abVar.tA().uu().mIsUseCurrentBDUSS = false;
            abVar.n("BDUSS", this.mZ);
            abVar.n("channel_id", TbadkCoreApplication.m11getInst().getPushChannelId());
            abVar.n("channel_uid", TbadkCoreApplication.m11getInst().getPushChannelUserId());
            abVar.tc();
        }
    }

    private boolean HX() {
        return MessageManager.getInstance().getSocketClient().aS() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aHW != null) {
            this.aHW.cancel();
        }
    }
}
