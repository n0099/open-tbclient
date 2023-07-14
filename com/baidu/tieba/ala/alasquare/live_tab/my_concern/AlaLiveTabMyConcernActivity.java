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
import com.baidu.tieba.ad6;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dd6;
import com.baidu.tieba.do5;
import com.baidu.tieba.fd6;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fd6 a;
    public MyConcernTabModel b;
    public boolean c;
    public do5 d;
    public boolean e;
    public boolean f;
    public String g;
    public CustomMessageListener h;
    public fd6.f i;
    public MyConcernTabModel.b j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.F1(ad6.class);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements fd6.f {
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

        @Override // com.baidu.tieba.fd6.f
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable() && !this.a.e) {
                    this.a.J1();
                } else if (this.a.a != null) {
                    this.a.a.q(false);
                }
            }
        }

        @Override // com.baidu.tieba.fd6.f
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && yi.G() && this.a.c && !this.a.e) {
                this.a.e = true;
                this.a.b.a0();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.H1(z);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void a(List<yn> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) {
                return;
            }
            this.a.e = false;
            this.a.I1();
            this.a.a.q(false);
            AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = this.a;
            alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.a.g());
            if (!ListUtils.isEmpty(list)) {
                this.a.a.p(list);
            } else {
                this.a.H1(z2);
            }
            this.a.c = z;
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.J1();
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

    public final void F1(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
            MyConcernTabModel myConcernTabModel = this.b;
            if (myConcernTabModel != null) {
                myConcernTabModel.d0(cls);
            }
            fd6 fd6Var = this.a;
            if (fd6Var != null) {
                fd6Var.o(cls);
            }
        }
    }

    public final void H1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            K1(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.k);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            fd6 fd6Var = this.a;
            if (fd6Var != null) {
                fd6Var.l(i);
            }
        }
    }

    public final void I1() {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (do5Var = this.d) != null) {
            do5Var.dettachView(this.a.f());
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = true;
            this.b.b0();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.tieba.m9
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
            J1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            this.e = false;
            fd6 fd6Var = this.a;
            if (fd6Var != null) {
                fd6Var.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (!this.f && dd6.a(getPageContext())) {
                F1(ad6.class);
            }
        }
    }

    public final void K1(int i, String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, str, onClickListener) == null) {
            if (this.d == null) {
                do5 do5Var = new do5(getPageContext().getPageActivity(), onClickListener);
                this.d = do5Var;
                do5Var.g(null);
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
            fd6 fd6Var = new fd6(getPageContext(), this.g);
            this.a = fd6Var;
            fd6Var.r(this.i);
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
            fd6 fd6Var = this.a;
            if (fd6Var != null && fd6Var.g() != null) {
                hideLoadingView(this.a.g());
            }
            fd6 fd6Var2 = this.a;
            if (fd6Var2 != null) {
                fd6Var2.m();
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
            this.f = dd6.a(getPageContext());
            MyConcernTabModel myConcernTabModel = new MyConcernTabModel(getPageContext());
            this.b = myConcernTabModel;
            myConcernTabModel.e0(this.j);
            if (!yi.G()) {
                K1(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.k);
            } else {
                showLoadingView(this.a.g(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c3));
                J1();
            }
            registerListener(this.h);
        }
    }
}
