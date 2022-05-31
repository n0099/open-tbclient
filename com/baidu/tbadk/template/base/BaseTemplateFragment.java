package com.baidu.tbadk.template.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pa5;
import com.repackage.r95;
import com.repackage.z85;
/* loaded from: classes3.dex */
public abstract class BaseTemplateFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z85 a;
    public ViewGroup b;
    public final CustomMessageListener c;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseTemplateFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseTemplateFragment baseTemplateFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseTemplateFragment, Integer.valueOf(i)};
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
            this.a = baseTemplateFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001453) {
                Object data = customResponsedMessage.getData();
                if (data instanceof r95) {
                    r95 r95Var = (r95) data;
                    if (r95Var.a() != this.a.getUniqueId()) {
                        return;
                    }
                    if (r95Var.c()) {
                        this.a.H0(r95Var);
                    } else if (r95Var.b()) {
                        this.a.G0(r95Var);
                    }
                }
            }
        }
    }

    public BaseTemplateFragment() {
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
        this.c = new a(this, 2001453);
    }

    public final String E0(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj != null ? obj.getClass().getSimpleName() : StringUtil.NULL_STRING : (String) invokeL.objValue;
    }

    public abstract z85 F0(ViewGroup viewGroup);

    public void G0(r95 r95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r95Var) == null) {
        }
    }

    public void H0(r95 r95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, r95Var) == null) {
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pa5.b("BaseTemplateFragment-->sendReq----");
            z85 z85Var = this.a;
            if (z85Var != null) {
                z85Var.n();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            pa5.b("BaseTemplateFragment-->onActivityCreated---- ");
            super.onActivityCreated(bundle);
            if (isPrimary()) {
                I0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            pa5.b("BaseTemplateFragment-->onAttach---- ");
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fragment) == null) {
            pa5.b("BaseTemplateFragment-->onAttachFragment----parentFragment=" + E0(getParentFragment()));
            pa5.b("BaseTemplateFragment-->onAttachFragment----currentFragment=" + E0(this));
            pa5.b("BaseTemplateFragment-->onAttachFragment----childFragment=" + E0(fragment));
            super.onAttachFragment(fragment);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            pa5.b("BaseTemplateFragment-->onChangeSkinType---- ");
            super.onChangeSkinType(i);
            z85 z85Var = this.a;
            if (z85Var != null) {
                z85Var.h(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            pa5.b("BaseTemplateFragment-->onCreate---- ");
            super.onCreate(bundle);
            getArguments();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            pa5.b("BaseTemplateFragment-->onCreateView---- ");
            ViewGroup viewGroup2 = this.b;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            if (this.b == null) {
                this.b = new RelativeLayout(getContext());
            }
            if (this.a == null) {
                this.a = F0(this.b);
            }
            this.a.o(getUniqueId());
            registerListener(this.c);
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pa5.b("BaseTemplateFragment-->onDestroy---- ");
            super.onDestroy();
            z85 z85Var = this.a;
            if (z85Var != null) {
                z85Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            pa5.b("BaseTemplateFragment-->onDetach---- ");
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            pa5.b("BaseTemplateFragment-->onHiddenChanged----hidden=" + z);
            super.onHiddenChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            pa5.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLazyLoad();
            I0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            pa5.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLoad();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            pa5.b("BaseTemplateFragment-->onPause---- ");
            super.onPause();
            z85 z85Var = this.a;
            if (z85Var != null) {
                z85Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            pa5.b("BaseTemplateFragment-->onPrimary----isPrimary =" + isPrimary());
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                z85 z85Var = this.a;
                if (z85Var != null) {
                    z85Var.k();
                    return;
                }
                return;
            }
            z85 z85Var2 = this.a;
            if (z85Var2 != null) {
                z85Var2.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view2, bundle) == null) {
            pa5.b("BaseTemplateFragment-->onViewCreated---- ");
            super.onViewCreated(view2, bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            pa5.b("BaseTemplateFragment-->setUserVisibleHint----isVisibleToUser=" + z);
            super.setUserVisibleHint(z);
        }
    }
}
