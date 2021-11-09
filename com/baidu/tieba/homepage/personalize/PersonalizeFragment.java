package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.q;
import b.a.r0.x0.n0;
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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class PersonalizeFragment extends BaseFragment implements n0, VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonalizePageView f49609e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f49610f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.d.b f49611g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49612h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f49613i;
    public final CustomMessageListener j;
    public final CustomMessageListener k;
    public final CustomMessageListener l;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f49614a;

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
            this.f49614a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f49614a.isPrimary()) {
                this.f49614a.h();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f49615a;

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
            this.f49615a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || this.f49615a.f49609e == null) {
                return;
            }
            this.f49615a.f49609e.deleteGodReplyInThread(l);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f49616a;

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
            this.f49616a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f49616a.f49609e.showActivityPrize();
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizeFragment f49617a;

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
            this.f49617a = personalizeFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f49617a.isResumed()) {
                this.f49617a.i();
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
        this.f49612h = false;
        this.f49613i = new a(this, 2921029);
        this.j = new b(this, 2921313);
        this.k = new c(this, 2001371);
        this.l = new d(this, 2921391);
    }

    @Override // b.a.r0.x0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void completePullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49609e.completePullRefresh();
        }
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49609e.setViewForeground(true);
        }
    }

    public void forceReloadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f49609e.forceReload();
        }
    }

    public final void g() {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b.a.r0.h1.h.c.a(getBaseFragmentActivity()) && (personalizePageView = this.f49609e) != null) {
            personalizePageView.scrollToPositionFromMemory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a002" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
    public b.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().q);
            }
            return pageStayDurationItem;
        }
        return (b.a.q0.o0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f49610f == null) {
                this.f49610f = VoiceManager.instance();
            }
            return this.f49610f;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && TbadkCoreApplication.getInst().isFirstTimeMotivate() && !b.a.q0.s.e0.b.j().g("show_recommend_label", false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.q0.a.d.y().N(b.a.q0.a.c.Y);
        }
    }

    public void notifyJumpToLastReadPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f49609e.notifyJumpToLastReadPosition();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.f49610f = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            this.f49613i.setTag(getUniqueId());
            registerListener(this.f49613i);
            registerListener(this.j);
            registerListener(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f49609e.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            b.a.r0.k3.c.g().i(getUniqueId());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_VIEW_START_STAMP_KEY);
            if (this.f49609e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f49609e.getParent()).removeView(this.f49609e);
                b.a.r0.h1.d.b bVar = this.f49611g;
                if (bVar != null) {
                    this.f49609e.setCallback(bVar);
                }
            }
            this.f49609e.setPageUniqueId(getUniqueId());
            if (this.f49612h) {
                this.f49609e.initListeners();
                this.f49612h = false;
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.f49609e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            VoiceManager voiceManager = this.f49610f;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            b.a.r0.k3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.f49613i);
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.l);
            this.f49610f = null;
            this.f49609e.onDestroy();
            this.f49612h = true;
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onLazyLoad();
        }
    }

    @Override // b.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // b.a.r0.x0.n0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            PersonalizePageView personalizePageView = this.f49609e;
            if (personalizePageView != null) {
                personalizePageView.onViewBackGround();
                this.f49609e.onPause();
                this.f49609e.setTabInForeBackgroundState(true);
            }
            MessageManager.getInstance().unRegisterListener(this.k);
            VoiceManager voiceManager = this.f49610f;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            b.a.q0.a.d.y().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.e.a.i
    public void onPreLoad(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, qVar) == null) || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        super.onPreLoad(qVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.f49609e.setViewForeground();
                g();
                h();
                b.a.r0.p.d.c().e("page_recommend");
                return;
            }
            this.f49609e.onViewBackGround();
            b.a.r0.p.d.c().d("page_recommend");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_RESUME_START_STAMP_KEY);
            super.onResume();
            b.a.q0.s.n.b.i().n(true);
            VoiceManager voiceManager = this.f49610f;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.f49609e.onResume();
            this.f49609e.setTabInForeBackgroundState(false);
            MessageManager.getInstance().registerListener(this.k);
            i();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_ON_RESUME_END_STAMP_KEY);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.f49610f;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStop();
            b.a.r0.k3.c.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.f49610f;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // b.a.r0.x0.n0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f49609e.reload();
        }
    }

    public void setCallback(b.a.r0.h1.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.f49611g = bVar;
            this.f49609e.setCallback(bVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizePageView personalizePageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, scrollFragmentTabHost) == null) || (personalizePageView = this.f49609e) == null) {
            return;
        }
        personalizePageView.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f49609e.showFirstLoadingView();
        }
    }

    public void startFirstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f49609e.startFirstLoad();
        }
    }

    public void updateData(DataRes dataRes, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f49609e.updateData(dataRes, z, z2);
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, str, i2) == null) {
            this.f49609e.updateError(str, i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49612h = false;
        this.f49613i = new a(this, 2921029);
        this.j = new b(this, 2921313);
        this.k = new c(this, 2001371);
        this.l = new d(this, 2921391);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PERSONALIZE_TAB_START_STAMP_KEY);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f13367a instanceof PersonalizePageView) && TbadkCoreApplication.getInst().getPersonalizeViewData().f13367a.getParent() == null) {
            this.f49609e = (PersonalizePageView) TbadkCoreApplication.getInst().getPersonalizeViewData().f13367a;
        }
        if (this.f49609e == null) {
            this.f49609e = new PersonalizePageView(context);
        }
        this.f49609e.init(context);
        this.f49609e.initListeners();
        SpeedStatsManager.getInstance().addStatsTimeStamp(5047);
    }
}
