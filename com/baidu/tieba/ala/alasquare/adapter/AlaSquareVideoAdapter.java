package com.baidu.tieba.ala.alasquare.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import b.a.e.l.e.a;
import b.a.r0.w.f.a.g;
import b.a.r0.w.f.i.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AlaSquareVideoAdapter extends a<g, SquareVideoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public g.b s;

    /* loaded from: classes9.dex */
    public class SquareVideoViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b.a.r0.w.f.i.g mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareVideoViewHolder(AlaSquareVideoAdapter alaSquareVideoAdapter, b.a.r0.w.f.i.g gVar) {
            super(gVar.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareVideoAdapter, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mView = gVar;
        }
    }

    public final String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.q;
            if (i2 == 2) {
                return "c12127";
            }
            if (i2 == 1) {
                return "c12479";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public SquareVideoViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b.a.r0.w.f.i.g gVar = new b.a.r0.w.f.i.g(this.m);
            gVar.u(this.n);
            gVar.t(this.o);
            gVar.q(this.p);
            gVar.s(this.s);
            return new SquareVideoViewHolder(this, gVar);
        }
        return (SquareVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.w.f.a.g gVar, SquareVideoViewHolder squareVideoViewHolder) {
        InterceptResult invokeCommon;
        b.a.r0.w.f.i.g gVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, squareVideoViewHolder})) == null) {
            if (squareVideoViewHolder == null || (gVar2 = squareVideoViewHolder.mView) == null || gVar2.i() == null) {
                return null;
            }
            if (gVar != null) {
                gVar.f24517f = i2 + 1;
            }
            gVar2.j(gVar);
            b.a.r0.w.f.e.a.c().a(gVar.i(g0(), false));
            j0(gVar);
            if (i2 == this.r) {
                gVar2.i().setAnimation(AnimationUtils.loadAnimation(this.f2419e, R.anim.list_anim));
            }
            return gVar2.i();
        }
        return (View) invokeCommon.objValue;
    }

    public final void j0(b.a.r0.w.f.a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null || gVar.f24516e == null || !TextUtils.equals("c12479", g0())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12461");
        if (StringUtils.isNull(gVar.f24516e.X0)) {
            statisticItem.param("obj_source", "0");
        } else {
            statisticItem.param("obj_source", "1");
        }
        if (StringUtils.isNull(gVar.f24516e.Z0)) {
            statisticItem.param("obj_locate", "0");
        } else {
            statisticItem.param("obj_locate", "1");
        }
        statisticItem.param("obj_type", "1");
        b.a.r0.w.f.e.a.c().a(statisticItem);
    }
}
