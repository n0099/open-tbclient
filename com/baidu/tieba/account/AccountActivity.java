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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private com.baidu.tieba.account.safeManage.a bmq;
    private TextView bmx;
    private NavigationBar mNavigationBar;
    private List<AccountData> bmn = null;
    private com.baidu.tieba.account.a bmo = null;
    private ListView mList = null;
    private RelativeLayout bmp = null;
    private TextView bmr = null;
    private View.OnClickListener bms = null;
    private d bmt = null;
    private a bmu = null;
    private com.baidu.tbadk.coreExtra.view.a aAX = null;
    private BdAsyncTask<?, ?, ?> bmv = null;
    private CustomMessageListener bmw = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.bmn != null) {
                AccountActivity.this.QJ();
                if (AccountActivity.this.bmo != null) {
                    AccountActivity.this.bmo.setData(AccountActivity.this.bmn);
                    AccountActivity.this.bmo.notifyDataSetChanged();
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
                    AccountActivity.this.QM();
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
        setContentView(d.h.account_activity);
        QJ();
        this.bmq = new com.baidu.tieba.account.safeManage.a(this);
        QK();
        registerListener(this.bmw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.h(this.bmx, d.C0140d.cp_cont_d);
        am.j(this.bmx, d.C0140d.cp_bg_line_e);
        this.bmq.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.bmp);
        this.bmo.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QJ() {
        this.bmn = com.baidu.tbadk.core.a.b.tr();
    }

    private void QK() {
        this.bmp = (RelativeLayout) findViewById(d.g.account_container);
        this.bms = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).ci(d.j.inform).a(new String[]{AccountActivity.this.getPageContext().getString(d.j.delete_account_only), AccountActivity.this.getPageContext().getString(d.j.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(d.j.cancel)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
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
                }).d(AccountActivity.this.getPageContext()).xi();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.bmr = (TextView) addCustomView.findViewById(d.g.right_textview);
        this.bmr.setText(getPageContext().getString(d.j.edit));
        am.c(this.bmr, d.C0140d.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.bmo.QQ()) {
                    AccountActivity.this.bmo.cx(true);
                    AccountActivity.this.bmr.setText(d.j.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(AccountActivity.this.bmr, d.C0140d.navi_op_text, 1);
                    } else {
                        am.c(AccountActivity.this.bmr, d.C0140d.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.bmo.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.bmo.cx(false);
                AccountActivity.this.bmr.setText(d.j.edit);
                am.c(AccountActivity.this.bmr, d.C0140d.navi_op_text, 1);
                AccountActivity.this.bmo.notifyDataSetChanged();
            }
        });
        this.bmo = new com.baidu.tieba.account.a(this, this.bms);
        this.bmo.setData(this.bmn);
        this.mList = (ListView) findViewById(d.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        QO();
        this.mList.setAdapter((ListAdapter) this.bmo);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.bmo.getItemId(i) >= 0) {
                    if (!AccountActivity.this.bmo.QQ() && (accountData = (AccountData) AccountActivity.this.bmo.getItem(i)) != null && accountData.getIsActive() != 1) {
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
        QL();
    }

    private void QL() {
        View rootView = this.bmq.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aAX == null) {
            this.aAX = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aAX.a(new a.InterfaceC0107a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0107a
                public void g(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.j(accountData2);
                }
            });
        }
        this.aAX.FN();
        this.aAX.setAccountData(accountData);
        this.aAX.FJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.bmt == null) {
            iB("account changed");
            showLoadingDialog(getPageContext().getString(d.j.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.iC("account changed");
                    AccountActivity.this.bmt = null;
                }
            });
            if (this.bmv != null) {
                this.bmv.cancel();
            }
            this.bmv = com.baidu.tbadk.core.a.a.tl().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.bmt = new d(accountData);
        this.bmt.setPriority(3);
        if (this.bmt != null) {
            if (QN()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.bmt.execute(new Object[0]);
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
        /* renamed from: m */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                this.mAccount.setIsActive(1);
                com.baidu.tbadk.core.a.b.b(this.mAccount);
                com.baidu.tbadk.coreExtra.a.c Bx = com.baidu.tbadk.coreExtra.a.a.Bx();
                if (Bx != null) {
                    Bx.h(this.mAccount);
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
    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0098a {
        private AccountData aHS;

        public c(AccountData accountData) {
            this.aHS = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void db(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new an("c12948").r("obj_type", 1));
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aHS != null) {
                ReloginManager.xU().e(this.aHS);
                AccountActivity.this.a(false, this.aHS);
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
        com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 1, false);
        this.bmt = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.bmu == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                iB("account delete");
            }
            showLoadingDialog(getPageContext().getString(d.j.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.iC("account delete cancel");
                    }
                    AccountActivity.this.bmu = null;
                }
            });
            this.bmu = new a(z, accountData);
            this.bmu.setPriority(3);
            QM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        if (this.bmu != null) {
            if (QN()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.bmu.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData bmB;
        private boolean bmC;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.bmC = false;
            this.bmB = accountData;
            this.bmC = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public AccountData doInBackground(Object... objArr) {
            try {
                if (this.bmB != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.bmC) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.bmB.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.bmB.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.bmB.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("get_addresslist_switch" + this.bmB.getID());
                    if (this.bmB.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c Bx = com.baidu.tbadk.coreExtra.a.a.Bx();
                        if (Bx != null) {
                            Bx.By();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c Bx2 = com.baidu.tbadk.coreExtra.a.a.Bx();
                        if (Bx2 != null) {
                            Bx2.f(this.bmB);
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
            if (this.bmB != null) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.bmB.getID());
                new b(this.bmB.getBDUSS(), com.baidu.tbadk.core.a.d.c(this.bmB)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.mType != 0) {
                e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.account.AccountActivity.a.1
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
                    AccountActivity.this.bmn.remove(this.bmB);
                    this.bmB = null;
                    AccountActivity.this.bmo.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    break;
            }
            AccountActivity.this.bmu = null;
        }
    }

    private void iB(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().fn();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String Bd;
        private String mStoken;

        public b(String str, String str2) {
            this.Bd = null;
            this.mStoken = null;
            this.Bd = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            y yVar = new y(TbConfig.SERVER_ADDRESS + "c/s/logout");
            yVar.yO().zM().arR = false;
            yVar.yO().zM().mIsUseCurrentBDUSS = false;
            yVar.o("BDUSS", this.Bd);
            yVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            yVar.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            yVar.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            yVar.yq();
        }
    }

    private boolean QN() {
        return MessageManager.getInstance().getSocketClient().fq() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bmq.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bmv != null) {
            this.bmv.cancel();
        }
    }

    private void QO() {
        this.bmx = new TextView(this);
        this.bmx.setGravity(16);
        this.bmx.setPadding(l.f(this, d.e.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.f(this, d.e.tbds74));
        this.bmx.setTextSize(0, l.f(this, d.e.tbds33));
        this.bmx.setText(d.j.account_manager);
        this.bmx.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.bmx);
    }
}
