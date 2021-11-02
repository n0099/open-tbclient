package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import b.a.q0.s.q.t1;
import b.a.q0.s.q.u1;
import b.a.r0.x0.b3.d;
import b.a.r0.x0.j1;
import b.a.r0.x0.k;
import b.a.r0.x0.x;
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
/* loaded from: classes9.dex */
public class FrsSchoolRecommendAdapter extends k<t1, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d x;

    /* loaded from: classes9.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d mCardView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, d dVar) {
            super(dVar.i());
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
    @Override // b.a.e.l.e.a
    /* renamed from: t0 */
    public FrsSchoolRecommendViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.x = new d(this.o, this.f2423i);
            return new FrsSchoolRecommendViewHolder(this, this.x);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: u0 */
    public View Z(int i2, View view, ViewGroup viewGroup, t1 t1Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t1Var, frsSchoolRecommendViewHolder})) == null) {
            super.Z(i2, view, viewGroup, t1Var, frsSchoolRecommendViewHolder);
            this.x = frsSchoolRecommendViewHolder.mCardView;
            ArrayList<u1> P4 = t1Var.P4();
            if (P4.size() <= 0) {
                return null;
            }
            x xVar = new x();
            xVar.showTopDivider = true;
            xVar.mGroupTitle = t1Var.getTitle();
            for (int i3 = 0; i3 != P4.size(); i3++) {
                u1 u1Var = P4.get(i3);
                if (u1Var != null) {
                    j1 j1Var = new j1();
                    j1Var.f25880a.setUserId(u1Var.d());
                    j1Var.f25880a.setUserName(u1Var.e());
                    j1Var.f25880a.setPortrait(u1Var.c());
                    j1Var.f25880a.getGodUserData().setIsLike(u1Var.b() == 1);
                    j1Var.f25880a.getGodUserData().setIntro(u1Var.a());
                    xVar.g(j1Var);
                }
            }
            this.x.k(this.o, this.r);
            frsSchoolRecommendViewHolder.mCardView.q(xVar);
            return frsSchoolRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
