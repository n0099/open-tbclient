package com.baidu.tieba.ala.alasquare.live_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fo5;
import com.repackage.h45;
import com.repackage.lo5;
import com.repackage.me6;
import com.repackage.mi;
import com.repackage.na;
import com.repackage.oi;
import com.repackage.up5;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AlaLiveTabFragment extends BaseFragment implements me6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int i = 1;
    public static int j = 1;
    public static int k = 1;
    public static HashMap<Integer, Integer> l;
    public transient /* synthetic */ FieldHolder $fh;
    public up5 a;
    public AlaLiveUserNotifyController b;
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener c;
    public boolean d;
    public int e;
    public boolean f;
    public CustomMessageListener g;
    public CustomMessageListener h;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabFragment alaLiveTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment, Integer.valueOf(i)};
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
            this.a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lo5)) {
                this.a.a.z(true);
                lo5 lo5Var = (lo5) customResponsedMessage.getData();
                if (lo5Var.a) {
                    if (this.a.d || !lo5Var.b) {
                        this.a.K0();
                        AlaLiveTabFragment alaLiveTabFragment = this.a;
                        alaLiveTabFragment.hideLoadingView(alaLiveTabFragment.a.m());
                        this.a.a.B(lo5Var.c);
                        this.a.d = false;
                    }
                } else if (this.a.d || !lo5Var.b) {
                    AlaLiveTabFragment alaLiveTabFragment2 = this.a;
                    alaLiveTabFragment2.hideLoadingView(alaLiveTabFragment2.a.m());
                    this.a.O0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AlaLiveTabFragment alaLiveTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment, Integer.valueOf(i)};
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
            this.a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (this.a.a != null) {
                    this.a.a.A(intValue);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabFragment a;

        public c(AlaLiveTabFragment alaLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabFragment;
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.isPrimary()) {
                this.a.b.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends na {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AlaLiveTabFragment alaLiveTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment, Integer.valueOf(i)};
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
            this.a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ra
        /* renamed from: c */
        public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
            InterceptResult invokeL;
            boolean e;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpResponsedMessage)) == null) {
                if ((((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname") == null || StringUtils.isNull(((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname").toString())) && (e = fo5.e()) != this.a.a.q) {
                    this.a.a.j(e, true, false);
                    return null;
                }
                return httpResponsedMessage;
            }
            return (HttpResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabFragment a;

        public e(AlaLiveTabFragment alaLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && mi.A() && this.a.a != null) {
                this.a.a.z(false);
                this.a.N0();
                this.a.a.s();
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1561664018, "Lcom/baidu/tieba/ala/alasquare/live_tab/AlaLiveTabFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1561664018, "Lcom/baidu/tieba/ala/alasquare/live_tab/AlaLiveTabFragment;");
                return;
            }
        }
        l = new HashMap<>();
    }

    public AlaLiveTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = true;
        this.e = -1;
        this.g = new a(this, AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE);
        this.h = new b(this, 2921446);
    }

    public static void I0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            if (l.containsKey(Integer.valueOf(i2))) {
                l.put(Integer.valueOf(i2), Integer.valueOf(l.get(Integer.valueOf(i2)).intValue() + 1));
            } else {
                l.put(Integer.valueOf(i2), 2);
            }
        }
    }

    public static int J0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            if (l.containsKey(Integer.valueOf(i2))) {
                return l.get(Integer.valueOf(i2)).intValue();
            }
            l.put(Integer.valueOf(i2), 1);
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // com.repackage.me6
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.me6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.z(true);
            h45 h45Var = this.mRefreshView;
            if (h45Var != null) {
                h45Var.dettachView(this.a.m());
                this.mRefreshView = null;
            }
        }
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && isAdded()) {
            N0();
            this.a.s();
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.e < 0) {
                this.e = this.a.m().getHeight();
            }
            showLoadingView(this.a.m(), false, (((this.e - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - oi.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h45(getContext(), new e(this));
            }
            this.mRefreshView.p();
            this.mRefreshView.m(null);
            this.mRefreshView.n(getResources().getString(R.string.obfuscated_res_0x7f0f0f6a));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.a.z(false);
            this.mRefreshView.l(0);
            this.mRefreshView.attachView(this.a.m(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a083" : (String) invokeV.objValue;
    }

    @Override // com.repackage.me6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.x();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            up5 up5Var = this.a;
            if (up5Var != null) {
                up5Var.v();
            }
            h45 h45Var = this.mRefreshView;
            if (h45Var != null) {
                h45Var.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(null);
            this.a = new up5(getPageContext(), getChildFragmentManager(), this.f);
            if (this.b == null) {
                this.b = new AlaLiveUserNotifyController(getPageContext());
            }
            this.c = new c(this);
            AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.c);
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
            MessageManager.getInstance().addResponsedMessageRule(new d(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO));
            this.a.n();
            if (this.e > 0) {
                N0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup m = this.a.m();
            if (m.getParent() instanceof ViewGroup) {
                ((ViewGroup) m.getParent()).removeView(m);
            }
            return m;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.d = true;
            up5 up5Var = this.a;
            if (up5Var != null) {
                up5Var.k();
            }
            AlaLiveUserNotifyController alaLiveUserNotifyController = this.b;
            if (alaLiveUserNotifyController != null) {
                alaLiveUserNotifyController.onDestroy();
            }
            AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.c);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onLazyLoad();
            this.f = true;
            this.a.s();
            N0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                up5 up5Var = this.a;
                if (up5Var != null) {
                    up5Var.u(true);
                }
            } else {
                up5 up5Var2 = this.a;
                if (up5Var2 != null) {
                    up5Var2.u(false);
                }
            }
            up5 up5Var3 = this.a;
            if (up5Var3 != null) {
                up5Var3.w(isPrimary());
            }
        }
    }

    @Override // com.repackage.me6
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }
}
