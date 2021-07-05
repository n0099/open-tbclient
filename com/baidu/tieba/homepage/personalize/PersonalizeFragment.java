package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.q;
import d.a.r0.z0.b0;
import d.a.s0.u0.n0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes5.dex */
public class PersonalizeFragment extends BaseFragment implements n0, VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonalizePageView f16653e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f16654f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.e1.d.b f16655g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16656h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16657i;
    public final CustomMessageListener j;
    public final CustomMessageListener k;
    public final CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f16658a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalizeFragment personalizeFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i2)};
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
            this.f16658a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f16658a.isPrimary()) {
                this.f16658a.P0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f16659a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonalizeFragment personalizeFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i2)};
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
            this.f16659a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || this.f16659a.f16653e == null) {
                return;
            }
            this.f16659a.f16653e.V(l);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f16660a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalizeFragment personalizeFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i2)};
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
            this.f16660a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f16660a.f16653e.s0();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f16661a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalizeFragment personalizeFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i2)};
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
            this.f16661a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f16661a.isResumed()) {
                this.f16661a.Q0();
            }
        }
    }

    public PersonalizeFragment() {
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
        this.f16656h = false;
        this.f16657i = new a(this, 2921029);
        this.j = new b(this, 2921313);
        this.k = new c(this, 2001371);
        this.l = new d(this, 2921391);
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
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void J0() {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && d.a.s0.e1.h.c.a(getBaseFragmentActivity()) && (personalizePageView = this.f16653e) != null) {
            personalizePageView.r0();
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16653e.U();
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16653e.W();
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16653e.h0();
        }
    }

    public void N0(d.a.s0.e1.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f16655g = bVar;
            this.f16653e.setCallback(bVar);
        }
    }

    public void O0(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, scrollFragmentTabHost) == null) || (personalizePageView = this.f16653e) == null) {
            return;
        }
        personalizePageView.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && TbadkCoreApplication.getInst().isFirstTimeMotivate() && !d.a.r0.r.d0.b.j().g("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.r0.a.d.y().N(d.a.r0.a.c.Y);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16653e.w0();
        }
    }

    public void S0(DataRes dataRes, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f16653e.x0(dataRes, z, z2);
        }
    }

    public void T0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            this.f16653e.y0(str, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "a002" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (super.getCurrentPageSourceKeyList() != null) {
                arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
            } else {
                arrayList = new ArrayList();
            }
            if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
                arrayList.add("a001");
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.r0.k0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d.a.r0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.n(TbadkCoreApplication.getInst().getAdAdSense().r);
            }
            return pageStayDurationItem;
        }
        return (d.a.r0.k0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f16654f == null) {
                this.f16654f = VoiceManager.instance();
            }
            return this.f16654f;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.f16654f = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            this.f16657i.setTag(getUniqueId());
            registerListener(this.f16657i);
            registerListener(this.j);
            registerListener(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f16653e.j0(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            d.a.s0.g3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f16653e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f16653e.getParent()).removeView(this.f16653e);
                d.a.s0.e1.d.b bVar = this.f16655g;
                if (bVar != null) {
                    this.f16653e.setCallback(bVar);
                }
            }
            this.f16653e.setPageUniqueId(getUniqueId());
            if (this.f16656h) {
                this.f16653e.b0();
                this.f16656h = false;
            }
            return this.f16653e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.f16654f;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.s0.g3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.f16657i);
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.l);
            this.f16654f = null;
            this.f16653e.k0();
            this.f16656h = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onLazyLoad();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            PersonalizePageView personalizePageView = this.f16653e;
            if (personalizePageView != null) {
                personalizePageView.o0();
                this.f16653e.l0();
                this.f16653e.setTabInForeBackgroundState(true);
            }
            MessageManager.getInstance().unRegisterListener(this.k);
            VoiceManager voiceManager = this.f16654f;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            d.a.r0.a.d.y().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.c.a.i
    public void onPreLoad(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, qVar) == null) || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        super.onPreLoad(qVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.f16653e.setViewForeground();
                J0();
                P0();
                d.a.s0.o.d.c().e("page_recommend");
                return;
            }
            this.f16653e.o0();
            d.a.s0.o.d.c().d("page_recommend");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            d.a.r0.r.n.b.i().n(true);
            VoiceManager voiceManager = this.f16654f;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.f16653e.m0();
            this.f16653e.setTabInForeBackgroundState(false);
            MessageManager.getInstance().registerListener(this.k);
            Q0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.f16654f;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStop();
            d.a.s0.g3.c.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.f16654f;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // d.a.s0.u0.n0
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f16653e.q0();
        }
    }

    @Override // d.a.s0.u0.n0
    public void r() {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (personalizePageView = this.f16653e) == null) {
            return;
        }
        personalizePageView.t0();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f16653e.setViewForeground(true);
        }
    }

    @Override // d.a.s0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void x(b0 b0Var) {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, b0Var) == null) || (personalizePageView = this.f16653e) == null) {
            return;
        }
        personalizePageView.setRecommendFrsNavigationAnimDispatcher(b0Var);
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16656h = false;
        this.f16657i = new a(this, 2921029);
        this.j = new b(this, 2921313);
        this.k = new c(this, 2001371);
        this.l = new d(this, 2921391);
        PersonalizePageView personalizePageView = new PersonalizePageView(context);
        this.f16653e = personalizePageView;
        personalizePageView.b0();
    }
}
