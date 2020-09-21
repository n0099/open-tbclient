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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a fqo;
    private TextView fqv;
    private NavigationBar mNavigationBar;
    private List<AccountData> fqm = null;
    private com.baidu.tieba.account.a fqn = null;
    private ListView mList = null;
    private RelativeLayout mContainer = null;
    private TextView fqp = null;
    private View.OnClickListener fqq = null;
    private d fqr = null;
    private a fqs = null;
    private com.baidu.tbadk.coreExtra.view.b eBF = null;
    private BdAsyncTask<?, ?, ?> fqt = null;
    private CustomMessageListener fqu = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.fqm != null) {
                AccountActivity.this.bBO();
                if (AccountActivity.this.fqn != null) {
                    AccountActivity.this.fqn.setData(AccountActivity.this.fqm);
                    AccountActivity.this.fqn.notifyDataSetChanged();
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
                    AccountActivity.this.bBR();
                    return;
                case 2:
                    if (message.obj instanceof AccountData) {
                        AccountActivity.this.k((AccountData) message.obj);
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
        setContentView(R.layout.account_activity);
        bBO();
        this.fqo = new com.baidu.tieba.account.safeManage.a(this);
        bBP();
        registerListener(this.fqu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setViewTextColor(this.fqv, R.color.cp_cont_d);
        ap.setBackgroundColor(this.fqv, R.color.cp_bg_line_c);
        this.fqo.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mContainer);
        this.fqn.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBO() {
        this.fqm = com.baidu.tbadk.core.a.b.bcL();
    }

    private void bBP() {
        this.mContainer = (RelativeLayout) findViewById(R.id.account_container);
        this.fqq = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).nJ(R.string.inform).a(new String[]{AccountActivity.this.getPageContext().getString(R.string.delete_account_only), AccountActivity.this.getPageContext().getString(R.string.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(R.string.cancel)}, new b.InterfaceC0533b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
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
                }).d(AccountActivity.this.getPageContext()).bic();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.fqp = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.fqp.setText(getPageContext().getString(R.string.edit));
        ap.setViewTextColor(this.fqp, R.color.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.fqn.bBV()) {
                    AccountActivity.this.fqn.kp(true);
                    AccountActivity.this.fqp.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(AccountActivity.this.fqp, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(AccountActivity.this.fqp, R.color.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.fqn.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.fqn.kp(false);
                AccountActivity.this.fqp.setText(R.string.edit);
                ap.setViewTextColor(AccountActivity.this.fqp, R.color.navi_op_text, 1);
                AccountActivity.this.fqn.notifyDataSetChanged();
            }
        });
        this.fqn = new com.baidu.tieba.account.a(this, this.fqq);
        this.fqn.setData(this.fqm);
        this.mList = (ListView) findViewById(R.id.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        bBT();
        this.mList.setAdapter((ListAdapter) this.fqn);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.fqn.getItemId(i) >= 0) {
                    if (!AccountActivity.this.fqn.bBV() && (accountData = (AccountData) AccountActivity.this.fqn.getItem(i)) != null && accountData.getIsActive() != 1) {
                        if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
                            AccountActivity.this.i(accountData);
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                        AccountActivity.this.j(accountData);
                        return;
                    }
                    return;
                }
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig(AccountActivity.this.getPageContext().getPageActivity());
                loginActivityConfig.setJumpToAfterDestroy(1);
                TbadkCoreApplication.getInst().login(AccountActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            }
        });
        bBQ();
    }

    private void bBQ() {
        View rootView = this.fqo.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.eBF == null) {
            this.eBF = new com.baidu.tbadk.coreExtra.view.b(this);
            this.eBF.a(new b.a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.j(accountData2);
                }
            });
        }
        this.eBF.bqP();
        this.eBF.setAccountData(accountData);
        this.eBF.bqL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.fqr == null) {
            com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 2);
            DI("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.DJ("account changed");
                    AccountActivity.this.fqr = null;
                }
            });
            if (this.fqt != null) {
                this.fqt.cancel();
            }
            this.fqt = com.baidu.tbadk.core.a.a.bcH().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.fqr = new d(accountData);
        this.fqr.setPriority(3);
        if (this.fqr != null) {
            if (bBS()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.fqr.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
                com.baidu.tbadk.coreExtra.a.c bnd = com.baidu.tbadk.coreExtra.a.a.bnd();
                if (bnd != null) {
                    bnd.h(this.mAccount);
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
            AccountActivity.this.l(this.mAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class c implements a.InterfaceC0531a {
        private AccountData eIZ;

        public c(AccountData accountData) {
            this.eIZ = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0531a
        public void onBeforeLogin(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0531a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new aq("c12948").ai("obj_type", 1));
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0531a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, BdStatsConstant.StatsKey.UNAME, str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.eIZ != null) {
                ReloginManager.biX().e(this.eIZ);
                AccountActivity.this.a(false, this.eIZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.getInst().onUserChanged();
        com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2, false);
        this.fqr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.fqs == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 3);
                DI("account delete");
            }
            showLoadingDialog(getPageContext().getString(R.string.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.DJ("account delete cancel");
                    }
                    AccountActivity.this.fqs = null;
                }
            });
            this.fqs = new a(z, accountData);
            this.fqs.setPriority(3);
            bBR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBR() {
        if (this.fqs != null) {
            if (bBS()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.fqs.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private boolean fqA;
        private AccountData fqz;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.fqA = false;
            this.fqz = accountData;
            this.fqA = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.fqz != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.fqA) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.fqz.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.fqz.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.fqz.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.bjf().remove(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + this.fqz.getID());
                    if (this.fqz.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c bnd = com.baidu.tbadk.coreExtra.a.a.bnd();
                        if (bnd != null) {
                            bnd.sapiLogout();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c bnd2 = com.baidu.tbadk.coreExtra.a.a.bnd();
                        if (bnd2 != null) {
                            bnd2.f(this.fqz);
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
        /* renamed from: m */
        public void onPostExecute(AccountData accountData) {
            if (this.fqz != null) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.fqz.getID());
                new b(this.fqz.getBDUSS(), com.baidu.tbadk.core.a.d.c(this.fqz)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountActivity.this.finish();
                    }
                }, 1000L);
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_activity_delete_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(R.string.success));
                    AccountActivity.this.fqm.remove(this.fqz);
                    this.fqz = null;
                    AccountActivity.this.fqn.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
                    break;
            }
            AccountActivity.this.fqs = null;
        }
    }

    private void DI(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().clearAllMessageQueue();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DJ(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + "c/s/logout");
            aaVar.bjL().bkq().mNeedBackgroundLogin = false;
            aaVar.bjL().bkq().mIsUseCurrentBDUSS = false;
            aaVar.addPostData("BDUSS", this.mBduss);
            aaVar.addPostData("stoken", this.mStoken);
            aaVar.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            aaVar.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            aaVar.postNetData();
        }
    }

    private boolean bBS() {
        return MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fqo.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fqt != null) {
            this.fqt.cancel();
        }
    }

    private void bBT() {
        this.fqv = new TextView(this);
        this.fqv.setGravity(16);
        this.fqv.setPadding(l.getDimens(this, R.dimen.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.getDimens(this, R.dimen.tbds74));
        this.fqv.setTextSize(0, l.getDimens(this, R.dimen.tbds33));
        this.fqv.setText(R.string.account_manager);
        this.fqv.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.fqv);
    }
}
