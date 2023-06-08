package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hb9 extends gb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h79 m;
    public y69 n;
    public z69 o;
    public c89 p;
    public PbReplyLoadMoreAdapter q;
    public jb9 r;
    public ib9 s;
    public a79 t;

    @Override // com.baidu.tieba.gb9
    public void C(m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m39Var) == null) {
        }
    }

    @Override // com.baidu.tieba.gb9
    public m79 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (m79) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb9
    public g69 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (g69) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb9
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb9
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.gb9
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        H();
    }

    @Override // com.baidu.tieba.gb9
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.n.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void D(s49 s49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s49Var) == null) {
            super.D(s49Var);
            this.p.q0(s49Var);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void E(m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, m39Var) == null) {
            this.r.R(m39Var);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r.o(str);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            c89 c89Var = this.p;
            if (c89Var != null) {
                c89Var.p0(z);
            }
            ib9 ib9Var = this.s;
            if (ib9Var != null) {
                ib9Var.x(z);
            }
            jb9 jb9Var = this.r;
            if (jb9Var != null) {
                jb9Var.Q(z);
            }
        }
    }

    @Override // com.baidu.tieba.gb9
    public void w(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, a0Var) == null) {
            super.w(a0Var);
            this.p.n(a0Var);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            super.z(onClickListener);
            this.p.e(onClickListener);
            this.q.y(onClickListener);
            this.t.e(onClickListener);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.r = new jb9(this.a.N(), jy9.R0);
            this.n = new y69(this.a.N(), v39.c, this.a.getUniqueId());
            this.o = new z69(this.a.N(), w39.a);
            this.m = new h79(this.a.N(), z39.f1);
            c89 c89Var = new c89(this.a.N(), jy9.S0);
            this.p = c89Var;
            c89Var.r0(this.a.N());
            this.p.m0(this.a.N().q3());
            this.q = new PbReplyLoadMoreAdapter(this.a.N(), jy9.Z0);
            this.s = new ib9(this.a.getContext(), i49.b, this.a.N());
            this.t = new a79(this.a.N(), x39.c);
            this.d.add(this.r);
            this.d.add(this.s);
            this.d.add(this.m);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.t);
            this.b.addAdapters(this.d);
        }
    }

    @Override // com.baidu.tieba.gb9
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.gb9
    public void m() {
        jb9 jb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (jb9Var = this.r) != null) {
            jb9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.gb9
    public void q(m39 m39Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{m39Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.r(m39Var);
            this.p.setFromCDN(z);
            this.p.o(str);
            this.p.c(z2);
            this.p.o0(0.5f);
        }
    }
}
