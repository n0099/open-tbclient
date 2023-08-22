package com.baidu.tieba.gift.myGiftList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListModel;
import com.baidu.tieba.hy7;
import com.baidu.tieba.ie5;
import com.baidu.tieba.jy7;
import com.baidu.tieba.p95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public MyGiftListModel b;
    public jy7 c;
    public String d;
    public int e;
    public String f;
    public long g;
    public String h;
    public String i;
    public int j;
    public MyGiftListModel.b k;
    public NoNetworkView.b l;
    public final CustomMessageListener m;
    public BdListView.p n;

    /* loaded from: classes6.dex */
    public class a implements MyGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public a(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.baidu.tieba.gift.myGiftList.MyGiftListModel.b
        public void a(int i, String str, boolean z, hy7 hy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), hy7Var}) == null) {
                this.a.closeLoadingDialog();
                this.a.c.F().setVisibility(8);
                this.a.c.E();
                if (i != 0) {
                    this.a.showToast(str);
                    if (z) {
                        this.a.c.L(hy7Var);
                        return;
                    } else {
                        this.a.c.N(str, true);
                        return;
                    }
                }
                this.a.c.L(hy7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public b(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.baidu.tieba.p95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdUtilHelper.isNetOk()) {
                    ie5.p0().m();
                    this.a.b.Z(false);
                    this.a.b.loadData();
                    ie5.p0().k0(0);
                    this.a.c.G();
                    return;
                }
                this.a.c.E();
                this.a.c.N(this.a.getString(R.string.obfuscated_res_0x7f0f0e29), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public c(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a) {
                return;
            }
            if (!BdUtilHelper.isNetOk()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e29);
                return;
            }
            long uid = this.a.b.getUid();
            if (uid == 0) {
                return;
            }
            TiebaStatic.log("gift_list_btn");
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageContext().getPageActivity(), uid, this.a.h, this.a.i);
            giftTabActivityConfig.getIntent().putExtra("account_type", this.a.j);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_GIFT_WALLS, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            this.a.sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public d(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.b.Z(false);
                this.a.b.loadData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MyGiftListActivity myGiftListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity, Integer.valueOf(i)};
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
            this.a = myGiftListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && !this.a.a && this.a.g == l.longValue()) {
                this.a.b.Z(false);
                this.a.b.loadData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListActivity a;

        public f(MyGiftListActivity myGiftListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b.V()) {
                    this.a.b.Z(true);
                    this.a.b.loadData();
                    this.a.c.F().setVisibility(0);
                    return;
                }
                this.a.c.F().setVisibility(8);
            }
        }
    }

    public MyGiftListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = 0;
        this.g = 0L;
        this.k = new a(this);
        this.l = new d(this);
        this.m = new e(this, 2001232);
        this.n = new f(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.c.onChangeSkinType(i);
        }
    }

    public View.OnClickListener A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new c(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f09b3);
            if (this.e == 2) {
                return getPageContext().getString(R.string.obfuscated_res_0x7f0f13d6);
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jy7 jy7Var = new jy7(this, this.n, this.a);
            this.c = jy7Var;
            jy7Var.M(new b(this));
            z1();
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.A(this.l);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            ie5.p0().m();
            Intent intent = getIntent();
            if (intent != null) {
                this.d = intent.getStringExtra("id");
                this.f = intent.getStringExtra("st_type");
                this.e = intent.getIntExtra("sex", 0);
                this.h = intent.getStringExtra("user_name");
                this.i = intent.getStringExtra("name_show");
                this.j = intent.getIntExtra("user_type", 0);
            }
            String str = this.d;
            if (str != null) {
                this.g = JavaTypesHelper.toLong(str, 0L);
            }
            MyGiftListModel myGiftListModel = new MyGiftListModel(getPageContext(), this.f);
            this.b = myGiftListModel;
            myGiftListModel.mUserType = this.j;
            myGiftListModel.setUid(this.g);
            this.a = this.b.T();
            this.b.X(this.k);
            C1();
            registerListener(this.m);
            this.b.Z(false);
            if (BdUtilHelper.isNetOk()) {
                this.c.O();
            } else {
                this.c.N(getString(R.string.obfuscated_res_0x7f0f0e29), true);
            }
            ie5.p0().k0(0);
        }
    }
}
