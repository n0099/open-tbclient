package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import b.a.e.l.e.a;
import b.a.r0.w.f.a.b;
import b.a.r0.w.f.i.c;
import b.a.r0.w.f.i.d;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AlaSquareActiveAdapter extends a<b, SquareActiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public d o;

    /* loaded from: classes9.dex */
    public class SquareActiveViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareActiveViewHolder(AlaSquareActiveAdapter alaSquareActiveAdapter, c cVar) {
            super(cVar.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareActiveAdapter, cVar};
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
            this.mView = cVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: g0 */
    public SquareActiveViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c cVar = new c(this.m);
            cVar.q(this.o);
            return new SquareActiveViewHolder(this, cVar);
        }
        return (SquareActiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b bVar, SquareActiveViewHolder squareActiveViewHolder) {
        InterceptResult invokeCommon;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, squareActiveViewHolder})) == null) {
            if (squareActiveViewHolder == null || (cVar = squareActiveViewHolder.mView) == null || cVar.i() == null) {
                return null;
            }
            cVar.j(bVar);
            b.a.r0.w.f.e.a.c().a(bVar.g("c12249", false));
            if (i2 == this.n) {
                cVar.i().setAnimation(AnimationUtils.loadAnimation(this.f2419e, R.anim.list_anim));
            }
            return squareActiveViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
