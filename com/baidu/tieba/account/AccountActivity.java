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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private List<AccountData> aPo = null;
    private l aPp = null;
    private ListView mList = null;
    private RelativeLayout aPq = null;
    private TextView aPr = null;
    private View.OnClickListener aPs = null;
    private d aPt = null;
    private a aPu = null;
    private com.baidu.tbadk.coreExtra.view.j axP = null;
    private BdAsyncTask<?, ?, ?> aPv = null;
    private CustomMessageListener aPw = new com.baidu.tieba.account.a(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new com.baidu.tieba.account.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.j.account_activity);
        KQ();
        KR();
        registerListener(this.aPw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.aPq);
        this.aPp.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KQ() {
        if (TbadkCoreApplication.m9getInst().isAccountsDataFromPass()) {
            this.aPo = com.baidu.tbadk.coreExtra.a.a.xc().xf();
        } else {
            this.aPo = com.baidu.tbadk.core.a.b.oP();
        }
    }

    private void KR() {
        this.aPq = (RelativeLayout) findViewById(r.h.account_container);
        this.aPs = new com.baidu.tieba.account.c(this);
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(r.l.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.navigation_right_button_layout, (View.OnClickListener) null);
        this.aPr = (TextView) addCustomView.findViewById(r.h.right_textview);
        this.aPr.setText(getPageContext().getString(r.l.edit));
        ap.c(this.aPr, r.e.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.aPp = new l(this, this.aPs);
        this.aPp.setData(this.aPo);
        this.mList = (ListView) findViewById(r.h.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.aPp);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.axP == null) {
            this.axP = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.axP.a(new g(this));
        }
        this.axP.AD();
        this.axP.i(accountData);
        this.axP.Az();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.aPt == null) {
            hi("account changed");
            showLoadingDialog(getPageContext().getString(r.l.account_logining), new h(this));
            if (this.aPv != null) {
                this.aPv.cancel();
            }
            this.aPv = com.baidu.tbadk.core.a.a.oK().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        this.aPt = new d(accountData);
        this.aPt.setPriority(3);
        if (this.aPt != null) {
            if (KT()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aPt.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c xc = com.baidu.tbadk.coreExtra.a.a.xc();
                if (xc != null) {
                    xc.g(this.mAccount);
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
    public class c implements a.InterfaceC0032a {
        private AccountData aof;

        public c(AccountData accountData) {
            this.aof = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
        public void cf(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", SapiAccountManager.SESSION_UID, accountData.getID());
            AccountActivity.this.m(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aof != null) {
                ReloginManager.tL().f(this.aof);
                AccountActivity.this.a(false, this.aof);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", SapiAccountManager.SESSION_UID, accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m9getInst().onUserChanged();
        com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 1, false);
        this.aPt = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aPu == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                hi("account delete");
            }
            showLoadingDialog(getPageContext().getString(r.l.deleting), new i(this, z2));
            this.aPu = new a(z, accountData);
            this.aPu.setPriority(3);
            KS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KS() {
        if (this.aPu != null) {
            if (KT()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aPu.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aPA;
        private boolean aPB;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aPB = false;
            this.aPA = accountData;
            this.aPB = z;
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
                if (this.aPA != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aPB) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aPA.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aPA.getID()));
                    m.deleteAccountAllInfo(this.aPA.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.tQ().remove("get_addresslist_switch" + this.aPA.getID());
                    if (this.aPA.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c xc = com.baidu.tbadk.coreExtra.a.a.xc();
                        if (xc != null) {
                            xc.xe();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c xc2 = com.baidu.tbadk.coreExtra.a.a.xc();
                        if (xc2 != null) {
                            xc2.h(this.aPA);
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
            if (this.aPA != null) {
                com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aPA.getID());
                new b(this.aPA.getBDUSS(), com.baidu.tbadk.core.a.h.d(this.aPA)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.g.h.eE().postDelayed(new j(this), 1000L);
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(r.l.success));
                    AccountActivity.this.aPo.remove(this.aPA);
                    this.aPA = null;
                    AccountActivity.this.aPp.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.m9getInst().onUserChanged();
                    AccountActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(AccountActivity.this.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                    break;
            }
            AccountActivity.this.aPu = null;
        }
    }

    private void hi(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().bJ();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String mStoken;
        private String pS;

        public b(String str, String str2) {
            this.pS = null;
            this.mStoken = null;
            this.pS = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
            yVar.uC().vv().abD = false;
            yVar.uC().vv().mIsUseCurrentBDUSS = false;
            yVar.n("BDUSS", this.pS);
            yVar.n("stoken", this.mStoken);
            yVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            yVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            yVar.ud();
        }
    }

    private boolean KT() {
        return MessageManager.getInstance().getSocketClient().bM() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aPv != null) {
            this.aPv.cancel();
        }
    }
}
