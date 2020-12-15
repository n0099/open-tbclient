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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a fYG;
    private TextView fYN;
    private NavigationBar mNavigationBar;
    private List<AccountData> fYE = null;
    private com.baidu.tieba.account.a fYF = null;
    private ListView mList = null;
    private RelativeLayout mContainer = null;
    private TextView fYH = null;
    private View.OnClickListener fYI = null;
    private d fYJ = null;
    private a fYK = null;
    private com.baidu.tbadk.coreExtra.view.b fiF = null;
    private BdAsyncTask<?, ?, ?> fYL = null;
    private CustomMessageListener fYM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.fYE != null) {
                AccountActivity.this.bLV();
                if (AccountActivity.this.fYF != null) {
                    AccountActivity.this.fYF.setData(AccountActivity.this.fYE);
                    AccountActivity.this.fYF.notifyDataSetChanged();
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
                    AccountActivity.this.bLY();
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
        bLV();
        this.fYG = new com.baidu.tieba.account.safeManage.a(this);
        bLW();
        registerListener(this.fYM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setViewTextColor(this.fYN, R.color.CAM_X0109);
        ap.setBackgroundColor(this.fYN, R.color.CAM_X0204);
        this.fYG.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mContainer);
        this.fYF.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLV() {
        this.fYE = com.baidu.tbadk.core.a.b.bma();
    }

    private void bLW() {
        this.mContainer = (RelativeLayout) findViewById(R.id.account_container);
        this.fYI = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).oV(R.string.inform).a(new String[]{AccountActivity.this.getPageContext().getString(R.string.delete_account_only), AccountActivity.this.getPageContext().getString(R.string.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(R.string.cancel)}, new b.InterfaceC0586b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
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
                }).d(AccountActivity.this.getPageContext()).brx();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.fYH = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.fYH.setText(getPageContext().getString(R.string.edit));
        ap.setViewTextColor(this.fYH, R.color.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.fYF.bMc()) {
                    AccountActivity.this.fYF.lF(true);
                    AccountActivity.this.fYH.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(AccountActivity.this.fYH, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(AccountActivity.this.fYH, R.color.CAM_X0302, 1);
                    }
                    AccountActivity.this.fYF.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.fYF.lF(false);
                AccountActivity.this.fYH.setText(R.string.edit);
                ap.setViewTextColor(AccountActivity.this.fYH, R.color.navi_op_text, 1);
                AccountActivity.this.fYF.notifyDataSetChanged();
            }
        });
        this.fYF = new com.baidu.tieba.account.a(this, this.fYI);
        this.fYF.setData(this.fYE);
        this.mList = (ListView) findViewById(R.id.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        bMa();
        this.mList.setAdapter((ListAdapter) this.fYF);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.fYF.getItemId(i) >= 0) {
                    if (!AccountActivity.this.fYF.bMc() && (accountData = (AccountData) AccountActivity.this.fYF.getItem(i)) != null && accountData.getIsActive() != 1) {
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
        bLX();
    }

    private void bLX() {
        View rootView = this.fYG.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fiF == null) {
            this.fiF = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fiF.a(new b.a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.j(accountData2);
                }
            });
        }
        this.fiF.bAH();
        this.fiF.setAccountData(accountData);
        this.fiF.bAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.fYJ == null) {
            com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 2);
            Fp("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.Fq("account changed");
                    AccountActivity.this.fYJ = null;
                }
            });
            if (this.fYL != null) {
                this.fYL.cancel();
            }
            this.fYL = com.baidu.tbadk.core.a.a.blW().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.fYJ = new d(accountData);
        this.fYJ.setPriority(3);
        if (this.fYJ != null) {
            if (bLZ()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.fYJ.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
                com.baidu.tbadk.coreExtra.a.c bwW = com.baidu.tbadk.coreExtra.a.a.bwW();
                if (bwW != null) {
                    bwW.h(this.mAccount);
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
    /* loaded from: classes22.dex */
    public class c implements a.InterfaceC0584a {
        private AccountData fqb;

        public c(AccountData accountData) {
            this.fqb = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0584a
        public void onBeforeLogin(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0584a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new ar("c12948").al("obj_type", 1));
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0584a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, BdStatsConstant.StatsKey.UNAME, str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.fqb != null) {
                ReloginManager.bsG().e(this.fqb);
                AccountActivity.this.a(false, this.fqb);
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
        this.fYJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.fYK == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 3);
                Fp("account delete");
            }
            showLoadingDialog(getPageContext().getString(R.string.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.Fq("account delete cancel");
                    }
                    AccountActivity.this.fYK = null;
                }
            });
            this.fYK = new a(z, accountData);
            this.fYK.setPriority(3);
            bLY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLY() {
        if (this.fYK != null) {
            if (bLZ()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.fYK.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData fYR;
        private boolean fYS;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.fYS = false;
            this.fYR = accountData;
            this.fYS = z;
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
                if (this.fYR != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.fYS) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.fYR.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.fYR.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.fYR.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.bsO().remove(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + this.fYR.getID());
                    if (this.fYR.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c bwW = com.baidu.tbadk.coreExtra.a.a.bwW();
                        if (bwW != null) {
                            bwW.sapiLogout();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c bwW2 = com.baidu.tbadk.coreExtra.a.a.bwW();
                        if (bwW2 != null) {
                            bwW2.f(this.fYR);
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
            if (this.fYR != null) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.fYR.getID());
                new b(this.fYR.getBDUSS(), com.baidu.tbadk.core.a.d.c(this.fYR)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
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
                    AccountActivity.this.fYE.remove(this.fYR);
                    this.fYR = null;
                    AccountActivity.this.fYF.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
                    break;
            }
            AccountActivity.this.fYK = null;
        }
    }

    private void Fp(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().clearAllMessageQueue();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
            aaVar.btv().bue().mNeedBackgroundLogin = false;
            aaVar.btv().bue().mIsUseCurrentBDUSS = false;
            aaVar.addPostData("BDUSS", this.mBduss);
            aaVar.addPostData("stoken", this.mStoken);
            aaVar.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            aaVar.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            aaVar.postNetData();
        }
    }

    private boolean bLZ() {
        return MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fYG.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fYL != null) {
            this.fYL.cancel();
        }
    }

    private void bMa() {
        this.fYN = new TextView(this);
        this.fYN.setGravity(16);
        this.fYN.setPadding(l.getDimens(this, R.dimen.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.getDimens(this, R.dimen.tbds74));
        this.fYN.setTextSize(0, l.getDimens(this, R.dimen.tbds33));
        this.fYN.setText(R.string.account_manager);
        this.fYN.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.fYN);
    }
}
