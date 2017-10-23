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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private NavigationBar mNavigationBar;
    private List<AccountData> aYe = null;
    private com.baidu.tieba.account.a aYf = null;
    private ListView mList = null;
    private RelativeLayout aYg = null;
    private TextView aYh = null;
    private View.OnClickListener aYi = null;
    private d aYj = null;
    private a aYk = null;
    private com.baidu.tbadk.coreExtra.view.d aFE = null;
    private BdAsyncTask<?, ?, ?> aYl = null;
    private CustomMessageListener aYm = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.aYe != null) {
                AccountActivity.this.Lk();
                if (AccountActivity.this.aYf != null) {
                    AccountActivity.this.aYf.setData(AccountActivity.this.aYe);
                    AccountActivity.this.aYf.notifyDataSetChanged();
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
                    AccountActivity.this.Lm();
                    return;
                case 2:
                    if (message.obj instanceof AccountData) {
                        AccountActivity.this.m((AccountData) message.obj);
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
        setContentView(d.j.account_activity);
        Lk();
        Ll();
        registerListener(this.aYm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.aYg);
        this.aYf.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        if (TbadkCoreApplication.getInst().isAccountsDataFromPass()) {
            this.aYe = com.baidu.tbadk.coreExtra.a.a.xg().xj();
        } else {
            this.aYe = com.baidu.tbadk.core.a.b.oZ();
        }
    }

    private void Ll() {
        this.aYg = (RelativeLayout) findViewById(d.h.account_container);
        this.aYi = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).cf(d.l.inform).a(new String[]{AccountActivity.this.getPageContext().getString(d.l.delete_account_only), AccountActivity.this.getPageContext().getString(d.l.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(d.l.cancel)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
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
                }).d(AccountActivity.this.getPageContext()).te();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.l.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.navigation_right_button_layout, (View.OnClickListener) null);
        this.aYh = (TextView) addCustomView.findViewById(d.h.right_textview);
        this.aYh.setText(getPageContext().getString(d.l.edit));
        aj.c(this.aYh, d.e.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.aYf.Lp()) {
                    AccountActivity.this.aYf.setEditState(true);
                    AccountActivity.this.aYh.setText(d.l.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.c(AccountActivity.this.aYh, d.e.navi_op_text, 1);
                    } else {
                        aj.c(AccountActivity.this.aYh, d.e.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.aYf.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.aYf.setEditState(false);
                AccountActivity.this.aYh.setText(d.l.edit);
                aj.c(AccountActivity.this.aYh, d.e.navi_op_text, 1);
                AccountActivity.this.aYf.notifyDataSetChanged();
            }
        });
        this.aYf = new com.baidu.tieba.account.a(this, this.aYi);
        this.aYf.setData(this.aYe);
        this.mList = (ListView) findViewById(d.h.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.aYf);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.aYf.getItemId(i) >= 0) {
                    if (!AccountActivity.this.aYf.Lp() && (accountData = (AccountData) AccountActivity.this.aYf.getItem(i)) != null && accountData.getIsActive() != 1) {
                        if (TextUtils.isEmpty(accountData.getAccount())) {
                            AccountActivity.this.k(accountData);
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                        AccountActivity.this.l(accountData);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(AccountActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(AccountActivity.this.getPageContext().getPageActivity())));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aFE == null) {
            this.aFE = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.aFE.a(new d.a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void j(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.l(accountData2);
                }
            });
        }
        this.aFE.AA();
        this.aFE.i(accountData);
        this.aFE.Aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.aYj == null) {
            hx("account changed");
            showLoadingDialog(getPageContext().getString(d.l.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.hy("account changed");
                    AccountActivity.this.aYj = null;
                }
            });
            if (this.aYl != null) {
                this.aYl.cancel();
            }
            this.aYl = com.baidu.tbadk.core.a.a.oU().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AccountData accountData) {
        this.aYj = new d(accountData);
        this.aYj.setPriority(3);
        if (this.aYj != null) {
            if (Ln()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.aYj.execute(new Object[0]);
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
        /* renamed from: h */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c xg = com.baidu.tbadk.coreExtra.a.a.xg();
                if (xg != null) {
                    xg.g(this.mAccount);
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
    public class c implements a.InterfaceC0044a {
        private AccountData ava;

        public c(AccountData accountData) {
            this.ava = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
        public void co(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", SapiAccountManager.SESSION_UID, accountData.getID());
            AccountActivity.this.m(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.ava != null) {
                ReloginManager.tQ().f(this.ava);
                AccountActivity.this.a(false, this.ava);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", SapiAccountManager.SESSION_UID, accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.getInst().onUserChanged();
        com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 1, false);
        this.aYj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aYk == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                hx("account delete");
            }
            showLoadingDialog(getPageContext().getString(d.l.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.hy("account delete cancel");
                    }
                    AccountActivity.this.aYk = null;
                }
            });
            this.aYk = new a(z, accountData);
            this.aYk.setPriority(3);
            Lm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lm() {
        if (this.aYk != null) {
            if (Ln()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aYk.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData aYq;
        private boolean aYr;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.aYr = false;
            this.aYq = accountData;
            this.aYr = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.aYq != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.aYr) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.aYq.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.aYq.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.aYq.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("get_addresslist_switch" + this.aYq.getID());
                    if (this.aYq.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c xg = com.baidu.tbadk.coreExtra.a.a.xg();
                        if (xg != null) {
                            xg.xi();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c xg2 = com.baidu.tbadk.coreExtra.a.a.xg();
                        if (xg2 != null) {
                            xg2.h(this.aYq);
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
            if (this.aYq != null) {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.aYq.getID());
                new b(this.aYq.getBDUSS(), e.d(this.aYq)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountActivity.this.finish();
                    }
                }, 1000L);
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(d.l.success));
                    AccountActivity.this.aYe.remove(this.aYq);
                    this.aYq = null;
                    AccountActivity.this.aYf.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
                    break;
            }
            AccountActivity.this.aYk = null;
        }
    }

    private void hx(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().cS();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String mStoken;
        private String wt;

        public b(String str, String str2) {
            this.wt = null;
            this.mStoken = null;
            this.wt = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/logout");
            xVar.uG().vC().ahz = false;
            xVar.uG().vC().mIsUseCurrentBDUSS = false;
            xVar.n("BDUSS", this.wt);
            xVar.n("stoken", this.mStoken);
            xVar.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            xVar.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            xVar.ui();
        }
    }

    private boolean Ln() {
        return MessageManager.getInstance().getSocketClient().cV() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aYl != null) {
            this.aYl.cancel();
        }
    }
}
