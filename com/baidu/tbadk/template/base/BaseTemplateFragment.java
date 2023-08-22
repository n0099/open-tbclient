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
import com.baidu.tieba.bu5;
import com.baidu.tieba.jt5;
import com.baidu.tieba.zu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class BaseTemplateFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jt5 a;
    public ViewGroup b;
    public final CustomMessageListener c;

    public abstract jt5 V1(ViewGroup viewGroup);

    public void W1(bu5 bu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bu5Var) == null) {
        }
    }

    public void X1(bu5 bu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bu5Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2001453) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof bu5)) {
                return;
            }
            bu5 bu5Var = (bu5) data;
            if (bu5Var.a() != this.a.getUniqueId()) {
                return;
            }
            if (bu5Var.c()) {
                this.a.X1(bu5Var);
            } else if (bu5Var.b()) {
                this.a.W1(bu5Var);
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

    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zu5.b("BaseTemplateFragment-->sendReq----");
            jt5 jt5Var = this.a;
            if (jt5Var != null) {
                jt5Var.n();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            zu5.b("BaseTemplateFragment-->onDestroy---- ");
            super.onDestroy();
            jt5 jt5Var = this.a;
            if (jt5Var != null) {
                jt5Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            zu5.b("BaseTemplateFragment-->onDetach---- ");
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            zu5.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLazyLoad();
            Y1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            zu5.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLoad();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            zu5.b("BaseTemplateFragment-->onPause---- ");
            super.onPause();
            jt5 jt5Var = this.a;
            if (jt5Var != null) {
                jt5Var.j();
            }
        }
    }

    public final String U1(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj != null) {
                return obj.getClass().getSimpleName();
            }
            return StringUtil.NULL_STRING;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            zu5.b("BaseTemplateFragment-->onActivityCreated---- ");
            super.onActivityCreated(bundle);
            if (isPrimary()) {
                Y1();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            zu5.b("BaseTemplateFragment-->onAttach---- ");
            super.onAttach(context);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            zu5.b("BaseTemplateFragment-->onChangeSkinType---- ");
            super.onChangeSkinType(i);
            jt5 jt5Var = this.a;
            if (jt5Var != null) {
                jt5Var.h(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            zu5.b("BaseTemplateFragment-->onCreate---- ");
            super.onCreate(bundle);
            getArguments();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            zu5.b("BaseTemplateFragment-->onHiddenChanged----hidden=" + z);
            super.onHiddenChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            zu5.b("BaseTemplateFragment-->setUserVisibleHint----isVisibleToUser=" + z);
            super.setUserVisibleHint(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fragment) == null) {
            zu5.b("BaseTemplateFragment-->onAttachFragment----parentFragment=" + U1(getParentFragment()));
            zu5.b("BaseTemplateFragment-->onAttachFragment----currentFragment=" + U1(this));
            zu5.b("BaseTemplateFragment-->onAttachFragment----childFragment=" + U1(fragment));
            super.onAttachFragment(fragment);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            zu5.b("BaseTemplateFragment-->onCreateView---- ");
            ViewGroup viewGroup2 = this.b;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            if (this.b == null) {
                this.b = new RelativeLayout(getContext());
            }
            if (this.a == null) {
                this.a = V1(this.b);
            }
            this.a.o(getUniqueId());
            registerListener(this.c);
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            zu5.b("BaseTemplateFragment-->onPrimary----isPrimary =" + isPrimary());
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                jt5 jt5Var = this.a;
                if (jt5Var != null) {
                    jt5Var.k();
                    return;
                }
                return;
            }
            jt5 jt5Var2 = this.a;
            if (jt5Var2 != null) {
                jt5Var2.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view2, bundle) == null) {
            zu5.b("BaseTemplateFragment-->onViewCreated---- ");
            super.onViewCreated(view2, bundle);
        }
    }
}
