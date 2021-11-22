package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import b.a.e.m.e.a;
import b.a.r0.w.f.a.e;
import b.a.r0.w.f.i.d;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AlaSquareLiveAdapter extends a<e, SquareLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public d s;

    /* loaded from: classes8.dex */
    public class SquareLiveViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b.a.r0.w.f.i.e mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareLiveViewHolder(AlaSquareLiveAdapter alaSquareLiveAdapter, b.a.r0.w.f.i.e eVar) {
            super(eVar.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveAdapter, eVar};
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
            this.mView = eVar;
        }
    }

    public final String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.q;
            if (i2 == 0) {
                return AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE;
            }
            if (i2 == 2) {
                return AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_DYNAMIC;
            }
            if (i2 == 1) {
                return AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.q;
            if (i2 == 0) {
                return "c12117";
            }
            if (i2 == 2) {
                return "c12129";
            }
            if (i2 == 1) {
                return "c12119";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public SquareLiveViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        b.a.r0.w.f.i.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            if (this.q == 1) {
                eVar = new b.a.r0.w.f.i.e(this.m, b.a.r0.w.f.i.a.a());
            } else {
                eVar = new b.a.r0.w.f.i.e(this.m);
            }
            eVar.w(this.n);
            eVar.v(this.o);
            eVar.u(this.p);
            eVar.t(g0());
            eVar.s(this.s);
            return new SquareLiveViewHolder(this, eVar);
        }
        return (SquareLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: j0 */
    public View Z(int i2, View view, ViewGroup viewGroup, e eVar, SquareLiveViewHolder squareLiveViewHolder) {
        InterceptResult invokeCommon;
        b.a.r0.w.f.i.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, squareLiveViewHolder})) == null) {
            if (squareLiveViewHolder == null || (eVar2 = squareLiveViewHolder.mView) == null || eVar2.i() == null) {
                return null;
            }
            if (eVar != null) {
                eVar.f26028i = i2 + 1;
            }
            eVar2.j(eVar);
            b.a.r0.w.f.e.a.c().a(eVar.k(h0(), false));
            if (i2 == this.r) {
                eVar2.i().setAnimation(AnimationUtils.loadAnimation(this.f2421e, R.anim.list_anim));
            }
            return squareLiveViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
