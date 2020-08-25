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
/* loaded from: classes16.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a fnf;
    private TextView fnm;
    private NavigationBar mNavigationBar;
    private List<AccountData> fnd = null;
    private com.baidu.tieba.account.a fne = null;
    private ListView mList = null;
    private RelativeLayout mContainer = null;
    private TextView fng = null;
    private View.OnClickListener fnh = null;
    private d fni = null;
    private a fnj = null;
    private com.baidu.tbadk.coreExtra.view.b ezx = null;
    private BdAsyncTask<?, ?, ?> fnk = null;
    private CustomMessageListener fnl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.fnd != null) {
                AccountActivity.this.bAB();
                if (AccountActivity.this.fne != null) {
                    AccountActivity.this.fne.setData(AccountActivity.this.fnd);
                    AccountActivity.this.fne.notifyDataSetChanged();
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
                    AccountActivity.this.bAE();
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
        bAB();
        this.fnf = new com.baidu.tieba.account.safeManage.a(this);
        bAC();
        registerListener(this.fnl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setViewTextColor(this.fnm, R.color.cp_cont_d);
        ap.setBackgroundColor(this.fnm, R.color.cp_bg_line_c);
        this.fnf.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mContainer);
        this.fne.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        this.fnd = com.baidu.tbadk.core.a.b.bbR();
    }

    private void bAC() {
        this.mContainer = (RelativeLayout) findViewById(R.id.account_container);
        this.fnh = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).nx(R.string.inform).a(new String[]{AccountActivity.this.getPageContext().getString(R.string.delete_account_only), AccountActivity.this.getPageContext().getString(R.string.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(R.string.cancel)}, new b.InterfaceC0538b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
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
                }).d(AccountActivity.this.getPageContext()).bhi();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.fng = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.fng.setText(getPageContext().getString(R.string.edit));
        ap.setViewTextColor(this.fng, R.color.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.fne.bAI()) {
                    AccountActivity.this.fne.km(true);
                    AccountActivity.this.fng.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(AccountActivity.this.fng, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(AccountActivity.this.fng, R.color.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.fne.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.fne.km(false);
                AccountActivity.this.fng.setText(R.string.edit);
                ap.setViewTextColor(AccountActivity.this.fng, R.color.navi_op_text, 1);
                AccountActivity.this.fne.notifyDataSetChanged();
            }
        });
        this.fne = new com.baidu.tieba.account.a(this, this.fnh);
        this.fne.setData(this.fnd);
        this.mList = (ListView) findViewById(R.id.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        bAG();
        this.mList.setAdapter((ListAdapter) this.fne);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.fne.getItemId(i) >= 0) {
                    if (!AccountActivity.this.fne.bAI() && (accountData = (AccountData) AccountActivity.this.fne.getItem(i)) != null && accountData.getIsActive() != 1) {
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
                TbadkCoreApplication.getInst().login(AccountActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(AccountActivity.this.getPageContext().getPageActivity())));
            }
        });
        bAD();
    }

    private void bAD() {
        View rootView = this.fnf.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.ezx == null) {
            this.ezx = new com.baidu.tbadk.coreExtra.view.b(this);
            this.ezx.a(new b.a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.j(accountData2);
                }
            });
        }
        this.ezx.bpU();
        this.ezx.setAccountData(accountData);
        this.ezx.bpQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.fni == null) {
            com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 2);
            Dk("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.Dl("account changed");
                    AccountActivity.this.fni = null;
                }
            });
            if (this.fnk != null) {
                this.fnk.cancel();
            }
            this.fnk = com.baidu.tbadk.core.a.a.bbN().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.fni = new d(accountData);
        this.fni.setPriority(3);
        if (this.fni != null) {
            if (bAF()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.fni.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
                com.baidu.tbadk.coreExtra.a.c bmj = com.baidu.tbadk.coreExtra.a.a.bmj();
                if (bmj != null) {
                    bmj.h(this.mAccount);
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
    /* loaded from: classes16.dex */
    public class c implements a.InterfaceC0536a {
        private AccountData eGO;

        public c(AccountData accountData) {
            this.eGO = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0536a
        public void onBeforeLogin(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0536a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new aq("c12948").ai("obj_type", 1));
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0536a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, BdStatsConstant.StatsKey.UNAME, str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.eGO != null) {
                ReloginManager.bid().e(this.eGO);
                AccountActivity.this.a(false, this.eGO);
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
        com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 0, false);
        this.fni = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.fnj == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 3);
                Dk("account delete");
            }
            showLoadingDialog(getPageContext().getString(R.string.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.Dl("account delete cancel");
                    }
                    AccountActivity.this.fnj = null;
                }
            });
            this.fnj = new a(z, accountData);
            this.fnj.setPriority(3);
            bAE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAE() {
        if (this.fnj != null) {
            if (bAF()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.fnj.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData fnq;
        private boolean fnr;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.fnr = false;
            this.fnq = accountData;
            this.fnr = z;
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
                if (this.fnq != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.fnr) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.fnq.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.fnq.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.fnq.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + this.fnq.getID());
                    if (this.fnq.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c bmj = com.baidu.tbadk.coreExtra.a.a.bmj();
                        if (bmj != null) {
                            bmj.sapiLogout();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c bmj2 = com.baidu.tbadk.coreExtra.a.a.bmj();
                        if (bmj2 != null) {
                            bmj2.f(this.fnq);
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
            if (this.fnq != null) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.fnq.getID());
                new b(this.fnq.getBDUSS(), com.baidu.tbadk.core.a.d.c(this.fnq)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
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
                    AccountActivity.this.fnd.remove(this.fnq);
                    this.fnq = null;
                    AccountActivity.this.fne.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
                    break;
            }
            AccountActivity.this.fnj = null;
        }
    }

    private void Dk(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().clearAllMessageQueue();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
            aaVar.biQ().bjv().mNeedBackgroundLogin = false;
            aaVar.biQ().bjv().mIsUseCurrentBDUSS = false;
            aaVar.addPostData("BDUSS", this.mBduss);
            aaVar.addPostData("stoken", this.mStoken);
            aaVar.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            aaVar.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            aaVar.postNetData();
        }
    }

    private boolean bAF() {
        return MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fnf.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fnk != null) {
            this.fnk.cancel();
        }
    }

    private void bAG() {
        this.fnm = new TextView(this);
        this.fnm.setGravity(16);
        this.fnm.setPadding(l.getDimens(this, R.dimen.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.getDimens(this, R.dimen.tbds74));
        this.fnm.setTextSize(0, l.getDimens(this, R.dimen.tbds33));
        this.fnm.setText(R.string.account_manager);
        this.fnm.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.fnm);
    }
}
