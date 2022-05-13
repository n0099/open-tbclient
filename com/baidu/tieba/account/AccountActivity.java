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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
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
import com.repackage.bs4;
import com.repackage.du4;
import com.repackage.iu4;
import com.repackage.jj5;
import com.repackage.kj5;
import com.repackage.kz4;
import com.repackage.lj5;
import com.repackage.mi;
import com.repackage.mn4;
import com.repackage.ng;
import com.repackage.on4;
import com.repackage.pr4;
import com.repackage.pw4;
import com.repackage.q45;
import com.repackage.qn4;
import com.repackage.qw4;
import com.repackage.xt4;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCOUNT_DELETE = 1;
    public static final int ACCOUNT_SWITCH = 2;
    public static final int MAX_ACCOUNT_SIZE = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener accountChangedListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public lj5 mAccountSafePresenter;
    public jj5 mAdapter;
    public RelativeLayout mContainer;
    public View.OnClickListener mDeleteListener;
    public i mDeleteTask;
    public TextView mEdit;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;
    public kz4 mInputUserNameDialog;
    public ListView mList;
    public TextView mListAccountTitle;
    public List<AccountData> mModel;
    public NavigationBar mNavigationBar;
    public l mSwitchTask;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AccountActivity accountActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

        /* loaded from: classes3.dex */
        public class a implements pr4.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;
            public final /* synthetic */ b b;

            public a(b bVar, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = view2;
            }

            @Override // com.repackage.pr4.c
            public void a(pr4 pr4Var, int i, View view2) {
                View view3;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLIL(1048576, this, pr4Var, i, view2) == null) || (view3 = this.a) == null) {
                    return;
                }
                AccountData accountData = (AccountData) view3.getTag();
                if (i != 0) {
                    if (i == 1 && accountData != null) {
                        this.b.a.deleteAccount(true, accountData);
                    }
                } else if (accountData != null) {
                    this.b.a.deleteAccount(false, accountData);
                }
                pr4Var.e();
            }
        }

        public b(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f049f), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f049e), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0374)};
                pr4 pr4Var = new pr4(this.a.getPageContext().getPageActivity());
                pr4Var.k(R.string.obfuscated_res_0x7f0f08df);
                pr4Var.j(strArr, new a(this, view2));
                pr4Var.c(this.a.getPageContext());
                pr4Var.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

        public c(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.mAdapter.a()) {
                    this.a.mAdapter.c(true);
                    this.a.mEdit.setText(R.string.obfuscated_res_0x7f0f04ed);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.a.mEdit, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.a.mEdit, R.color.CAM_X0302, 1);
                    }
                    this.a.mAdapter.notifyDataSetChanged();
                    return;
                }
                this.a.mAdapter.c(false);
                this.a.mEdit.setText(R.string.obfuscated_res_0x7f0f0519);
                SkinManager.setViewTextColor(this.a.mEdit, R.color.navi_op_text, 1);
                this.a.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Dialog a;

            public a(d dVar, Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, dialog};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.dismiss();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            AccountData accountData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = this.a.mAdapter.getItemId(i) < 0;
                if (ListUtils.getCount(this.a.mModel) > 10 || (z && ListUtils.getCount(this.a.mModel) == 10)) {
                    TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f006d, TBAlertConfig.OperateBtnStyle.MAIN);
                    bs4 bs4Var = new bs4(this.a.getActivity());
                    bs4Var.v(R.string.obfuscated_res_0x7f0f006e);
                    bs4Var.l(R.string.obfuscated_res_0x7f0f142a);
                    bs4Var.r(aVar);
                    bs4Var.i(false);
                    aVar.a(new a(this, bs4Var.y()));
                } else if (!z) {
                    if (this.a.mAdapter.a() || (accountData = (AccountData) this.a.mAdapter.getItem(i)) == null || accountData.getIsActive() == 1) {
                        return;
                    }
                    if (TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() && TextUtils.isEmpty(accountData.getAccount())) {
                        this.a.showInputDialog(accountData);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                    this.a.switchAccount(accountData);
                } else {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.a.getPageContext().getPageActivity());
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, loginActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements kz4.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountActivity;
        }

        @Override // com.repackage.kz4.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                this.a.switchAccount(accountData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

        public f(AccountActivity accountActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
                this.a.manualOpenSocket("account changed");
                this.a.mSwitchTask = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ AccountActivity b;

        public g(AccountActivity accountActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = accountActivity;
            this.a = z;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.b.destroyWaitingDialog();
                if (this.a) {
                    this.b.manualOpenSocket("account delete cancel");
                }
                this.b.mDeleteTask = null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i == 1) {
                    this.a.doDeleteTask();
                } else if (i != 2) {
                } else {
                    Object obj = message.obj;
                    if (obj instanceof AccountData) {
                        this.a.doSwitchTask((AccountData) obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<Object, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;
        public int b;
        public boolean c;
        public final /* synthetic */ AccountActivity d;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.d.finish();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = accountActivity;
            this.b = 0;
            this.c = false;
            this.a = accountData;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public AccountData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (this.a == null) {
                    return null;
                }
                try {
                    Thread.sleep(1000L);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                if (this.c) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.a.getID()));
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, this.a.getID()));
                kj5.a(this.a.getID());
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                iu4 k = iu4.k();
                k.D("get_addresslist_switch" + this.a.getID());
                if (this.a.getID().equals(currentAccount)) {
                    qw4 b = pw4.b();
                    if (b != null) {
                        b.a();
                    }
                    this.b = 2;
                } else {
                    qw4 b2 = pw4.b();
                    if (b2 != null) {
                        b2.c(this.a);
                    }
                    this.b = 0;
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
                    xt4.a(DI.ACCOUNT, -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.b), "delete_uid", this.a.getID());
                    new j(this.d, this.a.getBDUSS(), qn4.a(this.a)).start();
                }
                this.d.closeLoadingDialog();
                if (this.b != 0) {
                    ng.a().postDelayed(new a(this), 1000L);
                    xt4.a(DI.ACCOUNT, -1L, 0, "account_activity_delete_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, this.d.getPageContext().getPageActivity());
                }
                int i = this.b;
                if (i == 0) {
                    AccountActivity accountActivity = this.d;
                    accountActivity.showToast(accountActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1217));
                    this.d.mModel.remove(this.a);
                    this.a = null;
                    this.d.mAdapter.notifyDataSetChanged();
                } else if (i == 2) {
                    TbadkCoreApplication.getInst().onUserChanged();
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.d.getPageContext().getPageActivity(), true);
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                }
                this.d.mDeleteTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ AccountActivity c;

        public j(AccountActivity accountActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = accountActivity;
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.run();
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/logout");
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.addPostData(HttpRequest.BDUSS, this.a);
                netWork.addPostData("stoken", this.b);
                netWork.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                netWork.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                netWork.postNetData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements mn4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;
        public final /* synthetic */ AccountActivity b;

        public k(AccountActivity accountActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = accountActivity;
            this.a = accountData;
        }

        @Override // com.repackage.mn4.a
        public void a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                xt4.a(DI.ACCOUNT, -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
                this.b.closeLoadingDialog();
                this.b.showToast(str2);
                if (i != 1 || this.a == null) {
                    return;
                }
                ReloginManager.g().f(this.a);
                this.b.deleteAccount(false, this.a);
            }
        }

        @Override // com.repackage.mn4.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.repackage.mn4.a
        public void c(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                xt4.a(DI.ACCOUNT, -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", 1).param("obj_param1", "account_change"));
                this.b.doSwitchTask(accountData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends BdAsyncTask<Object, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;
        public final /* synthetic */ AccountActivity b;

        public l(AccountActivity accountActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = accountActivity;
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
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    this.a.setIsActive(1);
                    on4.g(this.a);
                    qw4 b = pw4.b();
                    if (b != null) {
                        b.b(this.a);
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
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
                this.b.handleChangeSuccess(this.a);
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
            this.mModel = on4.f();
        }
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090052);
            this.mDeleteListener = new b(this);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f007a));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05d9, (View.OnClickListener) null);
            TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091af7);
            this.mEdit = textView;
            textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0519));
            SkinManager.setViewTextColor(this.mEdit, R.color.navi_op_text, 1);
            addCustomView.setOnClickListener(new c(this));
            jj5 jj5Var = new jj5(this, this.mDeleteListener);
            this.mAdapter = jj5Var;
            jj5Var.b(this.mModel);
            this.mList = (ListView) findViewById(R.id.obfuscated_res_0x7f09127a);
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
            this.mListAccountTitle.setPadding(mi.f(this, R.dimen.tbds44), 0, 0, 0);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, mi.f(this, R.dimen.tbds74));
            this.mListAccountTitle.setTextSize(0, mi.f(this, R.dimen.tbds33));
            this.mListAccountTitle.setText(R.string.obfuscated_res_0x7f0f007a);
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
                q45.b(0, 0, 0, 2, 3);
                manualCloseSocket("account delete");
            }
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f04b7), new g(this, z2));
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
            xt4.a(DI.ACCOUNT, -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            closeLoadingDialog();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            TbadkCoreApplication.getInst().onUserChanged();
            du4.g(getPageContext().getPageActivity(), 2, false);
            this.mSwitchTask = null;
        }
    }

    private boolean hasProcessingTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? MessageManager.getInstance().getSocketClient().r() > 0 : invokeV.booleanValue;
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
                kz4 kz4Var = new kz4(this);
                this.mInputUserNameDialog = kz4Var;
                kz4Var.w(new e(this));
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
            q45.b(0, 0, 0, 2, 2);
            manualCloseSocket("account changed");
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f0079), new f(this));
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = mn4.b().a(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new k(this, accountData));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setViewTextColor(this.mListAccountTitle, (int) R.color.CAM_X0109);
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
            setContentView(R.layout.obfuscated_res_0x7f0d001f);
            InitData();
            this.mAccountSafePresenter = new lj5(this);
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
