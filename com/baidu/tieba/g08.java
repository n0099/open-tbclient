package com.baidu.tieba;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public q28 b;
    public p28 c;
    public boolean d;

    public g08(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.a = pbFragment;
    }

    public void a() {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.O();
    }

    public void b() {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.f0();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q28 q28Var = this.b;
            if (q28Var != null) {
                return q28Var.P();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View c = c();
            if (c != null) {
                return c.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q28 q28Var = this.b;
            if (q28Var != null) {
                return q28Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            q28 q28Var = this.b;
            return q28Var != null && q28Var.X();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q28 q28Var = this.b;
            if (q28Var != null) {
                return q28Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i) {
        p28 p28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (p28Var = this.c) == null) {
            return;
        }
        p28Var.c(i);
    }

    public void i(int i) {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.c0(i);
    }

    public void j(Configuration configuration) {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.d0(configuration);
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            q28 q28Var = this.b;
            if (q28Var != null) {
                return q28Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void l() {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.f0();
    }

    public void m() {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.g0();
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.h0(absListView, i);
    }

    public void o(AbsListView absListView, int i) {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.i0(absListView, i);
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        q28 q28Var = this.b;
        if (q28Var != null) {
            bdTypeListView.removeHeaderView(q28Var.R());
        }
        p28 p28Var = this.c;
        if (p28Var != null) {
            p28Var.e(bdTypeListView);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) == null) || pbLandscapeListView == null) {
            return;
        }
        q28 q28Var = this.b;
        if (q28Var == null || q28Var.P() == null) {
            q28 q28Var2 = this.b;
            if (q28Var2 != null) {
                pbLandscapeListView.removeHeaderView(q28Var2.R());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.x(textView, 0);
                return;
            }
            return;
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.setTextViewAdded(false);
        }
        if (i != 1) {
            pbLandscapeListView.removeHeaderView(this.b.R());
            pbLandscapeListView.x(this.b.R(), 0);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d = z;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.r0(onClickListener);
    }

    public void t() {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (q28Var = this.b) == null) {
            return;
        }
        q28Var.s0();
    }

    public void u(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bdTypeListView) == null) || this.b == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
        this.b.s0();
        bdTypeListView.smoothScrollToPosition(0);
    }

    public void v(jv7 jv7Var, PostData postData, BdTypeListView bdTypeListView, f08 f08Var, FrameLayout frameLayout, o18 o18Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{jv7Var, postData, bdTypeListView, f08Var, frameLayout, o18Var, str, Long.valueOf(j)}) == null) && jv7Var != null && jv7Var.u0()) {
            q28 q28Var = this.b;
            if (q28Var == null) {
                q28 q28Var2 = new q28(this.a, o18Var, jv7Var.O().getThreadVideoInfo(), j);
                this.b = q28Var2;
                q28Var2.U(jv7Var.O().getThreadVideoInfo(), jv7Var.O(), jv7Var.m());
                this.b.v0();
            } else if (this.d) {
                q28Var.U(jv7Var.O().getThreadVideoInfo(), jv7Var.O(), jv7Var.m());
                this.b.v0();
            } else {
                q28Var.w0(jv7Var.m());
            }
            j28.d(this.a.getUniqueId(), jv7Var, postData, 1, 1);
            if (jv7Var.K() != null && jv7Var.K().size() >= 1) {
                ThreadData threadData = jv7Var.K().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, jv7Var.O(), jv7Var.S());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new p28(this.a.getBaseFragmentActivity());
            }
            this.c.d(jv7Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            f08Var.B(bdTypeListView);
            f08Var.n(bdTypeListView, 2);
            if (this.b != null) {
                o18Var.I(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
