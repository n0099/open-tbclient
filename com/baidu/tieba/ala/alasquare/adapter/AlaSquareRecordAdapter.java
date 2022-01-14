package com.baidu.tieba.ala.alasquare.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import c.a.d.n.e.a;
import c.a.t0.a0.f.a.f;
import c.a.t0.a0.f.i.f;
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
/* loaded from: classes12.dex */
public class AlaSquareRecordAdapter extends a<f, SquareRecordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public f.a s;

    /* loaded from: classes12.dex */
    public class SquareRecordViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.t0.a0.f.i.f mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareRecordViewHolder(AlaSquareRecordAdapter alaSquareRecordAdapter, c.a.t0.a0.f.i.f fVar) {
            super(fVar.j());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareRecordAdapter, fVar};
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
            this.mView = fVar;
        }
    }

    public final String Z() {
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
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public SquareRecordViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            c.a.t0.a0.f.i.f fVar = new c.a.t0.a0.f.i.f(this.m);
            fVar.v(this.n);
            fVar.u(this.o);
            fVar.t(this.p);
            SquareRecordViewHolder squareRecordViewHolder = new SquareRecordViewHolder(this, fVar);
            fVar.s(this.s);
            return squareRecordViewHolder;
        }
        return (SquareRecordViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.a0.f.a.f fVar, SquareRecordViewHolder squareRecordViewHolder) {
        InterceptResult invokeCommon;
        c.a.t0.a0.f.i.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, squareRecordViewHolder})) == null) {
            if (squareRecordViewHolder == null || (fVar2 = squareRecordViewHolder.mView) == null || fVar2.j() == null) {
                return null;
            }
            if (fVar != null) {
                fVar.f14349f = i2 + 1;
            }
            fVar2.k(fVar);
            c.a.t0.a0.f.e.a.c().a(fVar.i(Z(), false));
            c0(fVar);
            if (i2 == this.r) {
                fVar2.j().setAnimation(AnimationUtils.loadAnimation(this.f3258e, R.anim.list_anim));
            }
            return fVar2.j();
        }
        return (View) invokeCommon.objValue;
    }

    public final void c0(c.a.t0.a0.f.a.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null || fVar.f14348e == null || !TextUtils.equals("c12479", Z())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12461");
        if (StringUtils.isNull(fVar.f14348e.Z0)) {
            statisticItem.param("obj_source", "0");
        } else {
            statisticItem.param("obj_source", "1");
        }
        if (StringUtils.isNull(fVar.f14348e.b1)) {
            statisticItem.param("obj_locate", "0");
        } else {
            statisticItem.param("obj_locate", "1");
        }
        statisticItem.param("obj_type", "1");
        c.a.t0.a0.f.e.a.c().a(statisticItem);
    }
}
