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
/* loaded from: classes8.dex */
public abstract class BaseTemplateFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.a1.a f46901e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f46902f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f46903g;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseTemplateFragment f46904a;

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
            this.f46904a = baseTemplateFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001453) {
                Object data = customResponsedMessage.getData();
                if (data instanceof b.a.q0.a1.b.a.a) {
                    b.a.q0.a1.b.a.a aVar = (b.a.q0.a1.b.a.a) data;
                    if (aVar.a() != this.f46904a.getUniqueId()) {
                        return;
                    }
                    if (aVar.c()) {
                        this.f46904a.onItemShowLog(aVar);
                    } else if (aVar.b()) {
                        this.f46904a.onItemClickLog(aVar);
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
        this.f46903g = new a(this, 2001453);
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
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onActivityCreated---- ");
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
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onAttach---- ");
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fragment) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onAttachFragment----parentFragment=" + a(getParentFragment()));
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onAttachFragment----currentFragment=" + a(this));
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onAttachFragment----childFragment=" + a(fragment));
            super.onAttachFragment(fragment);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onChangeSkinType---- ");
            super.onChangeSkinType(i2);
            b.a.q0.a1.a aVar = this.f46901e;
            if (aVar != null) {
                aVar.a(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onCreate---- ");
            super.onCreate(bundle);
            getArguments();
        }
    }

    public abstract b.a.q0.a1.a onCreatePageLoader(ViewGroup viewGroup);

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onCreateView---- ");
            ViewGroup viewGroup2 = this.f46902f;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f46902f.getParent()).removeView(this.f46902f);
            }
            if (this.f46902f == null) {
                this.f46902f = onCreateView();
            }
            if (this.f46901e == null) {
                this.f46901e = onCreatePageLoader(this.f46902f);
            }
            this.f46901e.f(getUniqueId());
            registerListener(this.f46903g);
            return this.f46902f;
        }
        return (View) invokeLLL.objValue;
    }

    public abstract ViewGroup onCreateView();

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onDestroy---- ");
            super.onDestroy();
            b.a.q0.a1.a aVar = this.f46901e;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onDetach---- ");
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onHiddenChanged----hidden=" + z);
            super.onHiddenChanged(z);
        }
    }

    public void onItemClickLog(b.a.q0.a1.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
        }
    }

    public void onItemShowLog(b.a.q0.a1.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLazyLoad();
            sendReq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
            super.onLoad();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onPause---- ");
            super.onPause();
            b.a.q0.a1.a aVar = this.f46901e;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onPrimary----isPrimary =" + isPrimary());
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                b.a.q0.a1.a aVar = this.f46901e;
                if (aVar != null) {
                    aVar.d();
                    return;
                }
                return;
            }
            b.a.q0.a1.a aVar2 = this.f46901e;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view, bundle) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->onViewCreated---- ");
            super.onViewCreated(view, bundle);
        }
    }

    public void sendReq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->sendReq----");
            b.a.q0.a1.a aVar = this.f46901e;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            b.a.q0.a1.d.a.b("BaseTemplateFragment-->setUserVisibleHint----isVisibleToUser=" + z);
            super.setUserVisibleHint(z);
        }
    }
}
