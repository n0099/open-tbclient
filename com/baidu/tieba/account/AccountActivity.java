package com.baidu.tieba.account;

import android.annotation.SuppressLint;
import android.app.Dialog;
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
import c.a.d.f.p.m;
import c.a.r0.s.m.a;
import c.a.r0.s.t.b;
import c.a.r0.t.i.b;
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
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
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
/* loaded from: classes11.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCOUNT_DELETE = 1;
    public static final int ACCOUNT_SWITCH = 2;
    public static final int MAX_ACCOUNT_SIZE = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener accountChangedListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public c.a.s0.u.c.a mAccountSafePresenter;
    public c.a.s0.u.a mAdapter;
    public RelativeLayout mContainer;
    public View.OnClickListener mDeleteListener;
    public i mDeleteTask;
    public TextView mEdit;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;
    public c.a.r0.t.i.b mInputUserNameDialog;
    public ListView mList;
    public TextView mListAccountTitle;
    public List<AccountData> mModel;
    public NavigationBar mNavigationBar;
    public l mSwitchTask;

    /* loaded from: classes11.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

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
            this.a = accountActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.mModel == null) {
                return;
            }
            this.a.InitData();
            if (this.a.mAdapter != null) {
                this.a.mAdapter.b(this.a.mModel);
                this.a.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43018e;

        /* loaded from: classes11.dex */
        public class a implements b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f43019b;

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
                this.f43019b = bVar;
                this.a = view;
            }

            @Override // c.a.r0.s.t.b.c
            public void a(c.a.r0.s.t.b bVar, int i2, View view) {
                View view2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || (view2 = this.a) == null) {
                    return;
                }
                AccountData accountData = (AccountData) view2.getTag();
                if (i2 != 0) {
                    if (i2 == 1 && accountData != null) {
                        this.f43019b.f43018e.deleteAccount(true, accountData);
                    }
                } else if (accountData != null) {
                    this.f43019b.f43018e.deleteAccount(false, accountData);
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
            this.f43018e = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String[] strArr = {this.f43018e.getPageContext().getString(R.string.delete_account_only), this.f43018e.getPageContext().getString(R.string.delete_account_and_group_cache), this.f43018e.getPageContext().getString(R.string.cancel)};
                c.a.r0.s.t.b bVar = new c.a.r0.s.t.b(this.f43018e.getPageContext().getPageActivity());
                bVar.k(R.string.inform);
                bVar.j(strArr, new a(this, view));
                bVar.c(this.f43018e.getPageContext());
                bVar.m();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43020e;

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
            this.f43020e = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f43020e.mAdapter.a()) {
                    this.f43020e.mAdapter.c(true);
                    this.f43020e.mEdit.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.f43020e.mEdit, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.f43020e.mEdit, R.color.CAM_X0302, 1);
                    }
                    this.f43020e.mAdapter.notifyDataSetChanged();
                    return;
                }
                this.f43020e.mAdapter.c(false);
                this.f43020e.mEdit.setText(R.string.edit);
                SkinManager.setViewTextColor(this.f43020e.mEdit, R.color.navi_op_text, 1);
                this.f43020e.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43021e;

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Dialog f43022e;

            public a(d dVar, Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, dialog};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43022e = dialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f43022e.dismiss();
                }
            }
        }

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
            this.f43021e = accountActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AccountData accountData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                boolean z = this.f43021e.mAdapter.getItemId(i2) < 0;
                if (ListUtils.getCount(this.f43021e.mModel) > 10 || (z && ListUtils.getCount(this.f43021e.mModel) == 10)) {
                    TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.account_dialog_ok, TBAlertConfig.OperateBtnStyle.MAIN);
                    c.a.r0.s.t.l lVar = new c.a.r0.s.t.l(this.f43021e.getActivity());
                    lVar.q(R.string.account_dialog_title);
                    lVar.j(R.string.too_many_account);
                    lVar.p(aVar);
                    lVar.g(false);
                    aVar.a(new a(this, lVar.t()));
                } else if (!z) {
                    if (this.f43021e.mAdapter.a() || (accountData = (AccountData) this.f43021e.mAdapter.getItem(i2)) == null || accountData.getIsActive() == 1) {
                        return;
                    }
                    if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
                        this.f43021e.showInputDialog(accountData);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    this.f43021e.switchAccount(accountData);
                } else {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.f43021e.getPageContext().getPageActivity());
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    TbadkCoreApplication.getInst().login(this.f43021e.getPageContext(), new CustomMessage<>(2002001, loginActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

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
            this.a = accountActivity;
        }

        @Override // c.a.r0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                this.a.switchAccount(accountData);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43023e;

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
            this.f43023e = accountActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f43023e.destroyWaitingDialog();
                this.f43023e.manualOpenSocket("account changed");
                this.f43023e.mSwitchTask = null;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f43024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43025f;

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
            this.f43025f = accountActivity;
            this.f43024e = z;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f43025f.destroyWaitingDialog();
                if (this.f43024e) {
                    this.f43025f.manualOpenSocket("account delete cancel");
                }
                this.f43025f.mDeleteTask = null;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class h extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

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
            this.a = accountActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 1) {
                    this.a.doDeleteTask();
                } else if (i2 != 2) {
                } else {
                    Object obj = message.obj;
                    if (obj instanceof AccountData) {
                        this.a.doSwitchTask((AccountData) obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class i extends BdAsyncTask<Object, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;

        /* renamed from: b  reason: collision with root package name */
        public int f43026b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43027c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43028d;

        /* loaded from: classes11.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f43029e;

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
                this.f43029e = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43029e.f43028d.finish();
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
            this.f43028d = accountActivity;
            this.f43026b = 0;
            this.f43027c = false;
            this.a = accountData;
            this.f43027c = z;
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
                if (this.a == null) {
                    return null;
                }
                try {
                    Thread.sleep(1000L);
                } catch (Exception e3) {
                    BdLog.detailException(e3);
                }
                if (this.f43027c) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.a.getID()));
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.a.getID()));
                c.a.s0.u.b.a(this.a.getID());
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                c.a.r0.s.g0.b j2 = c.a.r0.s.g0.b.j();
                j2.C("get_addresslist_switch" + this.a.getID());
                if (this.a.getID().equals(currentAccount)) {
                    c.a.r0.t.a.b b2 = c.a.r0.t.a.a.b();
                    if (b2 != null) {
                        b2.a();
                    }
                    this.f43026b = 2;
                } else {
                    c.a.r0.t.a.b b3 = c.a.r0.t.a.a.b();
                    if (b3 != null) {
                        b3.c(this.a);
                    }
                    this.f43026b = 0;
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
                if (this.a != null) {
                    c.a.r0.s.c0.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.f43026b), "delete_uid", this.a.getID());
                    new j(this.f43028d, this.a.getBDUSS(), c.a.r0.s.m.e.a(this.a)).start();
                }
                this.f43028d.closeLoadingDialog();
                if (this.f43026b != 0) {
                    c.a.d.f.m.e.a().postDelayed(new a(this), 1000L);
                    c.a.r0.s.c0.a.a("account", -1L, 0, "account_activity_delete_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, this.f43028d.getPageContext().getPageActivity());
                }
                int i2 = this.f43026b;
                if (i2 == 0) {
                    AccountActivity accountActivity = this.f43028d;
                    accountActivity.showToast(accountActivity.getPageContext().getString(R.string.success));
                    this.f43028d.mModel.remove(this.a);
                    this.a = null;
                    this.f43028d.mAdapter.notifyDataSetChanged();
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.f43028d.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                }
                this.f43028d.mDeleteTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f43030e;

        /* renamed from: f  reason: collision with root package name */
        public String f43031f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43032g;

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
            this.f43032g = accountActivity;
            this.f43030e = null;
            this.f43031f = null;
            this.f43030e = str;
            this.f43031f = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.run();
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/logout");
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.addPostData(HttpRequest.BDUSS, this.f43030e);
                netWork.addPostData("stoken", this.f43031f);
                netWork.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                netWork.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                netWork.postNetData();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class k implements a.InterfaceC0840a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43033b;

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
            this.f43033b = accountActivity;
            this.a = accountData;
        }

        @Override // c.a.r0.s.m.a.InterfaceC0840a
        public void onBeforeLogin(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.r0.s.m.a.InterfaceC0840a
        public void onFailure(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
                c.a.r0.s.c0.a.a("account", -1L, 0, "account_change_cslogin_fail", i2, str2, "uname", str);
                this.f43033b.closeLoadingDialog();
                this.f43033b.showToast(str2);
                if (i2 != 1 || this.a == null) {
                    return;
                }
                ReloginManager.g().f(this.a);
                this.f43033b.deleteAccount(false, this.a);
            }
        }

        @Override // c.a.r0.s.m.a.InterfaceC0840a
        public void onSuccess(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                c.a.r0.s.c0.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", 1));
                this.f43033b.doSwitchTask(accountData);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class l extends BdAsyncTask<Object, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f43034b;

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
            this.f43034b = accountActivity;
            this.a = null;
            this.a = accountData;
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
                    this.a.setIsActive(1);
                    c.a.r0.s.m.c.g(this.a);
                    c.a.r0.t.a.b b2 = c.a.r0.t.a.a.b();
                    if (b2 != null) {
                        b2.b(this.a);
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
                this.f43034b.handleChangeSuccess(this.a);
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
            this.mModel = c.a.r0.s.m.c.f();
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
            c.a.s0.u.a aVar = new c.a.s0.u.a(this, this.mDeleteListener);
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
            this.mListAccountTitle.setPadding(m.f(this, R.dimen.tbds44), 0, 0, 0);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, m.f(this, R.dimen.tbds74));
            this.mListAccountTitle.setTextSize(0, m.f(this, R.dimen.tbds33));
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
                c.a.r0.f0.a.b(0, 0, 0, 2, 3);
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
            c.a.r0.s.c0.a.a("account", -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            closeLoadingDialog();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            TbadkCoreApplication.getInst().onUserChanged();
            c.a.r0.s.d0.b.g(getPageContext().getPageActivity(), 2, false);
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
                c.a.r0.t.i.b bVar = new c.a.r0.t.i.b(this);
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
            c.a.r0.f0.a.b(0, 0, 0, 2, 2);
            manualCloseSocket("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new f(this));
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = c.a.r0.s.m.a.b().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new k(this, accountData));
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
            this.mAccountSafePresenter = new c.a.s0.u.c.a(this);
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
