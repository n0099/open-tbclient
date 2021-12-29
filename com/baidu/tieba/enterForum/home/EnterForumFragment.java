package com.baidu.tieba.enterForum.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class EnterForumFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.u0.h.a f44168e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.u0.h.c f44169f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f44170g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f44171h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f44172i;

    /* renamed from: j  reason: collision with root package name */
    public ObservedChangeLinearLayout f44173j;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f44174k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public final CustomMessageListener n;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnterForumFragment enterForumFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment, Integer.valueOf(i2)};
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
            this.a = enterForumFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && this.a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.a.getActivity() && this.a.f44168e != null) {
                this.a.f44168e.x();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnterForumFragment enterForumFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment, Integer.valueOf(i2)};
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
            this.a = enterForumFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && this.a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.a.getActivity()) {
                if (this.a.f44168e != null) {
                    this.a.f44168e.M(true);
                }
                if (this.a.f44169f != null) {
                    this.a.f44169f.n();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EnterForumFragment f44175e;

        public c(EnterForumFragment enterForumFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44175e = enterForumFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f44175e.f44168e.M(z);
                if (this.f44175e.getTabViewController() != null) {
                    this.f44175e.getTabViewController().I();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(EnterForumFragment enterForumFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment, Integer.valueOf(i2)};
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
            this.a = enterForumFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && c.a.t0.u0.j.b.b()) {
                c.a.t0.u0.j.b.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(702061834, "Lcom/baidu/tieba/enterForum/home/EnterForumFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(702061834, "Lcom/baidu/tieba/enterForum/home/EnterForumFragment;");
                return;
            }
        }
        new ArrayList();
    }

    public EnterForumFragment() {
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
        this.l = new a(this, 2001629);
        this.m = new b(this, 2001631);
        this.n = new d(this, 2001371);
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f44172i = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
            this.f44170g = (NoNetworkView) view.findViewById(R.id.view_no_network);
            this.f44171h = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
            this.f44173j = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
            c.a.t0.u0.h.a aVar = new c.a.t0.u0.h.a(this);
            this.f44168e = aVar;
            aVar.R(getUniqueId());
            this.f44170g.addNetworkChangeListener(new c(this));
            this.f44172i.addView(this.f44168e.z(), 0);
            this.f44168e.B();
            View findViewById = this.f44172i.findViewById(R.id.enter_forum_ad);
            if (findViewById != null) {
                this.f44172i.removeView(findViewById);
                this.f44172i.addView(findViewById, 0);
            }
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            this.f44168e.G();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "a025" : (String) invokeV.objValue;
    }

    public RelativeLayout getRootLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44172i : (RelativeLayout) invokeV.objValue;
    }

    public ObservedChangeLinearLayout getTabLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44173j : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public c.a.t0.u0.h.c getTabViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44169f : (c.a.t0.u0.h.c) invokeV.objValue;
    }

    public final void i() {
        c.a.t0.u0.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f44168e) == null) {
            return;
        }
        aVar.v(true);
    }

    public boolean isAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.t0.u0.h.a aVar = this.f44168e;
            if (aVar == null || aVar.y() == null) {
                return true;
            }
            return this.f44168e.y().U();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f44172i, R.color.CAM_X0201);
            c.a.t0.u0.h.a aVar = this.f44168e;
            if (aVar != null) {
                aVar.H(i2);
            }
            NoNetworkView noNetworkView = this.f44170g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), i2);
            }
            PluginErrorTipView pluginErrorTipView = this.f44171h;
            if (pluginErrorTipView != null) {
                pluginErrorTipView.onChangeSkinType(getPageContext(), i2);
            }
            if (this.f44174k != null) {
                c.a.s0.x0.a.a(getPageContext(), this.f44174k);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            this.n.setPriority(101);
            registerListener(this.n);
            registerListener(this.l);
            registerListener(this.m);
            c.a.t0.v3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
            e(inflate);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            c.a.t0.v3.c.g().i(getUniqueId());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.t0.u0.h.a aVar = this.f44168e;
            if (aVar != null) {
                aVar.I();
            }
            this.f44169f = null;
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.m);
            MessageManager.getInstance().unRegisterListener(this.n);
            c.a.t0.v3.c.g().k(getUniqueId());
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.t0.v3.c.g().k(getUniqueId());
            super.onDestroyView();
        }
    }

    public void onNavigationbarHeightChange(View view, int i2) {
        c.a.t0.u0.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, view, i2) == null) || (aVar = this.f44168e) == null || aVar.y() == null) {
            return;
        }
        this.f44168e.y().Y(view, i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            c.a.t0.u0.h.a aVar = this.f44168e;
            if (aVar != null) {
                aVar.J();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                switchTab();
                c.a.t0.u0.h.a aVar = this.f44168e;
                if (aVar != null) {
                    refreshImage(aVar.z());
                }
                c.a.t0.v3.c.g().h(getUniqueId(), false);
            }
            c.a.t0.u0.h.a aVar2 = this.f44168e;
            if (aVar2 != null) {
                aVar2.K();
            }
            if (getTabViewController() != null) {
                getTabViewController().I();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            NoNetworkView noNetworkView = this.f44170g;
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && l.z()) {
                this.f44170g.update(false);
            }
        }
    }

    public void setAdState(c.a.t0.u0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f44169f.K(cVar);
        }
    }

    public void setTabViewController(c.a.t0.u0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.f44169f = cVar;
        }
    }

    public void switchTab() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i();
            c.a.t0.u0.h.a aVar = this.f44168e;
            if (aVar != null) {
                aVar.G();
            }
        }
    }
}
