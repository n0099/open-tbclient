package com.baidu.tieba.gift.myGiftList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListModel;
import com.baidu.tieba.iu7;
import com.baidu.tieba.ku7;
import com.baidu.tieba.me5;
import com.baidu.tieba.ug;
import com.baidu.tieba.wi;
import com.baidu.tieba.x95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public MyGiftListModel b;
    public ku7 c;
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

    /* loaded from: classes5.dex */
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
        public void a(int i, String str, boolean z, iu7 iu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), iu7Var}) == null) {
                this.a.closeLoadingDialog();
                this.a.c.D().setVisibility(8);
                this.a.c.C();
                if (i != 0) {
                    this.a.showToast(str);
                    if (z) {
                        this.a.c.J(iu7Var);
                        return;
                    } else {
                        this.a.c.M(str, true);
                        return;
                    }
                }
                this.a.c.J(iu7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements x95.g {
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

        @Override // com.baidu.tieba.x95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (wi.F()) {
                    me5.h0().m();
                    this.a.b.g0(false);
                    this.a.b.loadData();
                    me5.h0().d0(0);
                    this.a.c.E();
                    return;
                }
                this.a.c.C();
                this.a.c.M(this.a.getString(R.string.obfuscated_res_0x7f0f0df3), true);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (!wi.F()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0df3);
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

    /* loaded from: classes5.dex */
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
        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.b.g0(false);
                this.a.b.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.b.g0(false);
                this.a.b.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.b.c0()) {
                    this.a.b.g0(true);
                    this.a.b.loadData();
                    this.a.c.D().setVisibility(0);
                    return;
                }
                this.a.c.D().setVisibility(8);
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
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.c.onChangeSkinType(i);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.A(this.l);
        }
    }

    public View.OnClickListener F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new c(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public String H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f099c);
            if (this.e == 2) {
                return getPageContext().getString(R.string.obfuscated_res_0x7f0f1392);
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ku7 ku7Var = new ku7(this, this.n, this.a);
            this.c = ku7Var;
            ku7Var.K(new b(this));
            E1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            me5.h0().m();
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
                this.g = ug.g(str, 0L);
            }
            MyGiftListModel myGiftListModel = new MyGiftListModel(getPageContext(), this.f);
            this.b = myGiftListModel;
            myGiftListModel.mUserType = this.j;
            myGiftListModel.setUid(this.g);
            this.a = this.b.a0();
            this.b.e0(this.k);
            I1();
            registerListener(this.m);
            this.b.g0(false);
            if (wi.F()) {
                this.c.N();
            } else {
                this.c.M(getString(R.string.obfuscated_res_0x7f0f0df3), true);
            }
            me5.h0().d0(0);
        }
    }
}
