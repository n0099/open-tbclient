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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a fbL;
    private TextView fbS;
    private NavigationBar mNavigationBar;
    private List<AccountData> fbJ = null;
    private com.baidu.tieba.account.a fbK = null;
    private ListView mList = null;
    private RelativeLayout mContainer = null;
    private TextView fbM = null;
    private View.OnClickListener fbN = null;
    private d fbO = null;
    private a fbP = null;
    private com.baidu.tbadk.coreExtra.view.b epl = null;
    private BdAsyncTask<?, ?, ?> fbQ = null;
    private CustomMessageListener fbR = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.fbJ != null) {
                AccountActivity.this.brE();
                if (AccountActivity.this.fbK != null) {
                    AccountActivity.this.fbK.setData(AccountActivity.this.fbJ);
                    AccountActivity.this.fbK.notifyDataSetChanged();
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
                    AccountActivity.this.brH();
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
        brE();
        this.fbL = new com.baidu.tieba.account.safeManage.a(this);
        brF();
        registerListener(this.fbR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setViewTextColor(this.fbS, R.color.cp_cont_d);
        ao.setBackgroundColor(this.fbS, R.color.cp_bg_line_c);
        this.fbL.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mContainer);
        this.fbK.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brE() {
        this.fbJ = com.baidu.tbadk.core.a.b.aTA();
    }

    private void brF() {
        this.mContainer = (RelativeLayout) findViewById(R.id.account_container);
        this.fbN = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).lr(R.string.inform).a(new String[]{AccountActivity.this.getPageContext().getString(R.string.delete_account_only), AccountActivity.this.getPageContext().getString(R.string.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(R.string.cancel)}, new b.InterfaceC0492b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
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
                }).d(AccountActivity.this.getPageContext()).aYN();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.fbM = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.fbM.setText(getPageContext().getString(R.string.edit));
        ao.setViewTextColor(this.fbM, R.color.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.fbK.brL()) {
                    AccountActivity.this.fbK.jO(true);
                    AccountActivity.this.fbM.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(AccountActivity.this.fbM, R.color.navi_op_text, 1);
                    } else {
                        ao.setViewTextColor(AccountActivity.this.fbM, R.color.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.fbK.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.fbK.jO(false);
                AccountActivity.this.fbM.setText(R.string.edit);
                ao.setViewTextColor(AccountActivity.this.fbM, R.color.navi_op_text, 1);
                AccountActivity.this.fbK.notifyDataSetChanged();
            }
        });
        this.fbK = new com.baidu.tieba.account.a(this, this.fbN);
        this.fbK.setData(this.fbJ);
        this.mList = (ListView) findViewById(R.id.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        brJ();
        this.mList.setAdapter((ListAdapter) this.fbK);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.fbK.getItemId(i) >= 0) {
                    if (!AccountActivity.this.fbK.brL() && (accountData = (AccountData) AccountActivity.this.fbK.getItem(i)) != null && accountData.getIsActive() != 1) {
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
        brG();
    }

    private void brG() {
        View rootView = this.fbL.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.epl == null) {
            this.epl = new com.baidu.tbadk.coreExtra.view.b(this);
            this.epl.a(new b.a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.j(accountData2);
                }
            });
        }
        this.epl.bhi();
        this.epl.setAccountData(accountData);
        this.epl.bhe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.fbO == null) {
            com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 2);
            AQ("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.AR("account changed");
                    AccountActivity.this.fbO = null;
                }
            });
            if (this.fbQ != null) {
                this.fbQ.cancel();
            }
            this.fbQ = com.baidu.tbadk.core.a.a.aTw().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.fbO = new d(accountData);
        this.fbO.setPriority(3);
        if (this.fbO != null) {
            if (brI()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.fbO.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c bdD = com.baidu.tbadk.coreExtra.a.a.bdD();
                if (bdD != null) {
                    bdD.h(this.mAccount);
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
    public class c implements a.InterfaceC0490a {
        private AccountData ewo;

        public c(AccountData accountData) {
            this.ewo = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0490a
        public void onBeforeLogin(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0490a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new ap("c12948").ah("obj_type", 1));
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0490a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, BdStatsConstant.StatsKey.UNAME, str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.ewo != null) {
                ReloginManager.aZI().e(this.ewo);
                AccountActivity.this.a(false, this.ewo);
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
        this.fbO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.fbP == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                com.baidu.tbadk.lcs.a.d(0, 0, 0, 2, 3);
                AQ("account delete");
            }
            showLoadingDialog(getPageContext().getString(R.string.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.AR("account delete cancel");
                    }
                    AccountActivity.this.fbP = null;
                }
            });
            this.fbP = new a(z, accountData);
            this.fbP.setPriority(3);
            brH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brH() {
        if (this.fbP != null) {
            if (brI()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.fbP.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData fbW;
        private boolean fbX;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.fbX = false;
            this.fbW = accountData;
            this.fbX = z;
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
                if (this.fbW != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.fbX) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, this.fbW.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, this.fbW.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.fbW.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.aZP().remove(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + this.fbW.getID());
                    if (this.fbW.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c bdD = com.baidu.tbadk.coreExtra.a.a.bdD();
                        if (bdD != null) {
                            bdD.sapiLogout();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c bdD2 = com.baidu.tbadk.coreExtra.a.a.bdD();
                        if (bdD2 != null) {
                            bdD2.f(this.fbW);
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
            if (this.fbW != null) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.fbW.getID());
                new b(this.fbW.getBDUSS(), com.baidu.tbadk.core.a.d.c(this.fbW)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
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
                    AccountActivity.this.fbJ.remove(this.fbW);
                    this.fbW = null;
                    AccountActivity.this.fbK.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
                    break;
            }
            AccountActivity.this.fbP = null;
        }
    }

    private void AQ(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().clearAllMessageQueue();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR(String str) {
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
            z zVar = new z(TbConfig.SERVER_ADDRESS + "c/s/logout");
            zVar.bav().baW().mNeedBackgroundLogin = false;
            zVar.bav().baW().mIsUseCurrentBDUSS = false;
            zVar.addPostData("BDUSS", this.mBduss);
            zVar.addPostData("stoken", this.mStoken);
            zVar.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            zVar.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            zVar.postNetData();
        }
    }

    private boolean brI() {
        return MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fbL.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fbQ != null) {
            this.fbQ.cancel();
        }
    }

    private void brJ() {
        this.fbS = new TextView(this);
        this.fbS.setGravity(16);
        this.fbS.setPadding(l.getDimens(this, R.dimen.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.getDimens(this, R.dimen.tbds74));
        this.fbS.setTextSize(0, l.getDimens(this, R.dimen.tbds33));
        this.fbS.setText(R.string.account_manager);
        this.fbS.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.fbS);
    }
}
