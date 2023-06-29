package com.baidu.tieba;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.forumSquare.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class hc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public RelativeLayout c;
    public ForumHeaderView d;
    public NavigationBar e;
    public TextView f;
    public View g;
    public oc7 h;
    public RelativeLayout i;
    public dn5 j;
    public en5 k;
    public NoDataView l;
    public View.OnClickListener m;
    public final TbPageContext n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hc7 hc7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var, Integer.valueOf(i)};
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
            this.a = hc7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.a(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public hc7(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this, 2001304);
        this.a = context;
        this.n = tbPageContext;
        this.b = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d030a, (ViewGroup) null);
        l();
        k();
    }

    public void A(BdListView.p pVar) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) && (oc7Var = this.h) != null) {
            oc7Var.v(pVar);
        }
    }

    public void B(String str) {
        ForumHeaderView forumHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (forumHeaderView = this.d) != null) {
            forumHeaderView.setSearchHint(str);
        }
    }

    public void C(String str) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (oc7Var = this.h) != null) {
            oc7Var.x(str);
        }
    }

    public void D(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            View view2 = this.g;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public boolean F(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    p();
                    return true;
                }
                q();
                return true;
            }
            o();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void t(List<xn> list) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, list) == null) && (oc7Var = this.h) != null) {
            oc7Var.p(list);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) && (textView = this.f) != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void x(LeftAdapter.b bVar) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) && (oc7Var = this.h) != null) {
            oc7Var.t(bVar);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void z(RecyclerView.OnScrollListener onScrollListener) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, onScrollListener) == null) && (oc7Var = this.h) != null) {
            oc7Var.u(onScrollListener);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
            i();
            j();
            oc7 oc7Var = this.h;
            if (oc7Var != null) {
                oc7Var.y(true);
                this.h.w(8);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i();
            j();
            H(true);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            j();
            I(true);
            oc7 oc7Var = this.h;
            if (oc7Var != null) {
                oc7Var.s(8);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
            i();
            j();
            oc7 oc7Var = this.h;
            if (oc7Var != null) {
                oc7Var.f();
                this.h.s(0);
            }
        }
    }

    public Pair<Integer, Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            oc7 oc7Var = this.h;
            if (oc7Var != null) {
                return oc7Var.c();
            }
            return new Pair<>(0, 0);
        }
        return (Pair) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h.d();
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (oc7Var = this.h) != null) {
            oc7Var.e();
        }
    }

    public void h() {
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (dn5Var = this.j) != null) {
            dn5Var.dettachView(this.i);
            this.j = null;
        }
    }

    public void i() {
        en5 en5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (en5Var = this.k) != null) {
            en5Var.dettachView(this.i);
            this.k = null;
        }
    }

    public void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (noDataView = this.l) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void k() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (tbPageContext = this.n) != null) {
            tbPageContext.registerListener(this.o);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            dn5 dn5Var = this.j;
            if (dn5Var != null) {
                return dn5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            en5 en5Var = this.k;
            if (en5Var != null) {
                return en5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (oc7Var = this.h) != null) {
            oc7Var.j();
        }
    }

    public void p() {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (oc7Var = this.h) != null) {
            oc7Var.k();
        }
    }

    public void q() {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (oc7Var = this.h) != null) {
            oc7Var.l();
        }
    }

    public void v() {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (oc7Var = this.h) != null) {
            oc7Var.r();
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048583, this, z) != null) || m()) {
            return;
        }
        if (this.j == null) {
            dn5 dn5Var = new dn5(this.a);
            this.j = dn5Var;
            dn5Var.t(xi.g(this.a, R.dimen.obfuscated_res_0x7f0703a0));
        }
        this.j.onChangeSkinType();
        this.j.attachView(this.i, z);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || n()) {
            return;
        }
        if (this.k == null) {
            en5 en5Var = new en5(this.a, this.m);
            this.k = en5Var;
            en5Var.k(xi.g(this.a, R.dimen.obfuscated_res_0x7f0703a0));
        }
        this.k.attachView(this.i, z);
        this.k.p();
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            ForumHeaderView forumHeaderView = this.d;
            if (forumHeaderView != null) {
                forumHeaderView.b();
            }
            NavigationBar navigationBar = this.e;
            if (navigationBar != null && this.a != null) {
                navigationBar.onChangeSkinType(this.n, i);
            }
            oc7 oc7Var = this.h;
            if (oc7Var != null) {
                oc7Var.m(i);
            }
            dn5 dn5Var = this.j;
            if (dn5Var != null) {
                dn5Var.onChangeSkinType();
            }
            en5 en5Var = this.k;
            if (en5Var != null) {
                en5Var.onChangeSkinType();
            }
            NoDataView noDataView = this.l;
            if (noDataView != null && this.a != null) {
                noDataView.setSubTitleTextColor(R.color.CAM_X0105);
                this.l.f(this.n, i);
            }
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207, i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            ((LinearLayout.LayoutParams) this.i.getLayoutParams()).bottomMargin = xi.g(this.n.getPageActivity(), R.dimen.tbds22);
        }
    }

    public void c() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                i = UtilHelper.getStatusBarHeight();
            } else {
                i = 0;
            }
            int g = i + xi.g(this.a, R.dimen.tbds238);
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, g, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.navigation_bar);
            this.e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.e.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f07cc));
            View addCustomView = this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.g = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.f = textView;
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f07cd));
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090bc0);
            ForumHeaderView forumHeaderView = (ForumHeaderView) this.b.findViewById(R.id.obfuscated_res_0x7f090bc1);
            this.d = forumHeaderView;
            forumHeaderView.setFrom(1);
            this.d.setSearchHint(TbSingleton.getInstance().getHotSearch());
            this.h = new oc7(this.n, this.b);
            this.i = (RelativeLayout) this.b.findViewById(R.id.layout_container);
            a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void r(int i, int i2) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) && (oc7Var = this.h) != null) {
            oc7Var.n(i, i2);
        }
    }

    public void u(List<xn> list, int i) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048607, this, list, i) == null) && (oc7Var = this.h) != null) {
            oc7Var.q(list, i);
        }
    }

    public void s(String str, List<String> list, boolean z) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048605, this, str, list, z) == null) && (oc7Var = this.h) != null) {
            oc7Var.o(str, list, z);
        }
    }
}
