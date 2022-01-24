package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import c.a.d.n.e.a;
import c.a.t0.a0.f.a.c;
import c.a.t0.a0.f.i.b;
import c.a.t0.a0.f.i.d;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class AlaSquareActiveAllAdapter extends a<c, SquareActiveAllViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public d o;

    /* loaded from: classes12.dex */
    public class SquareActiveAllViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareActiveAllViewHolder(AlaSquareActiveAllAdapter alaSquareActiveAllAdapter, b bVar) {
            super(bVar.j());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareActiveAllAdapter, bVar};
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
            this.mView = bVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: Z */
    public SquareActiveAllViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b bVar = new b(this.m);
            bVar.s(this.o);
            return new SquareActiveAllViewHolder(this, bVar);
        }
        return (SquareActiveAllViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public View S(int i2, View view, ViewGroup viewGroup, c cVar, SquareActiveAllViewHolder squareActiveAllViewHolder) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, squareActiveAllViewHolder})) == null) {
            if (squareActiveAllViewHolder == null || (bVar = squareActiveAllViewHolder.mView) == null || bVar.j() == null) {
                return null;
            }
            bVar.k(cVar);
            if (i2 == this.n) {
                bVar.j().setAnimation(AnimationUtils.loadAnimation(this.f3360e, R.anim.list_anim));
            }
            return squareActiveAllViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
