package com.baidu.tieba.ala.alasquare.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import c.a.d.m.e.a;
import c.a.r0.a0.f.a.g;
import c.a.r0.a0.f.i.g;
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
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public class SquareVideoViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.a0.f.i.g mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareVideoViewHolder(AlaSquareVideoAdapter alaSquareVideoAdapter, c.a.r0.a0.f.i.g gVar) {
            super(gVar.j());
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
    @Override // c.a.d.m.e.a
    /* renamed from: h0 */
    public SquareVideoViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            c.a.r0.a0.f.i.g gVar = new c.a.r0.a0.f.i.g(this.m);
            gVar.v(this.n);
            gVar.u(this.o);
            gVar.s(this.p);
            gVar.t(this.s);
            return new SquareVideoViewHolder(this, gVar);
        }
        return (SquareVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.a0.f.a.g gVar, SquareVideoViewHolder squareVideoViewHolder) {
        InterceptResult invokeCommon;
        c.a.r0.a0.f.i.g gVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, squareVideoViewHolder})) == null) {
            if (squareVideoViewHolder == null || (gVar2 = squareVideoViewHolder.mView) == null || gVar2.j() == null) {
                return null;
            }
            if (gVar != null) {
                gVar.f13862f = i2 + 1;
            }
            gVar2.k(gVar);
            c.a.r0.a0.f.e.a.c().a(gVar.i(g0(), false));
            j0(gVar);
            if (i2 == this.r) {
                gVar2.j().setAnimation(AnimationUtils.loadAnimation(this.f2907e, R.anim.list_anim));
            }
            return gVar2.j();
        }
        return (View) invokeCommon.objValue;
    }

    public final void j0(c.a.r0.a0.f.a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null || gVar.f13861e == null || !TextUtils.equals("c12479", g0())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12461");
        if (StringUtils.isNull(gVar.f13861e.Z0)) {
            statisticItem.param("obj_source", "0");
        } else {
            statisticItem.param("obj_source", "1");
        }
        if (StringUtils.isNull(gVar.f13861e.b1)) {
            statisticItem.param("obj_locate", "0");
        } else {
            statisticItem.param("obj_locate", "1");
        }
        statisticItem.param("obj_type", "1");
        c.a.r0.a0.f.e.a.c().a(statisticItem);
    }
}
