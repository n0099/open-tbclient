package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.hn;
import com.baidu.tieba.ii;
import com.baidu.tieba.pg5;
import com.baidu.tieba.s46;
import com.baidu.tieba.v46;
import com.baidu.tieba.x46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x46 a;
    public MyConcernTabModel b;
    public boolean c;
    public pg5 d;
    public boolean e;
    public boolean f;
    public String g;
    public CustomMessageListener h;
    public x46.f i;
    public MyConcernTabModel.b j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity, Integer.valueOf(i)};
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
            this.a = alaLiveTabMyConcernActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.J1(s46.class);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements x46.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

        public b(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // com.baidu.tieba.x46.f
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable() || this.a.e) {
                    if (this.a.a != null) {
                        this.a.a.q(false);
                        return;
                    }
                    return;
                }
                this.a.M1();
            }
        }

        @Override // com.baidu.tieba.x46.f
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ii.F() && this.a.c && !this.a.e) {
                this.a.e = true;
                this.a.b.V();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MyConcernTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

        public c(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) {
                return;
            }
            this.a.e = false;
            AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = this.a;
            alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.a.g());
            this.a.a.q(false);
            this.a.K1(z);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void a(List<hn> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.e = false;
                this.a.L1();
                this.a.a.q(false);
                AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = this.a;
                alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.a.g());
                if (ListUtils.isEmpty(list)) {
                    this.a.K1(z2);
                } else {
                    this.a.a.p(list);
                }
                this.a.c = z;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabMyConcernActivity a;

        public d(AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabMyConcernActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabMyConcernActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.M1();
        }
    }

    public AlaLiveTabMyConcernActivity() {
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
        this.c = true;
        this.e = false;
        this.f = false;
        this.g = "";
        this.h = new a(this, 2921421);
        this.i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
    }

    public final void J1(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
            MyConcernTabModel myConcernTabModel = this.b;
            if (myConcernTabModel != null) {
                myConcernTabModel.Y(cls);
            }
            x46 x46Var = this.a;
            if (x46Var != null) {
                x46Var.o(cls);
            }
        }
    }

    public final void K1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            N1(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.k);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            x46 x46Var = this.a;
            if (x46Var != null) {
                x46Var.l(i);
            }
        }
    }

    public final void L1() {
        pg5 pg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pg5Var = this.d) != null) {
            pg5Var.dettachView(this.a.f());
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = true;
            this.b.W();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.tieba.b9
    public TbPageContext<AlaLiveTabMyConcernActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return super.getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onNetRefreshButtonClicked();
            M1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            this.e = false;
            x46 x46Var = this.a;
            if (x46Var != null) {
                x46Var.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (!this.f && v46.a(getPageContext())) {
                J1(s46.class);
            }
        }
    }

    public final void N1(int i, String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, str, onClickListener) == null) {
            if (this.d == null) {
                pg5 pg5Var = new pg5(getPageContext().getPageActivity(), onClickListener);
                this.d = pg5Var;
                pg5Var.g(null);
                this.d.p();
                this.d.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.d.i(i);
            this.d.m(null);
            this.d.n(str);
            this.d.onChangeSkinType();
            this.d.dettachView(this.a.f());
            this.d.attachView(this.a.f());
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            x46 x46Var = new x46(getPageContext(), this.g);
            this.a = x46Var;
            x46Var.r(this.i);
            setContentView(this.a.h());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            MyConcernTabModel myConcernTabModel = this.b;
            if (myConcernTabModel != null) {
                myConcernTabModel.onDestroy();
            }
            x46 x46Var = this.a;
            if (x46Var != null && x46Var.g() != null) {
                hideLoadingView(this.a.g());
            }
            x46 x46Var2 = this.a;
            if (x46Var2 != null) {
                x46Var2.m();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            if (!TbadkCoreApplication.isLogin()) {
                finish();
                return;
            }
            if (getIntent() != null) {
                this.g = getIntent().getStringExtra(AlaLiveTabMyConcernActivityConfig.ALA_LIVE_SOURCE);
            }
            initView();
            this.f = v46.a(getPageContext());
            MyConcernTabModel myConcernTabModel = new MyConcernTabModel(getPageContext());
            this.b = myConcernTabModel;
            myConcernTabModel.Z(this.j);
            if (!ii.F()) {
                N1(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.k);
            } else {
                showLoadingView(this.a.g(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a6));
                M1();
            }
            registerListener(this.h);
        }
    }
}
