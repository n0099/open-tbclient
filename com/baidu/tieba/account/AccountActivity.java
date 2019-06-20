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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a cUI;
    private TextView cUP;
    private NavigationBar mNavigationBar;
    private List<AccountData> cUF = null;
    private com.baidu.tieba.account.a cUG = null;
    private ListView mList = null;
    private RelativeLayout cUH = null;
    private TextView cUJ = null;
    private View.OnClickListener cUK = null;
    private d cUL = null;
    private a cUM = null;
    private com.baidu.tbadk.coreExtra.view.c cdW = null;
    private BdAsyncTask<?, ?, ?> cUN = null;
    private CustomMessageListener cUO = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.cUF != null) {
                AccountActivity.this.aBr();
                if (AccountActivity.this.cUG != null) {
                    AccountActivity.this.cUG.setData(AccountActivity.this.cUF);
                    AccountActivity.this.cUG.notifyDataSetChanged();
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
                    AccountActivity.this.aBu();
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
        aBr();
        this.cUI = new com.baidu.tieba.account.safeManage.a(this);
        aBs();
        registerListener(this.cUO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.cUP, R.color.cp_cont_d);
        al.l(this.cUP, R.color.cp_bg_line_e);
        this.cUI.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.cUH);
        this.cUG.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        this.cUF = com.baidu.tbadk.core.a.b.abl();
    }

    private void aBs() {
        this.cUH = (RelativeLayout) findViewById(R.id.account_container);
        this.cUK = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).hs(R.string.inform).a(new String[]{AccountActivity.this.getPageContext().getString(R.string.delete_account_only), AccountActivity.this.getPageContext().getString(R.string.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(R.string.cancel)}, new b.a() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.a
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
                }).d(AccountActivity.this.getPageContext()).afJ();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.cUJ = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.cUJ.setText(getPageContext().getString(R.string.edit));
        al.f(this.cUJ, R.color.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.cUG.aBy()) {
                    AccountActivity.this.cUG.gg(true);
                    AccountActivity.this.cUJ.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(AccountActivity.this.cUJ, R.color.navi_op_text, 1);
                    } else {
                        al.f(AccountActivity.this.cUJ, R.color.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.cUG.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.cUG.gg(false);
                AccountActivity.this.cUJ.setText(R.string.edit);
                al.f(AccountActivity.this.cUJ, R.color.navi_op_text, 1);
                AccountActivity.this.cUG.notifyDataSetChanged();
            }
        });
        this.cUG = new com.baidu.tieba.account.a(this, this.cUK);
        this.cUG.setData(this.cUF);
        this.mList = (ListView) findViewById(R.id.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        aBw();
        this.mList.setAdapter((ListAdapter) this.cUG);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.cUG.getItemId(i) >= 0) {
                    if (!AccountActivity.this.cUG.aBy() && (accountData = (AccountData) AccountActivity.this.cUG.getItem(i)) != null && accountData.getIsActive() != 1) {
                        if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
                            AccountActivity.this.i(accountData);
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                        AccountActivity.this.j(accountData);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(AccountActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(AccountActivity.this.getPageContext().getPageActivity())));
            }
        });
        aBt();
    }

    private void aBt() {
        View rootView = this.cUI.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.cdW == null) {
            this.cdW = new com.baidu.tbadk.coreExtra.view.c(this);
            this.cdW.a(new c.a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.j(accountData2);
                }
            });
        }
        this.cdW.apm();
        this.cdW.setAccountData(accountData);
        this.cdW.aph();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.cUL == null) {
            com.baidu.tbadk.lcs.a.c(0, 0, 0, 2, 2);
            rV("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.rW("account changed");
                    AccountActivity.this.cUL = null;
                }
            });
            if (this.cUN != null) {
                this.cUN.cancel();
            }
            this.cUN = com.baidu.tbadk.core.a.a.abg().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.cUL = new d(accountData);
        this.cUL.setPriority(3);
        if (this.cUL != null) {
            if (aBv()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.cUL.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
        /* renamed from: o */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c akD = com.baidu.tbadk.coreExtra.a.a.akD();
                if (akD != null) {
                    akD.h(this.mAccount);
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
    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC0237a {
        private AccountData cmh;

        public c(AccountData accountData) {
            this.cmh = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0237a
        public void ma(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0237a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new am("c12948").P("obj_type", 1));
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0237a
        public void h(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.cmh != null) {
                ReloginManager.agF().e(this.cmh);
                AccountActivity.this.a(false, this.cmh);
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
        com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 0, false);
        this.cUL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.cUM == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                com.baidu.tbadk.lcs.a.c(0, 0, 0, 2, 3);
                rV("account delete");
            }
            showLoadingDialog(getPageContext().getString(R.string.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.rW("account delete cancel");
                    }
                    AccountActivity.this.cUM = null;
                }
            });
            this.cUM = new a(z, accountData);
            this.cUM.setPriority(3);
            aBu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.cUM != null) {
            if (aBv()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.cUM.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData cUT;
        private boolean cUU;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.cUU = false;
            this.cUT = accountData;
            this.cUU = z;
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
                if (this.cUT != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.cUU) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.cUT.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.cUT.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.cUT.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.agM().remove("get_addresslist_switch" + this.cUT.getID());
                    if (this.cUT.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c akD = com.baidu.tbadk.coreExtra.a.a.akD();
                        if (akD != null) {
                            akD.akE();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c akD2 = com.baidu.tbadk.coreExtra.a.a.akD();
                        if (akD2 != null) {
                            akD2.f(this.cUT);
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
            if (this.cUT != null) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.cUT.getID());
                new b(this.cUT.getBDUSS(), com.baidu.tbadk.core.a.d.c(this.cUT)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountActivity.this.finish();
                    }
                }, 1000L);
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            switch (this.mType) {
                case 0:
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(R.string.success));
                    AccountActivity.this.cUF.remove(this.cUT);
                    this.cUT = null;
                    AccountActivity.this.cUG.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    break;
            }
            AccountActivity.this.cUM = null;
        }
    }

    private void rV(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().fE();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends Thread {
        private String BS;
        private String mStoken;

        public b(String str, String str2) {
            this.BS = null;
            this.mStoken = null;
            this.BS = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            x xVar = new x(TbConfig.SERVER_ADDRESS + "c/s/logout");
            xVar.ahC().aiB().bTF = false;
            xVar.ahC().aiB().mIsUseCurrentBDUSS = false;
            xVar.o("BDUSS", this.BS);
            xVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            xVar.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            xVar.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            xVar.ahe();
        }
    }

    private boolean aBv() {
        return MessageManager.getInstance().getSocketClient().fH() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cUI.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.cUN != null) {
            this.cUN.cancel();
        }
    }

    private void aBw() {
        this.cUP = new TextView(this);
        this.cUP.setGravity(16);
        this.cUP.setPadding(l.g(this, R.dimen.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.g(this, R.dimen.tbds74));
        this.cUP.setTextSize(0, l.g(this, R.dimen.tbds33));
        this.cUP.setText(R.string.account_manager);
        this.cUP.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.cUP);
    }
}
