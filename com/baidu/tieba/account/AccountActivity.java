package com.baidu.tieba.account;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a bbZ;
    private TextView bch;
    private NavigationBar mNavigationBar;
    private List<AccountData> bbW = null;
    private com.baidu.tieba.account.a bbX = null;
    private ListView mList = null;
    private RelativeLayout bbY = null;
    private TextView bca = null;
    private View.OnClickListener bcb = null;
    private d bcc = null;
    private a bcd = null;
    private com.baidu.tbadk.coreExtra.view.a bce = null;
    private BdAsyncTask<?, ?, ?> bcf = null;
    private CustomMessageListener bcg = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.bbW != null) {
                AccountActivity.this.MI();
                if (AccountActivity.this.bbX != null) {
                    AccountActivity.this.bbX.setData(AccountActivity.this.bbW);
                    AccountActivity.this.bbX.notifyDataSetChanged();
                }
            }
        }
    };
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.account.AccountActivity.8
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    AccountActivity.this.ML();
                    return;
                case 2:
                    if (message.obj instanceof AccountData) {
                        AccountActivity.this.l((AccountData) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.account_activity);
        MI();
        this.bbZ = new com.baidu.tieba.account.safeManage.a(this);
        MJ();
        registerListener(this.bcg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.h(this.bch, d.C0126d.cp_cont_d);
        ak.j(this.bch, d.C0126d.cp_bg_line_e);
        this.bbZ.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.bbY);
        this.bbX.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MI() {
        if (TbadkCoreApplication.getInst().isAccountsDataFromPass()) {
            this.bbW = com.baidu.tbadk.coreExtra.a.a.xN().xQ();
        } else {
            this.bbW = com.baidu.tbadk.core.a.b.qk();
        }
    }

    private void MJ() {
        this.bbY = (RelativeLayout) findViewById(d.g.account_container);
        this.bcb = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view2) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).cc(d.k.inform).a(new String[]{AccountActivity.this.getPageContext().getString(d.k.delete_account_only), AccountActivity.this.getPageContext().getString(d.k.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(d.k.cancel)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view3) {
                        if (view2 != null) {
                            AccountData accountData = (AccountData) view2.getTag();
                            switch (i) {
                                case 0:
                                    if (accountData != null) {
                                        AccountActivity.this.a(false, accountData);
                                        break;
                                    }
                                    break;
                                case 1:
                                    if (accountData != null) {
                                        AccountActivity.this.a(true, accountData);
                                        break;
                                    }
                                    break;
                            }
                            bVar.dismiss();
                        }
                    }
                }).d(AccountActivity.this.getPageContext()).tG();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.k.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.bca = (TextView) addCustomView.findViewById(d.g.right_textview);
        this.bca.setText(getPageContext().getString(d.k.edit));
        ak.c(this.bca, d.C0126d.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!AccountActivity.this.bbX.MP()) {
                    AccountActivity.this.bbX.co(true);
                    AccountActivity.this.bca.setText(d.k.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ak.c(AccountActivity.this.bca, d.C0126d.navi_op_text, 1);
                    } else {
                        ak.c(AccountActivity.this.bca, d.C0126d.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.bbX.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.bbX.co(false);
                AccountActivity.this.bca.setText(d.k.edit);
                ak.c(AccountActivity.this.bca, d.C0126d.navi_op_text, 1);
                AccountActivity.this.bbX.notifyDataSetChanged();
            }
        });
        this.bbX = new com.baidu.tieba.account.a(this, this.bcb);
        this.bbX.setData(this.bbW);
        this.mList = (ListView) findViewById(d.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        MN();
        this.mList.setAdapter((ListAdapter) this.bbX);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.bbX.getItemId(i) >= 0) {
                    if (!AccountActivity.this.bbX.MP() && (accountData = (AccountData) AccountActivity.this.bbX.getItem(i)) != null && accountData.getIsActive() != 1) {
                        if (TextUtils.isEmpty(accountData.getAccount())) {
                            AccountActivity.this.j(accountData);
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                        AccountActivity.this.k(accountData);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(AccountActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(AccountActivity.this.getPageContext().getPageActivity())));
            }
        });
        MK();
    }

    private void MK() {
        View rootView = this.bbZ.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.bce == null) {
            this.bce = new com.baidu.tbadk.coreExtra.view.a(getPageContext());
            this.bce.a(new a.InterfaceC0092a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0092a
                public void i(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.k(accountData2);
                }
            });
        }
        this.bce.BY();
        this.bce.h(accountData);
        this.bce.BU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.bcc == null) {
            hZ("account changed");
            showLoadingDialog(getPageContext().getString(d.k.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.ia("account changed");
                    AccountActivity.this.bcc = null;
                }
            });
            if (this.bcf != null) {
                this.bcf.cancel();
            }
            this.bcf = com.baidu.tbadk.core.a.a.qf().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        this.bcc = new d(accountData);
        this.bcc.setPriority(3);
        if (this.bcc != null) {
            if (MM()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.bcc.execute(new Object[0]);
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
        /* renamed from: n */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c xN = com.baidu.tbadk.coreExtra.a.a.xN();
                if (xN != null) {
                    xN.f(this.mAccount);
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
            AccountActivity.this.m(this.mAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0083a {
        private AccountData ayD;

        public c(AccountData accountData) {
            this.ayD = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
        public void cE(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new al("c12948").r("obj_type", 1));
            AccountActivity.this.l(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.ayD != null) {
                ReloginManager.us().e(this.ayD);
                AccountActivity.this.a(false, this.ayD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.getInst().onUserChanged();
        com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 1, false);
        this.bcc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.bcd == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                hZ("account delete");
            }
            showLoadingDialog(getPageContext().getString(d.k.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.ia("account delete cancel");
                    }
                    AccountActivity.this.bcd = null;
                }
            });
            this.bcd = new a(z, accountData);
            this.bcd.setPriority(3);
            ML();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML() {
        if (this.bcd != null) {
            if (MM()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.bcd.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData bcl;
        private boolean bcm;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.bcm = false;
            this.bcl = accountData;
            this.bcm = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.bcl != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.bcm) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.bcl.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.bcl.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.bcl.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("get_addresslist_switch" + this.bcl.getID());
                    if (this.bcl.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c xN = com.baidu.tbadk.coreExtra.a.a.xN();
                        if (xN != null) {
                            xN.xP();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c xN2 = com.baidu.tbadk.coreExtra.a.a.xN();
                        if (xN2 != null) {
                            xN2.g(this.bcl);
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
            if (this.bcl != null) {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.bcl.getID());
                new b(this.bcl.getBDUSS(), e.c(this.bcl)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountActivity.this.finish();
                    }
                }, 1000L);
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(d.k.success));
                    AccountActivity.this.bbW.remove(this.bcl);
                    this.bcl = null;
                    AccountActivity.this.bbX.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    break;
            }
            AccountActivity.this.bcd = null;
        }
    }

    private void hZ(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().cA();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String mStoken;
        private String vc;

        public b(String str, String str2) {
            this.vc = null;
            this.mStoken = null;
            this.vc = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/logout");
            xVar.vj().wi().ajD = false;
            xVar.vj().wi().mIsUseCurrentBDUSS = false;
            xVar.n("BDUSS", this.vc);
            xVar.n(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            xVar.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            xVar.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            xVar.uL();
        }
    }

    private boolean MM() {
        return MessageManager.getInstance().getSocketClient().cD() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bbZ.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bcf != null) {
            this.bcf.cancel();
        }
    }

    private void MN() {
        this.bch = new TextView(this);
        this.bch.setGravity(16);
        this.bch.setPadding(l.e(this, d.e.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.e(this, d.e.tbds74));
        this.bch.setTextSize(0, l.e(this, d.e.tbds33));
        this.bch.setText(d.k.account_manager);
        this.bch.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.bch);
    }
}
