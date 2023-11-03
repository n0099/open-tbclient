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
public class i1a extends h1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uw9 n;
    public lw9 o;
    public mw9 p;
    public px9 q;
    public PbReplyLoadMoreAdapter r;
    public k1a s;
    public j1a t;
    public nw9 u;

    @Override // com.baidu.tieba.h1a
    public void D(ds9 ds9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ds9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.h1a
    public ax9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (ax9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h1a
    public tv9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (tv9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h1a
    public PbFirstFloorCommentAndPraiseAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h1a
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.h1a
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.h1a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.z(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.baidu.tieba.h1a
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.z(onClickListener);
        }
    }

    @Override // com.baidu.tieba.h1a
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.z(onClickListener);
        }
    }

    @Override // com.baidu.tieba.h1a
    public void E(yt9 yt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yt9Var) == null) {
            super.E(yt9Var);
            this.q.k0(yt9Var);
        }
    }

    @Override // com.baidu.tieba.h1a
    public void F(ds9 ds9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ds9Var) == null) {
            this.s.Q(ds9Var);
        }
    }

    @Override // com.baidu.tieba.h1a
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.p(str);
        }
    }

    @Override // com.baidu.tieba.h1a
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.l(onClickListener);
        }
    }

    @Override // com.baidu.tieba.h1a
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            px9 px9Var = this.q;
            if (px9Var != null) {
                px9Var.j0(z);
            }
            j1a j1aVar = this.t;
            if (j1aVar != null) {
                j1aVar.y(z);
            }
            k1a k1aVar = this.s;
            if (k1aVar != null) {
                k1aVar.P(z);
            }
        }
    }

    @Override // com.baidu.tieba.h1a
    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, zVar) == null) {
            super.x(zVar);
            this.q.o(zVar);
        }
    }

    @Override // com.baidu.tieba.h1a
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
            this.s = new k1a(this.a.e0(), ura.W0);
            this.o = new lw9(this.a.e0(), ls9.c, this.a.getUniqueId());
            this.p = new mw9(this.a.e0(), ms9.a);
            this.n = new uw9(this.a.e0(), ps9.k1);
            px9 px9Var = new px9(this.a.e0(), ura.X0);
            this.q = px9Var;
            px9Var.l0(this.a.e0());
            this.q.g0(this.a.e0().d4());
            this.r = new PbReplyLoadMoreAdapter(this.a.e0(), ura.e1);
            this.t = new j1a(this.a.getContext(), ys9.b, this.a.e0());
            this.u = new nw9(this.a.e0(), ns9.c);
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

    @Override // com.baidu.tieba.h1a
    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.h1a
    public void n() {
        k1a k1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (k1aVar = this.s) != null) {
            k1aVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.h1a
    public void r(ds9 ds9Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{ds9Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.s(ds9Var);
            this.q.setFromCDN(z);
            this.q.p(str);
            this.q.c(z2);
            this.q.i0(0.5f);
        }
    }
}
