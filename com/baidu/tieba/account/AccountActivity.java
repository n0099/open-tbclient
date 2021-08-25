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
import c.a.p0.s.l.a;
import c.a.p0.s.s.b;
import c.a.p0.t.i.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCOUNT_DELETE = 1;
    public static final int ACCOUNT_SWITCH = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener accountChangedListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public c.a.q0.p.c.a mAccountSafePresenter;
    public c.a.q0.p.a mAdapter;
    public RelativeLayout mContainer;
    public View.OnClickListener mDeleteListener;
    public i mDeleteTask;
    public TextView mEdit;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;
    public c.a.p0.t.i.b mInputUserNameDialog;
    public ListView mList;
    public TextView mListAccountTitle;
    public List<AccountData> mModel;
    public NavigationBar mNavigationBar;
    public l mSwitchTask;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48961a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AccountActivity accountActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48961a = accountActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f48961a.mModel == null) {
                return;
            }
            this.f48961a.InitData();
            if (this.f48961a.mAdapter != null) {
                this.f48961a.mAdapter.b(this.f48961a.mModel);
                this.f48961a.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48962e;

        /* loaded from: classes6.dex */
        public class a implements b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f48963a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f48964b;

            public a(b bVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48964b = bVar;
                this.f48963a = view;
            }

            @Override // c.a.p0.s.s.b.c
            public void a(c.a.p0.s.s.b bVar, int i2, View view) {
                View view2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || (view2 = this.f48963a) == null) {
                    return;
                }
                AccountData accountData = (AccountData) view2.getTag();
                if (i2 != 0) {
                    if (i2 == 1 && accountData != null) {
                        this.f48964b.f48962e.deleteAccount(true, accountData);
                    }
                } else if (accountData != null) {
                    this.f48964b.f48962e.deleteAccount(false, accountData);
                }
                bVar.e();
            }
        }

        public b(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48962e = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String[] strArr = {this.f48962e.getPageContext().getString(R.string.delete_account_only), this.f48962e.getPageContext().getString(R.string.delete_account_and_group_cache), this.f48962e.getPageContext().getString(R.string.cancel)};
                c.a.p0.s.s.b bVar = new c.a.p0.s.s.b(this.f48962e.getPageContext().getPageActivity());
                bVar.k(R.string.inform);
                bVar.j(strArr, new a(this, view));
                bVar.c(this.f48962e.getPageContext());
                bVar.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48965e;

        public c(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48965e = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f48965e.mAdapter.a()) {
                    this.f48965e.mAdapter.c(true);
                    this.f48965e.mEdit.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.f48965e.mEdit, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.f48965e.mEdit, R.color.CAM_X0302, 1);
                    }
                    this.f48965e.mAdapter.notifyDataSetChanged();
                    return;
                }
                this.f48965e.mAdapter.c(false);
                this.f48965e.mEdit.setText(R.string.edit);
                SkinManager.setViewTextColor(this.f48965e.mEdit, R.color.navi_op_text, 1);
                this.f48965e.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48966e;

        public d(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48966e = accountActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AccountData accountData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f48966e.mAdapter.getItemId(i2) >= 0) {
                    if (this.f48966e.mAdapter.a() || (accountData = (AccountData) this.f48966e.mAdapter.getItem(i2)) == null || accountData.getIsActive() == 1) {
                        return;
                    }
                    if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
                        this.f48966e.showInputDialog(accountData);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    this.f48966e.switchAccount(accountData);
                    return;
                }
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.f48966e.getPageContext().getPageActivity());
                loginActivityConfig.setJumpToAfterDestroy(1);
                TbadkCoreApplication.getInst().login(this.f48966e.getPageContext(), new CustomMessage<>(2002001, loginActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48967a;

        public e(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48967a = accountActivity;
        }

        @Override // c.a.p0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                this.f48967a.switchAccount(accountData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48968e;

        public f(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48968e = accountActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f48968e.destroyWaitingDialog();
                this.f48968e.manualOpenSocket("account changed");
                this.f48968e.mSwitchTask = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48970f;

        public g(AccountActivity accountActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48970f = accountActivity;
            this.f48969e = z;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f48970f.destroyWaitingDialog();
                if (this.f48969e) {
                    this.f48970f.manualOpenSocket("account delete cancel");
                }
                this.f48970f.mDeleteTask = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48971a;

        public h(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48971a = accountActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 1) {
                    this.f48971a.doDeleteTask();
                } else if (i2 != 2) {
                } else {
                    Object obj = message.obj;
                    if (obj instanceof AccountData) {
                        this.f48971a.doSwitchTask((AccountData) obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<Object, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AccountData f48972a;

        /* renamed from: b  reason: collision with root package name */
        public int f48973b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48974c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48975d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f48976e;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48976e = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f48976e.f48975d.finish();
                }
            }
        }

        public i(AccountActivity accountActivity, boolean z, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, Boolean.valueOf(z), accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48975d = accountActivity;
            this.f48973b = 0;
            this.f48974c = false;
            this.f48972a = accountData;
            this.f48974c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public AccountData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                if (this.f48972a == null) {
                    return null;
                }
                try {
                    Thread.sleep(1000L);
                } catch (Exception e3) {
                    BdLog.detailException(e3);
                }
                if (this.f48974c) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.f48972a.getID()));
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.f48972a.getID()));
                c.a.q0.p.b.a(this.f48972a.getID());
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
                j2.C("get_addresslist_switch" + this.f48972a.getID());
                if (this.f48972a.getID().equals(currentAccount)) {
                    c.a.p0.t.a.b b2 = c.a.p0.t.a.a.b();
                    if (b2 != null) {
                        b2.a();
                    }
                    this.f48973b = 2;
                } else {
                    c.a.p0.t.a.b b3 = c.a.p0.t.a.a.b();
                    if (b3 != null) {
                        b3.c(this.f48972a);
                    }
                    this.f48973b = 0;
                }
                return null;
            }
            return (AccountData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
                if (this.f48972a != null) {
                    c.a.p0.s.z.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.f48973b), "delete_uid", this.f48972a.getID());
                    new j(this.f48975d, this.f48972a.getBDUSS(), c.a.p0.s.l.e.a(this.f48972a)).start();
                }
                this.f48975d.closeLoadingDialog();
                if (this.f48973b != 0) {
                    c.a.e.e.m.e.a().postDelayed(new a(this), 1000L);
                    c.a.p0.s.z.a.a("account", -1L, 0, "account_activity_delete_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, this.f48975d.getPageContext().getPageActivity());
                }
                int i2 = this.f48973b;
                if (i2 == 0) {
                    AccountActivity accountActivity = this.f48975d;
                    accountActivity.showToast(accountActivity.getPageContext().getString(R.string.success));
                    this.f48975d.mModel.remove(this.f48972a);
                    this.f48972a = null;
                    this.f48975d.mAdapter.notifyDataSetChanged();
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.f48975d.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                }
                this.f48975d.mDeleteTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f48977e;

        /* renamed from: f  reason: collision with root package name */
        public String f48978f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48979g;

        public j(AccountActivity accountActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48979g = accountActivity;
            this.f48977e = null;
            this.f48978f = null;
            this.f48977e = str;
            this.f48978f = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.run();
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/logout");
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.addPostData("BDUSS", this.f48977e);
                netWork.addPostData("stoken", this.f48978f);
                netWork.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                netWork.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                netWork.postNetData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements a.InterfaceC0689a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AccountData f48980a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48981b;

        public k(AccountActivity accountActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48981b = accountActivity;
            this.f48980a = accountData;
        }

        @Override // c.a.p0.s.l.a.InterfaceC0689a
        public void a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                c.a.p0.s.z.a.a("account", -1L, 0, "account_change_cslogin_fail", i2, str2, "uname", str);
                this.f48981b.closeLoadingDialog();
                this.f48981b.showToast(str2);
                if (i2 != 1 || this.f48980a == null) {
                    return;
                }
                ReloginManager.g().f(this.f48980a);
                this.f48981b.deleteAccount(false, this.f48980a);
            }
        }

        @Override // c.a.p0.s.l.a.InterfaceC0689a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.p0.s.l.a.InterfaceC0689a
        public void c(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                c.a.p0.s.z.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", 1));
                this.f48981b.doSwitchTask(accountData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends BdAsyncTask<Object, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AccountData f48982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f48983b;

        public l(AccountActivity accountActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48983b = accountActivity;
            this.f48982a = null;
            this.f48982a = accountData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    this.f48982a.setIsActive(1);
                    c.a.p0.s.l.c.g(this.f48982a);
                    c.a.p0.t.a.b b2 = c.a.p0.t.a.a.b();
                    if (b2 != null) {
                        b2.b(this.f48982a);
                    }
                } catch (Exception e3) {
                    BdLog.detailException(e3);
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                this.f48983b.handleChangeSuccess(this.f48982a);
            }
        }
    }

    public AccountActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mModel = null;
        this.mAdapter = null;
        this.mList = null;
        this.mContainer = null;
        this.mEdit = null;
        this.mDeleteListener = null;
        this.mSwitchTask = null;
        this.mDeleteTask = null;
        this.mInputUserNameDialog = null;
        this.mAccountLoginTask = null;
        this.accountChangedListener = new a(this, 2005016);
        this.mHandler = new h(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InitData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mModel = c.a.p0.s.l.c.f();
        }
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mContainer = (RelativeLayout) findViewById(R.id.account_container);
            this.mDeleteListener = new b(this);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.account_manager));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.mEdit = textView;
            textView.setText(getPageContext().getString(R.string.edit));
            SkinManager.setViewTextColor(this.mEdit, R.color.navi_op_text, 1);
            addCustomView.setOnClickListener(new c(this));
            c.a.q0.p.a aVar = new c.a.q0.p.a(this, this.mDeleteListener);
            this.mAdapter = aVar;
            aVar.b(this.mModel);
            this.mList = (ListView) findViewById(R.id.list);
            TextView textView2 = new TextView(getActivity());
            textView2.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
            this.mList.addHeaderView(textView2);
            addAccountListTitle();
            this.mList.setAdapter((ListAdapter) this.mAdapter);
            this.mList.setOnItemClickListener(new d(this));
            addAccountSafeView();
        }
    }

    private void addAccountListTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            TextView textView = new TextView(this);
            this.mListAccountTitle = textView;
            textView.setGravity(16);
            this.mListAccountTitle.setPadding(c.a.e.e.p.l.g(this, R.dimen.tbds44), 0, 0, 0);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, c.a.e.e.p.l.g(this, R.dimen.tbds74));
            this.mListAccountTitle.setTextSize(0, c.a.e.e.p.l.g(this, R.dimen.tbds33));
            this.mListAccountTitle.setText(R.string.account_manager);
            this.mListAccountTitle.setLayoutParams(layoutParams);
            this.mList.addHeaderView(this.mListAccountTitle);
        }
    }

    private void addAccountSafeView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            View d2 = this.mAccountSafePresenter.d();
            d2.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
            this.mList.addFooterView(d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAccount(boolean z, AccountData accountData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65554, this, z, accountData) == null) && this.mDeleteTask == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                c.a.p0.e0.a.b(0, 0, 0, 2, 3);
                manualCloseSocket("account delete");
            }
            showLoadingDialog(getPageContext().getString(R.string.deleting), new g(this, z2));
            i iVar = new i(this, z, accountData);
            this.mDeleteTask = iVar;
            iVar.setPriority(3);
            doDeleteTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDeleteTask() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || this.mDeleteTask == null) {
            return;
        }
        if (hasProcessingTask()) {
            this.mHandler.removeMessages(1);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(1), 200L);
            return;
        }
        this.mDeleteTask.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSwitchTask(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, accountData) == null) {
            l lVar = new l(this, accountData);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeSuccess(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, accountData) == null) {
            c.a.p0.s.z.a.a("account", -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            closeLoadingDialog();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            TbadkCoreApplication.getInst().onUserChanged();
            c.a.p0.s.a0.b.g(getPageContext().getPageActivity(), 2, false);
            this.mSwitchTask = null;
        }
    }

    private boolean hasProcessingTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? MessageManager.getInstance().getSocketClient().s() > 0 : invokeV.booleanValue;
    }

    private void manualCloseSocket(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            BdSocketLinkService.setHasAbsoluteClose(true);
            MessageManager.getInstance().getSocketClient().j();
            BdSocketLinkService.setAvailable(false);
            BdSocketLinkService.close(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manualOpenSocket(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.startService(true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputDialog(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, accountData) == null) {
            if (this.mInputUserNameDialog == null) {
                c.a.p0.t.i.b bVar = new c.a.p0.t.i.b(this);
                this.mInputUserNameDialog = bVar;
                bVar.w(new e(this));
            }
            this.mInputUserNameDialog.p();
            this.mInputUserNameDialog.u(accountData);
            this.mInputUserNameDialog.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchAccount(AccountData accountData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, this, accountData) == null) && this.mSwitchTask == null) {
            c.a.p0.e0.a.b(0, 0, 0, 2, 2);
            manualCloseSocket("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new f(this));
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = c.a.p0.s.l.a.b().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new k(this, accountData));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setViewTextColor(this.mListAccountTitle, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.mListAccountTitle, R.color.CAM_X0204);
            this.mAccountSafePresenter.e(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mContainer);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.account_activity);
            InitData();
            this.mAccountSafePresenter = new c.a.q0.p.c.a(this);
            InitUI();
            registerListener(this.accountChangedListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
}
