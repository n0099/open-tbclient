package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import c.a.q0.s.q.t1;
import c.a.q0.s.q.u1;
import c.a.r0.x0.k;
import c.a.r0.x0.r2.d;
import c.a.r0.x0.x;
import c.a.r0.x0.z0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class FrsSchoolRecommendAdapter extends k<t1, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d x;

    /* loaded from: classes7.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d mCardView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, d dVar) {
            super(dVar.j());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, dVar};
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
            this.mCardView = dVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSchoolRecommendAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: u0 */
    public FrsSchoolRecommendViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.x = new d(this.o, this.f2962i);
            return new FrsSchoolRecommendViewHolder(this, this.x);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: v0 */
    public View a0(int i2, View view, ViewGroup viewGroup, t1 t1Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t1Var, frsSchoolRecommendViewHolder})) == null) {
            super.a0(i2, view, viewGroup, t1Var, frsSchoolRecommendViewHolder);
            this.x = frsSchoolRecommendViewHolder.mCardView;
            ArrayList<u1> N4 = t1Var.N4();
            if (N4.size() <= 0) {
                return null;
            }
            x xVar = new x();
            xVar.showTopDivider = true;
            xVar.mGroupTitle = t1Var.getTitle();
            for (int i3 = 0; i3 != N4.size(); i3++) {
                u1 u1Var = N4.get(i3);
                if (u1Var != null) {
                    z0 z0Var = new z0();
                    z0Var.f28243a.setUserId(u1Var.d());
                    z0Var.f28243a.setUserName(u1Var.e());
                    z0Var.f28243a.setPortrait(u1Var.c());
                    z0Var.f28243a.getGodUserData().setIsLike(u1Var.b() == 1);
                    z0Var.f28243a.getGodUserData().setIntro(u1Var.a());
                    xVar.g(z0Var);
                }
            }
            this.x.l(this.o, this.r);
            frsSchoolRecommendViewHolder.mCardView.k(xVar);
            return frsSchoolRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
