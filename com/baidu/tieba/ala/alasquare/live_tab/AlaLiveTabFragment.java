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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.b1.b0;
import d.a.p0.f0.h;
import d.a.q0.u0.n0;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlaLiveTabFragment extends BaseFragment implements n0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int m = 1;
    public static int n = 1;
    public static int o = 1;
    public static HashMap<Integer, Integer> p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.v.d.c.h.a f14009e;

    /* renamed from: f  reason: collision with root package name */
    public AlaLiveUserNotifyController f14010f;

    /* renamed from: g  reason: collision with root package name */
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener f14011g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14012h;

    /* renamed from: i  reason: collision with root package name */
    public int f14013i;
    public boolean j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f14014a;

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
            this.f14014a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.q0.v.d.c.e.b)) {
                this.f14014a.f14009e.z(true);
                d.a.q0.v.d.c.e.b bVar = (d.a.q0.v.d.c.e.b) customResponsedMessage.getData();
                if (bVar.f64942a) {
                    if (this.f14014a.f14012h || !bVar.f64943b) {
                        this.f14014a.V0();
                        AlaLiveTabFragment alaLiveTabFragment = this.f14014a;
                        alaLiveTabFragment.hideLoadingView(alaLiveTabFragment.f14009e.m());
                        this.f14014a.f14009e.B(bVar.f64944c);
                        this.f14014a.f14012h = false;
                    }
                } else if (this.f14014a.f14012h || !bVar.f64943b) {
                    AlaLiveTabFragment alaLiveTabFragment2 = this.f14014a;
                    alaLiveTabFragment2.hideLoadingView(alaLiveTabFragment2.f14009e.m());
                    this.f14014a.Z0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f14015a;

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
            this.f14015a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (this.f14015a.f14009e != null) {
                    this.f14015a.f14009e.A(intValue);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f14016a;

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
            this.f14016a = alaLiveTabFragment;
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f14016a.isPrimary()) {
                this.f14016a.f14010f.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.d.c.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f14017a;

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
            this.f14017a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.c.f.g
        /* renamed from: c */
        public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
            InterceptResult invokeL;
            boolean e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpResponsedMessage)) == null) {
                if ((((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname") == null || StringUtils.isNull(((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname").toString())) && (e2 = d.a.q0.v.d.c.c.e()) != this.f14017a.f14009e.q) {
                    this.f14017a.f14009e.j(e2, true, false);
                    return null;
                }
                return httpResponsedMessage;
            }
            return (HttpResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f14018e;

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
            this.f14018e = alaLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f14018e.f14009e != null) {
                this.f14018e.f14009e.z(false);
                this.f14018e.Y0();
                this.f14018e.f14009e.s();
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
        this.f14012h = true;
        this.f14013i = -1;
        this.k = new a(this, AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE);
        this.l = new b(this, 2921446);
    }

    public static void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            if (p.containsKey(Integer.valueOf(i2))) {
                p.put(Integer.valueOf(i2), Integer.valueOf(p.get(Integer.valueOf(i2)).intValue() + 1));
            } else {
                p.put(Integer.valueOf(i2), 2);
            }
        }
    }

    public static int U0(int i2) {
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

    @Override // d.a.q0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.q0.u0.n0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14009e.z(true);
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.dettachView(this.f14009e.m());
                this.mRefreshView = null;
            }
        }
    }

    public boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14012h : invokeV.booleanValue;
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && isAdded()) {
            Y0();
            this.f14009e.s();
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f14013i < 0) {
                this.f14013i = this.f14009e.m().getHeight();
            }
            showLoadingView(this.f14009e.m(), false, (((this.f14013i - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new e(this));
            }
            this.mRefreshView.o();
            this.mRefreshView.l(null);
            this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.f14009e.z(false);
            this.mRefreshView.k(0);
            this.mRefreshView.attachView(this.f14009e.m(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a083" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.u0.n0
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f14009e.x();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.v.d.c.h.a aVar = this.f14009e;
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
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(null);
            this.f14009e = new d.a.q0.v.d.c.h.a(getPageContext(), getChildFragmentManager(), this.j);
            if (this.f14010f == null) {
                this.f14010f = new AlaLiveUserNotifyController(getPageContext());
            }
            this.f14011g = new c(this);
            AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.f14011g);
            MessageManager.getInstance().registerListener(this.k);
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().addResponsedMessageRule(new d(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO));
            this.f14009e.n();
            if (this.f14013i > 0) {
                Y0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup m2 = this.f14009e.m();
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.f14012h = true;
            d.a.q0.v.d.c.h.a aVar = this.f14009e;
            if (aVar != null) {
                aVar.k();
            }
            AlaLiveUserNotifyController alaLiveUserNotifyController = this.f14010f;
            if (alaLiveUserNotifyController != null) {
                alaLiveUserNotifyController.onDestroy();
            }
            AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.f14011g);
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onLazyLoad();
            this.j = true;
            this.f14009e.s();
            Y0();
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
                d.a.q0.v.d.c.h.a aVar = this.f14009e;
                if (aVar != null) {
                    aVar.u(true);
                }
            } else {
                d.a.q0.v.d.c.h.a aVar2 = this.f14009e;
                if (aVar2 != null) {
                    aVar2.u(false);
                }
            }
            d.a.q0.v.d.c.h.a aVar3 = this.f14009e;
            if (aVar3 != null) {
                aVar3.w(isPrimary());
            }
        }
    }

    @Override // d.a.q0.u0.n0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // d.a.q0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // d.a.q0.u0.n0
    public void x(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, b0Var) == null) {
        }
    }
}
