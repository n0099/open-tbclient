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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private TextView bmB;
    private com.baidu.tieba.account.safeManage.a bmu;
    private NavigationBar mNavigationBar;
    private List<AccountData> bmr = null;
    private com.baidu.tieba.account.a bms = null;
    private ListView mList = null;
    private RelativeLayout bmt = null;
    private TextView bmv = null;
    private View.OnClickListener bmw = null;
    private d bmx = null;
    private a bmy = null;
    private com.baidu.tbadk.coreExtra.view.a aAU = null;
    private BdAsyncTask<?, ?, ?> bmz = null;
    private CustomMessageListener bmA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.account.AccountActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AccountActivity.this.bmr != null) {
                AccountActivity.this.QO();
                if (AccountActivity.this.bms != null) {
                    AccountActivity.this.bms.setData(AccountActivity.this.bmr);
                    AccountActivity.this.bms.notifyDataSetChanged();
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
                    AccountActivity.this.QR();
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
        setContentView(f.h.account_activity);
        QO();
        this.bmu = new com.baidu.tieba.account.safeManage.a(this);
        QP();
        registerListener(this.bmA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.h(this.bmB, f.d.cp_cont_d);
        am.j(this.bmB, f.d.cp_bg_line_e);
        this.bmu.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.bmt);
        this.bms.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QO() {
        this.bmr = com.baidu.tbadk.core.a.b.tq();
    }

    private void QP() {
        this.bmt = (RelativeLayout) findViewById(f.g.account_container);
        this.bmw = new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                new com.baidu.tbadk.core.dialog.b(AccountActivity.this.getPageContext().getPageActivity()).ci(f.j.inform).a(new String[]{AccountActivity.this.getPageContext().getString(f.j.delete_account_only), AccountActivity.this.getPageContext().getString(f.j.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(f.j.cancel)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.account.AccountActivity.2.1
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
                }).d(AccountActivity.this.getPageContext()).xh();
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(f.j.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.bmv = (TextView) addCustomView.findViewById(f.g.right_textview);
        this.bmv.setText(getPageContext().getString(f.j.edit));
        am.c(this.bmv, f.d.navi_op_text, 1);
        addCustomView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AccountActivity.this.bms.QV()) {
                    AccountActivity.this.bms.cy(true);
                    AccountActivity.this.bmv.setText(f.j.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(AccountActivity.this.bmv, f.d.navi_op_text, 1);
                    } else {
                        am.c(AccountActivity.this.bmv, f.d.cp_link_tip_a, 1);
                    }
                    AccountActivity.this.bms.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.bms.cy(false);
                AccountActivity.this.bmv.setText(f.j.edit);
                am.c(AccountActivity.this.bmv, f.d.navi_op_text, 1);
                AccountActivity.this.bms.notifyDataSetChanged();
            }
        });
        this.bms = new com.baidu.tieba.account.a(this, this.bmw);
        this.bms.setData(this.bmr);
        this.mList = (ListView) findViewById(f.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView);
        QT();
        this.mList.setAdapter((ListAdapter) this.bms);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.account.AccountActivity.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AccountData accountData;
                if (AccountActivity.this.bms.getItemId(i) >= 0) {
                    if (!AccountActivity.this.bms.QV() && (accountData = (AccountData) AccountActivity.this.bms.getItem(i)) != null && accountData.getIsActive() != 1) {
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
        QQ();
    }

    private void QQ() {
        View rootView = this.bmu.getRootView();
        rootView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aAU == null) {
            this.aAU = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aAU.a(new a.InterfaceC0107a() { // from class: com.baidu.tieba.account.AccountActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0107a
                public void g(AccountData accountData2) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    AccountActivity.this.j(accountData2);
                }
            });
        }
        this.aAU.FN();
        this.aAU.setAccountData(accountData);
        this.aAU.FJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.bmx == null) {
            iC("account changed");
            showLoadingDialog(getPageContext().getString(f.j.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    AccountActivity.this.iD("account changed");
                    AccountActivity.this.bmx = null;
                }
            });
            if (this.bmz != null) {
                this.bmz.cancel();
            }
            this.bmz = com.baidu.tbadk.core.a.a.tk().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new c(accountData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        this.bmx = new d(accountData);
        this.bmx.setPriority(3);
        if (this.bmx != null) {
            if (QS()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.bmx.execute(new Object[0]);
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
                com.baidu.tbadk.coreExtra.a.c Bu = com.baidu.tbadk.coreExtra.a.a.Bu();
                if (Bu != null) {
                    Bu.h(this.mAccount);
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
        private AccountData aHQ;

        public c(AccountData accountData) {
            this.aHQ = accountData;
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void dc(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new an("c12948").r("obj_type", 1));
            AccountActivity.this.k(accountData);
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i == 1 && this.aHQ != null) {
                ReloginManager.xT().e(this.aHQ);
                AccountActivity.this.a(false, this.aHQ);
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
        this.bmx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.bmy == null) {
            final boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                iC("account delete");
            }
            showLoadingDialog(getPageContext().getString(f.j.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.AccountActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AccountActivity.this.destroyWaitingDialog();
                    if (z2) {
                        AccountActivity.this.iD("account delete cancel");
                    }
                    AccountActivity.this.bmy = null;
                }
            });
            this.bmy = new a(z, accountData);
            this.bmy.setPriority(3);
            QR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QR() {
        if (this.bmy != null) {
            if (QS()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.bmy.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, AccountData> {
        private AccountData bmF;
        private boolean bmG;
        private int mType = 0;

        public a(boolean z, AccountData accountData) {
            this.bmG = false;
            this.bmF = accountData;
            this.bmG = z;
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
                if (this.bmF != null) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    if (this.bmG) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.bmF.getID()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.bmF.getID()));
                    com.baidu.tieba.account.b.deleteAccountAllInfo(this.bmF.getID());
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("get_addresslist_switch" + this.bmF.getID());
                    if (this.bmF.getID().equals(currentAccount)) {
                        com.baidu.tbadk.coreExtra.a.c Bu = com.baidu.tbadk.coreExtra.a.a.Bu();
                        if (Bu != null) {
                            Bu.Bv();
                        }
                        this.mType = 2;
                    } else {
                        com.baidu.tbadk.coreExtra.a.c Bu2 = com.baidu.tbadk.coreExtra.a.a.Bu();
                        if (Bu2 != null) {
                            Bu2.f(this.bmF);
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
            if (this.bmF != null) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.mType), "delete_uid", this.bmF.getID());
                new b(this.bmF.getBDUSS(), com.baidu.tbadk.core.a.d.c(this.bmF)).start();
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
                    AccountActivity.this.showToast(AccountActivity.this.getPageContext().getString(f.j.success));
                    AccountActivity.this.bmr.remove(this.bmF);
                    this.bmF = null;
                    AccountActivity.this.bms.notifyDataSetChanged();
                    break;
                case 2:
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    break;
            }
            AccountActivity.this.bmy = null;
        }
    }

    private void iC(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().fn();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private String Be;
        private String mStoken;

        public b(String str, String str2) {
            this.Be = null;
            this.mStoken = null;
            this.Be = str;
            this.mStoken = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            y yVar = new y(TbConfig.SERVER_ADDRESS + "c/s/logout");
            yVar.yM().zK().arS = false;
            yVar.yM().zK().mIsUseCurrentBDUSS = false;
            yVar.o("BDUSS", this.Be);
            yVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            yVar.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            yVar.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            yVar.yo();
        }
    }

    private boolean QS() {
        return MessageManager.getInstance().getSocketClient().fq() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bmu.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bmz != null) {
            this.bmz.cancel();
        }
    }

    private void QT() {
        this.bmB = new TextView(this);
        this.bmB.setGravity(16);
        this.bmB.setPadding(l.f(this, f.e.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, l.f(this, f.e.tbds74));
        this.bmB.setTextSize(0, l.f(this, f.e.tbds33));
        this.bmB.setText(f.j.account_manager);
        this.bmB.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.bmB);
    }
}
