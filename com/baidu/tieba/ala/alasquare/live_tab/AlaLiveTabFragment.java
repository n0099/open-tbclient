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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.d0.h;
import d.a.r0.z0.b0;
import d.a.s0.u0.n0;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AlaLiveTabFragment extends BaseFragment implements n0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int m = 1;
    public static int n = 1;
    public static int o = 1;
    public static HashMap<Integer, Integer> p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.v.d.c.h.a f13922e;

    /* renamed from: f  reason: collision with root package name */
    public AlaLiveUserNotifyController f13923f;

    /* renamed from: g  reason: collision with root package name */
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener f13924g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13925h;

    /* renamed from: i  reason: collision with root package name */
    public int f13926i;
    public boolean j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f13927a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabFragment alaLiveTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment, Integer.valueOf(i2)};
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
            this.f13927a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.v.d.c.e.b)) {
                this.f13927a.f13922e.z(true);
                d.a.s0.v.d.c.e.b bVar = (d.a.s0.v.d.c.e.b) customResponsedMessage.getData();
                if (bVar.f67515a) {
                    if (this.f13927a.f13925h || !bVar.f67516b) {
                        this.f13927a.P0();
                        AlaLiveTabFragment alaLiveTabFragment = this.f13927a;
                        alaLiveTabFragment.hideLoadingView(alaLiveTabFragment.f13922e.m());
                        this.f13927a.f13922e.B(bVar.f67517c);
                        this.f13927a.f13925h = false;
                    }
                } else if (this.f13927a.f13925h || !bVar.f67516b) {
                    AlaLiveTabFragment alaLiveTabFragment2 = this.f13927a;
                    alaLiveTabFragment2.hideLoadingView(alaLiveTabFragment2.f13922e.m());
                    this.f13927a.T0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f13928a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AlaLiveTabFragment alaLiveTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment, Integer.valueOf(i2)};
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
            this.f13928a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (this.f13928a.f13922e != null) {
                    this.f13928a.f13922e.A(intValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f13929a;

        public c(AlaLiveTabFragment alaLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13929a = alaLiveTabFragment;
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f13929a.isPrimary()) {
                this.f13929a.f13923f.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.c.c.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f13930a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AlaLiveTabFragment alaLiveTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment, Integer.valueOf(i2)};
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
            this.f13930a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.c.f.g
        /* renamed from: c */
        public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
            InterceptResult invokeL;
            boolean e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpResponsedMessage)) == null) {
                if ((((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname") == null || StringUtils.isNull(((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname").toString())) && (e2 = d.a.s0.v.d.c.c.e()) != this.f13930a.f13922e.q) {
                    this.f13930a.f13922e.j(e2, true, false);
                    return null;
                }
                return httpResponsedMessage;
            }
            return (HttpResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f13931e;

        public e(AlaLiveTabFragment alaLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13931e = alaLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f13931e.f13922e != null) {
                this.f13931e.f13922e.z(false);
                this.f13931e.S0();
                this.f13931e.f13922e.s();
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
        p = new HashMap<>();
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
        this.f13925h = true;
        this.f13926i = -1;
        this.k = new a(this, AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE);
        this.l = new b(this, 2921446);
    }

    public static void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            if (p.containsKey(Integer.valueOf(i2))) {
                p.put(Integer.valueOf(i2), Integer.valueOf(p.get(Integer.valueOf(i2)).intValue() + 1));
            } else {
                p.put(Integer.valueOf(i2), 2);
            }
        }
    }

    public static int O0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            if (p.containsKey(Integer.valueOf(i2))) {
                return p.get(Integer.valueOf(i2)).intValue();
            }
            p.put(Integer.valueOf(i2), 1);
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // d.a.s0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13922e.z(true);
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.dettachView(this.f13922e.m());
                this.mRefreshView = null;
            }
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13925h : invokeV.booleanValue;
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && isAdded()) {
            S0();
            this.f13922e.s();
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f13926i < 0) {
                this.f13926i = this.f13922e.m().getHeight();
            }
            showLoadingView(this.f13922e.m(), false, (((this.f13926i - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new e(this));
            }
            this.mRefreshView.o();
            this.mRefreshView.l(null);
            this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.f13922e.z(false);
            this.mRefreshView.k(0);
            this.mRefreshView.attachView(this.f13922e.m(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a083" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.v.d.c.h.a aVar = this.f13922e;
            if (aVar != null) {
                aVar.v();
            }
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(null);
            this.f13922e = new d.a.s0.v.d.c.h.a(getPageContext(), getChildFragmentManager(), this.j);
            if (this.f13923f == null) {
                this.f13923f = new AlaLiveUserNotifyController(getPageContext());
            }
            this.f13924g = new c(this);
            AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.f13924g);
            MessageManager.getInstance().registerListener(this.k);
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().addResponsedMessageRule(new d(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO));
            this.f13922e.n();
            if (this.f13926i > 0) {
                S0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup m2 = this.f13922e.m();
            if (m2.getParent() instanceof ViewGroup) {
                ((ViewGroup) m2.getParent()).removeView(m2);
            }
            return m2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.f13925h = true;
            d.a.s0.v.d.c.h.a aVar = this.f13922e;
            if (aVar != null) {
                aVar.k();
            }
            AlaLiveUserNotifyController alaLiveUserNotifyController = this.f13923f;
            if (alaLiveUserNotifyController != null) {
                alaLiveUserNotifyController.onDestroy();
            }
            AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.f13924g);
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onLazyLoad();
            this.j = true;
            this.f13922e.s();
            S0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                d.a.s0.v.d.c.h.a aVar = this.f13922e;
                if (aVar != null) {
                    aVar.u(true);
                }
            } else {
                d.a.s0.v.d.c.h.a aVar2 = this.f13922e;
                if (aVar2 != null) {
                    aVar2.u(false);
                }
            }
            d.a.s0.v.d.c.h.a aVar3 = this.f13922e;
            if (aVar3 != null) {
                aVar3.w(isPrimary());
            }
        }
    }

    @Override // d.a.s0.u0.n0
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f13922e.x();
        }
    }

    @Override // d.a.s0.u0.n0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void x(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, b0Var) == null) {
        }
    }
}
