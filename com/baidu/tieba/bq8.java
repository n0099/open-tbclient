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
public class bq8 extends aq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zl8 n;
    public ql8 o;
    public rl8 p;
    public vm8 q;
    public PbReplyLoadMoreAdapter r;
    public jq8 s;
    public iq8 t;
    public sl8 u;

    @Override // com.baidu.tieba.aq8
    public void D(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ki8Var) == null) {
        }
    }

    @Override // com.baidu.tieba.aq8
    public em8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (em8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aq8
    public zk8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (zk8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aq8
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aq8
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.aq8
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.aq8
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.y(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void E(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mj8Var) == null) {
            super.E(mj8Var);
            this.q.p0(mj8Var);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void F(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ki8Var) == null) {
            this.s.P(ki8Var);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.o(str);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            vm8 vm8Var = this.q;
            if (vm8Var != null) {
                vm8Var.o0(z);
            }
            iq8 iq8Var = this.t;
            if (iq8Var != null) {
                iq8Var.x(z);
            }
            jq8 jq8Var = this.s;
            if (jq8Var != null) {
                jq8Var.O(z);
            }
        }
    }

    @Override // com.baidu.tieba.aq8
    public void x(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, a0Var) == null) {
            super.x(a0Var);
            this.q.n(a0Var);
        }
    }

    @Override // com.baidu.tieba.aq8
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
            this.s = new jq8(this.b.D(), bc9.P0);
            this.o = new ql8(this.b.D(), qi8.c, this.b.getUniqueId());
            this.p = new rl8(this.b.D(), ri8.a);
            this.n = new zl8(this.b.D(), ui8.f1);
            vm8 vm8Var = new vm8(this.b.D(), bc9.Q0);
            this.q = vm8Var;
            vm8Var.q0(this.b.D());
            this.q.l0(this.b.D().Y3());
            this.r = new PbReplyLoadMoreAdapter(this.b.D(), bc9.X0);
            this.t = new iq8(this.b.getContext(), ej8.b, this.b.D());
            this.u = new sl8(this.b.D(), si8.c);
            this.e.add(this.s);
            this.e.add(this.t);
            this.e.add(this.n);
            this.e.add(this.o);
            this.e.add(this.p);
            this.e.add(this.q);
            this.e.add(this.r);
            this.e.add(this.u);
            this.c.addAdapters(this.e);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.c) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.aq8
    public void m() {
        jq8 jq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (jq8Var = this.s) != null) {
            jq8Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.aq8
    public void q(ki8 ki8Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{ki8Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.r(ki8Var);
            this.q.setFromCDN(z);
            this.q.o(str);
            this.q.c(z2);
            this.q.n0(0.5f);
        }
    }
}
