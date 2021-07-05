package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.r1;
import d.a.r0.r.q.s1;
import d.a.s0.u0.k;
import d.a.s0.u0.r2.d;
import d.a.s0.u0.x;
import d.a.s0.u0.z0;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FrsSchoolRecommendAdapter extends k<r1, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d x;

    /* loaded from: classes5.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f15375a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, d dVar) {
            super(dVar.l());
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
            this.f15375a = dVar;
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
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public FrsSchoolRecommendViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.x = new d(this.o, this.f44825i);
            return new FrsSchoolRecommendViewHolder(this, this.x);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.u0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, r1 r1Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, r1Var, frsSchoolRecommendViewHolder})) == null) {
            super.X(i2, view, viewGroup, r1Var, frsSchoolRecommendViewHolder);
            this.x = frsSchoolRecommendViewHolder.f15375a;
            ArrayList<s1> r4 = r1Var.r4();
            if (r4.size() <= 0) {
                return null;
            }
            x xVar = new x();
            xVar.showTopDivider = true;
            xVar.mGroupTitle = r1Var.getTitle();
            for (int i3 = 0; i3 != r4.size(); i3++) {
                s1 s1Var = r4.get(i3);
                if (s1Var != null) {
                    z0 z0Var = new z0();
                    z0Var.f67237a.setUserId(s1Var.d());
                    z0Var.f67237a.setUserName(s1Var.e());
                    z0Var.f67237a.setPortrait(s1Var.c());
                    z0Var.f67237a.getGodUserData().setIsLike(s1Var.b() == 1);
                    z0Var.f67237a.getGodUserData().setIntro(s1Var.a());
                    xVar.c(z0Var);
                }
            }
            this.x.n(this.o, this.r);
            frsSchoolRecommendViewHolder.f15375a.m(xVar);
            return frsSchoolRecommendViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
