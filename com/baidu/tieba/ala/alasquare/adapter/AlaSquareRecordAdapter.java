package com.baidu.tieba.ala.alasquare.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import b.a.e.m.e.a;
import b.a.r0.w.f.a.f;
import b.a.r0.w.f.i.f;
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
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class SquareRecordViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b.a.r0.w.f.i.f mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareRecordViewHolder(AlaSquareRecordAdapter alaSquareRecordAdapter, b.a.r0.w.f.i.f fVar) {
            super(fVar.i());
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
    @Override // b.a.e.m.e.a
    /* renamed from: h0 */
    public SquareRecordViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b.a.r0.w.f.i.f fVar = new b.a.r0.w.f.i.f(this.m);
            fVar.u(this.n);
            fVar.t(this.o);
            fVar.s(this.p);
            SquareRecordViewHolder squareRecordViewHolder = new SquareRecordViewHolder(this, fVar);
            fVar.q(this.s);
            return squareRecordViewHolder;
        }
        return (SquareRecordViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.w.f.a.f fVar, SquareRecordViewHolder squareRecordViewHolder) {
        InterceptResult invokeCommon;
        b.a.r0.w.f.i.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, squareRecordViewHolder})) == null) {
            if (squareRecordViewHolder == null || (fVar2 = squareRecordViewHolder.mView) == null || fVar2.i() == null) {
                return null;
            }
            if (fVar != null) {
                fVar.f26031f = i2 + 1;
            }
            fVar2.j(fVar);
            b.a.r0.w.f.e.a.c().a(fVar.i(g0(), false));
            j0(fVar);
            if (i2 == this.r) {
                fVar2.i().setAnimation(AnimationUtils.loadAnimation(this.f2421e, R.anim.list_anim));
            }
            return fVar2.i();
        }
        return (View) invokeCommon.objValue;
    }

    public final void j0(b.a.r0.w.f.a.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null || fVar.f26030e == null || !TextUtils.equals("c12479", g0())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12461");
        if (StringUtils.isNull(fVar.f26030e.X0)) {
            statisticItem.param("obj_source", "0");
        } else {
            statisticItem.param("obj_source", "1");
        }
        if (StringUtils.isNull(fVar.f26030e.Z0)) {
            statisticItem.param("obj_locate", "0");
        } else {
            statisticItem.param("obj_locate", "1");
        }
        statisticItem.param("obj_type", "1");
        b.a.r0.w.f.e.a.c().a(statisticItem);
    }
}
