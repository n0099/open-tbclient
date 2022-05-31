package com.baidu.tieba.enterForum.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a46;
import com.repackage.b36;
import com.repackage.bf8;
import com.repackage.ji;
import com.repackage.n36;
import com.repackage.p36;
import com.repackage.q85;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class EnterForumFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n36 a;
    public p36 b;
    public NoNetworkView c;
    public RelativeLayout d;
    public ObservedChangeLinearLayout e;
    public RelativeLayout f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public final CustomMessageListener i;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnterForumFragment enterForumFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment, Integer.valueOf(i)};
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
            this.a = enterForumFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && this.a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.a.getActivity() && this.a.a != null) {
                this.a.a.z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnterForumFragment enterForumFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment, Integer.valueOf(i)};
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
            this.a = enterForumFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && this.a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.a.getActivity()) {
                if (this.a.a != null) {
                    this.a.a.N(true);
                }
                if (this.a.b != null) {
                    this.a.b.s();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumFragment a;

        public c(EnterForumFragment enterForumFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.a.N(z);
                if (this.a.I0() != null) {
                    this.a.I0().O();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(EnterForumFragment enterForumFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumFragment, Integer.valueOf(i)};
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
            this.a = enterForumFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && a46.b()) {
                a46.a();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2001629);
        this.h = new b(this, 2001631);
        this.i = new d(this, 2001371);
    }

    public RelativeLayout G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (RelativeLayout) invokeV.objValue;
    }

    public ObservedChangeLinearLayout H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public p36 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (p36) invokeV.objValue;
    }

    public final void J0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908ca);
            this.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f0923a4);
            this.e = (ObservedChangeLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e31);
            n36 n36Var = new n36(this);
            this.a = n36Var;
            n36Var.T(getUniqueId());
            this.c.a(new c(this));
            this.d.addView(this.a.B(), 0);
            this.a.C();
            View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0908c0);
            if (findViewById != null) {
                this.d.removeView(findViewById);
                this.d.addView(findViewById, 0);
            }
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            this.a.H();
        }
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n36 n36Var = this.a;
            if (n36Var == null || n36Var.A() == null) {
                return true;
            }
            return this.a.A().b0();
        }
        return invokeV.booleanValue;
    }

    public void L0(b36 b36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b36Var) == null) {
            this.b.Q(b36Var);
        }
    }

    public final void M0() {
        n36 n36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (n36Var = this.a) == null) {
            return;
        }
        n36Var.x(true);
    }

    public void N0(p36 p36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p36Var) == null) {
            this.b = p36Var;
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            M0();
            n36 n36Var = this.a;
            if (n36Var != null) {
                n36Var.H();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.f75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "a025" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
            n36 n36Var = this.a;
            if (n36Var != null) {
                n36Var.I(i);
            }
            NoNetworkView noNetworkView = this.c;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i);
            }
            if (this.f != null) {
                q85.a(getPageContext(), this.f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.i.setPriority(101);
            registerListener(this.i);
            registerListener(this.g);
            registerListener(this.h);
            bf8.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02d0, viewGroup, false);
            J0(inflate);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bf8.g().i(getUniqueId());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            n36 n36Var = this.a;
            if (n36Var != null) {
                n36Var.J();
            }
            this.b = null;
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            bf8.g().k(getUniqueId());
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            bf8.g().k(getUniqueId());
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            n36 n36Var = this.a;
            if (n36Var != null) {
                n36Var.K();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                O0();
                n36 n36Var = this.a;
                if (n36Var != null) {
                    refreshImage(n36Var.B());
                }
                bf8.g().h(getUniqueId(), false);
            }
            n36 n36Var2 = this.a;
            if (n36Var2 != null) {
                n36Var2.L();
            }
            if (I0() != null) {
                I0().O();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            NoNetworkView noNetworkView = this.c;
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && ji.z()) {
                this.c.update(false);
            }
        }
    }
}
