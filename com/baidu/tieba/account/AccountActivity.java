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
import b.a.q0.s.l.a;
import b.a.q0.s.s.b;
import b.a.q0.t.i.b;
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
/* loaded from: classes9.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCOUNT_DELETE = 1;
    public static final int ACCOUNT_SWITCH = 2;
    public static final int MAX_ACCOUNT_SIZE = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener accountChangedListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public b.a.r0.q.c.a mAccountSafePresenter;
    public b.a.r0.q.a mAdapter;
    public RelativeLayout mContainer;
    public View.OnClickListener mDeleteListener;
    public i mDeleteTask;
    public TextView mEdit;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;
    public b.a.q0.t.i.b mInputUserNameDialog;
    public ListView mList;
    public TextView mListAccountTitle;
    public List<AccountData> mModel;
    public NavigationBar mNavigationBar;
    public l mSwitchTask;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46606a;

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
            this.f46606a = accountActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f46606a.mModel == null) {
                return;
            }
            this.f46606a.InitData();
            if (this.f46606a.mAdapter != null) {
                this.f46606a.mAdapter.b(this.f46606a.mModel);
                this.f46606a.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46607e;

        /* loaded from: classes9.dex */
        public class a implements b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f46608a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f46609b;

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
                this.f46609b = bVar;
                this.f46608a = view;
            }

            @Override // b.a.q0.s.s.b.c
            public void a(b.a.q0.s.s.b bVar, int i2, View view) {
                View view2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || (view2 = this.f46608a) == null) {
                    return;
                }
                AccountData accountData = (AccountData) view2.getTag();
                if (i2 != 0) {
                    if (i2 == 1 && accountData != null) {
                        this.f46609b.f46607e.deleteAccount(true, accountData);
                    }
                } else if (accountData != null) {
                    this.f46609b.f46607e.deleteAccount(false, accountData);
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
            this.f46607e = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String[] strArr = {this.f46607e.getPageContext().getString(R.string.delete_account_only), this.f46607e.getPageContext().getString(R.string.delete_account_and_group_cache), this.f46607e.getPageContext().getString(R.string.cancel)};
                b.a.q0.s.s.b bVar = new b.a.q0.s.s.b(this.f46607e.getPageContext().getPageActivity());
                bVar.k(R.string.inform);
                bVar.j(strArr, new a(this, view));
                bVar.c(this.f46607e.getPageContext());
                bVar.m();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46610e;

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
            this.f46610e = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f46610e.mAdapter.a()) {
                    this.f46610e.mAdapter.c(true);
                    this.f46610e.mEdit.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.f46610e.mEdit, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.f46610e.mEdit, R.color.CAM_X0302, 1);
                    }
                    this.f46610e.mAdapter.notifyDataSetChanged();
                    return;
                }
                this.f46610e.mAdapter.c(false);
                this.f46610e.mEdit.setText(R.string.edit);
                SkinManager.setViewTextColor(this.f46610e.mEdit, R.color.navi_op_text, 1);
                this.f46610e.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46611e;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Dialog f46612e;

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
                this.f46612e = dialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46612e.dismiss();
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
            this.f46611e = accountActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            AccountData accountData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                boolean z = this.f46611e.mAdapter.getItemId(i2) < 0;
                if (ListUtils.getCount(this.f46611e.mModel) > 10 || (z && ListUtils.getCount(this.f46611e.mModel) == 10)) {
                    TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.account_dialog_ok, TBAlertConfig.OperateBtnStyle.MAIN);
                    b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f46611e.getActivity());
                    lVar.q(R.string.account_dialog_title);
                    lVar.j(R.string.too_many_account);
                    lVar.p(aVar);
                    lVar.g(false);
                    aVar.a(new a(this, lVar.t()));
                } else if (!z) {
                    if (this.f46611e.mAdapter.a() || (accountData = (AccountData) this.f46611e.mAdapter.getItem(i2)) == null || accountData.getIsActive() == 1) {
                        return;
                    }
                    if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
                        this.f46611e.showInputDialog(accountData);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    this.f46611e.switchAccount(accountData);
                } else {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.f46611e.getPageContext().getPageActivity());
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    TbadkCoreApplication.getInst().login(this.f46611e.getPageContext(), new CustomMessage<>(2002001, loginActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46613a;

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
            this.f46613a = accountActivity;
        }

        @Override // b.a.q0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                this.f46613a.switchAccount(accountData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46614e;

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
            this.f46614e = accountActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f46614e.destroyWaitingDialog();
                this.f46614e.manualOpenSocket("account changed");
                this.f46614e.mSwitchTask = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46615e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46616f;

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
            this.f46616f = accountActivity;
            this.f46615e = z;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f46616f.destroyWaitingDialog();
                if (this.f46615e) {
                    this.f46616f.manualOpenSocket("account delete cancel");
                }
                this.f46616f.mDeleteTask = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46617a;

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
            this.f46617a = accountActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 1) {
                    this.f46617a.doDeleteTask();
                } else if (i2 != 2) {
                } else {
                    Object obj = message.obj;
                    if (obj instanceof AccountData) {
                        this.f46617a.doSwitchTask((AccountData) obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends BdAsyncTask<Object, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AccountData f46618a;

        /* renamed from: b  reason: collision with root package name */
        public int f46619b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f46620c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46621d;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f46622e;

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
                this.f46622e = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46622e.f46621d.finish();
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
            this.f46621d = accountActivity;
            this.f46619b = 0;
            this.f46620c = false;
            this.f46618a = accountData;
            this.f46620c = z;
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
                if (this.f46618a == null) {
                    return null;
                }
                try {
                    Thread.sleep(1000L);
                } catch (Exception e3) {
                    BdLog.detailException(e3);
                }
                if (this.f46620c) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.f46618a.getID()));
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.f46618a.getID()));
                b.a.r0.q.b.a(this.f46618a.getID());
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                j.C("get_addresslist_switch" + this.f46618a.getID());
                if (this.f46618a.getID().equals(currentAccount)) {
                    b.a.q0.t.a.b b2 = b.a.q0.t.a.a.b();
                    if (b2 != null) {
                        b2.a();
                    }
                    this.f46619b = 2;
                } else {
                    b.a.q0.t.a.b b3 = b.a.q0.t.a.a.b();
                    if (b3 != null) {
                        b3.c(this.f46618a);
                    }
                    this.f46619b = 0;
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
                if (this.f46618a != null) {
                    b.a.q0.s.a0.a.a("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.f46619b), "delete_uid", this.f46618a.getID());
                    new j(this.f46621d, this.f46618a.getBDUSS(), b.a.q0.s.l.e.a(this.f46618a)).start();
                }
                this.f46621d.closeLoadingDialog();
                if (this.f46619b != 0) {
                    b.a.e.e.m.e.a().postDelayed(new a(this), 1000L);
                    b.a.q0.s.a0.a.a("account", -1L, 0, "account_activity_delete_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, this.f46621d.getPageContext().getPageActivity());
                }
                int i2 = this.f46619b;
                if (i2 == 0) {
                    AccountActivity accountActivity = this.f46621d;
                    accountActivity.showToast(accountActivity.getPageContext().getString(R.string.success));
                    this.f46621d.mModel.remove(this.f46618a);
                    this.f46618a = null;
                    this.f46621d.mAdapter.notifyDataSetChanged();
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.f46621d.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                }
                this.f46621d.mDeleteTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f46623e;

        /* renamed from: f  reason: collision with root package name */
        public String f46624f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46625g;

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
            this.f46625g = accountActivity;
            this.f46623e = null;
            this.f46624f = null;
            this.f46623e = str;
            this.f46624f = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.run();
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/logout");
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.addPostData(HttpRequest.BDUSS, this.f46623e);
                netWork.addPostData("stoken", this.f46624f);
                netWork.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                netWork.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                netWork.postNetData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements a.InterfaceC0685a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AccountData f46626a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46627b;

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
            this.f46627b = accountActivity;
            this.f46626a = accountData;
        }

        @Override // b.a.q0.s.l.a.InterfaceC0685a
        public void a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                b.a.q0.s.a0.a.a("account", -1L, 0, "account_change_cslogin_fail", i2, str2, "uname", str);
                this.f46627b.closeLoadingDialog();
                this.f46627b.showToast(str2);
                if (i2 != 1 || this.f46626a == null) {
                    return;
                }
                ReloginManager.g().f(this.f46626a);
                this.f46627b.deleteAccount(false, this.f46626a);
            }
        }

        @Override // b.a.q0.s.l.a.InterfaceC0685a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // b.a.q0.s.l.a.InterfaceC0685a
        public void c(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                b.a.q0.s.a0.a.a("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", 1));
                this.f46627b.doSwitchTask(accountData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends BdAsyncTask<Object, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AccountData f46628a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f46629b;

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
            this.f46629b = accountActivity;
            this.f46628a = null;
            this.f46628a = accountData;
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
                    this.f46628a.setIsActive(1);
                    b.a.q0.s.l.c.g(this.f46628a);
                    b.a.q0.t.a.b b2 = b.a.q0.t.a.a.b();
                    if (b2 != null) {
                        b2.b(this.f46628a);
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
                this.f46629b.handleChangeSuccess(this.f46628a);
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
            this.mModel = b.a.q0.s.l.c.f();
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
            b.a.r0.q.a aVar = new b.a.r0.q.a(this, this.mDeleteListener);
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
            this.mListAccountTitle.setPadding(b.a.e.e.p.l.g(this, R.dimen.tbds44), 0, 0, 0);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, b.a.e.e.p.l.g(this, R.dimen.tbds74));
            this.mListAccountTitle.setTextSize(0, b.a.e.e.p.l.g(this, R.dimen.tbds33));
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
                b.a.q0.f0.a.b(0, 0, 0, 2, 3);
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
            b.a.q0.s.a0.a.a("account", -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            closeLoadingDialog();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            TbadkCoreApplication.getInst().onUserChanged();
            b.a.q0.s.b0.b.g(getPageContext().getPageActivity(), 2, false);
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
                b.a.q0.t.i.b bVar = new b.a.q0.t.i.b(this);
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
            b.a.q0.f0.a.b(0, 0, 0, 2, 2);
            manualCloseSocket("account changed");
            showLoadingDialog(getPageContext().getString(R.string.account_logining), new f(this));
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = b.a.q0.s.l.a.b().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new k(this, accountData));
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
            this.mAccountSafePresenter = new b.a.r0.q.c.a(this);
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
