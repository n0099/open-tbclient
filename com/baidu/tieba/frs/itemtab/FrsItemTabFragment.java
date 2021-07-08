package com.baidu.tieba.frs.itemtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.d0.c;
import d.a.p0.u0.a2.d;
import d.a.p0.u0.p0;
import d.a.p0.u0.r0;
import d.a.p0.u0.t;
/* loaded from: classes4.dex */
public class FrsItemTabFragment extends BaseFragment implements VoiceManager.j, p0, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15906e;

    /* renamed from: f  reason: collision with root package name */
    public int f15907f;

    /* renamed from: g  reason: collision with root package name */
    public int f15908g;

    /* renamed from: h  reason: collision with root package name */
    public String f15909h;

    /* renamed from: i  reason: collision with root package name */
    public String f15910i;
    public boolean j;
    public View k;
    public c l;
    public d.a.p0.u0.a2.b m;
    public d.a.p0.u0.a2.c n;
    public String o;
    public VoiceManager p;
    public int q;
    public CustomMessageListener r;
    public CustomMessageListener s;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsItemTabFragment f15911a;

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
            this.f15911a = frsItemTabFragment;
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
                FrsItemTabFragment frsItemTabFragment = this.f15911a;
                if (parseInt == frsItemTabFragment.f15906e) {
                    if (frsItemTabFragment.m != null) {
                        this.f15911a.m.j(0);
                    }
                    if (this.f15911a.l != null && this.f15911a.l.isViewAttached()) {
                        this.f15911a.onNetRefreshButtonClicked();
                        return;
                    }
                    this.f15911a.M0(true);
                    this.f15911a.l0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsItemTabFragment f15912a;

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
            this.f15912a = frsItemTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.u0.a2.h.a)) {
                d.a.p0.u0.a2.h.a aVar = (d.a.p0.u0.a2.h.a) customResponsedMessage.getData();
                String str = this.f15912a.f15909h;
                if (str == null) {
                    str = "";
                }
                aVar.h(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.f15912a.f15908g);
                d.a.p0.u0.a2.h.b.a(aVar);
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
        this.q = -1;
        this.r = new a(this, 2001624);
        this.s = new b(this, 2921573);
    }

    @Override // d.a.p0.u0.p0
    public void E0() {
        d.a.p0.u0.a2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.j(0);
    }

    @Override // d.a.p0.u0.r0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.frs_item_tab_fragment : invokeV.intValue;
    }

    public void K0(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        hideLoadingView(this.k);
        if (this.m != null) {
            M0(false);
            this.m.i(dVar);
        }
        d.a.p0.g3.c.g().h(getUniqueId(), false);
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && l.D()) {
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            d.a.p0.u0.a2.c cVar = this.n;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            t tVar = new t();
            tVar.f63805a = this.f15906e;
            tVar.f63806b = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.p == null) {
                this.p = VoiceManager.instance();
            }
            return this.p;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            d.a.p0.u0.a2.b bVar = this.m;
            if (bVar != null) {
                bVar.l(true);
            }
            c cVar = this.l;
            if (cVar != null) {
                cVar.dettachView(view);
            }
        }
    }

    @Override // d.a.p0.u0.r0
    public void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || getContext() == null) {
            return;
        }
        if (j.z()) {
            hideNetRefreshView(this.k);
            if (this.n.a()) {
                hideLoadingView(this.k);
            } else {
                showLoadingView(this.k, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            L0();
            return;
        }
        M0(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.p0.u0.a2.b bVar = this.m;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f15906e = bundle.getInt("tab_id");
                this.f15907f = bundle.getInt("tab_type");
                this.f15908g = d.a.c.e.m.b.d(bundle.getString(LowFlowsActivityConfig.TAB_CODE), 0);
                this.f15909h = bundle.getString("forum_id");
                this.f15910i = bundle.getString("name");
                this.j = bundle.getBoolean("need_log");
                this.o = bundle.getString("theme_color");
                this.q = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f15906e = arguments.getInt("tab_id");
                    this.f15907f = arguments.getInt("tab_type");
                    this.f15908g = d.a.c.e.m.b.d(arguments.getString(LowFlowsActivityConfig.TAB_CODE), 0);
                    this.f15909h = arguments.getString("forum_id");
                    this.f15910i = arguments.getString("name");
                    this.j = arguments.getBoolean("need_log");
                    this.q = arguments.getInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
                    this.o = arguments.getString("theme_color");
                }
            }
            VoiceManager voiceManager = getVoiceManager();
            this.p = voiceManager;
            voiceManager.onCreate(getPageContext());
            d.a.p0.g3.c.g().i(getUniqueId());
            this.n = new d.a.p0.u0.a2.c(this, this.f15908g);
            if (this.q != -1) {
                d.a.p0.u0.a2.h.a aVar = new d.a.p0.u0.a2.h.a(5);
                String str = this.f15909h;
                if (str == null) {
                    str = "";
                }
                aVar.h(str, TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount() : "", this.f15908g);
                aVar.i(this.q);
                d.a.p0.u0.a2.h.b.a(aVar);
            }
            registerListener(this.r);
            registerListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(J0(), (ViewGroup) null);
            this.k = inflate;
            d.a.p0.u0.a2.b bVar = new d.a.p0.u0.a2.b(this, inflate);
            this.m = bVar;
            bVar.k(this.o);
            return this.k;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.p0.g3.c.g().k(getUniqueId());
            d.a.p0.a0.t.b().e(false);
            super.onDestroy();
            d.a.p0.u0.a2.b bVar = this.m;
            if (bVar != null) {
                bVar.g();
            }
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onLazyLoad();
            if (j.z()) {
                showLoadingView(this.k, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                L0();
                return;
            }
            showNetRefreshView(this.k, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && j.z()) {
            hideNetRefreshView(this.k);
            showLoadingView(this.k, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            L0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.isLazyLoaded) {
                onLazyLoad();
            }
            d.a.p0.u0.a2.b bVar = this.m;
            if (bVar != null) {
                bVar.h(isAdded() && isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.f15906e);
            bundle.putInt("tab_type", this.f15907f);
            bundle.putString(LowFlowsActivityConfig.TAB_CODE, this.f15908g + "");
            bundle.putString("forum_id", this.f15909h);
            bundle.putString("name", this.f15910i);
            bundle.putBoolean("need_log", this.j);
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, errorData) == null) {
            hideLoadingView(this.k);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            if (!this.n.a()) {
                showNetRefreshView(this.k, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            M0(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            d.a.p0.g3.c.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // d.a.p0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            E0();
            d.a.p0.u0.a2.c cVar = this.n;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048600, this, view, str, z) == null) {
            d.a.p0.u0.a2.b bVar = this.m;
            if (bVar != null) {
                bVar.l(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.l == null) {
                this.l = new c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.l.e(null);
            this.l.d(str);
            this.l.c(null);
            this.l.attachView(view, z);
            this.l.f();
            this.l.a(0);
        }
    }
}
