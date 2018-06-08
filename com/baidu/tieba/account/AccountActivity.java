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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private com.baidu.tieba.account.safeManage.a bkl;
    private TextView bks;
    private NavigationBar mNavigationBar;
    private List<AccountData> bki = null;
    private com.baidu.tieba.account.a bkj = null;
    private ListView mList = null;
    private RelativeLayout bkk = null;
    private TextView bkm = null;
    private View.OnClickListener bkn = null;
    private d bko = null;
    private a bkp = null;
    private com.baidu.tbadk.coreExtra.view.a aAl = null;
    private BdAsyncTask<?, ?, ?> bkq = null;
    private CustomMessageListener bkr = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.bki != null) {
                AccountActivity.this.Qf();
                if (AccountActivity.this.bkj != null) {
                    AccountActivity.this.bkj.setData(AccountActivity.this.bki);
                    AccountActivity.this.bkj.notifyDataSetChanged();
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
                    AccountActivity.this.Qi();
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
        Qf();
        this.bkl = new com.baidu.tieba.account.safeManage.a(this);
        Qg();
        registerListener(this.bkr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.h(this.bks, d.C0141d.cp_cont_d);
        al.j(this.bks, d.C0141d.cp_bg_line_e);
        this.bkl.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.bkk);
        this.bkj.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qf() {
        this.bki = com.baidu.tbadk.core.a.b.tF();
    }

    private void Qg() {
        this.bkk = (RelativeLayout) findViewById(d.g.account_container);
        this.bkn = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).cf(d.k.inform).a(new String[]{AccountActivity.this.getPageContext().getString(d.k.delete_account_only), AccountActivity.this.getPageContext().getString(d.k.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(d.k.cancel)}, new b.InterfaceC0103b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
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
                }).d(AccountActivity.this.getPageContext()).xd();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.k.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.bkm = (TextView) addCustomView.findViewById(d.g.right_textview);
        this.bkm.setText(getPageContext().getString(d.k.edit));
        al.c(this.bkm, d.C0141d.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.bkj.Qm()) {
                    AccountActivity.this.bkj.ct(true);
                    AccountActivity.this.bkm.setText(d.k.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(AccountActivity.this.bkm, d.C0141d.navi_op_text, 1);
                    } else {
                        al.c(AccountActivity.this.bkm, d.C0141d.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.bkj.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.bkj.ct(false);
                AccountActivity.this.bkm.setText(d.k.edit);
                al.c(AccountActivity.this.bkm, d.C0141d.navi_op_text, 1);
                AccountActivity.this.bkj.notifyDataSetChanged();
            }
        });
        this.bkj = new com.baidu.tieba.account.a(this, this.bkn);
        this.bkj.setData(this.bki);
        this.mList = (ListView) findViewById(d.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        Qk();
        this.mList.setAdapter((ListAdapter) this.bkj);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.bkj.getItemId(i) >= 0) {
                    if (!AccountActivity.this.bkj.Qm() && (accountData = (AccountData) AccountActivity.this.bkj.getItem(i)) != null && accountData.getIsActive() != 1) {
                        if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
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
        Qh();
    }

    private void Qh() {
        View rootView = this.bkl.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.aAl == null) {
            this.aAl = new com.baidu.tbadk.coreExtra.view.a(getPageContext());
            this.aAl.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0109a
                public void f(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.k(accountData2);
                }
            });
        }
        this.aAl.Fz();
        this.aAl.i(accountData);
        this.aAl.Fv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.bko == null) {
            iz("account changed");
            showLoadingDialog(getPageContext().getString(d.k.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.iA("account changed");
                    AccountActivity.this.bko = null;
                }
            });
            if (this.bkq != null) {
                this.bkq.cancel();
            }
            this.bkq = com.baidu.tbadk.core.a.a.tA().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        this.bko = new d(accountData);
        this.bko.setPriority(3);
        if (this.bko != null) {
            if (Qj()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.bko.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c Bn = com.baidu.tbadk.coreExtra.a.a.Bn();
                if (Bn != null) {
                    Bn.g(this.mAccount);
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
    public class c implements a.InterfaceC0100a {
        private AccountData aGZ;

        public c(AccountData accountData) {
            this.aGZ = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0100a
        public void dc(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0100a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new am("c12948").r("obj_type", 1));
            AccountActivity.this.l(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0100a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aGZ != null) {
                ReloginManager.xP().e(this.aGZ);
                AccountActivity.this.a(false, this.aGZ);
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
        this.bko = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.bkp == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                iz("account delete");
            }
            showLoadingDialog(getPageContext().getString(d.k.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.iA("account delete cancel");
                    }
                    AccountActivity.this.bkp = null;
                }
            });
            this.bkp = new a(z, accountData);
            this.bkp.setPriority(3);
            Qi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi() {
        if (this.bkp != null) {
            if (Qj()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.bkp.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData bkw;
        private boolean bkx;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.bkx = false;
            this.bkw = accountData;
            this.bkx = z;
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
                if (this.bkw != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.bkx) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.bkw.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.bkw.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.bkw.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("get_addresslist_switch" + this.bkw.getID());
                    if (this.bkw.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c Bn = com.baidu.tbadk.coreExtra.a.a.Bn();
                        if (Bn != null) {
                            Bn.Bp();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c Bn2 = com.baidu.tbadk.coreExtra.a.a.Bn();
                        if (Bn2 != null) {
                            Bn2.h(this.bkw);
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
            if (this.bkw != null) {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.bkw.getID());
                new b(this.bkw.getBDUSS(), e.c(this.bkw)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
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
                    AccountActivity.this.bki.remove(this.bkw);
                    this.bkw = null;
                    AccountActivity.this.bkj.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    break;
            }
            AccountActivity.this.bkp = null;
        }
    }

    private void iz(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().fo();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String Bg;
        private String mStoken;

        public b(String str, String str2) {
            this.Bg = null;
            this.mStoken = null;
            this.Bg = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            y yVar = new y(TbConfig.SERVER_ADDRESS + "c/s/logout");
            yVar.yJ().zI().arL = false;
            yVar.yJ().zI().mIsUseCurrentBDUSS = false;
            yVar.o("BDUSS", this.Bg);
            yVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            yVar.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            yVar.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            yVar.yl();
        }
    }

    private boolean Qj() {
        return MessageManager.getInstance().getSocketClient().fs() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bkl.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bkq != null) {
            this.bkq.cancel();
        }
    }

    private void Qk() {
        this.bks = new TextView(this);
        this.bks.setGravity(16);
        this.bks.setPadding(l.e(this, d.e.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.e(this, d.e.tbds74));
        this.bks.setTextSize(0, l.e(this, d.e.tbds33));
        this.bks.setText(d.k.account_manager);
        this.bks.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.bks);
    }
}
