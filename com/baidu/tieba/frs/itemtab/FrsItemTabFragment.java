package com.baidu.tieba.frs.itemtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.o0.f0.c;
import c.a.p0.a0.t;
import c.a.p0.v0.a2.d;
import c.a.p0.v0.p0;
import c.a.p0.v0.r0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FrsItemTabFragment extends BaseFragment implements VoiceManager.j, p0, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f51133e;

    /* renamed from: f  reason: collision with root package name */
    public c f51134f;
    public String forumId;
    public String forumName;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.v0.a2.b f51135g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.v0.a2.c f51136h;

    /* renamed from: i  reason: collision with root package name */
    public String f51137i;
    public int itemId;

    /* renamed from: j  reason: collision with root package name */
    public VoiceManager f51138j;
    public int k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public boolean needLog;
    public int tabId;
    public int tabType;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsItemTabFragment f51139a;

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
            this.f51139a = frsItemTabFragment;
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
                FrsItemTabFragment frsItemTabFragment = this.f51139a;
                if (parseInt == frsItemTabFragment.tabId) {
                    if (frsItemTabFragment.f51135g != null) {
                        this.f51139a.f51135g.l(0);
                    }
                    if (this.f51139a.f51134f != null && this.f51139a.f51134f.isViewAttached()) {
                        this.f51139a.onNetRefreshButtonClicked();
                        return;
                    }
                    this.f51139a.setIsRefresh(true);
                    this.f51139a.onPullRefresh();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsItemTabFragment f51140a;

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
            this.f51140a = frsItemTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.o0.s.f0.p.b)) {
                c.a.o0.s.f0.p.b bVar = (c.a.o0.s.f0.p.b) customResponsedMessage.getData();
                String str = this.f51140a.forumId;
                if (str == null) {
                    str = "";
                }
                bVar.h(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.f51140a.itemId);
                c.a.p0.v0.a2.h.a.a(bVar);
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
        this.k = -1;
        this.l = new a(this, 2001624);
        this.m = new b(this, 2921573);
    }

    @Override // c.a.p0.v0.p0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            View view = this.f51133e;
            view.setPadding(view.getPaddingLeft(), this.f51133e.getPaddingTop(), this.f51133e.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(R.dimen.tbds200) : this.f51133e.getPaddingRight());
        }
    }

    @Override // c.a.p0.v0.p0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            scrollToTop();
            c.a.p0.v0.a2.c cVar = this.f51136h;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.frs_item_tab_fragment : invokeV.intValue;
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
            if (this.f51138j == null) {
                this.f51138j = VoiceManager.instance();
            }
            return this.f51138j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            c.a.p0.v0.a2.b bVar = this.f51135g;
            if (bVar != null) {
                bVar.n(true);
            }
            c cVar = this.f51134f;
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
            c.a.p0.v0.a2.b bVar = this.f51135g;
            if (bVar != null) {
                bVar.h();
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
                this.itemId = c.a.e.e.m.b.d(bundle.getString("tab_code"), 0);
                this.forumId = bundle.getString("forum_id");
                this.forumName = bundle.getString("name");
                this.needLog = bundle.getBoolean(FrsCommonTabFragment.NEED_LOG);
                this.f51137i = bundle.getString(FrsCommonTabFragment.THEME_COLOR);
                this.k = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.tabId = arguments.getInt("tab_id");
                    this.tabType = arguments.getInt("tab_type");
                    this.itemId = c.a.e.e.m.b.d(arguments.getString("tab_code"), 0);
                    this.forumId = arguments.getString("forum_id");
                    this.forumName = arguments.getString("name");
                    this.needLog = arguments.getBoolean(FrsCommonTabFragment.NEED_LOG);
                    this.k = arguments.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
                    this.f51137i = arguments.getString(FrsCommonTabFragment.THEME_COLOR);
                }
            }
            VoiceManager voiceManager = getVoiceManager();
            this.f51138j = voiceManager;
            voiceManager.onCreate(getPageContext());
            c.a.p0.h3.c.g().i(getUniqueId());
            this.f51136h = new c.a.p0.v0.a2.c(this, this.itemId);
            if (this.k != -1) {
                c.a.o0.s.f0.p.b bVar = new c.a.o0.s.f0.p.b(5);
                String str = this.forumId;
                if (str == null) {
                    str = "";
                }
                bVar.h(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.itemId);
                bVar.i(this.k);
                c.a.p0.v0.a2.h.a.a(bVar);
            }
            registerListener(this.l);
            registerListener(this.m);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
            this.f51133e = inflate;
            c.a.p0.v0.a2.b bVar = new c.a.p0.v0.a2.b(this, inflate);
            this.f51135g = bVar;
            bVar.m(this.f51137i);
            return this.f51133e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.h3.c.g().k(getUniqueId());
            t.b().e(false);
            super.onDestroy();
            c.a.p0.v0.a2.b bVar = this.f51135g;
            if (bVar != null) {
                bVar.i();
            }
            VoiceManager voiceManager = this.f51138j;
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
            if (j.z()) {
                showLoadingView(this.f51133e, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                pullRefresh();
                return;
            }
            showNetRefreshView(this.f51133e, null, true);
        }
    }

    @Override // c.a.p0.v0.r0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && j.z()) {
            hideNetRefreshView(this.f51133e);
            showLoadingView(this.f51133e, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            pullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.f51138j;
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
            if (isAdded() && isPrimary() && !this.isLazyLoaded) {
                onLazyLoad();
            }
            c.a.p0.v0.a2.b bVar = this.f51135g;
            if (bVar != null) {
                bVar.j(isAdded() && isPrimary());
            }
        }
    }

    @Override // c.a.p0.v0.r0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getContext() == null) {
            return;
        }
        if (j.z()) {
            hideNetRefreshView(this.f51133e);
            if (this.f51136h.a()) {
                hideLoadingView(this.f51133e);
            } else {
                showLoadingView(this.f51133e, false, getResources().getDimensionPixelSize(R.dimen.ds250));
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
            VoiceManager voiceManager = this.f51138j;
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
            VoiceManager voiceManager = this.f51138j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, errorData) == null) {
            hideLoadingView(this.f51133e);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            if (!this.f51136h.a()) {
                showNetRefreshView(this.f51133e, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            setIsRefresh(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.f51138j;
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
            c.a.p0.h3.c.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.f51138j;
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
        hideLoadingView(this.f51133e);
        if (this.f51135g != null) {
            setIsRefresh(false);
            this.f51135g.k(dVar);
        }
        c.a.p0.h3.c.g().h(getUniqueId(), false);
    }

    public final void pullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l.D()) {
            VoiceManager voiceManager = this.f51138j;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            c.a.p0.v0.a2.c cVar = this.f51136h;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    @Override // c.a.p0.v0.p0
    public void scrollToTop() {
        c.a.p0.v0.a2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bVar = this.f51135g) == null) {
            return;
        }
        bVar.l(0);
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            c.a.p0.v0.t tVar = new c.a.p0.v0.t();
            tVar.f26819a = this.tabId;
            tVar.f26820b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048601, this, view, str, z) == null) {
            c.a.p0.v0.a2.b bVar = this.f51135g;
            if (bVar != null) {
                bVar.n(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.f51134f == null) {
                this.f51134f = new c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.f51134f.e(null);
            this.f51134f.d(str);
            this.f51134f.c(null);
            this.f51134f.attachView(view, z);
            this.f51134f.f();
            this.f51134f.a(0);
        }
    }
}
