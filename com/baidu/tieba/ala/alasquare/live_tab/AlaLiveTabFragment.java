package com.baidu.tieba.ala.alasquare.live_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.b1.d0;
import c.a.p0.f0.h;
import c.a.q0.v0.n0;
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
import java.util.HashMap;
/* loaded from: classes7.dex */
public class AlaLiveTabFragment extends BaseFragment implements n0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIVE_FEED_LOAD_MORE = 1;
    public static final int LIVE_FEED_REFRESH_NEW = 0;
    public static int REFRESH_NEW_COUNT_FRIEND_TAB = 1;
    public static int REFRESH_NEW_COUNT_RECOMMEND_TAB = 1;
    public static int REFRESH_NEW_COUNT_YANZHI_TAB = 1;
    public static HashMap<Integer, Integer> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v.d.c.h.a f49251e;

    /* renamed from: f  reason: collision with root package name */
    public AlaLiveUserNotifyController f49252f;

    /* renamed from: g  reason: collision with root package name */
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener f49253g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49254h;

    /* renamed from: i  reason: collision with root package name */
    public int f49255i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49256j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f49257a;

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
            this.f49257a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.v.d.c.e.b)) {
                this.f49257a.f49251e.z(true);
                c.a.q0.v.d.c.e.b bVar = (c.a.q0.v.d.c.e.b) customResponsedMessage.getData();
                if (bVar.f25076a) {
                    if (this.f49257a.f49254h || !bVar.f25077b) {
                        this.f49257a.hideNetRefreshView();
                        AlaLiveTabFragment alaLiveTabFragment = this.f49257a;
                        alaLiveTabFragment.hideLoadingView(alaLiveTabFragment.f49251e.m());
                        this.f49257a.f49251e.B(bVar.f25078c);
                        this.f49257a.f49254h = false;
                    }
                } else if (this.f49257a.f49254h || !bVar.f25077b) {
                    AlaLiveTabFragment alaLiveTabFragment2 = this.f49257a;
                    alaLiveTabFragment2.hideLoadingView(alaLiveTabFragment2.f49251e.m());
                    this.f49257a.showNetRefreshView();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f49258a;

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
            this.f49258a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (this.f49258a.f49251e != null) {
                    this.f49258a.f49251e.A(intValue);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f49259a;

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
            this.f49259a = alaLiveTabFragment;
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f49259a.isPrimary()) {
                this.f49259a.f49252f.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends c.a.e.c.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f49260a;

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
            this.f49260a = alaLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.c.f.g
        /* renamed from: c */
        public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
            InterceptResult invokeL;
            boolean e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpResponsedMessage)) == null) {
                if ((((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname") == null || StringUtils.isNull(((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getParams().get("fname").toString())) && (e2 = c.a.q0.v.d.c.c.e()) != this.f49260a.f49251e.q) {
                    this.f49260a.f49251e.j(e2, true, false);
                    return null;
                }
                return httpResponsedMessage;
            }
            return (HttpResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFragment f49261e;

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
            this.f49261e = alaLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f49261e.f49251e != null) {
                this.f49261e.f49251e.z(false);
                this.f49261e.h();
                this.f49261e.f49251e.s();
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
        m = new HashMap<>();
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
        this.f49254h = true;
        this.f49255i = -1;
        this.k = new a(this, AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE);
        this.l = new b(this, 2921446);
    }

    public static void addRefreshNewCountYYTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            if (m.containsKey(Integer.valueOf(i2))) {
                m.put(Integer.valueOf(i2), Integer.valueOf(m.get(Integer.valueOf(i2)).intValue() + 1));
            } else {
                m.put(Integer.valueOf(i2), 2);
            }
        }
    }

    public static int getRefreshNewCountYYTab(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            if (m.containsKey(Integer.valueOf(i2))) {
                return m.get(Integer.valueOf(i2)).intValue();
            }
            m.put(Integer.valueOf(i2), 1);
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // c.a.q0.v0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "a083" : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f49255i < 0) {
                this.f49255i = this.f49251e.m().getHeight();
            }
            showLoadingView(this.f49251e.m(), false, (((this.f49255i - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
        }
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f49251e.z(true);
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.dettachView(this.f49251e.m());
                this.mRefreshView = null;
            }
        }
    }

    public boolean isFirstRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49254h : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.v.d.c.h.a aVar = this.f49251e;
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
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(null);
            this.f49251e = new c.a.q0.v.d.c.h.a(getPageContext(), getChildFragmentManager(), this.f49256j);
            if (this.f49252f == null) {
                this.f49252f = new AlaLiveUserNotifyController(getPageContext());
            }
            this.f49253g = new c(this);
            AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.f49253g);
            MessageManager.getInstance().registerListener(this.k);
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().addResponsedMessageRule(new d(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO));
            this.f49251e.n();
            if (this.f49255i > 0) {
                h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup m2 = this.f49251e.m();
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.f49254h = true;
            c.a.q0.v.d.c.h.a aVar = this.f49251e;
            if (aVar != null) {
                aVar.k();
            }
            AlaLiveUserNotifyController alaLiveUserNotifyController = this.f49252f;
            if (alaLiveUserNotifyController != null) {
                alaLiveUserNotifyController.onDestroy();
            }
            AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.f49253g);
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onLazyLoad();
            this.f49256j = true;
            this.f49251e.s();
            h();
        }
    }

    @Override // c.a.q0.v0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // c.a.q0.v0.n0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                c.a.q0.v.d.c.h.a aVar = this.f49251e;
                if (aVar != null) {
                    aVar.u(true);
                }
            } else {
                c.a.q0.v.d.c.h.a aVar2 = this.f49251e;
                if (aVar2 != null) {
                    aVar2.u(false);
                }
            }
            c.a.q0.v.d.c.h.a aVar3 = this.f49251e;
            if (aVar3 != null) {
                aVar3.w(isPrimary());
            }
        }
    }

    @Override // c.a.q0.v0.n0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f49251e.x();
        }
    }

    public void reload() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && isAdded()) {
            h();
            this.f49251e.s();
        }
    }

    public void setHeaderViewHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    @Override // c.a.q0.v0.n0
    public void setRecommendFrsNavigationAnimDispatcher(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d0Var) == null) {
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // c.a.q0.v0.n0
    public void showFloatingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new e(this));
            }
            this.mRefreshView.o();
            this.mRefreshView.l(null);
            this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.f49251e.z(false);
            this.mRefreshView.k(0);
            this.mRefreshView.attachView(this.f49251e.m(), false);
        }
    }
}
