package com.baidu.tieba.frs.itemtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.c;
import c.a.t0.d1.d1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.d1.n2.d;
import c.a.t0.d1.q0;
import c.a.t0.d1.s0;
import c.a.t0.d1.t;
import c.a.t0.g0.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsItemTabFragment extends BaseFragment implements VoiceManager.j, q0, s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f43526e;

    /* renamed from: f  reason: collision with root package name */
    public c f43527f;
    public String forumId;
    public String forumName;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.d1.n2.b f43528g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.d1.n2.c f43529h;

    /* renamed from: i  reason: collision with root package name */
    public String f43530i;
    public int itemId;

    /* renamed from: j  reason: collision with root package name */
    public BdUniqueId f43531j;
    public VoiceManager k;
    public int l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public boolean needLog;
    public int tabId;
    public int tabType;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsItemTabFragment frsItemTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemTabFragment, Integer.valueOf(i2)};
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
            this.a = frsItemTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int parseInt = Integer.parseInt(data.toString());
                FrsItemTabFragment frsItemTabFragment = this.a;
                if (parseInt == frsItemTabFragment.tabId) {
                    if (frsItemTabFragment.f43528g != null) {
                        this.a.f43528g.o(0);
                    }
                    if (this.a.f43527f != null && this.a.f43527f.isViewAttached()) {
                        this.a.onNetRefreshButtonClicked();
                        return;
                    }
                    this.a.setIsRefresh(true);
                    this.a.onPullRefresh();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsItemTabFragment frsItemTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemTabFragment, Integer.valueOf(i2)};
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
            this.a = frsItemTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.s.j0.p.b)) {
                c.a.s0.s.j0.p.b bVar = (c.a.s0.s.j0.p.b) customResponsedMessage.getData();
                String str = this.a.forumId;
                if (str == null) {
                    str = "";
                }
                bVar.j(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.a.itemId);
                c.a.s0.s.j0.p.c.c(bVar);
            }
        }
    }

    public FrsItemTabFragment() {
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
        this.l = -1;
        this.m = new a(this, 2001624);
        this.n = new b(this, 2921573);
    }

    @Override // c.a.t0.d1.q0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            View view = this.f43526e;
            view.setPadding(view.getPaddingLeft(), this.f43526e.getPaddingTop(), this.f43526e.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(d1.tbds150) : this.f43526e.getPaddingBottom());
            this.f43528g.i(z);
        }
    }

    @Override // c.a.t0.d1.q0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            scrollToTop();
            c.a.t0.d1.n2.c cVar = this.f43529h;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? g1.frs_item_tab_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.k == null) {
                this.k = VoiceManager.instance();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            c.a.t0.d1.n2.b bVar = this.f43528g;
            if (bVar != null) {
                bVar.q(true);
            }
            c cVar = this.f43527f;
            if (cVar != null) {
                cVar.dettachView(view);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.t0.d1.n2.b bVar = this.f43528g;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.tabId = bundle.getInt("tab_id");
                this.tabType = bundle.getInt("tab_type");
                this.itemId = c.a.d.f.m.b.e(bundle.getString("tab_code"), 0);
                this.forumId = bundle.getString("forum_id");
                this.forumName = bundle.getString("name");
                this.needLog = bundle.getBoolean(FrsCommonTabFragment.NEED_LOG);
                this.f43530i = bundle.getString(FrsCommonTabFragment.THEME_COLOR);
                this.l = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.tabId = arguments.getInt("tab_id");
                    this.tabType = arguments.getInt("tab_type");
                    this.itemId = c.a.d.f.m.b.e(arguments.getString("tab_code"), 0);
                    this.forumId = arguments.getString("forum_id");
                    this.forumName = arguments.getString("name");
                    this.needLog = arguments.getBoolean(FrsCommonTabFragment.NEED_LOG);
                    this.l = arguments.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
                    this.f43530i = arguments.getString(FrsCommonTabFragment.THEME_COLOR);
                }
            }
            VoiceManager voiceManager = getVoiceManager();
            this.k = voiceManager;
            voiceManager.onCreate(getPageContext());
            c.a.t0.v3.c.g().i(getUniqueId());
            this.f43529h = new c.a.t0.d1.n2.c(this, this.itemId);
            if (this.l != -1) {
                c.a.s0.s.j0.p.b bVar = new c.a.s0.s.j0.p.b(5);
                String str = this.forumId;
                if (str == null) {
                    str = "";
                }
                bVar.j(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.itemId);
                bVar.n(this.l);
                c.a.s0.s.j0.p.c.c(bVar);
            }
            registerListener(this.m);
            registerListener(this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
            this.f43526e = inflate;
            c.a.t0.d1.n2.b bVar = new c.a.t0.d1.n2.b(this, inflate);
            this.f43528g = bVar;
            bVar.p(this.f43530i);
            this.f43528g.n(this.f43531j);
            return this.f43526e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.t0.v3.c.g().k(getUniqueId());
            v.b().e(false);
            super.onDestroy();
            c.a.t0.d1.n2.b bVar = this.f43528g;
            if (bVar != null) {
                bVar.k();
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLazyLoad();
            if (l.z()) {
                showLoadingView(this.f43526e, false, getResources().getDimensionPixelSize(d1.ds250));
                pullRefresh();
                return;
            }
            showNetRefreshView(this.f43526e, null, true);
        }
    }

    @Override // c.a.t0.d1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && l.z()) {
            hideNetRefreshView(this.f43526e);
            showLoadingView(this.f43526e, false, getResources().getDimensionPixelSize(d1.ds250));
            pullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            boolean z = true;
            if (isAdded() && isPrimary()) {
                TbSingleton.getInstance().isItemTabVisible = true;
                if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            } else {
                TbSingleton.getInstance().isItemTabVisible = false;
            }
            c.a.t0.d1.n2.b bVar = this.f43528g;
            if (bVar != null) {
                bVar.l((isAdded() && isPrimary()) ? false : false);
            }
        }
    }

    @Override // c.a.t0.d1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getContext() == null) {
            return;
        }
        if (l.z()) {
            hideNetRefreshView(this.f43526e);
            if (this.f43529h.a()) {
                hideLoadingView(this.f43526e);
            } else {
                showLoadingView(this.f43526e, false, getResources().getDimensionPixelSize(d1.ds250));
            }
            pullRefresh();
            return;
        }
        setIsRefresh(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.tabId);
            bundle.putInt("tab_type", this.tabType);
            bundle.putString("tab_code", this.itemId + "");
            bundle.putString("forum_id", this.forumId);
            bundle.putString("name", this.forumName);
            bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.needLog);
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, errorData) == null) {
            hideLoadingView(this.f43526e);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(i1.im_error_default);
                }
            }
            if (!this.f43529h.a()) {
                showNetRefreshView(this.f43526e, errorData != null ? getPageContext().getResources().getString(i1.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            setIsRefresh(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStop();
            c.a.t0.v3.c.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public void onViewDataChange(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) || dVar == null) {
            return;
        }
        hideLoadingView(this.f43526e);
        if (this.f43528g != null) {
            setIsRefresh(false);
            this.f43528g.m(dVar);
        }
        c.a.t0.v3.c.g().h(getUniqueId(), false);
    }

    public final void pullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && n.C()) {
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            c.a.t0.d1.n2.c cVar = this.f43529h;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    @Override // c.a.t0.d1.q0
    public void scrollToTop() {
        c.a.t0.d1.n2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bVar = this.f43528g) == null) {
            return;
        }
        bVar.o(0);
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.f43531j = bdUniqueId;
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            t tVar = new t();
            tVar.a = this.tabId;
            tVar.f16576b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048602, this, view, str, z) == null) {
            c.a.t0.d1.n2.b bVar = this.f43528g;
            if (bVar != null) {
                bVar.q(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.f43527f == null) {
                this.f43527f = new c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.f43527f.e(null);
            this.f43527f.d(str);
            this.f43527f.c(null);
            this.f43527f.attachView(view, z);
            this.f43527f.f();
            this.f43527f.a(0);
        }
    }
}
