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
/* loaded from: classes3.dex */
public class b39 extends a39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fz8 m;
    public wy8 n;
    public xy8 o;
    public a09 p;
    public PbReplyLoadMoreAdapter q;
    public d39 r;
    public c39 s;
    public yy8 t;

    @Override // com.baidu.tieba.a39
    public void C(qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qv8Var) == null) {
        }
    }

    @Override // com.baidu.tieba.a39
    public kz8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (kz8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a39
    public hy8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (hy8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a39
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a39
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.a39
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b39(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.a39
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.n.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.a39
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.a39
    public void D(uw8 uw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uw8Var) == null) {
            super.D(uw8Var);
            this.p.o0(uw8Var);
        }
    }

    @Override // com.baidu.tieba.a39
    public void E(qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qv8Var) == null) {
            this.r.P(qv8Var);
        }
    }

    @Override // com.baidu.tieba.a39
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r.o(str);
        }
    }

    @Override // com.baidu.tieba.a39
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.a39
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            a09 a09Var = this.p;
            if (a09Var != null) {
                a09Var.n0(z);
            }
            c39 c39Var = this.s;
            if (c39Var != null) {
                c39Var.x(z);
            }
            d39 d39Var = this.r;
            if (d39Var != null) {
                d39Var.O(z);
            }
        }
    }

    @Override // com.baidu.tieba.a39
    public void w(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, a0Var) == null) {
            super.w(a0Var);
            this.p.n(a0Var);
        }
    }

    @Override // com.baidu.tieba.a39
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.a39
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
            this.r = new d39(this.a.N(), pp9.R0);
            this.n = new wy8(this.a.N(), xv8.c, this.a.getUniqueId());
            this.o = new xy8(this.a.N(), yv8.a);
            this.m = new fz8(this.a.N(), bw8.f1);
            a09 a09Var = new a09(this.a.N(), pp9.S0);
            this.p = a09Var;
            a09Var.p0(this.a.N());
            this.p.k0(this.a.N().o3());
            this.q = new PbReplyLoadMoreAdapter(this.a.N(), pp9.Z0);
            this.s = new c39(this.a.getContext(), kw8.b, this.a.N());
            this.t = new yy8(this.a.N(), zv8.c);
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

    @Override // com.baidu.tieba.a39
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.a39
    public void m() {
        d39 d39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (d39Var = this.r) != null) {
            d39Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.a39
    public void q(qv8 qv8Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{qv8Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.r(qv8Var);
            this.p.setFromCDN(z);
            this.p.o(str);
            this.p.c(z2);
            this.p.m0(0.5f);
        }
    }
}
