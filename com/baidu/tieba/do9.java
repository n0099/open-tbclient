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
/* loaded from: classes5.dex */
public class do9 extends co9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pj9 n;
    public gj9 o;
    public hj9 p;
    public kk9 q;
    public PbReplyLoadMoreAdapter r;
    public fo9 s;
    public eo9 t;
    public ij9 u;

    @Override // com.baidu.tieba.co9
    public void D(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ye9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.co9
    public vj9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (vj9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.co9
    public oi9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (oi9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.co9
    public PbFirstFloorCommentAndPraiseAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.co9
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.co9
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public do9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        I();
    }

    @Override // com.baidu.tieba.co9
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.y(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.co9
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.co9
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.co9
    public void E(tg9 tg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tg9Var) == null) {
            super.E(tg9Var);
            this.q.k0(tg9Var);
        }
    }

    @Override // com.baidu.tieba.co9
    public void F(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ye9Var) == null) {
            this.s.P(ye9Var);
        }
    }

    @Override // com.baidu.tieba.co9
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.o(str);
        }
    }

    @Override // com.baidu.tieba.co9
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.co9
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            kk9 kk9Var = this.q;
            if (kk9Var != null) {
                kk9Var.j0(z);
            }
            eo9 eo9Var = this.t;
            if (eo9Var != null) {
                eo9Var.x(z);
            }
            fo9 fo9Var = this.s;
            if (fo9Var != null) {
                fo9Var.O(z);
            }
        }
    }

    @Override // com.baidu.tieba.co9
    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, zVar) == null) {
            super.x(zVar);
            this.q.n(zVar);
        }
    }

    @Override // com.baidu.tieba.co9
    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            super.y(onLongClickListener);
            this.q.d(onLongClickListener);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.s = new fo9(this.a.a0(), pea.W0);
            this.o = new gj9(this.a.a0(), gf9.c, this.a.getUniqueId());
            this.p = new hj9(this.a.a0(), hf9.a);
            this.n = new pj9(this.a.a0(), kf9.k1);
            kk9 kk9Var = new kk9(this.a.a0(), pea.X0);
            this.q = kk9Var;
            kk9Var.l0(this.a.a0());
            this.q.g0(this.a.a0().L3());
            this.r = new PbReplyLoadMoreAdapter(this.a.a0(), pea.e1);
            this.t = new eo9(this.a.getContext(), tf9.b, this.a.a0());
            this.u = new ij9(this.a.a0(), if9.c);
            this.d.add(this.s);
            this.d.add(this.t);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.u);
            this.b.addAdapters(this.d);
        }
    }

    @Override // com.baidu.tieba.co9
    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.co9
    public void n() {
        fo9 fo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (fo9Var = this.s) != null) {
            fo9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.co9
    public void r(ye9 ye9Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{ye9Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.q(ye9Var);
            this.q.setFromCDN(z);
            this.q.o(str);
            this.q.c(z2);
            this.q.i0(0.5f);
        }
    }
}
