package com.baidu.tbadk.template.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes9.dex */
public abstract class BaseTemplateFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.b1.a f41933e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f41934f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f41935g;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseTemplateFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseTemplateFragment baseTemplateFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseTemplateFragment, Integer.valueOf(i2)};
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
            this.a = baseTemplateFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001453) {
                Object data = customResponsedMessage.getData();
                if (data instanceof c.a.q0.b1.b.a.a) {
                    c.a.q0.b1.b.a.a aVar = (c.a.q0.b1.b.a.a) data;
                    if (aVar.a() != this.a.getUniqueId()) {
                        return;
                    }
                    if (aVar.c()) {
                        this.a.onItemShowLog(aVar);
                    } else if (aVar.b()) {
                        this.a.onItemClickLog(aVar);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41935g = new a(this, 2001453);
    }

    public final String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj != null ? obj.getClass().getSimpleName() : StringUtil.NULL_STRING : (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onActivityCreated---- ");
            super.onActivityCreated(bundle);
            if (isPrimary()) {
                sendReq();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onAttach---- ");
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fragment) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onAttachFragment----parentFragment=" + a(getParentFragment()));
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onAttachFragment----currentFragment=" + a(this));
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onAttachFragment----childFragment=" + a(fragment));
            super.onAttachFragment(fragment);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onChangeSkinType---- ");
            super.onChangeSkinType(i2);
            c.a.q0.b1.a aVar = this.f41933e;
            if (aVar != null) {
                aVar.a(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onCreate---- ");
            super.onCreate(bundle);
            getArguments();
        }
    }

    public abstract c.a.q0.b1.a onCreatePageLoader(ViewGroup viewGroup);

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onCreateView---- ");
            ViewGroup viewGroup2 = this.f41934f;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f41934f.getParent()).removeView(this.f41934f);
            }
            if (this.f41934f == null) {
                this.f41934f = onCreateView();
            }
            if (this.f41933e == null) {
                this.f41933e = onCreatePageLoader(this.f41934f);
            }
            this.f41933e.f(getUniqueId());
            registerListener(this.f41935g);
            return this.f41934f;
        }
        return (View) invokeLLL.objValue;
    }

    public abstract ViewGroup onCreateView();

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onDestroy---- ");
            super.onDestroy();
            c.a.q0.b1.a aVar = this.f41933e;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onDetach---- ");
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onHiddenChanged----hidden=" + z);
            super.onHiddenChanged(z);
        }
    }

    public void onItemClickLog(c.a.q0.b1.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
        }
    }

    public void onItemShowLog(c.a.q0.b1.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLazyLoad();
            sendReq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLoad();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onPause---- ");
            super.onPause();
            c.a.q0.b1.a aVar = this.f41933e;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onPrimary----isPrimary =" + isPrimary());
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                c.a.q0.b1.a aVar = this.f41933e;
                if (aVar != null) {
                    aVar.d();
                    return;
                }
                return;
            }
            c.a.q0.b1.a aVar2 = this.f41933e;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view, bundle) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->onViewCreated---- ");
            super.onViewCreated(view, bundle);
        }
    }

    public void sendReq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->sendReq----");
            c.a.q0.b1.a aVar = this.f41933e;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            c.a.q0.b1.d.a.b("BaseTemplateFragment-->setUserVisibleHint----isVisibleToUser=" + z);
            super.setUserVisibleHint(z);
        }
    }
}
