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
public class g58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public q78 b;
    public p78 c;
    public boolean d;

    public g58(PbFragment pbFragment) {
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

    public void h(int i) {
        p78 p78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (p78Var = this.c) != null) {
            p78Var.c(i);
        }
    }

    public void i(int i) {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (q78Var = this.b) != null) {
            q78Var.c0(i);
        }
    }

    public void j(Configuration configuration) {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (q78Var = this.b) != null) {
            q78Var.d0(configuration);
        }
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            q78 q78Var = this.b;
            if (q78Var != null) {
                return q78Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) && bdTypeListView != null) {
            q78 q78Var = this.b;
            if (q78Var != null) {
                bdTypeListView.removeHeaderView(q78Var.R());
            }
            p78 p78Var = this.c;
            if (p78Var != null) {
                p78Var.e(bdTypeListView);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d = z;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (q78Var = this.b) != null) {
            q78Var.r0(onClickListener);
        }
    }

    public void u(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, bdTypeListView) == null) && this.b != null) {
            TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
            this.b.s0();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public void a() {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (q78Var = this.b) != null) {
            q78Var.O();
        }
    }

    public void b() {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (q78Var = this.b) != null) {
            q78Var.f0();
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q78 q78Var = this.b;
            if (q78Var != null) {
                return q78Var.P();
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
            q78 q78Var = this.b;
            if (q78Var != null) {
                return q78Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            q78 q78Var = this.b;
            if (q78Var != null && q78Var.X()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q78 q78Var = this.b;
            if (q78Var != null) {
                return q78Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (q78Var = this.b) != null) {
            q78Var.f0();
        }
    }

    public void m() {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (q78Var = this.b) != null) {
            q78Var.g0();
        }
    }

    public void t() {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (q78Var = this.b) != null) {
            q78Var.s0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) && (q78Var = this.b) != null) {
            q78Var.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        q78 q78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) && (q78Var = this.b) != null) {
            q78Var.i0(absListView, i);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) != null) || pbLandscapeListView == null) {
            return;
        }
        q78 q78Var = this.b;
        if (q78Var != null && q78Var.P() != null) {
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.setTextViewAdded(false);
            }
            if (i != 1) {
                pbLandscapeListView.removeHeaderView(this.b.R());
                pbLandscapeListView.x(this.b.R(), 0);
                return;
            }
            return;
        }
        q78 q78Var2 = this.b;
        if (q78Var2 != null) {
            pbLandscapeListView.removeHeaderView(q78Var2.R());
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.x(textView, 0);
        }
    }

    public void v(i08 i08Var, PostData postData, BdTypeListView bdTypeListView, f58 f58Var, FrameLayout frameLayout, o68 o68Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{i08Var, postData, bdTypeListView, f58Var, frameLayout, o68Var, str, Long.valueOf(j)}) == null) && i08Var != null && i08Var.y0()) {
            q78 q78Var = this.b;
            if (q78Var == null) {
                q78 q78Var2 = new q78(this.a, o68Var, i08Var.Q().getThreadVideoInfo(), j);
                this.b = q78Var2;
                q78Var2.U(i08Var.Q().getThreadVideoInfo(), i08Var.Q(), i08Var.m());
                this.b.v0();
            } else if (this.d) {
                q78Var.U(i08Var.Q().getThreadVideoInfo(), i08Var.Q(), i08Var.m());
                this.b.v0();
            } else {
                q78Var.w0(i08Var.m());
            }
            j78.d(this.a.getUniqueId(), i08Var, postData, 1, 1);
            if (i08Var.M() != null && i08Var.M().size() >= 1) {
                ThreadData threadData = i08Var.M().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, i08Var.Q(), i08Var.U());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new p78(this.a.getBaseFragmentActivity());
            }
            this.c.d(i08Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            f58Var.F(bdTypeListView);
            f58Var.o(bdTypeListView, 2);
            if (this.b != null) {
                o68Var.I(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
