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
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.a28;
import com.baidu.tieba.aba;
import com.baidu.tieba.au4;
import com.baidu.tieba.b28;
import com.baidu.tieba.bc;
import com.baidu.tieba.bu4;
import com.baidu.tieba.co;
import com.baidu.tieba.da5;
import com.baidu.tieba.ej7;
import com.baidu.tieba.jt5;
import com.baidu.tieba.lo5;
import com.baidu.tieba.lu6;
import com.baidu.tieba.m7a;
import com.baidu.tieba.o7a;
import com.baidu.tieba.r48;
import com.baidu.tieba.r66;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class PersonalizeFragment extends BaseFragment implements ej7, VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalizePageView a;
    public VoiceManager b;
    public a28 c;
    public boolean d;
    public final Object e;
    public CustomMessageListener f;
    public final CustomMessageListener g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;

    @Override // com.baidu.tieba.ej7
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ej7
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.gt5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? "a002" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? "713" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements lo5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ PersonalizeFragment b;

        public a(PersonalizeFragment personalizeFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizeFragment;
            this.a = context;
        }

        @Override // com.baidu.tieba.lo5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new PersonalizePageView(this.a);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonalizeFragment personalizeFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i)};
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
            this.a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.isPrimary()) {
                return;
            }
            this.a.Q1();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalizeFragment personalizeFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i)};
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
            this.a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && this.a.a != null) {
                this.a.a.r0(l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalizeFragment personalizeFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i)};
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
            this.a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.a.c1();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalizeFragment personalizeFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeFragment, Integer.valueOf(i)};
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
            this.a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.isResumed()) {
                return;
            }
            this.a.startBrowseTimeMission();
        }
    }

    public PersonalizeFragment() {
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
        this.d = false;
        this.e = new Object();
        this.f = new b(this, 2921029);
        this.g = new c(this, 2921313);
        this.h = new d(this, 2001371);
        this.i = new e(this, 2921391);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.b;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            aba.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.i);
            this.b = null;
            this.a.T0();
            this.d = true;
            lo5.e().b();
            lu6.b().unregister(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPause();
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView != null) {
                personalizePageView.X0();
                this.a.U0();
                this.a.setTabInForeBackgroundState(true);
            }
            MessageManager.getInstance().unRegisterListener(this.h);
            VoiceManager voiceManager = this.b;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            if (bu4.w().y(au4.b0)) {
                bu4.w().E();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5052);
            super.onResume();
            VoiceManager voiceManager = this.b;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.a.V0();
            this.a.setTabInForeBackgroundState(false);
            MessageManager.getInstance().registerListener(this.h);
            startBrowseTimeMission();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_RESUME_END_STAMP_KEY);
        }
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = new Object();
        this.f = new b(this, 2921029);
        this.g = new c(this, 2921313);
        this.h = new d(this, 2001371);
        this.i = new e(this, 2921391);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_START_STAMP_KEY);
        PersonalizePageView personalizePageView = (PersonalizePageView) lo5.e().d(1011, new a(this, context));
        this.a = personalizePageView;
        if (personalizePageView == null) {
            this.a = new PersonalizePageView(context);
        }
        this.a.E0(context);
        this.a.F0();
        SpeedStatsManager.getInstance().addStatsTimeStamp(5047);
    }

    public void O1(a28 a28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, a28Var) == null) {
            this.c = a28Var;
            this.a.setCallback(a28Var);
        }
    }

    public void P1(b28 b28Var) {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, b28Var) == null) && (personalizePageView = this.a) != null) {
            personalizePageView.setScrollFragmentTabHost(b28Var);
        }
    }

    public void R1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.m1(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.S0(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            aba.g().i(getUniqueId());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.q9
    public void onPreLoad(co coVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, coVar) == null) && !TbadkCoreApplication.getInst().checkInterrupt()) {
            super.onPreLoad(coVar);
        }
    }

    @Override // com.baidu.tieba.ej7
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.a1();
        }
    }

    public final void K1() {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && r48.a(getBaseFragmentActivity()) && (personalizePageView = this.a) != null) {
            personalizePageView.b1();
        }
    }

    public void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.o0();
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.t0();
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.Q0();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.setViewForeground(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public jt5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            jt5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            return pageStayDurationItem;
        }
        return (jt5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ej7
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (personalizePageView = this.a) != null) {
            personalizePageView.P0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.b;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStop();
            aba.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.b;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public final void startBrowseTimeMission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            bu4.w().O(au4.b0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView != null) {
                return personalizePageView.getmTaskFloatingView();
            }
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.b == null) {
                this.b = VoiceManager.instance();
            }
            return this.b;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && TbadkCoreApplication.getInst().isFirstTimeMotivate() && !da5.p().l("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.gt5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.a.setViewForeground();
                K1();
                Q1();
                this.a.f1();
                r66.c().e("page_recommend");
                return;
            }
            this.a.X0();
            r66.c().d("page_recommend");
            bc.b().f();
        }
    }

    public void S1(DataRes dataRes, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a.n1(dataRes, z, z2);
        }
    }

    public void T1(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) {
            this.a.o1(str, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VoiceManager y0 = y0();
            this.b = y0;
            if (y0 != null) {
                y0.onCreate(getPageContext());
            }
            registerListener(this.f);
            registerListener(this.g);
            registerListener(this.i);
            lu6.b().a(this.e, new o7a());
            lu6.b().a(this.e, new m7a());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_VIEW_START_STAMP_KEY);
            if (this.a == null) {
                PersonalizePageView personalizePageView = new PersonalizePageView(getActivity());
                this.a = personalizePageView;
                personalizePageView.E0(getActivity());
                this.a.F0();
                this.d = false;
            }
            if (this.a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
                a28 a28Var = this.c;
                if (a28Var != null) {
                    this.a.setCallback(a28Var);
                }
            }
            this.a.setPageUniqueId(getUniqueId());
            if (this.d) {
                this.a.F0();
                this.d = false;
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5051);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }
}
