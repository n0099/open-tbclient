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
public class dn9 extends cn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ui9 m;
    public li9 n;
    public mi9 o;
    public pj9 p;
    public PbReplyLoadMoreAdapter q;
    public fn9 r;
    public en9 s;
    public ni9 t;

    @Override // com.baidu.tieba.cn9
    public void C(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ze9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.cn9
    public zi9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (zi9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn9
    public uh9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (uh9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn9
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn9
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.cn9
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.cn9
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.n.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.cn9
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.cn9
    public void D(gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gg9Var) == null) {
            super.D(gg9Var);
            this.p.q0(gg9Var);
        }
    }

    @Override // com.baidu.tieba.cn9
    public void E(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ze9Var) == null) {
            this.r.R(ze9Var);
        }
    }

    @Override // com.baidu.tieba.cn9
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r.o(str);
        }
    }

    @Override // com.baidu.tieba.cn9
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.cn9
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            pj9 pj9Var = this.p;
            if (pj9Var != null) {
                pj9Var.p0(z);
            }
            en9 en9Var = this.s;
            if (en9Var != null) {
                en9Var.x(z);
            }
            fn9 fn9Var = this.r;
            if (fn9Var != null) {
                fn9Var.Q(z);
            }
        }
    }

    @Override // com.baidu.tieba.cn9
    public void w(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, zVar) == null) {
            super.w(zVar);
            this.p.n(zVar);
        }
    }

    @Override // com.baidu.tieba.cn9
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.cn9
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
            this.r = new fn9(this.a.N(), yca.W0);
            this.n = new li9(this.a.N(), hf9.c, this.a.getUniqueId());
            this.o = new mi9(this.a.N(), if9.a);
            this.m = new ui9(this.a.N(), lf9.k1);
            pj9 pj9Var = new pj9(this.a.N(), yca.X0);
            this.p = pj9Var;
            pj9Var.r0(this.a.N());
            this.p.m0(this.a.N().r3());
            this.q = new PbReplyLoadMoreAdapter(this.a.N(), yca.e1);
            this.s = new en9(this.a.getContext(), uf9.b, this.a.N());
            this.t = new ni9(this.a.N(), jf9.c);
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

    @Override // com.baidu.tieba.cn9
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.cn9
    public void m() {
        fn9 fn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (fn9Var = this.r) != null) {
            fn9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.cn9
    public void q(ze9 ze9Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{ze9Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.r(ze9Var);
            this.p.setFromCDN(z);
            this.p.o(str);
            this.p.c(z2);
            this.p.o0(0.5f);
        }
    }
}
