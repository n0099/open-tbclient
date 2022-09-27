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
import com.baidu.tieba.cq4;
import com.baidu.tieba.o96;
import com.baidu.tieba.q97;
import com.baidu.tieba.vc5;
import com.baidu.tieba.xc5;
import com.baidu.tieba.yc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class EnterForumTabFragment extends LazyBaseFragment implements cq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o96 g;
    public NewPagerSlidingTabBaseStrip.c h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) || view2 == null || !this.a.isPrimary() || this.a.g == null) {
                return;
            }
            if (this.a.g.y() == i) {
                this.a.g.M(i);
            } else if (i == 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
            } else if (i > 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, this.a.g.A(i)));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.g.M(this.a.g.y());
                    return;
                }
                int y = this.a.g.y();
                if (y == 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                } else if (y > 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, this.a.g.A(y)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                Set keySet = map.keySet();
                String str = keySet.iterator().hasNext() ? (String) keySet.iterator().next() : "";
                int w = this.a.g.w(str);
                if (w == -1) {
                    w = 0;
                }
                this.a.g.W(w, (String) map.get(str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends vc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFragment b;

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

        @Override // com.baidu.tieba.vc5
        public boolean a(xc5 xc5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xc5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.vc5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? yc5.b().c() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.vc5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
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

    @Override // com.baidu.tieba.cq4
    public void c1(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null || this.g == null) {
            return;
        }
        int w = this.g.w(intent.getStringExtra("sub_locate_type"));
        if (w == -1) {
            w = 0;
        }
        if (this.g.R(w)) {
            intent.removeExtra("sub_locate_type");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.changeSkinType(i);
            o96 o96Var = this.g;
            if (o96Var != null) {
                o96Var.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.uc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o96 o96Var = this.g;
            if (o96Var != null) {
                return o96Var.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.uc5
    public vc5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new d(this) : (vc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.g.I();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            o96 o96Var = this.g;
            if (o96Var != null) {
                o96Var.K(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            o96 o96Var = this.g;
            if (o96Var != null) {
                o96Var.onChangeSkinType(this.mSkinType);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.g = new o96(this);
            registerListener(this.i);
            registerListener(this.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            q97.m().c();
            MessageManager.getInstance().unRegisterListener(this.i);
            o96 o96Var = this.g;
            if (o96Var != null) {
                o96Var.L();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            if (isPrimary() && getActivity() != null) {
                v1(getActivity().getIntent(), null);
            }
            o96 o96Var = this.g;
            if (o96Var != null) {
                o96Var.U(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public int r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.obfuscated_res_0x7f0d0274 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.setPrimary(z);
            o96 o96Var = this.g;
            if (o96Var != null) {
                o96Var.U(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public void t1(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, view2, bundle) == null) {
            this.g.E(view2, bundle);
            v1(getActivity().getIntent(), bundle);
            this.g.t(this.h);
        }
    }

    public final void v1(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, intent, bundle) == null) || this.g == null || intent == null || intent.getExtras() == null) {
            return;
        }
        if (intent.getBooleanExtra("is_from_scheme", false)) {
            int w = this.g.w(intent.getStringExtra("sub_locate_type"));
            if (this.g.G()) {
                if (this.g.R(w != -1 ? w : 0)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                }
            }
        }
    }
}
