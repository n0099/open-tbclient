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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.fc5;
import com.baidu.tieba.gc5;
import com.baidu.tieba.o05;
import com.baidu.tieba.p05;
import com.baidu.tieba.p56;
import com.baidu.tieba.pn5;
import com.baidu.tieba.qg5;
import com.baidu.tieba.r56;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public List<AccountData> b;
    public p56 c;
    public ListView d;
    public RelativeLayout e;
    public r56 f;
    public NavigationBar g;
    public TextView h;
    public View.OnClickListener i;
    public l j;
    public i k;
    public qg5 l;
    public BdAsyncTask<?, ?, ?> m;
    public CustomMessageListener n;
    public TextView o;
    @SuppressLint({"HandlerLeak"})
    public Handler p;

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

        /* loaded from: classes5.dex */
        public class a implements z45.c {
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

            @Override // com.baidu.tieba.z45.c
            public void a(z45 z45Var, int i, View view2) {
                View view3;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLIL(1048576, this, z45Var, i, view2) != null) || (view3 = this.a) == null) {
                    return;
                }
                AccountData accountData = (AccountData) view3.getTag();
                if (i != 0) {
                    if (i == 1 && accountData != null) {
                        this.b.a.K1(true, accountData);
                    }
                } else if (accountData != null) {
                    this.b.a.K1(false, accountData);
                }
                z45Var.e();
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
                String[] strArr = {this.a.getPageContext().getString(R.string.delete_account_only), this.a.getPageContext().getString(R.string.delete_account_and_group_cache), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f03d0)};
                z45 z45Var = new z45(this.a.getPageContext().getPageActivity());
                z45Var.k(R.string.obfuscated_res_0x7f0f0a9a);
                z45Var.j(strArr, new a(this, view2));
                z45Var.c(this.a.getPageContext());
                z45Var.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountActivity a;

        /* loaded from: classes5.dex */
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
            boolean z;
            AccountData accountData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.c.getItemId(i) < 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (ListUtils.getCount(this.a.b) <= 10 && (!z || ListUtils.getCount(this.a.b) != 10)) {
                    if (!z) {
                        if (!this.a.c.a() && (accountData = (AccountData) this.a.c.getItem(i)) != null && accountData.getIsActive() != 1) {
                            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                                this.a.T1(accountData);
                                return;
                            }
                            this.a.S1(accountData);
                            return;
                        }
                        return;
                    }
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.a.getPageContext().getPageActivity());
                    loginActivityConfig.setJumpToAfterDestroy(1);
                    TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, loginActivityConfig));
                    return;
                }
                TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f007f, TBAlertConfig.OperateBtnStyle.MAIN);
                operateBtnConfig.setListener(new a(this, new TBAlertBuilder(this.a.getActivity()).setTitle(R.string.obfuscated_res_0x7f0f0080).setDesc(R.string.obfuscated_res_0x7f0f16de).setOperateBtn(operateBtnConfig).setCancelable(false).show()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BdAsyncTask<Object, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;
        public int b;
        public boolean c;
        public final /* synthetic */ AccountActivity d;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        /* loaded from: classes5.dex */
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
                o05.t().g(this.a.getID(), true);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.remove("get_addresslist_switch" + this.a.getID());
                if (this.a.getID().equals(currentAccount)) {
                    if (this.d.b.size() >= 2) {
                        return (AccountData) this.d.b.get(1);
                    }
                    gc5 b = fc5.b();
                    if (b != null) {
                        b.a();
                    }
                    this.b = 2;
                } else {
                    gc5 b2 = fc5.b();
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
                if (accountData != null) {
                    accountData.setIsActive(1);
                    AccountStorage.saveAccountData(accountData);
                    gc5 b = fc5.b();
                    if (b != null) {
                        b.b(accountData);
                    }
                    this.d.N1(accountData);
                }
                if (this.a != null) {
                    Logger.addLog("account", -1L, 0, "account_change_delete_success", 0, "", "type", Integer.valueOf(this.b), "delete_uid", this.a.getID());
                    new j(this.a.getBDUSS(), p05.a(this.a)).start();
                }
                this.d.closeLoadingDialog();
                if (this.b != 0) {
                    SafeHandler.getInst().postDelayed(new a(this), 1000L);
                    Logger.addLog("account", -1L, 0, "account_activity_delete_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, this.d.getPageContext().getPageActivity());
                }
                int i = this.b;
                if (i != 0) {
                    if (i == 2) {
                        TbadkCoreApplication.getInst().onUserChanged();
                        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.d.getPageContext().getPageActivity(), true);
                        loginActivityConfig.setJumpToAfterDestroy(1);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    }
                } else {
                    AccountActivity accountActivity = this.d;
                    accountActivity.showToast(accountActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f14aa));
                    this.d.b.remove(this.a);
                    this.a = null;
                    this.d.c.notifyDataSetChanged();
                    AccountActivity accountActivity2 = this.d;
                    accountActivity2.a = accountActivity2.getIntent().getIntExtra(MainEntrance.GOTO_TYPE, -1);
                    if (this.d.a == -1) {
                        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                        if (sharedPrefHelper.getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            this.d.a = 2;
                            SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
                            sharedPrefHelper2.putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                        } else {
                            this.d.a = 2;
                        }
                    }
                    if (MainEntrance.getMainTabClass() != null) {
                        MainEntrance.goToMainTabRefresh(this.d.getPageContext().getPageActivity(), this.d.a, false);
                    } else {
                        this.d.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.d.getPageContext().getPageActivity()).createNormalCfg(this.d.a)));
                    }
                }
                this.d.k = null;
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.b == null) {
                return;
            }
            this.a.o1();
            if (this.a.c != null) {
                this.a.c.b(this.a.b);
                this.a.c.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (!this.a.c.a()) {
                    this.a.c.c(true);
                    this.a.h.setText(R.string.obfuscated_res_0x7f0f05ac);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.a.h, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.a.h, R.color.CAM_X0302, 1);
                    }
                    this.a.c.notifyDataSetChanged();
                    return;
                }
                this.a.c.c(false);
                this.a.h.setText(R.string.obfuscated_res_0x7f0f0618);
                SkinManager.setViewTextColor(this.a.h, R.color.navi_op_text, 1);
                this.a.c.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements qg5.e {
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

        @Override // com.baidu.tieba.qg5.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189, TbadkCoreApplication.getCurrentAccount()));
                this.a.T1(accountData);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.R1("account changed");
                this.a.j = null;
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    this.b.R1("account delete cancel");
                }
                this.b.k = null;
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (i != 1) {
                    if (i == 2) {
                        Object obj = message.obj;
                        if (obj instanceof AccountData) {
                            this.a.M1((AccountData) obj);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.L1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public j(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes5.dex */
    public class k implements AccountLoginCoreHelper.IReLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;
        public final /* synthetic */ AccountActivity b;

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onBeforeLogin(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

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

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onFailure(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) {
                Logger.addLog("account", -1L, 0, "account_change_cslogin_fail", i, str2, "uname", str);
                this.b.closeLoadingDialog();
                this.b.showToast(str2);
                if (i == 1 && this.a != null) {
                    ReloginManager.g().f(this.a);
                    this.b.K1(false, this.a);
                }
            }
        }

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onSuccess(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                Logger.addLog("account", -1L, 0, "account_change_cslogin_success", 0, "", "uid", accountData.getID());
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", 1).param("obj_param1", "account_change"));
                this.b.M1(accountData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends BdAsyncTask<Object, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AccountData a;
        public final /* synthetic */ AccountActivity b;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

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
                    AccountStorage.saveAccountData(this.a);
                    gc5 b = fc5.b();
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) != null) {
                return;
            }
            this.b.N1(this.a);
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
        this.a = -1;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = new a(this, 2005016);
        this.p = new h(this);
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = new TextView(this);
            this.o = textView;
            textView.setGravity(16);
            this.o.setPadding(BdUtilHelper.getDimens(this, R.dimen.tbds44), 0, 0, 0);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, BdUtilHelper.getDimens(this, R.dimen.tbds74));
            this.o.setTextSize(0, BdUtilHelper.getDimens(this, R.dimen.tbds33));
            this.o.setText(R.string.account_manager);
            this.o.setLayoutParams(layoutParams);
            this.d.addHeaderView(this.o);
        }
    }

    public final void P1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            BdSocketLinkService.setHasAbsoluteClose(true);
            MessageManager.getInstance().getSocketClient().j();
            BdSocketLinkService.setAvailable(false);
            BdSocketLinkService.close(str);
        }
    }

    public final void R1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.startService(true, str);
        }
    }

    public final void S1(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, accountData) == null) {
            if (this.l == null) {
                qg5 qg5Var = new qg5(this);
                this.l = qg5Var;
                qg5Var.w(new e(this));
            }
            this.l.p();
            this.l.u(accountData);
            this.l.y();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d001f);
            o1();
            this.f = new r56(this);
            p1();
            registerListener(this.n);
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View d2 = this.f.d();
            d2.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
            this.d.addFooterView(d2);
        }
    }

    public final boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (MessageManager.getInstance().getSocketClient().r() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b = AccountStorage.getAllAccountData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            this.f.f();
            this.p.removeMessages(1);
            this.p.removeMessages(2);
            this.p.removeCallbacksAndMessages(null);
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.m;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
    }

    public final void K1(boolean z, AccountData accountData) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, accountData) != null) || this.k != null) {
            return;
        }
        if (accountData != null && accountData.getID() != null && accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            pn5.b(0, 0, 0, 2, 3);
            P1("account delete");
        }
        showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f0569), new g(this, z2));
        i iVar = new i(this, z, accountData);
        this.k = iVar;
        iVar.setPriority(3);
        L1();
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.k != null) {
            if (O1()) {
                this.p.removeMessages(1);
                Handler handler = this.p;
                handler.sendMessageDelayed(handler.obtainMessage(1), 200L);
                return;
            }
            this.k.execute(new Object[0]);
        }
    }

    public final void M1(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, accountData) == null) {
            l lVar = new l(this, accountData);
            this.j = lVar;
            lVar.setPriority(3);
            if (this.j != null) {
                if (O1()) {
                    this.p.removeMessages(2);
                    Message obtainMessage = this.p.obtainMessage(2);
                    obtainMessage.obj = accountData;
                    this.p.sendMessageDelayed(obtainMessage, 200L);
                    return;
                }
                this.j.execute(new Object[0]);
            }
        }
    }

    public final void N1(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accountData) == null) {
            Logger.addLog("account", -1L, 0, "account_change_change_success", 0, "", "uid", accountData.getID());
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            closeLoadingDialog();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            TbadkCoreApplication.getInst().onUserChanged();
            MainEntrance.goToMainTabRefresh(getPageContext().getPageActivity(), 2, false);
            this.j = null;
        }
    }

    public final void T1(AccountData accountData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, accountData) != null) || this.j != null) {
            return;
        }
        pn5.b(0, 0, 0, 2, 2);
        P1("account changed");
        showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f0093), new f(this));
        BdAsyncTask<?, ?, ?> bdAsyncTask = this.m;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
        this.m = AccountLoginCoreHelper.getInstance().asyncReLogin(accountData.getAccount(), accountData.getBDUSS(), "", accountData.getStoken(), new k(this, accountData));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            this.f.e(i2);
            this.g.onChangeSkinType(getPageContext(), i2);
            BDLayoutMode layoutMode = getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.e);
            this.c.notifyDataSetChanged();
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090067);
            this.i = new b(this);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.g = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.g.setTitleText(getPageContext().getString(R.string.account_manager));
            View addCustomView = this.g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.h = textView;
            textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0618));
            SkinManager.setViewTextColor(this.h, R.color.navi_op_text, 1);
            addCustomView.setOnClickListener(new c(this));
            p56 p56Var = new p56(this, this.i);
            this.c = p56Var;
            p56Var.b(this.b);
            this.d = (ListView) findViewById(R.id.obfuscated_res_0x7f091551);
            TextView textView2 = new TextView(getActivity());
            textView2.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
            this.d.addHeaderView(textView2);
            I1();
            this.d.setAdapter((ListAdapter) this.c);
            this.d.setOnItemClickListener(new d(this));
            J1();
        }
    }
}
