package com.baidu.tieba.godSquare.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.b0.d0;
import b.a.r0.b0.f0.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class GodSquareHotGodAdapter extends b.a.e.m.e.a<h, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public b.a.r0.c1.d.a n;
    public d0 o;

    /* loaded from: classes9.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b.a.r0.c1.d.a mCardView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(GodSquareHotGodAdapter godSquareHotGodAdapter, b.a.r0.c1.d.a aVar) {
            super(aVar.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godSquareHotGodAdapter, aVar};
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
            this.mCardView = aVar;
        }
    }

    /* loaded from: classes9.dex */
    public class a extends d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GodSquareHotGodAdapter f50248b;

        public a(GodSquareHotGodAdapter godSquareHotGodAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godSquareHotGodAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50248b = godSquareHotGodAdapter;
        }

        @Override // b.a.r0.b0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            h hVar;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) || view == null || this.f50248b.n == null || !(baseCardInfo instanceof h) || (metaData = (hVar = (h) baseCardInfo).f16251e) == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            if (view.getId() != this.f50248b.n.m.getId()) {
                if (view.getId() == this.f50248b.n.i().getId() || view.getId() == this.f50248b.n.o.getId()) {
                    TiebaStatic.log(new StatisticItem("c10951").param("obj_id", hVar.f16251e.getUserId()));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c10803").param("obj_locate", 4).param("obj_id", hVar.f16251e.getUserId()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.f16249h);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: h0 */
    public ViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b.a.r0.c1.d.a aVar = new b.a.r0.c1.d.a(this.m);
            this.n = aVar;
            aVar.p(this.m.getUniqueId());
            this.n.l(this.o);
            return new ViewHolder(this, this.n);
        }
        return (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        b.a.r0.c1.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, viewHolder})) == null) {
            if (viewHolder == null || (aVar = viewHolder.mCardView) == null) {
                return null;
            }
            aVar.j(hVar);
            return viewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
