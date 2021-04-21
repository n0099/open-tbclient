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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import d.b.i0.r.l.a;
import d.b.i0.r.s.b;
import d.b.i0.s.i.b;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    public static final int ACCOUNT_DELETE = 1;
    public static final int ACCOUNT_SWITCH = 2;
    public d.b.j0.n.c.a mAccountSafePresenter;
    public TextView mListAccountTitle;
    public NavigationBar mNavigationBar;
    public List<AccountData> mModel = null;
    public d.b.j0.n.a mAdapter = null;
    public ListView mList = null;
    public RelativeLayout mContainer = null;
    public TextView mEdit = null;
    public View.OnClickListener mDeleteListener = null;
    public l mSwitchTask = null;
    public i mDeleteTask = null;
    public d.b.i0.s.i.b mInputUserNameDialog = null;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask = null;
    public CustomMessageListener accountChangedListener = new a(2005016);
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler = new h();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || AccountActivity.this.mModel == null) {
                return;
            }
            AccountActivity.this.InitData();
            if (AccountActivity.this.mAdapter != null) {
                AccountActivity.this.mAdapter.b(AccountActivity.this.mModel);
                AccountActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements b.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f14144a;

            public a(View view) {
                this.f14144a = view;
            }

            @Override // d.b.i0.r.s.b.c
            public void a(d.b.i0.r.s.b bVar, int i, View view) {
                View view2 = this.f14144a;
                if (view2 == null) {
                    return;
                }
                AccountData accountData = (AccountData) view2.getTag();
                if (i != 0) {
                    if (i == 1 && accountData != null) {
                        AccountActivity.this.deleteAccount(true, accountData);
                    }
                } else if (accountData != null) {
                    AccountActivity.this.deleteAccount(false, accountData);
                }
                bVar.e();
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr = {AccountActivity.this.getPageContext().getString(R.string.delete_account_only), AccountActivity.this.getPageContext().getString(R.string.delete_account_and_group_cache), AccountActivity.this.getPageContext().getString(R.string.cancel)};
            d.b.i0.r.s.b bVar = new d.b.i0.r.s.b(AccountActivity.this.getPageContext().getPageActivity());
            bVar.k(R.string.inform);
            bVar.j(strArr, new a(view));
            bVar.c(AccountActivity.this.getPageContext());
            bVar.m();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!AccountActivity.this.mAdapter.a()) {
                AccountActivity.this.mAdapter.c(true);
                AccountActivity.this.mEdit.setText(R.string.done);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(AccountActivity.this.mEdit, R.color.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(AccountActivity.this.mEdit, R.color.CAM_X0302, 1);
                }
                AccountActivity.this.mAdapter.notifyDataSetChanged();
                return;
            }
            AccountActivity.this.mAdapter.c(false);
            AccountActivity.this.mEdit.setText(R.string.edit);
            SkinManager.setViewTextColor(AccountActivity.this.mEdit, R.color.navi_op_text, 1);
            AccountActivity.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AccountData accountData;
            if (AccountActivity.this.mAdapter.getItemId(i) >= 0) {
                if (AccountActivity.this.mAdapter.a() || (accountData = (AccountData) AccountActivity.this.mAdapter.getItem(i)) == null || accountData.getIsActive() == 1) {
                    return;
                }
                if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
                    AccountActivity.this.showInputDialog(accountData);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                AccountActivity.this.switchAccount(accountData);
                return;
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(AccountActivity.this.getPageContext().getPageActivity());
            loginActivityConfig.setJumpToAfterDestroy(1);
            TbadkCoreApplication.getInst().login(AccountActivity.this.getPageContext(), new CustomMessage<>(2002001, loginActivityConfig));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.e {
        public e() {
        }

        @Override // d.b.i0.s.i.b.e
        public void a(AccountData accountData) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
            AccountActivity.this.switchAccount(accountData);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AccountActivity.this.destroyWaitingDialog();
            AccountActivity.this.manualOpenSocket("account changed");
            AccountActivity.this.mSwitchTask = null;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f14150e;

        public g(boolean z) {
            this.f14150e = z;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AccountActivity.this.destroyWaitingDialog();
            if (this.f14150e) {
                AccountActivity.this.manualOpenSocket("account delete cancel");
            }
            AccountActivity.this.mDeleteTask = null;
        }
    }

    /* loaded from: classes4.dex */
    public class h extends Handler {
        public h() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                AccountActivity.this.doDeleteTask();
            } else if (i != 2) {
            } else {
                Object obj = message.obj;
                if (obj instanceof AccountData) {
                    AccountActivity.this.doSwitchTask((AccountData) obj);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<Object, Integer, AccountData> {

        /* renamed from: a  reason: collision with root package name */
        public AccountData f14153a;

        /* renamed from: b  reason: collision with root package name */
        public int f14154b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14155c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AccountActivity.this.finish();
            }
        }

        public i(boolean z, AccountData accountData) {
            this.f14155c = false;
            this.f14153a = accountData;
            this.f14155c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public AccountData doInBackground(Object... objArr) {
            try {
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            if (this.f14153a == null) {
                return null;
            }
            try {
                Thread.sleep(1000L);
            } catch (Exception e3) {
                BdLog.detailException(e3);
            }
            if (this.f14155c) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.f14153a.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.f14153a.getID()));
            d.b.j0.n.b.a(this.f14153a.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
            j.C("get_addresslist_switch" + this.f14153a.getID());
            if (this.f14153a.getID().equals(currentAccount)) {
                d.b.i0.s.a.b b2 = d.b.i0.s.a.a.b();
                if (b2 != null) {
                    b2.a();
                }
                this.f14154b = 2;
            } else {
                d.b.i0.s.a.b b3 = d.b.i0.s.a.a.b();
                if (b3 != null) {
                    b3.c(this.f14153a);
                }
                this.f14154b = 0;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AccountData accountData) {
            if (this.f14153a != null) {
                d.b.i0.r.z.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.f14154b), "delete_uid", this.f14153a.getID());
                new j(this.f14153a.getBDUSS(), d.b.i0.r.l.e.a(this.f14153a)).start();
            }
            AccountActivity.this.closeLoadingDialog();
            if (this.f14154b != 0) {
                d.b.c.e.m.e.a().postDelayed(new a(), 1000L);
                d.b.i0.r.z.a.a("account", -1L, 0, "account_activity_delete_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(null, AccountActivity.this.getPageContext().getPageActivity());
            }
            int i = this.f14154b;
            if (i == 0) {
                AccountActivity accountActivity = AccountActivity.this;
                accountActivity.showToast(accountActivity.getPageContext().getString(R.string.success));
                AccountActivity.this.mModel.remove(this.f14153a);
                this.f14153a = null;
                AccountActivity.this.mAdapter.notifyDataSetChanged();
            } else if (i == 2) {
                TbadkCoreApplication.getInst().onUserChanged();
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) AccountActivity.this.getPageContext().getPageActivity(), true);
                loginActivityConfig.setJumpToAfterDestroy(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            }
            AccountActivity.this.mDeleteTask = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }
    }

    /* loaded from: classes4.dex */
    public class j extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public String f14158e;

        /* renamed from: f  reason: collision with root package name */
        public String f14159f;

        public j(String str, String str2) {
            this.f14158e = null;
            this.f14159f = null;
            this.f14158e = str;
            this.f14159f = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/logout");
            netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
            netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            netWork.addPostData(HttpRequest.BDUSS, this.f14158e);
            netWork.addPostData("stoken", this.f14159f);
            netWork.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            netWork.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            netWork.postNetData();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements a.InterfaceC1117a {

        /* renamed from: a  reason: collision with root package name */
        public AccountData f14161a;

        public k(AccountData accountData) {
            this.f14161a = accountData;
        }

        @Override // d.b.i0.r.l.a.InterfaceC1117a
        public void a(String str, int i, String str2) {
            d.b.i0.r.z.a.a("account", -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
            AccountActivity.this.closeLoadingDialog();
            AccountActivity.this.showToast(str2);
            if (i != 1 || this.f14161a == null) {
                return;
            }
            ReloginManager.g().f(this.f14161a);
            AccountActivity.this.deleteAccount(false, this.f14161a);
        }

        @Override // d.b.i0.r.l.a.InterfaceC1117a
        public void b(String str) {
        }

        @Override // d.b.i0.r.l.a.InterfaceC1117a
        public void c(AccountData accountData) {
            d.b.i0.r.z.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
            TiebaStatic.log(new StatisticItem("c12948").param("obj_type", 1));
            AccountActivity.this.doSwitchTask(accountData);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends BdAsyncTask<Object, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public AccountData f14163a;

        public l(AccountData accountData) {
            this.f14163a = null;
            this.f14163a = accountData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Object... objArr) {
            try {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                this.f14163a.setIsActive(1);
                d.b.i0.r.l.c.g(this.f14163a);
                d.b.i0.s.a.b b2 = d.b.i0.s.a.a.b();
                if (b2 != null) {
                    b2.b(this.f14163a);
                }
            } catch (Exception e3) {
                BdLog.detailException(e3);
            }
            return Boolean.TRUE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            AccountActivity.this.handleChangeSuccess(this.f14163a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InitData() {
        this.mModel = d.b.i0.r.l.c.f();
    }

    private void InitUI() {
        this.mContainer = (RelativeLayout) findViewById(R.id.account_container);
        this.mDeleteListener = new b();
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.mEdit = textView;
        textView.setText(getPageContext().getString(R.string.edit));
        SkinManager.setViewTextColor(this.mEdit, R.color.navi_op_text, 1);
        addCustomView.setOnClickListener(new c());
        d.b.j0.n.a aVar = new d.b.j0.n.a(this, this.mDeleteListener);
        this.mAdapter = aVar;
        aVar.b(this.mModel);
        this.mList = (ListView) findViewById(R.id.list);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mList.addHeaderView(textView2);
        addAccountListTitle();
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        this.mList.setOnItemClickListener(new d());
        addAccountSafeView();
    }

    private void addAccountListTitle() {
        TextView textView = new TextView(this);
        this.mListAccountTitle = textView;
        textView.setGravity(16);
        this.mListAccountTitle.setPadding(d.b.c.e.p.l.g(this, R.dimen.tbds44), 0, 0, 0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, d.b.c.e.p.l.g(this, R.dimen.tbds74));
        this.mListAccountTitle.setTextSize(0, d.b.c.e.p.l.g(this, R.dimen.tbds33));
        this.mListAccountTitle.setText(R.string.account_manager);
        this.mListAccountTitle.setLayoutParams(layoutParams);
        this.mList.addHeaderView(this.mListAccountTitle);
    }

    private void addAccountSafeView() {
        View d2 = this.mAccountSafePresenter.d();
        d2.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.mList.addFooterView(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAccount(boolean z, AccountData accountData) {
        if (this.mDeleteTask != null) {
            return;
        }
        boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (z2) {
            d.b.i0.c0.a.b(0, 0, 0, 2, 3);
            manualCloseSocket("account delete");
        }
        showLoadingDialog(getPageContext().getString(R.string.deleting), new g(z2));
        i iVar = new i(z, accountData);
        this.mDeleteTask = iVar;
        iVar.setPriority(3);
        doDeleteTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDeleteTask() {
        if (this.mDeleteTask != null) {
            if (hasProcessingTask()) {
                this.mHandler.removeMessages(1);
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(1), 200L);
                return;
            }
            this.mDeleteTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSwitchTask(AccountData accountData) {
        l lVar = new l(accountData);
        this.mSwitchTask = lVar;
        lVar.setPriority(3);
        if (this.mSwitchTask != null) {
            if (hasProcessingTask()) {
                this.mHandler.removeMessages(2);
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = accountData;
                this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                return;
            }
            this.mSwitchTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeSuccess(AccountData accountData) {
        d.b.i0.r.z.a.a("account", -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
        TbadkCoreApplication.getInst().onUserChanged();
        d.b.i0.r.a0.b.g(getPageContext().getPageActivity(), 2, false);
        this.mSwitchTask = null;
    }

    private boolean hasProcessingTask() {
        return MessageManager.getInstance().getSocketClient().s() > 0;
    }

    private void manualCloseSocket(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().j();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manualOpenSocket(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputDialog(AccountData accountData) {
        if (this.mInputUserNameDialog == null) {
            d.b.i0.s.i.b bVar = new d.b.i0.s.i.b(this);
            this.mInputUserNameDialog = bVar;
            bVar.w(new e());
        }
        this.mInputUserNameDialog.p();
        this.mInputUserNameDialog.u(accountData);
        this.mInputUserNameDialog.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchAccount(AccountData accountData) {
        if (this.mSwitchTask != null) {
            return;
        }
        d.b.i0.c0.a.b(0, 0, 0, 2, 2);
        manualCloseSocket("account changed");
        showLoadingDialog(getPageContext().getString(R.string.account_logining), new f());
        BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
        this.mAccountLoginTask = d.b.i0.r.l.a.b().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new k(accountData));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setViewTextColor(this.mListAccountTitle, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.mListAccountTitle, R.color.CAM_X0204);
        this.mAccountSafePresenter.e(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mContainer);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_activity);
        InitData();
        this.mAccountSafePresenter = new d.b.j0.n.c.a(this);
        InitUI();
        registerListener(this.accountChangedListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mAccountSafePresenter.f();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeCallbacksAndMessages(null);
        BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
    }
}
