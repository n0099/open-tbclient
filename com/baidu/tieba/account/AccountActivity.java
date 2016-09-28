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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aSE = null;
    private l aSF = null;
    private ListView mList = null;
    private RelativeLayout aSG = null;
    private TextView aSH = null;
    private View.OnClickListener aSI = null;
    private d aSJ = null;
    private a aSK = null;
    private com.baidu.tbadk.coreExtra.view.j ayF = null;
    private BdAsyncTask<?, ?, ?> aSL = null;
    private CustomMessageListener aSM = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.account_activity);
        Mc();
        Md();
        registerListener(this.aSM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.aSG);
        this.aSF.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mc() {
        if (TbadkCoreApplication.m9getInst().isAccountsDataFromPass()) {
            this.aSE = com.baidu.tbadk.coreExtra.a.a.xq().xt();
        } else {
            this.aSE = com.baidu.tbadk.core.a.b.oU();
        }
    }

    private void Md() {
        this.aSG = (RelativeLayout) findViewById(r.g.account_container);
        this.aSI = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(r.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.aSH = (TextView) addCustomView.findViewById(r.g.right_textview);
        this.aSH.setText(getPageContext().getString(r.j.edit));
        av.c(this.aSH, r.d.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aSF = new l(this, this.aSI);
        this.aSF.setData(this.aSE);
        this.mList = (ListView) findViewById(r.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.aSF);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.ayF == null) {
            this.ayF = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.ayF.a(new g(this));
        }
        this.ayF.AO();
        this.ayF.i(accountData);
        this.ayF.AK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.aSJ == null) {
            hq("account changed");
            showLoadingDialog(getPageContext().getString(r.j.account_logining), new h(this));
            if (this.aSL != null) {
                this.aSL.cancel();
            }
            this.aSL = com.baidu.tbadk.core.a.a.oP().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        this.aSJ = new d(accountData);
        this.aSJ.setPriority(3);
        if (this.aSJ != null) {
            if (Mf()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aSJ.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c xq = com.baidu.tbadk.coreExtra.a.a.xq();
                if (xq != null) {
                    xq.g(this.mAccount);
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
        private AccountData aoD;

        public c(AccountData accountData) {
            this.aoD = accountData;
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
            if (i == 1 && this.aoD != null) {
                ReloginManager.uc().f(this.aoD);
                AccountActivity.this.a(false, this.aoD);
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
        this.aSJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aSK == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                hq("account delete");
            }
            showLoadingDialog(getPageContext().getString(r.j.deleting), new i(this, z2));
            this.aSK = new a(z, accountData);
            this.aSK.setPriority(3);
            Me();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        if (this.aSK != null) {
            if (Mf()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aSK.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aSQ;
        private boolean aSR;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aSR = false;
            this.aSQ = accountData;
            this.aSR = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.aSQ != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aSR) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aSQ.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aSQ.getID()));
                    m.deleteAccountAllInfo(this.aSQ.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.uh().remove("get_addresslist_switch" + this.aSQ.getID());
                    if (this.aSQ.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c xq = com.baidu.tbadk.coreExtra.a.a.xq();
                        if (xq != null) {
                            xq.xs();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c xq2 = com.baidu.tbadk.coreExtra.a.a.xq();
                        if (xq2 != null) {
                            xq2.h(this.aSQ);
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
            if (this.aSQ != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aSQ.getID());
                new b(this.aSQ.getBDUSS(), com.baidu.tbadk.core.a.h.d(this.aSQ)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.h.h.eG().postDelayed(new j(this), 1000L);
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(r.j.success));
                    AccountActivity.this.aSE.remove(this.aSQ);
                    this.aSQ = null;
                    AccountActivity.this.aSF.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m9getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(AccountActivity.this.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                    break;
            }
            AccountActivity.this.aSK = null;
        }
    }

    private void hq(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().bJ();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(String str) {
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
            abVar.uS().vN().acA = false;
            abVar.uS().vN().mIsUseCurrentBDUSS = false;
            abVar.n("BDUSS", this.pX);
            abVar.n("stoken", this.mStoken);
            abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            abVar.uu();
        }
    }

    private boolean Mf() {
        return MessageManager.getInstance().getSocketClient().bM() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aSL != null) {
            this.aSL.cancel();
        }
    }
}
