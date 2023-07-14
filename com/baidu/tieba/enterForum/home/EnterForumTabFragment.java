package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.LazyBaseFragment;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.g17;
import com.baidu.tieba.ht5;
import com.baidu.tieba.jt5;
import com.baidu.tieba.kt5;
import com.baidu.tieba.l65;
import com.baidu.tieba.m65;
import com.baidu.tieba.u05;
import com.baidu.tieba.xd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class EnterForumTabFragment extends LazyBaseFragment implements u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g17 g;
    public NewPagerSlidingTabBaseStrip.c h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d02b7 : invokeV.intValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements NewPagerSlidingTabBaseStrip.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFragment a;

        public a(EnterForumTabFragment enterForumTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumTabFragment;
        }

        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.c
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && view2 != null && this.a.isPrimary() && this.a.g != null) {
                if (this.a.g.O() == i) {
                    this.a.g.a0(i);
                } else if (i == 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                } else if (i > 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param("resource_id", this.a.g.Q(i)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnterForumTabFragment enterForumTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFragment, Integer.valueOf(i)};
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
            this.a = enterForumTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1 && this.a.g != null) {
                if (this.a.isPrimary()) {
                    this.a.g.a0(this.a.g.O());
                    return;
                }
                int O = this.a.g.O();
                if (O == 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                } else if (O > 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param("resource_id", this.a.g.Q(O)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EnterForumTabFragment enterForumTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFragment, Integer.valueOf(i)};
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
            this.a = enterForumTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                Set keySet = map.keySet();
                if (keySet.iterator().hasNext()) {
                    str = (String) keySet.iterator().next();
                } else {
                    str = "";
                }
                int M = this.a.g.M(str);
                if (M == -1) {
                    M = 1;
                }
                this.a.g.k0(M, (String) map.get(str));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends ht5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFragment b;

        @Override // com.baidu.tieba.ht5
        public boolean a(jt5 jt5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jt5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ht5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public d(EnterForumTabFragment enterForumTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = enterForumTabFragment;
        }

        @Override // com.baidu.tieba.ht5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return kt5.b().c();
            }
            return invokeV.intValue;
        }
    }

    public EnterForumTabFragment() {
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
        this.h = new a(this);
        this.i = new b(this, 2001384);
        this.j = new c(this, 2921678);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.changeSkinType(i);
            g17 g17Var = this.g;
            if (g17Var != null) {
                g17Var.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.g.X();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            g17 g17Var = this.g;
            if (g17Var != null) {
                g17Var.onChangeSkinType(this.mSkinType);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            this.g = new g17(this);
            registerListener(this.i);
            registerListener(this.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            super.setPrimary(z);
            g17 g17Var = this.g;
            if (g17Var != null) {
                g17Var.i0(z);
            }
        }
    }

    @Override // com.baidu.tieba.u05
    public void t1(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, intent) == null) && intent != null && this.g != null) {
            int M = this.g.M(intent.getStringExtra("sub_locate_type"));
            if (M == -1) {
                M = 0;
            }
            this.g.f0(M);
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public void K1(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            this.g.U(view2, bundle);
            M1(getActivity().getIntent(), bundle);
            this.g.I(this.h);
        }
    }

    public final void M1(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, intent, bundle) == null) && this.g != null && intent != null && intent.getExtras() != null) {
            int i = 0;
            if (intent.getBooleanExtra("is_from_scheme", false)) {
                int M = this.g.M(intent.getStringExtra("sub_locate_type"));
                if (M != -1) {
                    i = M;
                }
                if (this.g.f0(i)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.gt5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g17 g17Var = this.g;
            if (g17Var != null) {
                return g17Var.N();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.gt5
    public ht5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new d(this);
        }
        return (ht5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            xd8.l().c();
            MessageManager.getInstance().unRegisterListener(this.i);
            g17 g17Var = this.g;
            if (g17Var != null) {
                g17Var.Z();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            m65.o(l65.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            g17 g17Var = this.g;
            if (g17Var != null) {
                g17Var.Y(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (isPrimary() && getActivity() != null) {
                M1(getActivity().getIntent(), null);
                if (getContext() != null) {
                    m65.p(getContext(), l65.k);
                }
            } else {
                m65.o(l65.k);
            }
            g17 g17Var = this.g;
            if (g17Var != null) {
                g17Var.i0(isPrimary());
            }
        }
    }
}
