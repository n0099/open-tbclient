package com.baidu.tieba.account;

import android.content.Context;
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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aVp = null;
    private l aVq = null;
    private ListView mList = null;
    private RelativeLayout aVr = null;
    private TextView aVs = null;
    private View.OnClickListener aVt = null;
    private d aVu = null;
    private a aVv = null;
    private com.baidu.tbadk.coreExtra.view.j aDB = null;
    private BdAsyncTask<?, ?, ?> aVw = null;
    private CustomMessageListener aVx = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.account_activity);
        LV();
        LW();
        registerListener(this.aVx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.aVr);
        this.aVq.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LV() {
        if (TbadkCoreApplication.m9getInst().isAccountsDataFromPass()) {
            this.aVp = com.baidu.tbadk.coreExtra.a.a.xU().xX();
        } else {
            this.aVp = com.baidu.tbadk.core.a.b.pB();
        }
    }

    private void LW() {
        this.aVr = (RelativeLayout) findViewById(w.h.account_container);
        this.aVt = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(w.l.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.navigation_right_button_layout, (View.OnClickListener) null);
        this.aVs = (TextView) addCustomView.findViewById(w.h.right_textview);
        this.aVs.setText(getPageContext().getString(w.l.edit));
        aq.c(this.aVs, w.e.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aVq = new l(this, this.aVt);
        this.aVq.setData(this.aVp);
        this.mList = (ListView) findViewById(w.h.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.aVq);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aDB == null) {
            this.aDB = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.aDB.a(new g(this));
        }
        this.aDB.Bv();
        this.aDB.i(accountData);
        this.aDB.Br();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.aVu == null) {
            hb("account changed");
            showLoadingDialog(getPageContext().getString(w.l.account_logining), new h(this));
            if (this.aVw != null) {
                this.aVw.cancel();
            }
            this.aVw = com.baidu.tbadk.core.a.a.pw().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        this.aVu = new d(accountData);
        this.aVu.setPriority(3);
        if (this.aVu != null) {
            if (LY()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aVu.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c xU = com.baidu.tbadk.coreExtra.a.a.xU();
                if (xU != null) {
                    xU.g(this.mAccount);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            AccountActivity.this.n(this.mAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0030a {
        private AccountData atS;

        public c(AccountData accountData) {
            this.atS = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
        public void cf(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", SapiAccountManager.SESSION_UID, accountData.getID());
            AccountActivity.this.m(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.atS != null) {
                ReloginManager.uG().f(this.atS);
                AccountActivity.this.a(false, this.atS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", SapiAccountManager.SESSION_UID, accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m9getInst().onUserChanged();
        com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 1, false);
        this.aVu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aVv == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                hb("account delete");
            }
            showLoadingDialog(getPageContext().getString(w.l.deleting), new i(this, z2));
            this.aVv = new a(z, accountData);
            this.aVv.setPriority(3);
            LX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LX() {
        if (this.aVv != null) {
            if (LY()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aVv.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aVB;
        private boolean aVC;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aVC = false;
            this.aVB = accountData;
            this.aVC = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.aVB != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aVC) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aVB.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aVB.getID()));
                    m.deleteAccountAllInfo(this.aVB.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.uL().remove("get_addresslist_switch" + this.aVB.getID());
                    if (this.aVB.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c xU = com.baidu.tbadk.coreExtra.a.a.xU();
                        if (xU != null) {
                            xU.xW();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c xU2 = com.baidu.tbadk.coreExtra.a.a.xU();
                        if (xU2 != null) {
                            xU2.h(this.aVB);
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
            if (this.aVB != null) {
                com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aVB.getID());
                new b(this.aVB.getBDUSS(), com.baidu.tbadk.core.a.h.d(this.aVB)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.g.h.fS().postDelayed(new j(this), 1000L);
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(w.l.success));
                    AccountActivity.this.aVp.remove(this.aVB);
                    this.aVB = null;
                    AccountActivity.this.aVq.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m9getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
                    break;
            }
            AccountActivity.this.aVv = null;
        }
    }

    private void hb(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().cR();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String mBduss;
        private String mStoken;

        public b(String str, String str2) {
            this.mBduss = null;
            this.mStoken = null;
            this.mBduss = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            zVar.vw().wp().ahi = false;
            zVar.vw().wp().mIsUseCurrentBDUSS = false;
            zVar.n("BDUSS", this.mBduss);
            zVar.n("stoken", this.mStoken);
            zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            zVar.uY();
        }
    }

    private boolean LY() {
        return MessageManager.getInstance().getSocketClient().cU() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aVw != null) {
            this.aVw.cancel();
        }
    }
}
