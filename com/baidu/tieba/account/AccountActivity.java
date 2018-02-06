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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a bSf;
    private TextView bSn;
    private NavigationBar mNavigationBar;
    private List<AccountData> bSc = null;
    private com.baidu.tieba.account.a bSd = null;
    private ListView mList = null;
    private RelativeLayout bSe = null;
    private TextView bSg = null;
    private View.OnClickListener bSh = null;
    private d bSi = null;
    private a bSj = null;
    private com.baidu.tbadk.coreExtra.view.d bSk = null;
    private BdAsyncTask<?, ?, ?> bSl = null;
    private CustomMessageListener bSm = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.bSc != null) {
                AccountActivity.this.Uh();
                if (AccountActivity.this.bSd != null) {
                    AccountActivity.this.bSd.setData(AccountActivity.this.bSc);
                    AccountActivity.this.bSd.notifyDataSetChanged();
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
                    AccountActivity.this.Uk();
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
        setContentView(d.h.account_activity);
        Uh();
        this.bSf = new com.baidu.tieba.account.safeManage.a(this);
        Ui();
        registerListener(this.bSm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.r(this.bSn, d.C0140d.cp_cont_d);
        aj.t(this.bSn, d.C0140d.cp_bg_line_e);
        this.bSf.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.bSe);
        this.bSd.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        if (TbadkCoreApplication.getInst().isAccountsDataFromPass()) {
            this.bSc = com.baidu.tbadk.coreExtra.a.a.Fa().Fd();
        } else {
            this.bSc = com.baidu.tbadk.core.a.b.xA();
        }
    }

    private void Ui() {
        this.bSe = (RelativeLayout) findViewById(d.g.account_container);
        this.bSh = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).fe(d.j.inform).a(new String[]{AccountActivity.this.getPageContext().getString(d.j.delete_account_only), AccountActivity.this.getPageContext().getString(d.j.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(d.j.cancel)}, new b.InterfaceC0096b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                        if (view != null) {
                            AccountData accountData = (AccountData) view.getTag();
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
                }).d(AccountActivity.this.getPageContext()).AX();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.bSg = (TextView) addCustomView.findViewById(d.g.right_textview);
        this.bSg.setText(getPageContext().getString(d.j.edit));
        aj.e(this.bSg, d.C0140d.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.bSd.Uo()) {
                    AccountActivity.this.bSd.cX(true);
                    AccountActivity.this.bSg.setText(d.j.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(AccountActivity.this.bSg, d.C0140d.navi_op_text, 1);
                    } else {
                        aj.e(AccountActivity.this.bSg, d.C0140d.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.bSd.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.bSd.cX(false);
                AccountActivity.this.bSg.setText(d.j.edit);
                aj.e(AccountActivity.this.bSg, d.C0140d.navi_op_text, 1);
                AccountActivity.this.bSd.notifyDataSetChanged();
            }
        });
        this.bSd = new com.baidu.tieba.account.a(this, this.bSh);
        this.bSd.setData(this.bSc);
        this.mList = (ListView) findViewById(d.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        Um();
        this.mList.setAdapter((ListAdapter) this.bSd);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.bSd.getItemId(i) >= 0) {
                    if (!AccountActivity.this.bSd.Uo() && (accountData = (AccountData) AccountActivity.this.bSd.getItem(i)) != null && accountData.getIsActive() != 1) {
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
        Uj();
    }

    private void Uj() {
        View rootView = this.bSf.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.bSk == null) {
            this.bSk = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.bSk.a(new d.a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void i(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.k(accountData2);
                }
            });
        }
        this.bSk.Jj();
        this.bSk.h(accountData);
        this.bSk.Jf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.bSi == null) {
            ie("account changed");
            showLoadingDialog(getPageContext().getString(d.j.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.m14if("account changed");
                    AccountActivity.this.bSi = null;
                }
            });
            if (this.bSl != null) {
                this.bSl.cancel();
            }
            this.bSl = com.baidu.tbadk.core.a.a.xv().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        this.bSi = new d(accountData);
        this.bSi.setPriority(3);
        if (this.bSi != null) {
            if (Ul()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.bSi.execute(new Object[0]);
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
        /* renamed from: p */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c Fa = com.baidu.tbadk.coreExtra.a.a.Fa();
                if (Fa != null) {
                    Fa.f(this.mAccount);
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
    public class c implements a.InterfaceC0093a {
        private AccountData bnb;

        public c(AccountData accountData) {
            this.bnb = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0093a
        public void cM(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0093a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            AccountActivity.this.l(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0093a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.bnb != null) {
                ReloginManager.BJ().e(this.bnb);
                AccountActivity.this.a(false, this.bnb);
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
        com.baidu.tbadk.core.e.b.e(getPageContext().getPageActivity(), 1, false);
        this.bSi = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.bSj == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                ie("account delete");
            }
            showLoadingDialog(getPageContext().getString(d.j.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.m14if("account delete cancel");
                    }
                    AccountActivity.this.bSj = null;
                }
            });
            this.bSj = new a(z, accountData);
            this.bSj.setPriority(3);
            Uk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk() {
        if (this.bSj != null) {
            if (Ul()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.bSj.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData bSr;
        private boolean bSs;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.bSs = false;
            this.bSr = accountData;
            this.bSs = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.bSr != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.bSs) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.bSr.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.bSr.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.bSr.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("get_addresslist_switch" + this.bSr.getID());
                    if (this.bSr.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c Fa = com.baidu.tbadk.coreExtra.a.a.Fa();
                        if (Fa != null) {
                            Fa.Fc();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c Fa2 = com.baidu.tbadk.coreExtra.a.a.Fa();
                        if (Fa2 != null) {
                            Fa2.g(this.bSr);
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
            if (this.bSr != null) {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.bSr.getID());
                new b(this.bSr.getBDUSS(), e.c(this.bSr)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountActivity.this.finish();
                    }
                }, 1000L);
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(d.j.success));
                    AccountActivity.this.bSc.remove(this.bSr);
                    this.bSr = null;
                    AccountActivity.this.bSd.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    break;
            }
            AccountActivity.this.bSj = null;
        }
    }

    private void ie(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().kw();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m14if(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String akE;
        private String mStoken;

        public b(String str, String str2) {
            this.akE = null;
            this.mStoken = null;
            this.akE = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/logout");
            xVar.Cz().Dw().aYk = false;
            xVar.Cz().Dw().mIsUseCurrentBDUSS = false;
            xVar.n("BDUSS", this.akE);
            xVar.n(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            xVar.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            xVar.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            xVar.Cb();
        }
    }

    private boolean Ul() {
        return MessageManager.getInstance().getSocketClient().kz() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bSf.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bSl != null) {
            this.bSl.cancel();
        }
    }

    private void Um() {
        this.bSn = new TextView(this);
        this.bSn.setGravity(16);
        this.bSn.setPadding(l.t(this, d.e.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.t(this, d.e.tbds74));
        this.bSn.setTextSize(0, l.t(this, d.e.tbds33));
        this.bSn.setText(d.j.account_manager);
        this.bSn.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.bSn);
    }
}
