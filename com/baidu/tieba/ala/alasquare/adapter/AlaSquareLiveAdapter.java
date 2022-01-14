package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import c.a.d.n.e.a;
import c.a.t0.a0.f.a.e;
import c.a.t0.a0.f.i.d;
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
/* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public class SquareLiveViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.t0.a0.f.i.e mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareLiveViewHolder(AlaSquareLiveAdapter alaSquareLiveAdapter, c.a.t0.a0.f.i.e eVar) {
            super(eVar.j());
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

    public final String Z() {
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

    public final String a0() {
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
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public SquareLiveViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.t0.a0.f.i.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            if (this.q == 1) {
                eVar = new c.a.t0.a0.f.i.e(this.m, c.a.t0.a0.f.i.a.a());
            } else {
                eVar = new c.a.t0.a0.f.i.e(this.m);
            }
            eVar.x(this.n);
            eVar.w(this.o);
            eVar.v(this.p);
            eVar.u(Z());
            eVar.t(this.s);
            return new SquareLiveViewHolder(this, eVar);
        }
        return (SquareLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: c0 */
    public View S(int i2, View view, ViewGroup viewGroup, e eVar, SquareLiveViewHolder squareLiveViewHolder) {
        InterceptResult invokeCommon;
        c.a.t0.a0.f.i.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, squareLiveViewHolder})) == null) {
            if (squareLiveViewHolder == null || (eVar2 = squareLiveViewHolder.mView) == null || eVar2.j() == null) {
                return null;
            }
            if (eVar != null) {
                eVar.f14345i = i2 + 1;
            }
            eVar2.k(eVar);
            c.a.t0.a0.f.e.a.c().a(eVar.k(a0(), false));
            if (i2 == this.r) {
                eVar2.j().setAnimation(AnimationUtils.loadAnimation(this.f3258e, R.anim.list_anim));
            }
            return squareLiveViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
